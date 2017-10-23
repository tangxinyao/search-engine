package party.shaytang.search;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class App {
    private static String PORT = "8080";
    private static String CONTEXT_PAH = "/";
    private static String MAPPING_URL = "/";
    private static String CONFIG_LOCATION_PACKAGE = "party.shaytang.search.config";

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.valueOf(PORT));
        server.setHandler(getServletContextHandler());
        server.start();
        server.join();
    }

    private static ServletContextHandler getServletContextHandler() {
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PAH);

        WebApplicationContext context = getWebApplicationContext();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletHolder servletHolder = new ServletHolder(dispatcherServlet);

        contextHandler.addServlet(servletHolder, MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        return contextHandler;
    }

    private static WebApplicationContext getWebApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION_PACKAGE);
        return context;
    }
}
