package com.andreea.proiectjavafacultate;

import com.andreea.proiectjavafacultate.controllers.LocationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocationControllerTest {
    @Autowired
    private LocationController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldInsertLocationWithCity() throws Exception {
            this.mockMvc.perform(post("/addLocation").contentType("application/json;charset=UTF-8")
                    .content("{\n" +
                            "    \"eventId\": 1,\n" +
                            "    \"city\": \"Iasi\",\n" +
                            "    \"country\": \"Romania\",\n" +
                            "    \"capacity\": 100,\n" +
                            "    \"status\": true\n" +
                            "}"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("true")));
    }


    @Test
    public void shouldReturnAllLocationsInArray() throws Exception {
        this.mockMvc.perform(get("/locations"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldReturnLocationById() throws Exception {
        this.mockMvc.perform(get("/location/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldDeleteLocationById() throws Exception {
        this.mockMvc.perform(post("/delLocation/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("true")));
    }

}
