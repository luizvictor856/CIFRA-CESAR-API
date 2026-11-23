# API de Cifra de César

## Descrição do Projeto

Este projeto consiste no desenvolvimento de uma API REST utilizando Java e Spring Boot, capaz de cifrar e decifrar textos utilizando o método da Cifra de César.

A aplicação permite realizar a criptografia de textos por meio de um deslocamento definido pelo usuário, a descriptografia utilizando um deslocamento conhecido e a descriptografia por força bruta, tentando identificar automaticamente o texto original.

## Autor

**Luiz Victor Carneiro Bueno**

**Modalidade:** Atividade individual

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- REST API
- JUnit
- Swagger / OpenAPI

## Funcionalidades

A API disponibiliza três endpoints principais:

### 1. Cifrar texto

**Endpoint:** `POST /cifrar`

Recebe um texto original e um valor de deslocamento, retornando o texto cifrado.

Exemplo de requisição:

```json
{
  "textoClaro": "ola mundo",
  "deslocamento": 3
}
```

Resposta:

```json
{
  "textoCifrado": "rod pxqgr"
}
```

### 2. Decifrar texto

**Endpoint:** `POST /decifrar`

Recebe um texto cifrado e o deslocamento utilizado, retornando o texto original.

Exemplo de requisição:

```json
{
  "textoCifrado": "rod pxqgr",
  "deslocamento": 3
}
```

Resposta:

```json
{
  "textoClaro": "ola mundo"
}
```

### 3. Decifrar por força bruta

**Endpoint:** `POST /decifrarForcaBruta`

Recebe um texto cifrado sem a necessidade de informar o deslocamento. A aplicação testa as possibilidades de deslocamento da Cifra de César e utiliza uma base de palavras em português para auxiliar na identificação da provável mensagem original.

Exemplo de requisição:

```json
{
  "textoCifrado": "rod pxqgr"
}
```

Resposta:

```json
{
  "textoClaro": "ola mundo"
}
```

## Funcionamento da Cifra de César

A Cifra de César é um método de criptografia baseado na substituição de letras por outras que se encontram a uma determinada distância no alfabeto.

O deslocamento define quantas posições cada letra será movimentada. Por exemplo, utilizando um deslocamento de 3:

| Texto original | Texto cifrado |
|---|---|
| A | D |
| B | E |
| C | F |
| X | A |
| Y | B |
| Z | C |

A aplicação considera letras maiúsculas e minúsculas, preservando a formatação do texto. Caracteres que não fazem parte do alfabeto, como espaços, números e pontuação, são mantidos.

## Execução do Projeto

### Pré-requisitos

- Java instalado
- Git (opcional, para clonar o repositório)

### Clonar o repositório

```bash
git clone https://github.com/luizvictor856/CIFRA-CESAR-API.git
```

### Acessar a pasta do projeto

```bash
cd CIFRA-CESAR-API
```

### Executar a aplicação

No Windows, utilize o Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Após a inicialização, a API estará disponível localmente na porta 8080.

## Documentação da API

Caso o Swagger esteja habilitado, a documentação interativa pode ser acessada pelo navegador:

http://localhost:8080/swagger-ui/index.html

Por meio do Swagger, é possível visualizar os endpoints disponíveis e realizar requisições diretamente pela interface.

## Testes

O projeto foi submetido a testes de funcionamento dos endpoints de cifragem, decifragem e decifragem por força bruta, utilizando diferentes textos, deslocamentos e combinações de caracteres.

## Repositório

GitHub:

https://github.com/luizvictor856/CIFRA-CESAR-API.git

## Considerações finais

O projeto foi desenvolvido individualmente como atividade acadêmica, com o objetivo de aplicar conhecimentos de desenvolvimento de APIs REST, Java, Spring Boot, lógica de programação, criptografia por substituição e testes de software.