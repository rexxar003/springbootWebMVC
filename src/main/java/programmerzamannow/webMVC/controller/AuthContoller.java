package programmerzamannow.webMVC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class AuthContoller {
    
    @PostMapping(path = "/auth/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String>  login(
    @RequestParam(name = "username") String name
    ,@RequestParam(name = "password") String Password){
        if("kanza".equals(name) && "rahasia".equals(Password)){
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
        }
    }
}
