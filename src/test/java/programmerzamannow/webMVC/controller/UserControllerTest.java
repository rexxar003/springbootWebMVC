package programmerzamannow.webMVC.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import programmerzamannow.webMVC.model.User;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Disabled
    void getUser() throws Exception{
        mockMvc.perform(get("/user/current")
        .sessionAttr("username", new User("kanza")))
        .andExpectAll(status().isOk(),content().string(Matchers.containsString("Hello kanza")));

        //sript ini tidak bisa 
        // cek kesalaha di file userContoller.java , AuthContller.java 
    }
}
