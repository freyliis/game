package ak.test.http.server.handler;

import com.sun.net.httpserver.HttpExchange;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GameHandlerTest {

    HttpExchange httpExchangeMock = mock(HttpExchange.class);

    @Test
    public void shouldReturnUserIdFromLoginRequest() throws IOException {
        String mainContext = "http://localhost:8081";
        String requestUrl = mainContext + "/4711/login";
        GameHandler objectUnderTest = new GameHandler(mainContext);
        when(httpExchangeMock.getRequestURI()).thenReturn(URI.create(requestUrl));
        String result = objectUnderTest.getRequestContext(httpExchangeMock);
        assertThat(result, is("login"));
    }

    @Test
    public void shouldReturnLoginRequestHandlerForLoginUrl() throws IOException {
        String mainContext = "http://localhost:8081";
        String requestUrl = mainContext + "/4711/login";
        GameHandler objectUnderTest = new GameHandler(mainContext);
        when(httpExchangeMock.getRequestURI()).thenReturn(URI.create(requestUrl));
        RequestHandler requestHandler = mock(RequestHandler.class);
        objectUnderTest.registerHandler("login", requestHandler);
        objectUnderTest.handle(httpExchangeMock);
        verify(requestHandler, times(1)).handleRequest(httpExchangeMock);
    }
}