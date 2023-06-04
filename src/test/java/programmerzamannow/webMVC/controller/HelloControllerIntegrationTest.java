package programmerzamannow.webMVC.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void gustTest() {
        String request = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class).getBody();
        Assertions.assertNotNull(request);
        Assertions.assertEquals(request.trim(), "hello world guest");
        log.info(request);
    }
    
    @Test
    void nameTest() {
        String request = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=kanza", String.class)
        .getBody();
        Assertions.assertNotNull(request);
        Assertions.assertEquals(request.trim(), "hello world kanza");
        System.out.println(request);
        log.info(request);
    }
}
