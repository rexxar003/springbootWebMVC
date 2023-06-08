package programmerzamannow.webMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import programmerzamannow.webMVC.model.CreatePersonRequest;
import programmerzamannow.webMVC.model.CreateSocialMediaRequest;


@SpringBootTest
@AutoConfigureMockMvc
public class PersonApiCotrollerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception{
        CreatePersonRequest request = new CreatePersonRequest();

        request.setFirstName("kanza");
        request.setMiddleName("az");
        request.setLastName("zahrawani");
        request.setEmail("kanza@gmail.com");
        request.setPhone("xiaomi");
        request.setHobbies(List.of("coding", "gaming", "reading"));
        request.setSocialMedia(new ArrayList<>());
        request.getSocialMedia().add(new CreateSocialMediaRequest("ig","kanzaIg"));
        request.getSocialMedia().add(new CreateSocialMediaRequest("facebood","kanzaFb"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/person")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
        .accept(org.springframework.http.MediaType.APPLICATION_JSON)
        .content(jsonRequest)
        )
        .andExpectAll(status().isOk(),content().json(jsonRequest));

    } 

    @Test
    void badRequest() throws JsonProcessingException, Exception{


        CreatePersonRequest request = new CreatePersonRequest();
        request.setMiddleName("az");
        request.setHobbies(List.of("coding"));
        request.setSocialMedia(new ArrayList<>());
        request.getSocialMedia().add(new CreateSocialMediaRequest("IG", "kanzaIG"));


        mockMvc.perform(post("/api/person")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(status().isBadRequest());
    }
}
