package mk.ukim.finki.wbs.jena_event.streamers;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import org.deri.cqels.engine.ExecContext;
import org.deri.cqels.engine.RDFStream;


/**
 * Created by Ilce on 7/4/2017.
 */
public class TestStream extends RDFStream {

    public TestStream(ExecContext context, String uri) {
        super(context,uri);
    }


    public void stream(Model t) {
        StmtIterator iter = t.listStatements();
        while (iter.hasNext()) {
            super.stream(iter.next().asTriple());
        }
    }
    @Override
    public void stop() {
    }
}
