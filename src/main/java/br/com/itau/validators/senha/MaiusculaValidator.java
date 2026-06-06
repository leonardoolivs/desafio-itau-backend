package br.com.itau.validators.senha;

import br.com.itau.validators.SenhaValidator;

public class MaiusculaValidator extends SenhaValidator {

    @Override
    public boolean check(String senha) {

        if (!senha.chars().anyMatch(Character::isUpperCase)) {
            return false;
        }

        return checkNext(senha);
    }
}
