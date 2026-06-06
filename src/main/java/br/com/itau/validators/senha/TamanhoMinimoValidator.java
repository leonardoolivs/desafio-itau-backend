package br.com.itau.validators.senha;

import br.com.itau.validators.SenhaValidator;

public class TamanhoMinimoValidator extends SenhaValidator {

    private static final int TAMANHO_MINIMO = 9;

    @Override
    public boolean check(String senha) {

        if (senha.length() < TAMANHO_MINIMO) {
            return false;
        }

        return checkNext(senha);
    }
}
