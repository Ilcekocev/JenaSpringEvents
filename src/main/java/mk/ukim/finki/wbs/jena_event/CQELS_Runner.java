package mk.ukim.finki.wbs.jena_event;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.Model;
import mk.ukim.finki.wbs.jena_event.events.JenaEventListener;
import mk.ukim.finki.wbs.jena_event.helpers.AssertListeners;
import mk.ukim.finki.wbs.jena_event.helpers.AssertListeners.SelectAssertListener;
import mk.ukim.finki.wbs.jena_event.helpers.Helpers;
import mk.ukim.finki.wbs.jena_event.streamers.TestStream;
import org.deri.cqels.data.Mapping;
import org.deri.cqels.engine.ContinuousSelect;
import org.deri.cqels.engine.ExecContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by Ilce on 7/17/2017.
 */
@Component
@Order(value = 3)
public class CQELS_Runner implements CommandLineRunner {

    @Autowired
    private JenaEventListener listener;

    private static final String STREAM_ID_PREFIX = "http://test/stream/s";
    private static final String CQELS_HOME = "cqels_home";
    private static ExecContext context;


    public static void beforeClass() {
        File home = new File(CQELS_HOME);
        if (!home.exists()) {
            home.mkdir();
        }
        context = new ExecContext(CQELS_HOME, true);
    }

    @Override
    public void run(String... strings) throws Exception {


        beforeClass();

        Model model = listener.getModel();

        final String STREAM_ID = STREAM_ID_PREFIX + "_1";

        TestStream stream = new TestStream(context,STREAM_ID);

        //Simple select query to select all triples in the stream
        ContinuousSelect query = context.registerSelect(""
                + "SELECT ?x ?y ?z WHERE {"
                + "STREAM <" + STREAM_ID + "> [NOW] {?x ?y ?z}"
                + "}");

        SelectAssertListener listener = new SelectAssertListener();
        query.register(listener);

        stream.stream(model);

        //The mappings are the filterd result from the query
        List<Mapping> mappings = null;
        try {
            mappings = listener.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Get the first triple from the mappings
        List<Node> nodes = Helpers.toNodeList(context, mappings.get(0));
        System.out.println("-----------The result from the first query is:--------------");
        Helpers.print(context, mappings);

       //Simple query to select only tasks from the stream
        ContinuousSelect query2 = context.registerSelect(
                 "PREFIX p: <http://test/task/> \n"
                + "SELECT ?x WHERE {"
                + "STREAM <" + STREAM_ID + "> [NOW] {\n"
                + "?x p:Time ?z .\n"
                + "}\n"
                + "}");

        listener = new SelectAssertListener();
        query2.register(listener);

        stream.stream(model);

        mappings = null;
        try {
            mappings = listener.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-----------The result from the seccond query is:--------------");
        Helpers.print(context, mappings);

    }
}
