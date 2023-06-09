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
public class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void formHello() throws Exception {
        mockMvc.perform(post("/form/hello")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "kanza")).andExpectAll(status().isOk(),
                        header().string(org.springframework.http.HttpHeaders.CONTENT_TYPE,
                                Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                        content().string(Matchers.containsString("Hello kanza")));
    }

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(post("/form/person").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "kanza")
                .param("birthDate", "2003-09-28")
                .param("address", "Indonesia"))
                .andExpectAll(status().isOk(), content().string(
                        Matchers.containsString(
                                "succes create person with name :kanzabirthDate : 2003-09-28address : Indonesia")));
    }

}
