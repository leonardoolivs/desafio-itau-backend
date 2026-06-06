package br.com.itau.unit;

import br.com.itau.services.SenhaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SenhaServiceTest {

    private static SenhaService service;

    @BeforeAll
    public static void setup(){
        service = new SenhaService();
    }

    @Test
    void deveRetornarTrueQuandoSenhaForValida() {
        assertTrue(service.isValid("AbTp9!fok"));
    }

    @Test
    void deveRetornarFalseQuandoSenhaForInvalida() {
        assertFalse(service.isValid("abc"));
    }

}
