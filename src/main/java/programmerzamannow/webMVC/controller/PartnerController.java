package programmerzamannow.webMVC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import programmerzamannow.webMVC.model.Partner;

public class PartnerController {
    
    @GetMapping(path = "/partner/current")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getPartner(Partner partner){
        return partner.getId()+" : " + partner.getName();
    }
}
