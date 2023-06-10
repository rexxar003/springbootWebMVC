package programmerzamannow.webMVC.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PartnerControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test 
    @Disabled
    void getPartner() throws Exception{
        mockMvc.perform(
            get("/partner/current")
            .header("X-API-KEY", "sample"))
        .andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("SAMPLE:Sample Partner")
            )
            );

            //kodingan ini tidak lancar
    }
    
}
