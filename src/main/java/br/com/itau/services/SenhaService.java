package br.com.itau.services;

import br.com.itau.validators.SenhaValidator;
import br.com.itau.validators.senha.*;
import org.springframework.stereotype.Service;

@Service
public class SenhaService {

    public boolean isValid(String senha) {
        SenhaValidator validator = SenhaValidator.link(
                new TamanhoMinimoValidator(),
                new DigitoValidator(),
                new MinusculaValidator(),
                new MaiusculaValidator(),
                new CaracterEspecialValidator(),
                new EspacoValidator(),
                new CaracterRepetidoValidator());

        return validator.check(senha);
    }

}