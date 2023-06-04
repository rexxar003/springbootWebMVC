package programmerzamannow.webMVC.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        if (name == null) {
            return "Hello guest";
        } else {
            return "hello " + name;
        }
    }
}
