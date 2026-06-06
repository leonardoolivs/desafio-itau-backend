package br.com.itau.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SenhaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarTrueQuandoSenhaValida() throws Exception {

        mockMvc.perform(post("/senha/validacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"senha":"AbTp9!fok"}
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void deveRetornarFalseQuandoSenhaInvalida() throws Exception {

        mockMvc.perform(post("/senha/validacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"senha":"abc"}
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}
