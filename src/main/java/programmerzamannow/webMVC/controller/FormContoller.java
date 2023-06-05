package programmerzamannow.webMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class FormContoller {

    @PostMapping(path = "/form/hello", consumes = org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String hello(@RequestParam(name = "name") String name) {
        return "Hello " + name;
    }
}
