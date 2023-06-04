package programmerzamannow.webMVC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import programmerzamannow.webMVC.service.HelloService;

@SpringBootTest
public class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;

    @Test
    void helloTest() {
        Assertions.assertNotNull(helloService);

        Assertions.assertEquals(helloService.hello(null), "Hello guest");
        Assertions.assertEquals(helloService.hello("kanza"), "Hello kanza");

    }
}
