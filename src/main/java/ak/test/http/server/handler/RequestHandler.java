package ak.test.http.server.handler;

import com.sun.net.httpserver.HttpExchange;

public interface RequestHandler {

    void handleRequest(HttpExchange httpExchange);

}
