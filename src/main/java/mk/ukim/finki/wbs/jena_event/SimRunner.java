package mk.ukim.finki.wbs.jena_event;

import mk.ukim.finki.wbs.jena_event.Simulator.FlatEarthDist;
import mk.ukim.finki.wbs.jena_event.Simulator.Location;
import mk.ukim.finki.wbs.jena_event.events.JenaEventListener;
import mk.ukim.finki.wbs.jena_event.events.JenaTripleEvent;
import mk.ukim.finki.wbs.jena_event.events.Publisher;
import mk.ukim.finki.wbs.jena_event.model.Employee;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Ilce on 6/23/2017.
 */

@Component
// Run the simulator after the first runner
@Order(value = Ordered.LOWEST_PRECEDENCE)

public class SimRunner implements CommandLineRunner {

    private JenaEventListener listener;
    private final ConfigurableApplicationContext context;
    @Autowired
    private Publisher publisher;

    public SimRunner(ConfigurableApplicationContext context,JenaEventListener listener) {
        this.context = context;
        this.listener=listener;
    }

    @Override
    public void run(String... strings) throws Exception {

        Employee emp = new Employee("John Smith",1,41.633686,22.465402);
        Employee emp2 = new Employee("Mike Miller",2,41.634505,22.467504);
        Node nodeEmp = NodeFactory.createURI("http://test/emp/"+emp.getId());
        Node nodeEmp2 = NodeFactory.createURI("http://test/emp/"+emp2.getId());
        Node nodeLocation2 = NodeFactory.createURI("http://test/emp/"+emp2.getId()+"/loc");
        Node nodeLocation = NodeFactory.createURI("http://test/emp/"+emp.getId()+"/loc");
        Node proEmpLon = NodeFactory.createURI("http://test/emp/Longitude");
        Node proEmpLat = NodeFactory.createURI("http://test/emp/Latitide");
        Node proEmpLoc = NodeFactory.createURI("http://test/emp/Location");

        Location startP1 = new Location(emp.getLat(),emp.getLon());
        Location startP2 = new Location(emp2.getLat(),emp2.getLon());

        //double distance = FlatEarthDist.distance(startP1.getLatitude(),startP1.getLongitude(),startP2.getLatitude(),startP2.getLongitude());
        //System.out.println("Inicial difrence is: "+(int)distance);


        for (int i =0;i<30;i++) {
            //change values
            startP1.IncrementLoc(0.000050,0.000050);
            startP2.DecrementLoc(0.000050,0.000050);

            //Send new values for first emp
            Node nodeLat = NodeFactory.createLiteral(Double.toString(startP1.getLatitude()));
            Node nodeLon = NodeFactory.createLiteral(Double.toString(startP1.getLongitude()));

            Triple trojka = Triple.create(nodeLocation,proEmpLat,nodeLat);
            JenaTripleEvent event = new JenaTripleEvent(this,trojka);
            event.setSimFlag(true);
            publisher.publishJenaEvent(event);

            trojka = Triple.create(nodeLocation,proEmpLon,nodeLon);
            event = new JenaTripleEvent(this,trojka);
            event.setSimFlag(true);
            publisher.publishJenaEvent(event);

            //Send new values for second emp
            Node nodeLat2 = NodeFactory.createLiteral(Double.toString(startP2.getLatitude()));
            Node nodeLon2 = NodeFactory.createLiteral(Double.toString(startP2.getLongitude()));

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

        context.close();

    }
}
