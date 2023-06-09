package programmerzamannow.webMVC.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create() throws Exception{
        mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON)
        .param("firstName", "kanza")
        .param("middleName", "az")
        .param("lastName", "zahrawani")
        .param("email", "kanza@gmail.com")
        .param("phone", "xiaomi")
        .param("address.street", "jln.srijaya")
        .param("address.city", "palembang")
        .param("address.country", "indonesia")
        .param("address.postalCode", "1111")
        .param("hobbies[0]", "coding")
        .param("hobbies[1]", "reading")
        .param("hobbies[2]", "gaming")
        .param("socialMedia[0].name", "kanzaazIG")
        .param("socialMedia[0].location", "socailMediaLocation")
        .param("socialMedia[1].name", "kanzaazIG1")
        .param("socialMedia[1].location", "socailMediaLocation1")
        
        

        ).andExpectAll(status().isOk(),content().string(Matchers.containsString(
            "Succes create person kanza az zahrawani with email kanza@gmail.com with phone xiaomi with address"+
            " jln.srijaya, palembang, indonesia, postal code 1111"
        )));
    }
}
