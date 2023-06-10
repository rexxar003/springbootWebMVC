package programmerzamannow.webMVC.controller;


import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class StaticResourcesTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStaticResource() throws Exception{

        mockMvc.perform(get("/index.html")).andExpectAll(status().isOk()
        ,content().string(Matchers.containsString("Hello static"))
        );


    }
}
