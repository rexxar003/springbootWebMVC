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
public class AuthControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void succesLogin() throws Exception{
        mockMvc.perform(post("/auth/login")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("username", "kanza")
        .param("password", "rahasia"))
        .andExpectAll(status().isOk(),content().string(Matchers.containsString("OK"))
        , cookie().value("username", Matchers.is("kanza")));
    }
}
