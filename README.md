Pokemon API

Este projeto é uma API RESTful desenvolvida em **Java + Spring Boot** seguindo os princípios da **Arquitetura Limpa**. Ele integra com a [PokeAPI](https://pokeapi.co) e permite que usuários gerenciem seus Pokémons favoritos.

### 📄 Documentação Swagger
Acesse via navegador:

```
http://localhost:8080/swagger-ui.html
```

## 💾 MongoDB

O projeto usa MongoDB como banco de dados. Por padrão, conecta-se à instância local:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/pokemon-db
```

## 🚀 Como executar

1. Clone o projeto:
```bash
git clone https://github.com/seu-usuario/pokemon-api.git
cd pokemon-api
```

2. Instale as dependências:
```bash
./mvnw clean install
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

---


Documentações usadas:
https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/
https://medium.com/@souzaluis/applying-clean-architecture-in-java-with-spring-boot-framework-part-iv-a3cb82d5421a
https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html
