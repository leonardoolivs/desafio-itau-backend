package br.com.itau.controllers;

import br.com.itau.models.SenhaRequest;
import br.com.itau.services.SenhaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/validar-senha")
public class SenhaController {

    private final SenhaService service;

    @PostMapping
    public ResponseEntity<Boolean> isValid(@RequestBody @Valid SenhaRequest dto){

        Boolean senhaValida = service.isValid(dto.senha());

        return ResponseEntity.ok(senhaValida);
    }
}
