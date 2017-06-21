package mk.ukim.finki.wbs.jena_event;

import mk.ukim.finki.wbs.jena_event.events.JenaEventListener;
import mk.ukim.finki.wbs.jena_event.events.JenaTripleEvent;
import mk.ukim.finki.wbs.jena_event.model.Employee;
import mk.ukim.finki.wbs.jena_event.model.Task;
import org.apache.commons.collections4.list.NodeCachingLinkedList;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Runner implements CommandLineRunner {

    private final ConfigurableApplicationContext context;
    private final ApplicationEventPublisher publisher;
    private final JenaEventListener listener;

    public Runner(ConfigurableApplicationContext context,ApplicationEventPublisher publisher,JenaEventListener listener) {
        this.listener=listener;
        this.context = context;
        this.publisher=publisher;
    }

    @Override
    public void run(String... strings) throws Exception {


        Employee emp = new Employee("John Smith",1,"123.45","345.67");
        Task task = new Task("semWeb",new Date());


        System.out.println("Im here !!!");

        // Prati trojka: resurs:vraboten , prperty:EmpName, literal:imeVraboten
        Node nodeEmp = NodeFactory.createURI("http://test/emp/"+emp.getId());
        Node proEmpName = NodeFactory.createURI("http://test/emp/Name");
        Node nodeName = NodeFactory.createLiteral(emp.getName());

        Triple trojka = Triple.create(nodeEmp,proEmpName,nodeName);
        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,trojka));

        //  Prati trojka: resurs:Task , prperty:TaskTime, literal:vreme

        Node nodeTask = NodeFactory.createURI("http://test/task/"+task.getName());
        Node proTaskTime = NodeFactory.createURI("http://test/task/Time");
        Node taskTime = NodeFactory.createLiteral(task.getTime().toString());

        trojka = Triple.create(nodeTask,proTaskTime,taskTime);
        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,trojka));

      // Prati trojka: resurs:emp-location , prperty:longitude, literal:longitude
        Node nodeLocation = NodeFactory.createURI("http://test/emp/"+emp.getId()+"/loc");
        Node proEmpLon = NodeFactory.createURI("http://test/emp/Longitude");
        Node nodeLon = NodeFactory.createLiteral(emp.getLon());

        trojka = Triple.create(nodeLocation,proEmpLon,nodeLon);
        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,trojka));

        // Prati trojka: resurs:emp-location , prperty:latitude, literal:latitude

        Node proEmpLat = NodeFactory.createURI("http://test/emp/Latitide");
        Node nodeLat = NodeFactory.createLiteral(emp.getLat());

        trojka = Triple.create(nodeLocation,proEmpLat,nodeLat);
        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,trojka));

        // Prati trojka: resurs:emp , prperty:Location, resurs:emp-location
        Node proEmpLoc = NodeFactory.createURI("http://test/emp/Location");

         trojka = Triple.create(nodeEmp,proEmpLoc,nodeLocation);
        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,trojka));


        // Prati trojka: resurs:vraboten , prperty:Task, resurs:Task

        Node proEmpTask = NodeFactory.createURI("http://test/emp/Task");

        trojka = Triple.create(nodeEmp,proEmpTask,nodeTask);
        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,trojka));

        //Send a second task to employee

        Task task2 = new Task("WebTask",new Date());

        Node nodeTask2 = NodeFactory.createURI("http://test/task/"+task2.getName());
        Node taskTime2 = NodeFactory.createLiteral(task2.getTime().toString());

        trojka = Triple.create(nodeTask2,proTaskTime,taskTime2);
        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,trojka));

        System.out.println("Sending Event...");
        publisher.publishEvent(new JenaTripleEvent(this,Triple.create(nodeEmp,proEmpTask,nodeTask2)));


        listener.printModel();

        context.close();
    }


}
