package com.avaneesh.bfhl_java_assignment;

import com.avaneesh.bfhl_java_assignment.dto.BfhlRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BfhlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // TEST CASE 1
    @Test
    public void testMixedData() throws Exception {

        BfhlRequest request =
                new BfhlRequest(
                        Arrays.asList(
                                "a",
                                "1",
                                "334",
                                "4",
                                "R",
                                "$"
                        )
                );

        mockMvc.perform(
                        post("/bfhl")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        objectMapper.writeValueAsString(request)
                                )
                )
                .andExpect(status().isOk());
    }
    @Test
    public void testOnlyAlphabets() throws Exception {

        BfhlRequest request =
                new BfhlRequest(
                        Arrays.asList(
                                "A",
                                "ABCD",
                                "DOE"
                        )
                );

        mockMvc.perform(
                        post("/bfhl")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        objectMapper.writeValueAsString(request)
                                )
                )
                .andExpect(status().isOk());
    }

    @Test
    public void testNumbersAndSpecialCharacters() throws Exception {

        BfhlRequest request =
                new BfhlRequest(
                        Arrays.asList(
                                "1",
                                "2",
                                "3",
                                "$",
                                "@"
                        )
                );

        mockMvc.perform(
                        post("/bfhl")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        objectMapper.writeValueAsString(request)
                                )
                )
                .andExpect(status().isOk());
    }
}