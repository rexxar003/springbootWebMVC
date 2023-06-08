package programmerzamannow.webMVC.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test 
    void uploadTest() throws IOException, Exception{
        mockMvc.perform(multipart("/upload/profile")
        .file(new MockMultipartFile("profile", "profile.png","image/png",
         getClass().getResourceAsStream("/images/profile.png"))).param("name", "kanza")
         .contentType(MediaType.MULTIPART_FORM_DATA)).andExpectAll(status().isOk(), 
         content().string(Matchers.containsString("succes save profile kanza to upload\\profile.png")));
    }
}
