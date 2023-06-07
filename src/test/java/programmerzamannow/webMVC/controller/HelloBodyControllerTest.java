package programmerzamannow.webMVC.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.apache.tomcat.util.http.parser.MediaType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import programmerzamannow.webMVC.model.HelloRequest;
import programmerzamannow.webMVC.model.HelloResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloBodyControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void HelloBody() throws JsonProcessingException, Exception{
        HelloRequest request = new HelloRequest();
        request.setName("kanza");

        mockMvc.perform(post("/body/hello")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
        .accept(org.springframework.http.MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request))
        )
        .andExpectAll(
            status().isOk()
            ,header().string(HttpHeaders.CONTENT_TYPE, 
            Matchers.containsString(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)))
        .andExpect(result -> {
            String responseJson = result.getResponse().getContentAsString();

            HelloResponse helloResponse = objectMapper.readValue(responseJson,  HelloResponse.class);
            assertEquals("hello kanza", helloResponse.getHello());
        });
    }
}
