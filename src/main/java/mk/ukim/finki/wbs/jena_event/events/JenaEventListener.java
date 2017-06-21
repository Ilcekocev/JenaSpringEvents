package mk.ukim.finki.wbs.jena_event.events;

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

  @EventListener
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

  public void printModel() {
    tdbHelper.openDataset();
    Model model = tdbHelper.getDataset().getDefaultModel();
    System.out.println("--Printing mk.ukim.finki.wbs.jena_event.model !---");
    model.write(System.out, "N-TRIPLES");
    tdbHelper.closeDataset();
  }

}
