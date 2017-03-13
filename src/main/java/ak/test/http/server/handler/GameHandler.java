package ak.test.http.server.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameHandler implements HttpHandler {

    private final Map<String, RequestHandler> handlers = new HashMap<>();
    private final String mainContext;

    public GameHandler(String mainContext) {
        this.mainContext = mainContext;
    }

    public void registerHandler(String requestContext, RequestHandler requestHandler) {
        handlers.put(requestContext, requestHandler);
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String requestContext = getRequestContext(httpExchange);
        if(handlers.containsKey(requestContext)) {
            handlers.get(requestContext).handleRequest(httpExchange);
        }

    }

    String getRequestContext(HttpExchange httpExchange) {
        String withoutContext = httpExchange.getRequestURI().getPath().replaceAll(mainContext, "");
        String[] splittedUrl = withoutContext.split("/");
        return splittedUrl[2];
    }
}
