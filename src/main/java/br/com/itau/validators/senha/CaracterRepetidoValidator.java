package br.com.itau.validators.senha;

import br.com.itau.validators.SenhaValidator;

public class CaracterRepetidoValidator extends SenhaValidator {

    @Override
    public boolean check(String senha) {

        if (senha.chars().distinct().count() != senha.length()) {
            return false;
        }

        return checkNext(senha);
    }
}
