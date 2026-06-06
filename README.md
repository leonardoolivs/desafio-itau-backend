# API de Validação de Senhas

## Descrição

API REST desenvolvida em Java com Spring Boot para validação de senhas de acordo com regras de negócio pré-definidas.

## Tecnologias Utilizadas

* Java 17
* Spring Boot 3.5.14
* Spring Web
* Spring Validation
* Lombok
* Spring Actuator
* Swagger / OpenAPI
* Internacionalização (i18n)
* JUnit 5
* Mockito

## Como Executar o Projeto

### Pré-requisitos

* Java 17 instalado
* Maven 3.9+
* Git

### Clonar o Repositório

```bash
git clone https://github.com/leonardoolivs/desafio-itau-backend
```

```bash
cd desafio-itau-backend
```

### Executar com Maven

```bash
mvn spring-boot:run
```

### Gerar Build

```bash
mvn clean package
```

O arquivo gerado ficará em:

```text
target/
```

### Executar o JAR

```bash
java -jar target/itau-0.0.1-SNAPSHOT.jar
```

### Executando os Testes

Para executar todos os testes unitários:

```bash
mvn test
```

## Regras de Validação da Senha

Uma senha será considerada válida quando atender **todas** as regras abaixo:

* Possuir no mínimo 9 caracteres
* Possuir ao menos 1 dígito
* Possuir ao menos 1 letra minúscula
* Possuir ao menos 1 letra maiúscula
* Possuir ao menos 1 caractere especial
* Não possuir caracteres repetidos
* Não possuir espaços em branco
* Caracteres especiais permitidos: !@#$%^&*()-+

## Exemplos

| Senha       | Resultado |
| ----------- | --------- |
| ""          | false     |
| "aa"        | false     |
| "ab"        | false     |
| "AAAbbbCc"  | false     |
| "AbTp9!foo" | false     |
| "AbTp9!foA" | false     |
| "AbTp9 fok" | false     |
| "AbTp9!fok" | true      |

# Endpoints

## Validar Senha

### Requisição

```http
POST /senha/validacao
```

### Comportamento

* Retorna `true` quando todas as regras forem atendidas.
* Retorna `false` quando ao menos uma regra for violada.

### Request Body

```json
{
  "senha": "AbTp9!fok"
}
```

### Resposta de Sucesso

```http
200 OK
```

```json
true
```

ou

```json
false
```

## Health Check

### Requisição

```http
GET /actuator/health
```

### Resposta

```json
{
  "status": "UP"
}
```

Este endpoint pode ser utilizado para monitoramento da aplicação e validação de disponibilidade.

# Tratamento de Erros

A API possui tratamento centralizado de exceções para fornecer respostas padronizadas.

## 400 - Bad Request

Retornado quando o JSON enviado é inválido ou contém campos inexistentes.

### JSON Inválido

Exemplo:

```json
{
  "senha": 
}
```

Resposta:

```json
{
  "status": 400,
  "error": "JSON inválido"
}
```

### Campo Inexistente

Exemplo:

```json
{
  "senhaa": "AbTp9!fok"
}
```

Resposta:

```json
{
  "status": 400,
  "error": "Campo 'senhaa' não existe"
}
```

## 422 - Unprocessable Entity

Retornado quando alguma regra de validação é violada.

Exemplo:

```json
{
  "senha": null
}
```

Resposta:

```json
{
  "status": 422,
  "errors": [
    {
      "field": "senha",
      "message": "campo obrigatório"
    }
  ]
}
```

## 404 - Not Found

Retornado quando o endpoint solicitado não existe.

Exemplo:

```http
POST /senha/validacaoo
```

Resposta:

```json
{
  "status": 404,
  "error": "Endpoint não encontrado"
}
```

## 500 - Internal Server Error

Retornado para erros inesperados da aplicação.

```json
{
  "status": 500,
  "error": "Erro interno do servidor"
}
```

# Documentação da API

Após iniciar a aplicação, a documentação poderá ser acessada através do Swagger:

```text
http://localhost:8080/swagger-ui.html
```

# Monitoramento

Endpoints do Spring Actuator disponíveis através de:

```text
http://localhost:8080/actuator
```

Health Check:

```text
http://localhost:8080/actuator/health
```

# Arquitetura e Boas Práticas
* Clean Code
* SOLID
* Baixo acoplamento
* Alta coesão
* Tratamento centralizado de exceções
* Internacionalização de mensagens
* Documentação OpenAPI
* Monitoramento com Spring Actuator
* Testes unitários
