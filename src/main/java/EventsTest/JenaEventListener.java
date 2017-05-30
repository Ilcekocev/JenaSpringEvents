package EventsTest;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Ilce on 5/28/2017.
 */
@Component
public class JenaEventListener {

    private Model model = ModelFactory.createDefaultModel();

    @EventListener
    void handle(JenaTripleEvent event) {
        System.out.println("Received <" + event.getMessage() + ">");
        String[] parts = event.getMessage().split("-");
        if (parts[0].equals("str")) {
            Resource subject = model.createResource(parts[1]);
            Property predicate = model.createProperty(parts[2]);
            subject.addProperty(predicate,parts[3]);
        } else {
            Resource subject = model.createResource(parts[1]);
            Property predicate = model.createProperty(parts[2]);
            Resource object = model.createResource(parts[3]);
            subject.addProperty(predicate,object);
        }
    }

    public void printModel() {
        System.out.println("--Printing model !---");
        model.write(System.out, "N-TRIPLES");
    }

}
