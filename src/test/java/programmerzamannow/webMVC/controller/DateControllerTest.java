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
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DateControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void getDateTest() throws Exception{
        mockMvc.perform(get("/date").queryParam("date", "2003-09-28"))
        .andExpectAll(status().isOk(), content().string(Matchers.containsString("date : 20030928")));
    }
}
