package com.bandcat.BandCat.controller;

import com.bandcat.BandCat.model.User;
import com.bandcat.BandCat.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Maybe come back to later.
 * Utilizing Postman for controller testing
 * @author Tyler Tom and Marcus
 */
@WebMvcTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // webEnvironment creates a temporary web server port to run requests/responses through
public class UserControllerTests {

    @LocalServerPort
    private int port;           // Port to use in webEnvironment
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService userService;


    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    @Test
    public void HttpWorks() throws Exception {
     mockMvc.perform((RequestBuilder) post("/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }






}
