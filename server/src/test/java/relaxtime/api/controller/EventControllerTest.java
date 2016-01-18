package relaxtime.api.controller;


import org.junit.Test;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import relaxtime.api.ws.TestHandler;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EventControllerTest {
    @Test
    public void testEventList() {
        List<Transport> transports = new ArrayList<>(2);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(new RestTemplateXhrTransport());

        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.doHandshake(new TestHandler(), "http://localhost:8080/sockjs");
    }
}