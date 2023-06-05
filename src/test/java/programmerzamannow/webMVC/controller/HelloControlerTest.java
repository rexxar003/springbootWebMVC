package programmerzamannow.webMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloGuestTest() throws Exception {
        mockMvc.perform(
                get("/hello")).andExpectAll(status().isOk(),
                        content().string(Matchers.containsString("Hello guest")));
    }

    @Test
    public void hellonameTest() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "kanza"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("hello kanza")));
    }

    @Test
    public void helloPost() throws Exception {
        mockMvc.perform(post("/hello").queryParam("name", "kanza"))
                .andExpectAll(status().isMethodNotAllowed());
    }

}
