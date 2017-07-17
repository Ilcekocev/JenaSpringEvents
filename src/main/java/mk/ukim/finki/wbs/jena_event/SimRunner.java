package mk.ukim.finki.wbs.jena_event;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import mk.ukim.finki.wbs.jena_event.events.JenaEventListener;
import mk.ukim.finki.wbs.jena_event.events.JenaTripleEvent;
import mk.ukim.finki.wbs.jena_event.events.Publisher;
import mk.ukim.finki.wbs.jena_event.model.Employee;
import mk.ukim.finki.wbs.jena_event.simulator.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Ilce on 6/23/2017.
 */

@Component
@Order(value = 2)

public class SimRunner implements CommandLineRunner {

    @Autowired
    private JenaEventListener listener;

    @Autowired
    private Publisher publisher;


    @Override
    public void run(String... strings) throws Exception {


        Employee emp = new Employee("John Smith",1,41.633686,22.465402);
        Employee emp2 = new Employee("Mike Miller",2,41.634505,22.467504);
        Node nodeEmp = Node.createURI("http://test/emp/"+emp.getId());
        Node nodeEmp2 = Node.createURI("http://test/emp/"+emp2.getId());
        Node nodeLocation2 = Node.createURI("http://test/emp/"+emp2.getId()+"/loc");
        Node nodeLocation = Node.createURI("http://test/emp/"+emp.getId()+"/loc");
        Node proEmpLon = Node.createURI("http://test/emp/Longitude");
        Node proEmpLat = Node.createURI("http://test/emp/Latitide");
        Node proEmpLoc = Node.createURI("http://test/emp/Location");

        Location startP1 = new Location(emp.getLat(),emp.getLon());
        Location startP2 = new Location(emp2.getLat(),emp2.getLon());

        //double distance = FlatEarthDist.distance(startP1.getLatitude(),startP1.getLongitude(),startP2.getLatitude(),startP2.getLongitude());
        //System.out.println("Inicial difrence is: "+(int)distance);


        for (int i =0;i<10;i++) {
            //change values
            startP1.IncrementLoc(0.000050,0.000050);
            startP2.DecrementLoc(0.000050,0.000050);

            //Send new values for first emp
            Node nodeLat = Node.createLiteral(Double.toString(startP1.getLatitude()));
            Node nodeLon = Node.createLiteral(Double.toString(startP1.getLongitude()));

            Triple trojka = Triple.create(nodeLocation,proEmpLat,nodeLat);
            JenaTripleEvent event = new JenaTripleEvent(this,trojka);
            event.setSimFlag(true);
            publisher.publishJenaEvent(event);

            trojka = Triple.create(nodeLocation,proEmpLon,nodeLon);
            event = new JenaTripleEvent(this,trojka);
            event.setSimFlag(true);
            publisher.publishJenaEvent(event);

            //Send new values for second emp
            Node nodeLat2 = Node.createLiteral(Double.toString(startP2.getLatitude()));
            Node nodeLon2 = Node.createLiteral(Double.toString(startP2.getLongitude()));

            trojka = Triple.create(nodeLocation2,proEmpLat,nodeLat2);
            event = new JenaTripleEvent(this,trojka);
            event.setSimFlag(true);
            publisher.publishJenaEvent(event);

            trojka = Triple.create(nodeLocation2,proEmpLon,nodeLon2);
            event = new JenaTripleEvent(this,trojka);
            event.setSimFlag(true);
            publisher.publishJenaEvent(event);

        }


        listener.printModel();


    }
}
