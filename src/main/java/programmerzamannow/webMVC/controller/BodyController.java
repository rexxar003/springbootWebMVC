package programmerzamannow.webMVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import programmerzamannow.webMVC.model.HelloRequest;
import programmerzamannow.webMVC.model.HelloResponse;

@Controller
public class BodyController {

  @Autowired
  private ObjectMapper objectMapper;

  @PostMapping(
    path = "/body/hello",
    consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
    produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseBody
  private String body(@RequestBody String requestBody)throws JsonMappingException, JsonProcessingException {
    //convert
    HelloRequest request = objectMapper.readValue(requestBody,HelloRequest.class);

    HelloResponse response = new HelloResponse();
    response.setHello("hello "+request.getName());

    return objectMapper.writeValueAsString(response);
  }
}
