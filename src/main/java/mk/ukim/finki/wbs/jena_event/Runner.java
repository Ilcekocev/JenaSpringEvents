package mk.ukim.finki.wbs.jena_event;

import mk.ukim.finki.wbs.jena_event.events.JenaEventListener;
import mk.ukim.finki.wbs.jena_event.events.JenaTripleEvent;
import mk.ukim.finki.wbs.jena_event.model.Employee;
import mk.ukim.finki.wbs.jena_event.model.Task;
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

        Employee emp = new Employee("John Smith",1);
        Task task = new Task(1,"semWeb",new Date(),"123.45","345.67");

        // Prati trojka: resurs:vraboten , prperty:EmpName, literal:imeVraboten
         System.out.println("Sending Event...");
         String message = buildMessage("str","http://test/emp"+emp.getId(),"EmpName",emp.getName());
         publisher.publishEvent(new JenaTripleEvent(this,message));

         // Prati trojka: resurs:task , prperty:TaskName, literal:imeTask
        System.out.println("Sending Event...");
        message = buildMessage("str","http://test/task"+task.getId(),"TaskName",task.getName());
        publisher.publishEvent(new JenaTripleEvent(this,message));

        // Prati trojka: resurs:Task , prperty:TaskTime, literal:vreme
        System.out.println("Sending Event...");
        message = buildMessage("str","http://test/task"+task.getId(),"TaskTime",task.getTime().toString());
        publisher.publishEvent(new JenaTripleEvent(this,message));

        // Prati trojka: resurs:task-location , prperty:longitude, literal:longitude
        System.out.println("Sending Event...");
        message = buildMessage("str","http://test/task"+task.getId()+"/loc","Longitude",task.getLon());
        publisher.publishEvent(new JenaTripleEvent(this,message));

        // Prati trojka: resurs:task-location , prperty:latitude, literal:latitude
        System.out.println("Sending Event...");
        message = buildMessage("str","http://test/task"+task.getId()+"/loc","Latitide",task.getLat());
        publisher.publishEvent(new JenaTripleEvent(this,message));

        // Prati trojka: resurs:task , prperty:TaskLocation, resurs:task-location
        System.out.println("Sending Event...");
        message = buildMessage("obj","http://test/task"+task.getId(),"TaskLocation","http://test/task"+task.getId()+"/loc");
        publisher.publishEvent(new JenaTripleEvent(this,message));

        // Prati trojka: resurs:vraboten , prperty:Task, resurs:Task
        System.out.println("Sending Event...");
        message = buildMessage("obj","http://test/emp"+emp.getId(),"Task","http://test/task"+task.getId());
        publisher.publishEvent(new JenaTripleEvent(this,message));

        //Send a second task to employee

        Task task2 = new Task(2,"WebTask",new Date(),"425.45","645.67");

        System.out.println("Sending Event...");
        message = buildMessage("str","http://test/task"+task2.getId(),"TaskName",task2.getName());
        publisher.publishEvent(new JenaTripleEvent(this,message));


        System.out.println("Sending Event...");
        message = buildMessage("obj","http://test/emp"+emp.getId(),"Task","http://test/task"+task2.getId());
        publisher.publishEvent(new JenaTripleEvent(this,message));

        listener.printModel();

        context.close();
    }

    private String buildMessage(String type,String sub,String pred,String obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append("-")
                .append(sub).append("-");
        sb.append(pred).append("-")
                .append(obj);
        return sb.toString();
    }
}
