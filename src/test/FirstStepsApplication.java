package test;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.routing.Template;
import org.restlet.routing.TemplateRoute;

/**
 * Created by chenjiansheng on 2016-5-20.
 */
public class FirstStepsApplication extends Application {
    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());
        // Defines only one route
        TemplateRoute route  = router.attach("/{test}/{test2}/hello", HelloWorldResource.class);
        //route.setMatchingQuery(false);
        return router;
    }
}
