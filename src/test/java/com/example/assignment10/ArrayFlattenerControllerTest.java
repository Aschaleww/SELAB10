package com.example.assignment10;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ArrayFlattenerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFlattenArrayEndpoint_valid2DArray() throws Exception {
        String jsonArray = "[[1, 3], [0], [4, 5, 9]]";

        mockMvc.perform(post("/api/array/flatten")
                        .contentType("application/json")
                        .content(jsonArray))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(arrayContaining(1, 3, 0, 4, 5, 9))));
    }

    @Test
    public void testFlattenArrayEndpoint_nullArray() throws Exception {
        mockMvc.perform(post("/api/array/flatten")
                        .contentType("application/json")
                        .content("null"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }
}

