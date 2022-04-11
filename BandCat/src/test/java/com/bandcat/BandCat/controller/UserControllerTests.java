package com.bandcat.BandCat.controller;

import com.bandcat.BandCat.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Tyler, Tom, Marcus
 *
 * This class is designed to test the UserController class
 */
@WebMvcTest(UserController.class)
public class UserControllerTests
{
    /**
     * Tyler, Tom, Marcus
     *
     * Service(s) needed for the Controller
     */
    @MockBean
    private UserService userService;

    /**
     * Tyler, Tom, Marcus
     *
     * For HTTP request/response support from Spring
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * @author Tyler, Tom, Marcus
     * @throws Exception HTTP Request could fail
     */
    @Test
    void postTest() throws Exception
    {
        // mockMvc -> used to perform HTTP requests
        mockMvc.perform(post("/users")        // Indicate HTTP method and url
                .contentType("application/json")        // Indicate content type
                .content("{\"username\": \"user\"}"))   // Set content to send (only works for post, use params for get)
                .andExpect(status().isOk());            // Expectation for test
    }
}
