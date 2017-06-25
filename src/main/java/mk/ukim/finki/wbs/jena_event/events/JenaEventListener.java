package mk.ukim.finki.wbs.jena_event.events;

import mk.ukim.finki.wbs.jena_event.Simulator.FlatEarthDist;
import mk.ukim.finki.wbs.jena_event.Simulator.Location;
import mk.ukim.finki.wbs.jena_event.repository.TdbHelper;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Ilce on 5/28/2017.
 */
@Component
public class JenaEventListener {

  TdbHelper tdbHelper = new TdbHelper();

  //this event listener populates the model
  @EventListener(condition = "#event.sim==false")
  void handle(JenaTripleEvent event) {
    tdbHelper.openDataset();
    Model model = tdbHelper.getDataset().getDefaultModel();
    System.out.println("Received <" + event.getMessage() + ">");
    Triple t = event.getMessage();
     Resource resource = model.createResource(t.getSubject().getURI());
     Property property =model.createProperty(t.getPredicate().getURI());
    Node obj = t.getObject();
    if (obj.isURI()) {
      resource.addProperty(property,obj.getURI());
    } else resource.addProperty(property,obj.getLiteralValue().toString());

    tdbHelper.closeDataset();
  }

  //This event listener is for the simulation
  @EventListener(condition = "#event.sim==true")
  void handleSim(JenaTripleEvent event) {

    tdbHelper.openDataset();
    Model model = tdbHelper.getDataset().getDefaultModel();
    System.out.println("Received <" + event.getMessage() + ">");
    Triple t = event.getMessage();

    //remove old statment
    Resource oldLoc = model.getResource(t.getSubject().getURI());
    Property property =model.createProperty(t.getPredicate().getURI());
    Statement oldStm = oldLoc.getProperty(property);
    model.remove(oldStm);

    //insert new statment
    Resource resource = model.createResource(t.getSubject().getURI());
    Node obj = t.getObject();
    resource.addProperty(property,obj.getLiteralValue().toString());

    //get current employee
    Property p =model.createProperty("http://test/emp/Location");
    Property lat = model.createProperty("http://test/emp/Latitide");
    Property lon = model.createProperty("http://test/emp/Longitude");
    Property taskP = model.createProperty("http://test/emp/Task");
    ResIterator resIter = model.listSubjectsWithProperty(p,t.getSubject().getURI());
    Resource currentEmp = resIter.nextResource();
    Statement currStm = currentEmp.getProperty(p);
    currStm = resource.getProperty(lat);
    double currLatitude = Double.parseDouble(currStm.getObject().toString());
    currStm = resource.getProperty(lon);
    double currLongitude = Double.parseDouble(currStm.getObject().toString());

    //check distance between current employee and the others
    resIter = model.listSubjectsWithProperty(p);
    while (resIter.hasNext()) {
      Resource emp = resIter.nextResource();
      if (emp!=currentEmp) {
        Statement stm = emp.getProperty(p);
        Resource loc = model.getResource(stm.getObject().toString());
        stm = loc.getProperty(lat);
        double latitude = Double.parseDouble(stm.getObject().toString());
        stm = loc.getProperty(lon);
        double longitude = Double.parseDouble(stm.getObject().toString());
        double distance = FlatEarthDist.distance(currLatitude,currLongitude,latitude,longitude);
        if (distance<100) {
          //if they are in 100m radius of each other check if they work on the same task
          StmtIterator taskCurrEmp = currentEmp.listProperties(taskP);
          while (taskCurrEmp.hasNext()) {
            Resource task = model.getResource(taskCurrEmp.nextStatement().getObject().toString());
            StmtIterator taskEmp = emp.listProperties(taskP);
            while (taskEmp.hasNext()) {
              Resource task2 = model.getResource(taskEmp.nextStatement().getObject().toString());
              if (task==task2) {
                sendNotification();
                //break;
              }
            }
          }
        }
      }
    }

    tdbHelper.closeDataset();
  }

  public void printModel() {
    tdbHelper.openDataset();
    Model model = tdbHelper.getDataset().getDefaultModel();
    System.out.println("--Printing mk.ukim.finki.wbs.jena_event.model !---");
    model.write(System.out, "N-TRIPLES");
    tdbHelper.closeDataset();
  }

  public void sendNotification() {
    System.out.println("Sending notification to mobile device !");
  }

}
