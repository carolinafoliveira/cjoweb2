package ifitness;

import br.edu.ifspcjo.ads.web2.ifitness.IfitnessApplication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(
    classes = IfitnessApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:ifitness;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
        "spring.flyway.locations=classpath:db/migration/{vendor}"
    }
)
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void apiListsCreatesAndFindsUsersWithoutReturningPasswords() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI usersUri = URI.create("http://localhost:" + port + "/api/users");

        HttpResponse<String> listResponse = client.send(
            HttpRequest.newBuilder(usersUri).GET().build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(200, listResponse.statusCode());
        assertTrue(listResponse.body().contains("Fernando Duarte"));
        assertTrue(listResponse.body().contains("Juliana Silva"));
        assertFalse(listResponse.body().contains("password"));

        String newUserJson = """
            {
                "name": "Adriana Silva",
                "email": "adrianasilva@ifsp.edu.br",
                "password": "hashed-password",
                "birthDate": "03/10/2000",
                "gender": "FEMININO",
                "active": true
            }
            """;
        HttpResponse<String> createResponse = client.send(
            HttpRequest.newBuilder(usersUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(newUserJson))
                .build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(201, createResponse.statusCode());
        assertTrue(createResponse.body().contains("\"birthDate\":\"03/10/2000\""));
        assertFalse(createResponse.body().contains("password"));

        HttpResponse<String> findResponse = client.send(
            HttpRequest.newBuilder(URI.create(usersUri + "/3")).GET().build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(200, findResponse.statusCode());
        assertTrue(findResponse.body().contains("Adriana Silva"));
        assertFalse(findResponse.body().contains("password"));

        HttpResponse<String> missingResponse = client.send(
            HttpRequest.newBuilder(URI.create(usersUri + "/10")).GET().build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(404, missingResponse.statusCode());
    }

    @Test
    void rejectsUnknownPropertiesAndInvalidJsonWithCustomMessage() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI usersUri = URI.create("http://localhost:" + port + "/api/users");

        String unknownPropertyJson = """
            {
                "name": "Juliana Santos",
                "email": "julianasantos@ifsp.edu.br",
                "password": "juliana123",
                "birthDate": "26/09/2002",
                "gender": "FEMININO",
                "active": true,
                "category": "Iniciante"
            }
            """;
        HttpResponse<String> unknownPropertyResponse = client.send(
            HttpRequest.newBuilder(usersUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(unknownPropertyJson))
                .build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(400, unknownPropertyResponse.statusCode());
        assertTrue(unknownPropertyResponse.body().contains("Mensagem inválida"));

        HttpResponse<String> invalidEnumResponse = client.send(
            HttpRequest.newBuilder(usersUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(validUserJson(
                    "FEMININA", "03/10/2000")))
                .build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(400, invalidEnumResponse.statusCode());
        assertTrue(invalidEnumResponse.body().contains("Mensagem inválida"));

        HttpResponse<String> invalidDateResponse = client.send(
            HttpRequest.newBuilder(usersUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(validUserJson(
                    "FEMININO", "2000-10-03")))
                .build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(400, invalidDateResponse.statusCode());
        assertTrue(invalidDateResponse.body().contains("Mensagem inválida"));

        HttpResponse<String> emptyBodyResponse = client.send(
            HttpRequest.newBuilder(usersUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(400, emptyBodyResponse.statusCode());
        assertTrue(emptyBodyResponse.body().contains("Mensagem inválida"));
    }

    @Test
    void returnsLocalizedValidationErrorsForInvalidUserFields() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI usersUri = URI.create("http://localhost:" + port + "/api/users");

        String nullFieldsJson = """
            {
                "name": null,
                "email": null,
                "password": null,
                "birthDate": null,
                "gender": null,
                "active": true
            }
            """;
        HttpResponse<String> nullFieldsResponse = client.send(
            HttpRequest.newBuilder(usersUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(nullFieldsJson))
                .build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(400, nullFieldsResponse.statusCode());
        assertTrue(nullFieldsResponse.body().contains("Data de nascimento é obrigatório(a)"));
        assertTrue(nullFieldsResponse.body().contains("E-mail é obrigatório(a)"));
        assertTrue(nullFieldsResponse.body().contains("Senha é obrigatório(a)"));
        assertTrue(nullFieldsResponse.body().contains("Gênero é obrigatório(a)"));
        assertTrue(nullFieldsResponse.body().contains("Nome é obrigatório(a)"));

        HttpResponse<String> invalidFieldsResponse = client.send(
            HttpRequest.newBuilder(usersUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("""
                    {
                        "name": "Ju",
                        "email": "julianasantos",
                        "password": "",
                        "birthDate": "26/09/2030",
                        "gender": "FEMININO",
                        "active": true
                    }
                    """))
                .build(),
            HttpResponse.BodyHandlers.ofString());
        assertEquals(400, invalidFieldsResponse.statusCode());
        assertTrue(invalidFieldsResponse.body().contains(
            "Nome deve ter o tamanho entre 3 e 50"));
        assertTrue(invalidFieldsResponse.body().contains(
            "Data de nascimento deve ser uma data no passado"));
        assertTrue(invalidFieldsResponse.body().contains(
            "E-mail deve ter um formato válido"));
        assertTrue(invalidFieldsResponse.body().contains("Senha é obrigatório(a)"));
    }

    private String validUserJson(String gender, String birthDate) {
        return """
            {
                "name": "Juliana Santos",
                "email": "julianasantos@ifsp.edu.br",
                "password": "juliana123",
                "birthDate": "%s",
                "gender": "%s",
                "active": true
            }
            """.formatted(birthDate, gender);
    }
}
