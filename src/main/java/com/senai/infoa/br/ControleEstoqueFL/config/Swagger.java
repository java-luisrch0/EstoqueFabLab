package com.senai.infoa.ControleEstoqueFL.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Estoque do FabLab",
        version = "1.0",
        description = "email de contato: gabril.q.pontes@aluno.senai.br"
    )
)
public class Swagger {
    
}