package com.bandcat.BandCat.controller;

import com.bandcat.BandCat.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTests
{
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void postTest() throws Exception
    {
        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content("{\"username\": \"user\"}"))
                .andExpect(status().isOk());
    }
}
