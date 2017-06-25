package mk.ukim.finki.wbs.jena_event;

import mk.ukim.finki.wbs.jena_event.events.JenaEventListener;
import mk.ukim.finki.wbs.jena_event.events.JenaTripleEvent;
import mk.ukim.finki.wbs.jena_event.events.Publisher;
import mk.ukim.finki.wbs.jena_event.model.Employee;
import mk.ukim.finki.wbs.jena_event.model.Task;
import org.apache.commons.collections4.list.NodeCachingLinkedList;
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

import java.util.Date;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)

public class Runner implements CommandLineRunner {

    private JenaEventListener listener;
    @Autowired
    private Publisher publisher;

    public Runner(JenaEventListener listener) {
        this.listener=listener;
    }

    @Override
    public void run(String... strings) throws Exception {


        Employee emp = new Employee("John Smith",1,41.633686,22.465402);
        Task task = new Task("semWeb",new Date());


        // Prati trojka: resurs:vraboten , prperty:EmpName, literal:imeVraboten
        Node nodeEmp = NodeFactory.createURI("http://test/emp/"+emp.getId());
        Node proEmpName = NodeFactory.createURI("http://test/emp/Name");
        Node nodeName = NodeFactory.createLiteral(emp.getName());

        Triple trojka = Triple.create(nodeEmp,proEmpName,nodeName);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        //  Prati trojka: resurs:Task , prperty:TaskTime, literal:vreme

        Node nodeTask = NodeFactory.createURI("http://test/task/"+task.getName());
        Node proTaskTime = NodeFactory.createURI("http://test/task/Time");
        Node taskTime = NodeFactory.createLiteral(task.getTime().toString());

        trojka = Triple.create(nodeTask,proTaskTime,taskTime);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

      // Prati trojka: resurs:emp-location , prperty:longitude, literal:longitude
        Node nodeLocation = NodeFactory.createURI("http://test/emp/"+emp.getId()+"/loc");
        Node proEmpLon = NodeFactory.createURI("http://test/emp/Longitude");
        Node nodeLon = NodeFactory.createLiteral(Double.toString(emp.getLon()));

        trojka = Triple.create(nodeLocation,proEmpLon,nodeLon);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        // Prati trojka: resurs:emp-location , prperty:latitude, literal:latitude

        Node proEmpLat = NodeFactory.createURI("http://test/emp/Latitide");
        Node nodeLat = NodeFactory.createLiteral(Double.toString(emp.getLat()));

        trojka = Triple.create(nodeLocation,proEmpLat,nodeLat);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        // Prati trojka: resurs:emp , prperty:Location, resurs:emp-location
        Node proEmpLoc = NodeFactory.createURI("http://test/emp/Location");

         trojka = Triple.create(nodeEmp,proEmpLoc,nodeLocation);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));


        // Prati trojka: resurs:vraboten , prperty:Task, resurs:Task

        Node proEmpTask = NodeFactory.createURI("http://test/emp/Task");

        trojka = Triple.create(nodeEmp,proEmpTask,nodeTask);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        //Send a second task to employee

        Task task2 = new Task("WebTask",new Date());

        Node nodeTask2 = NodeFactory.createURI("http://test/task/"+task2.getName());
        Node taskTime2 = NodeFactory.createLiteral(task2.getTime().toString());

        trojka = Triple.create(nodeTask2,proTaskTime,taskTime2);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,Triple.create(nodeEmp,proEmpTask,nodeTask2)));

        //Send second emp

        Employee emp2 = new Employee("Mike Miller",2,41.634505,22.467504);

       // Prati trojka: resurs:vraboten , prperty:EmpName, literal:imeVraboten
        Node nodeEmp2 = NodeFactory.createURI("http://test/emp/"+emp2.getId());
        Node nodeName2 = NodeFactory.createLiteral(emp2.getName());

        trojka = Triple.create(nodeEmp2,proEmpName,nodeName2);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));



        // Prati trojka: resurs:emp-location , prperty:longitude, literal:longitude
        Node nodeLocation2 = NodeFactory.createURI("http://test/emp/"+emp2.getId()+"/loc");
        Node nodeLon2 = NodeFactory.createLiteral(Double.toString(emp2.getLon()));

        trojka = Triple.create(nodeLocation2,proEmpLon,nodeLon2);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        // Prati trojka: resurs:emp-location , prperty:latitude, literal:latitude

        Node nodeLat2 = NodeFactory.createLiteral(Double.toString(emp2.getLat()));

        trojka = Triple.create(nodeLocation2,proEmpLat,nodeLat2);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        trojka = Triple.create(nodeEmp2,proEmpLoc,nodeLocation2);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));

        //Send task to second employee
        trojka = Triple.create(nodeEmp2,proEmpTask,nodeTask);
        System.out.println("Sending Event...");
        publisher.publishJenaEvent(new JenaTripleEvent(this,trojka));


    }


}
