package programmerzamannow.webMVC.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import programmerzamannow.webMVC.model.CreatePersonRequest;

@Controller
public class PersonApiController {
    
    @PostMapping(
        path = "/api/person",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public CreatePersonRequest createPerson(@RequestBody @Valid CreatePersonRequest Request){
        return Request;
    }
}
