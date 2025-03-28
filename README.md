# Restaurant Menu API - Documentação

## Introdução
O **Restaurant Menu API** é um sistema de gerenciamento de cardápios para restaurantes, desenvolvido com **Spring Boot** e **PostgreSQL**. A API permite a criação, edição e busca de pratos e menus.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL** (via **Docker Compose**)
- **Flyway** (para migração do banco de dados)
- **Swagger/OpenAPI** (para documentação da API - a ser implementado)
- **OAuth2 com JWT** (para autenticação - a ser implementado)

## Configuração do Ambiente
1. Clone o repositório:
   ```sh
   git clone https://github.com/immark007/restaurant-menu-api.git
   cd restaurant-menu-api
   ```

2. Suba o banco de dados PostgreSQL com Docker Compose:
   ```sh
   docker-compose up -d
   ```

3. Execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

4. Acesse a documentação da API via Swagger/OpenAPI (quando implementado):
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## Endpoints da API

### 1. Pratos
#### Criar Prato
**POST** `/pratos`
```json
{
  "nome": "Pizza Margherita",
  "descricao": "Pizza com molho de tomate, queijo e manjericão",
  "preco": 35.00,
  "categoria": "Italiana",
  "restauranteId": "41e383b7-a574-4ed1-93d2-4123a44ce0d5"
}
```

#### Buscar Prato por ID
**GET** `/pratos/{id}`

#### Buscar Pratos por Restaurante
**GET** `/pratos?restauranteId={id}`

#### Deletar Prato
**DELETE** `/pratos/{id}`

---

### 2. Menus
#### Criar Menu
**POST** `/menus`
```json
{
  "nome": "Menu Executivo",
  "descricao": "Opções de pratos para o almoço",
  "restauranteId": "41e383b7-a574-4ed1-93d2-4123a44ce0d5"
}
```

#### Buscar Menu por ID
**GET** `/menus/{id}`

#### Deletar Menu
**DELETE** `/menus/{id}`

---

## Autenticação
A API utilizará **OAuth2 com JWT** para autenticação e autorização (a ser implementado). Alguns endpoints requerem um token JWT válido.

## Banco de Dados
A aplicação utiliza **PostgreSQL**, com migrações gerenciadas pelo **Flyway**.

O banco de dados roda via **Docker Compose**, podendo ser iniciado com:
```sh
docker-compose up -d
```

## Documentação da API
A API será documentada utilizando **Swagger/OpenAPI**.

## Testes
A aplicação inclui testes unitários e de integração usando **Spring Boot Test**:
```sh
mvn test
```

---

## Contato
Caso tenha dúvidas ou sugestões, entre em contato via **[GitHub](https://github.com/immark007/restaurant-menu-api)**.

## Contribuição
Caso queira colaborar com o projeto, sinta-se à vontade para abrir **issues** ou enviar **pull requests** no repositório do GitHub. Toda ajuda é bem-vinda!

