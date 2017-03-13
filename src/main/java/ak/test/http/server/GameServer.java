package ak.test.http.server;

import ak.test.http.server.handler.GameHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class GameServer {

    public static final String MAIN_CONTEXT = "/";
    private final HttpServer httpServer;

    public GameServer(int portNumber) throws IOException {
        this.httpServer = HttpServer.create(new InetSocketAddress(portNumber), 0);
        this.httpServer.createContext(MAIN_CONTEXT, new GameHandler(MAIN_CONTEXT));
    }
}
