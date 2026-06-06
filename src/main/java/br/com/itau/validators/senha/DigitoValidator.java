package br.com.itau.validators.senha;

import br.com.itau.validators.SenhaValidator;

public class DigitoValidator extends SenhaValidator {

    @Override
    public boolean check(String senha) {

        if (!senha.chars().anyMatch(Character::isDigit)) {
            return false;
        }

        return checkNext(senha);
    }
}