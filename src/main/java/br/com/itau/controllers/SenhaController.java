package br.com.itau.controllers;

import br.com.itau.models.SenhaRequest;
import br.com.itau.services.SenhaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/validar")
@Tag(name = "Senha")
public class SenhaController {

    private final SenhaService service;

    @PostMapping
    @Operation(summary = "Validar senha", description = "Retorna 'true' caso a senha atenda todos os critérios e 'false' caso contrário.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Senha validada com sucesso")
    })
    public ResponseEntity<Boolean> isValid(@RequestBody @Valid SenhaRequest request){
        Boolean senhaValida = service.isValid(request.senha());

        return ResponseEntity.ok(senhaValida);
    }
}
