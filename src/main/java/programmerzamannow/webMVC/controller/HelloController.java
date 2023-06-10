package programmerzamannow.webMVC.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import javax.swing.plaf.TreeUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;
import programmerzamannow.webMVC.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    // @GetMapping // bisa juga menggunakan annotation ini tanpa harus menulis di
    // method di atas
    public void helloWorld(@RequestParam(name = "name", required = false) String name, HttpServletResponse response)
            throws IOException {

        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false)String name){

        if(Objects.isNull(name)){
            return new ModelAndView("redirects:/web/hello?name=Guest");
        }else{
        return new ModelAndView("hello",Map.of(
        "title", "belajar view",
        "name", name)
        );
        }
    }
}
