package programmerzamannow.webMVC.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
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
        ).andExpectAll(status().isOk(),content().string(Matchers.containsString(
            "Succes create person kanza az zahrawani with email kanza@gmail.com with phone xiaomi"
        )));
    }
}
