package com.example.hateoasdocs.resthateoas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GreetingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createGreeting() throws Exception{
        this.mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(jsonPath("$.content").value("Hello, World!"))
                .andExpect(jsonPath("$._links.self.href").value("http://localhost/greeting?name=World"));

    }

}