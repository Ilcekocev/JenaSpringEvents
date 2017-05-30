package EventsTest;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Ilce on 5/28/2017.
 */
public class JenaTripleEvent extends ApplicationEvent {

    protected String message;

    //inSource- od kade doaga eventot
    public JenaTripleEvent(final Object inSource,String msg) {
        super(inSource);
        message=msg;
    }

    public String getMessage() {
        return message;
    }

}
