# API de Criptografia — Cifra de Vernam

## 1. Sobre o projeto

Este projeto consiste no desenvolvimento de uma API REST para criptografar e descriptografar mensagens utilizando a Cifra de Vernam.

A aplicação foi desenvolvida em Java com Spring Boot e permite realizar operações de criptografia e descriptografia por meio de requisições HTTP.

## 2. Integrante

- Luiz Victor Carneiro Bueno

Trabalho realizado individualmente.

## 3. Tecnologias utilizadas

- Java 25
- Spring Boot
- Maven
- Spring Web
- Spring Validation
- JUnit 5
- Base64

## 4. Links do projeto

**Repositório GitHub:**

https://github.com/luizvictor856/cifra-vernam-api

**API hospedada no Vercel:**

https://cifra-vernam-api.vercel.app

**Documentação Swagger:**

https://cifra-vernam-api.vercel.app/swagger-ui/index.html

## 5. Como executar o projeto

### Pré-requisitos

- Java JDK 25 instalado.
- Visual Studio Code ou outra IDE compatível.
- Terminal de comandos.

### Passo 1 — Abrir o projeto

Abra a pasta `cifra-vernam-api` no Visual Studio Code.

### Passo 2 — Executar a aplicação

Abra o terminal na raiz do projeto, onde está localizado o arquivo `pom.xml`, e execute:

```powershell
.\mvnw\.cmd spring-boot:run
```

Aguarde a inicialização do Spring Boot.

Quando a aplicação estiver iniciada, estará disponível em:

`http://localhost:8080`

## 6. Endpoints disponíveis

A API possui dois endpoints principais.

### 6.1 Criptografar mensagem

**Método:** POST

**Endpoint:**

`http://localhost:8080/vernam/criptografar`

**Corpo da requisição (JSON):**

```json
{
    "mensagem": "OLA MUNDO",
    "chave": "123456789"
}
```

**Resposta esperada:**

```json
{
    "resultado": "fn5yFHhjeXx2"
}
```

### 6.2 Descriptografar mensagem

**Método:** POST

**Endpoint:**

`http://localhost:8080/vernam/descriptografar`

**Corpo da requisição (JSON):**

```json
{
    "mensagem": "fn5yFHhjeXx2",
    "chave": "123456789"
}
```

**Resposta esperada:**

```json
{
    "resultado": "OLA MUNDO"
}
```

## 7. Validações e tratamento de erros

A aplicação possui validações para impedir o recebimento de campos vazios e verifica se a chave possui o mesmo tamanho da mensagem em bytes.

Também possui tratamento para mensagens criptografadas com formato Base64 inválido.

Os erros de entrada são retornados com o código HTTP 400 (Bad Request).

## 8. Testes

Os testes automatizados podem ser executados pelo terminal, na raiz do projeto, utilizando:

```powershell
.\mvnw\.cmd test
```

## 9. Observação

A aplicação utiliza a operação XOR para realizar a criptografia e a descriptografia. O resultado criptografado é convertido para Base64 para facilitar sua representação e transmissão em formato textual.

