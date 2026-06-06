package br.com.itau.validators.senha;

import br.com.itau.validator.SenhaValidator;

public class MinusculaValidator extends SenhaValidator {

    @Override
    public boolean check(String senha) {

        if (!senha.chars().anyMatch(Character::isLowerCase)) {
            return false;
        }

        return checkNext(senha);
    }
}
