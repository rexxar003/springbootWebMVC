package programmerzamannow.webMVC.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import programmerzamannow.webMVC.model.CreatePersonRequest;

@Controller
public class PersonController {


    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createPerson(@ModelAttribute CreatePersonRequest request, BindingResult bindingResult){

        List<ObjectError> errors = bindingResult.getAllErrors();

        if(!errors.isEmpty()){

            errors.forEach(objectError -> {
                System.out.println(objectError.getDefaultMessage());
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you send invalid data");
        }
        
        System.out.println(request);


        String response =  new StringBuilder().append("Succes create person ").append(request.getFirstName())
        .append(" ").append(request.getMiddleName()).append(" ").append(request.getLastName())
        .append(" ").append("with email ").append(request.getEmail()).append(" ")
        .append("with phone ").append(request.getPhone())
        .append(" with address ").append(request.getAddress().getStreet()).append(", ")
        .append(request.getAddress().getCity()).append(", ")
        .append(request.getAddress().getCountry()).append(", ")
        .append("postal code ").append(request.getAddress().getPostalCode())
        .toString();

        return ResponseEntity.ok(response);
    }
    
}
