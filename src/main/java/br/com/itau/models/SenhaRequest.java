package br.com.itau.models;

import jakarta.validation.constraints.NotNull;

public record SenhaRequest(@NotNull String senha){
}
