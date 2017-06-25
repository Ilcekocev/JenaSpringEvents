package mk.ukim.finki.wbs.jena_event.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by Ilce on 6/24/2017.
 */
@Component
public class Publisher {

    private final ApplicationEventPublisher publisher;

    @Autowired
    public Publisher(ApplicationEventPublisher publisher) {
        this.publisher=publisher;
    }

    public void publishJenaEvent(JenaTripleEvent event) {
        System.out.println("Sending Event...");
        this.publisher.publishEvent(event);
    }

}
