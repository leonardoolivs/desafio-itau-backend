package br.com.itau.unit;

import br.com.itau.validators.senha.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SenhaValidatorTest {

    private static TamanhoMinimoValidator tamanhoMinimoValidator;
    private static DigitoValidator digitoValidator;
    private static MinusculaValidator minusculaValidator;
    private static MaiusculaValidator maiusculaValidator;
    private static CaracterEspecialValidator caracterEspecialValidator;
    private static CaracterRepetidoValidator caracterRepetidoValidator;
    private static EspacoValidator espacoValidator;

    @BeforeAll
    public static void setup() {
        tamanhoMinimoValidator = new TamanhoMinimoValidator();
        digitoValidator = new DigitoValidator();
        minusculaValidator = new MinusculaValidator();
        maiusculaValidator = new MaiusculaValidator();
        caracterEspecialValidator = new CaracterEspecialValidator();
        caracterRepetidoValidator = new CaracterRepetidoValidator();
        espacoValidator = new EspacoValidator();
    }

    @Test
    void deveRetornarTrueQuandoPossuiNoveOuMaisCaracteres() {
        assertTrue(tamanhoMinimoValidator.check("123456789"));
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiNoveOuMaisCaracteres() {
        assertFalse(tamanhoMinimoValidator.check("12345678"));
    }

    @Test
    void deveRetornarTrueQuandoPossuiDigito() {
        assertTrue(digitoValidator.check("abc1"));
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiDigito() {
        assertFalse(digitoValidator.check("abc"));
    }

    @Test
    void deveRetornarTrueQuandoPossuiMaiuscula() {
        assertTrue(maiusculaValidator.check("Abc"));
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiMaiuscula() {
        assertFalse(maiusculaValidator.check("abc"));
    }

    @Test
    void deveRetornarTrueQuandoPossuiMinuscula() {
        assertTrue(minusculaValidator.check("abc"));
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiMinuscula() {
        assertFalse(minusculaValidator.check("ABC"));
    }

    @Test
    void deveRetornarTrueQuandoPossuiCaracterEspecial() {
        assertTrue(caracterEspecialValidator.check("a@bc"));
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiCaracterEspecial() {
        assertFalse(caracterEspecialValidator.check("abc"));
    }

    @Test
    void deveRetornarTrueQuandoNaoPossuiCaracterRepetido() {
        assertTrue(caracterRepetidoValidator.check("abc"));
    }

    @Test
    void deveRetornarFalseQuandoPossuiCaracterRepetido() {
        assertFalse(caracterRepetidoValidator.check("aabc"));
    }

    @Test
    void deveRetornarTrueQuandoNaoPossuiEspaco() {
        assertTrue(espacoValidator.check("abc"));
    }

    @Test
    void deveRetornarFalseQuandoPossuiEspaco() {
        assertFalse(espacoValidator.check("a bc"));
    }
}
