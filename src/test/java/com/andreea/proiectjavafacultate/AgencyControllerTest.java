package com.andreea.proiectjavafacultate;

import com.andreea.proiectjavafacultate.controllers.AgencyController;
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
public class AgencyControllerTest {
    @Autowired
    private AgencyController controller;

    @Autowired
    private MockMvc mockMvc;

    private int insertedId;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldInsertAgencyWithCity() throws Exception {
            this.mockMvc.perform(post("/addAgency").contentType("application/json;charset=UTF-8").content("{\"nume\":\"Automation Test\"}"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("true")));
    }


    @Test
    public void shouldReturnAllAgencysInArray() throws Exception {
        this.mockMvc.perform(get("/agencies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldReturnAgencyById() throws Exception {
        this.mockMvc.perform(get("/agency/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldDeleteAgencyById() throws Exception {
        this.mockMvc.perform(post("/delAgency/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("true")));
    }

}
