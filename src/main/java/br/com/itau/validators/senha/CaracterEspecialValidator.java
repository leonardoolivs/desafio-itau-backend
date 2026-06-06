package br.com.itau.validators.senha;

import br.com.itau.validator.SenhaValidator;

public class CaracterEspecialValidator extends SenhaValidator {

    private static final String CARACTERES_ESPECIAIS = ".*[!@#$%^&*()\\-+].*";

    @Override
    public boolean check(String senha) {

        if (!senha.matches(CARACTERES_ESPECIAIS)) {
            return false;
        }

        return checkNext(senha);
    }
}
