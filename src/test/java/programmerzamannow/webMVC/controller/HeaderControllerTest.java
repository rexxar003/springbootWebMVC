package programmerzamannow.webMVC.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HeaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void headersucces() throws Exception {
        mockMvc.perform(get("/header/token").header("X-TOKEN", "KANZA"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("OK")));
    }

    @Test
    public void headerfailed() throws Exception {
        mockMvc.perform(get("/header/token").header("X-TOKEN", "NOBODY"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("KO")));
    }
}
