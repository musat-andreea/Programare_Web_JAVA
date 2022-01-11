package com.andreea.proiectjavafacultate;

import com.andreea.proiectjavafacultate.controllers.DesignerController;
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
public class DesignerControllerTest {
    @Autowired
    private DesignerController controller;

    @Autowired
    private MockMvc mockMvc;

    private int insertedId;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldInsertDesignerWithCity() throws Exception {
            this.mockMvc.perform(post("/addDesigner").contentType("application/json;charset=UTF-8").content("{\"name\":\"Automation Test\"}") )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("true")));
    }


    @Test
    public void shouldReturnAllDesignersInArray() throws Exception {
        this.mockMvc.perform(get("/designers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldReturnDesignerById() throws Exception {
        this.mockMvc.perform(get("/designer/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldDeleteDesignerById() throws Exception {
        this.mockMvc.perform(post("/delDesigner/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("true")));
    }

}
