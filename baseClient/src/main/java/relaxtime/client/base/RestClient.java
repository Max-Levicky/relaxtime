package relaxtime.client.base;

import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Component
public class RestClient {
    private final RestTemplate restTemplate;
    private final DefaultHttpClient httpClient;

    @Autowired
    public RestClient(RestTemplate restTemplate, DefaultHttpClient httpClient) {
        this.restTemplate = restTemplate;
        this.httpClient = httpClient;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public DefaultHttpClient getHttpClient() {
        return httpClient;
    }
}
