package it.zilfio.artistportrait.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ArtistPortraitControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSecondsAlive() throws Exception {
        Map<String,Object> body = new HashMap<>();
        body.put("birthDate","2020-01-01T00:00:00");
        body.put("deathDate","2020-01-01T00:00:00");
        mockMvc.perform(post("/api/v1/artistPortrait/secondsAlive")
                        .content(mapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void testSecondsAliveInvalidDateFormat() throws Exception {
        Map<String,Object> body = new HashMap<>();
        body.put("birthDate","1990/01/01");
        body.put("deathDate","2020/01/01");
        mockMvc.perform(post("/api/v1/artistPortrait/secondsAlive")
                        .content(mapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSecondsAliveNegativeResult() throws Exception {
        Map<String,Object> body = new HashMap<>();
        body.put("birthDate","2020-01-01T00:00:00");
        body.put("deathDate","1990-01-01T00:00:00");
        mockMvc.perform(post("/api/v1/artistPortrait/secondsAlive")
                        .content(mapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSecondsAliveMissingParameter() throws Exception {
        Map<String,Object> body = new HashMap<>();
        body.put("birthDate","2020-01-01T00:00:00");
        mockMvc.perform(post("/api/v1/artistPortrait/secondsAlive")
                        .content(mapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testDaysAlive() throws Exception {
        Map<String,Object> body = new HashMap<>();
        body.put("birthDate","2020-01-01T00:00:00");
        body.put("deathDate","2020-01-01T00:00:00");
        mockMvc.perform(post("/api/v1/artistPortrait/daysAlive")
                        .content(mapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}