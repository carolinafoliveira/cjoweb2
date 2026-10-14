# iFitness

API REST de usuários desenvolvida com Java 25, Spring Boot, Spring Web,
Spring Data JPA, SQL Server e Flyway.

Crie o banco `ifitness` no SQL Server e configure a autenticação no ambiente:

```powershell
$env:DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=ifitness;encrypt=true;trustServerCertificate=true"
$env:DB_USERNAME = "sa"
$env:DB_PASSWORD = "sua-senha"
```

Se estiver usando uma instância nomeada (por exemplo, `SQLEXPRESS`), ajuste
`DB_URL` para apontar para a instância e sua porta. O Flyway cria a tabela e
insere os usuários iniciais na primeira execução.

```text
mvnw.cmd spring-boot:run
```

Com a aplicação em execução, os endpoints disponíveis são:

- `GET http://localhost:8080/api/users` — lista usuários.
- `POST http://localhost:8080/api/users` — cria um usuário a partir de JSON.
- `GET http://localhost:8080/api/users/{id}` — consulta um usuário por ID;
  retorna 404 quando ele não existe.

As datas de nascimento devem seguir o formato `dd/MM/yyyy`. O endpoint espera
receber a senha já codificada com BCrypt, como no exemplo do roteiro; senhas
nunca são incluídas nas respostas JSON.

Para executar os testes sem conectar ao SQL Server:

```text
mvnw.cmd test
```
