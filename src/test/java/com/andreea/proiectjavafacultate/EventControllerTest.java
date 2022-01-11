package com.andreea.proiectjavafacultate;

import com.andreea.proiectjavafacultate.controllers.EventController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {
    @Autowired
    private EventController controller;

    @Autowired
    private MockMvc mockMvc;

    private int insertedId;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldInsertEventWithCity() throws Exception {
            this.mockMvc.perform(post("/addEvent").contentType("application/json;charset=UTF-8").content("{\"event_name\":\"Automation Test\",\"event_date\":\"2019-01-01\"}") )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("true")));
    }


    @Test
    public void shouldReturnAllEventsInArray() throws Exception {
        this.mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldReturnEventById() throws Exception {
        this.mockMvc.perform(get("/events/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldDeleteEventById() throws Exception {
        this.mockMvc.perform(post("/delEvent/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("true")));
    }

}
