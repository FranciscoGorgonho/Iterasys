// 1 - Pacote
package petstore;

// 2 - Bibliotecas

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;


// 3 - Classe
public class Pet {
    // 3.1 - Atributos
    String uri = "https://petstore.swagger.io/v2/pet"; // endereço da entidade Pet

    // 3.2 - Métodos e Funções
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test(priority = 1)  // Identifica o método ou função como um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        // Sintaxe Gherkin
        // Dado - Quando - Então
        // Given - When - Then

        given() // Dado
                .contentType("application/json") // comum em API REST - antigas era "text/xml"
                .log().all()
                .body(jsonBody)
                .when()  // Quando
                .post(uri)
                .then()  // Então
                .log().all()
                .statusCode(200)
                .body("name", is("Atena"))
                .body("status", is("available"))
                .body("category.name", is("AXCV"))
                .body("tags.name", contains("data"))

        ;
    }

    @Test(priority = 2)
    public void consultarPet() {
        String petId = "2023";

        String token =
                given()
                        .contentType("application/json")
                        .log().all()

                        .when()
                        .get(uri + "/" + petId)

                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("name", is("Atena"))
                        .body("category.name", is("AXCV"))
                        .body("status", is("available"))
                        .extract()
                        .path("category.name");

        System.out.println("O token é " + token);

    }

    @Test(priority = 3)
    public void alterarPet() throws IOException {
        String jsonBody = lerJson("db/pet2.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .put(uri)
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Atena"))
                .body("status", is("sold"))
        ;
    }

    @Test(priority = 4)
    public void excluirPet() {
        String petId = "2023";

        given()
                .contentType("application/json")
                .log().all()
                .when()
                .delete(uri + "/" + petId)
                .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(petId))

        ;
    }


}



