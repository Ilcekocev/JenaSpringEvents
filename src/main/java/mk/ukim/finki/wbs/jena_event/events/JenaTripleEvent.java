package mk.ukim.finki.wbs.jena_event.events;

import org.apache.jena.graph.Triple;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Ilce on 5/28/2017.
 */
public class JenaTripleEvent extends ApplicationEvent {

    protected Triple trojka;
    public boolean sim=false;

    public JenaTripleEvent(final Object inSource,Triple t) {
        super(inSource);
        trojka=t;
    }

    public void setSimFlag(boolean flag) {
        sim=flag;
    }

    public Triple getMessage() {
        return trojka;
    }

}
