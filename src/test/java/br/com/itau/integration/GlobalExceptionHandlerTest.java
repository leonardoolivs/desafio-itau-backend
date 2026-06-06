package br.com.itau.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornar422QuandoSenhaForNula() throws Exception {

        mockMvc.perform(post("/senha/validacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"senha":null}
                                """))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.error")
                        .value("Campo(s) abaixo com erro(s)"))
                .andExpect(jsonPath("$.errors[0].fieldName")
                        .value("senha"))
                .andExpect(jsonPath("$.errors[0].message")
                        .value("campo obrigatório"));
    }

    @Test
    void deveRetornar404QuandoEndpointNaoExistir() throws Exception {

        mockMvc.perform(post("/senha/validacaoo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error")
                        .value("Endpoint não encontrado"));
    }

    @Test
    void deveRetornar400QuandoCampoNaoExistir() throws Exception {

        mockMvc.perform(post("/senha/validacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "senhaa": "AbTp9!fok"
                            }
                            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Campo 'senhaa' não existe"));
    }

    @Test
    void deveRetornar400QuandoJsonForInvalido() throws Exception {

        mockMvc.perform(post("/senha/validacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "senha":
                            }
                            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("JSON inválido"));
    }

    @Test
    void deveRetornar500QuandoErroInternoDoServidor() throws Exception {

        mockMvc.perform(get("/senha/validacao")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error")
                        .value("Erro interno do servidor"));
    }
}