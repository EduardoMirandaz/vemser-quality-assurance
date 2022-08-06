package pessoa.service;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UsuarioService {
    // Chamadas
    private static final String baseUrl = "https://dbc-pessoa-api.herokuapp.com/auth";

    public String recuperarBearer(String jsonBody) {

        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl)
                .then()
                .log()
                .all()
                .extract().asString();// recuperar como String
    }

}
