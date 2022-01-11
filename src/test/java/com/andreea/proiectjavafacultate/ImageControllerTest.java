package com.andreea.proiectjavafacultate;

import com.andreea.proiectjavafacultate.controllers.ImageController;
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
public class ImageControllerTest {
    @Autowired
    private ImageController controller;

    @Autowired
    private MockMvc mockMvc;

    private int insertedId;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldInsertImageWithCity() throws Exception {
            this.mockMvc.perform(post("/addImage").contentType("application/json;charset=UTF-8").content("{\"image\":\"base64 Automation Test\"}") )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("true")));
    }


    @Test
    public void shouldReturnAllImagesInArray() throws Exception {
        this.mockMvc.perform(get("/images"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldReturnImageById() throws Exception {
        this.mockMvc.perform(get("/image/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldDeleteImageById() throws Exception {
        this.mockMvc.perform(post("/delImage/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("true")));
    }

}
