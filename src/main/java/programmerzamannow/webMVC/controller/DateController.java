package programmerzamannow.webMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @GetMapping(path = "/date")
    @ResponseBody
    public String getDate(@RequestParam(name = "date") Date date) throws IOException {
        return "date : " + dateFormat.format(date);
    }
}
