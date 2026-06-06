package br.com.itau.validators.senha;

import br.com.itau.validator.SenhaValidator;

public class EspacoValidator extends SenhaValidator {

    @Override
    public boolean check(String senha) {

        if (senha.chars().anyMatch(Character::isSpaceChar)) {
            return false;
        }

        return checkNext(senha);
    }
}
