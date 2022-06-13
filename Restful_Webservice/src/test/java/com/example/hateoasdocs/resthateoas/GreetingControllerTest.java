package com.example.hateoasdocs.resthateoas;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
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


    @Test
    @DisplayName("링크 테스트")
    public void link(){
        Link link = Link.of("/test");
        assertEquals(link.getHref(), "/test");
        assertEquals(link.getRel(), IanaLinkRelations.SELF);
        log.info("1::{}", link.getHref());
        log.info("1::{}", link.getRel());
        log.info("1::{}", IanaLinkRelations.SELF);

        link = Link.of("/test", "relTest");
        assertEquals(link.getHref(), "/test");
        assertEquals(link.getRel(), LinkRelation.of("relTest"));
        log.info("2::{}", link.getHref());
        log.info("2::{}", link.getRel());
        log.info("2::{}", LinkRelation.of("relTest"));


        link = Link.of("/test", IanaLinkRelations.NEXT);
        assertEquals(link.getRel(), LinkRelation.of("next"));
        assertTrue(IanaLinkRelations.isIanaRel(link.getRel()));
        log.info("3::{}", link.getRel());
        log.info("3::{}", LinkRelation.of("next"));
        log.info("3::{}", IanaLinkRelations.isIanaRel(link.getRel()));

    }

}