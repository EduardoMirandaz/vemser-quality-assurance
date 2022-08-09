package usuario.service;

import io.restassured.http.ContentType;
import usuario.dto.BearerDTO;
import usuario.dto.CodeTypeMessageDTO;
import usuario.dto.UsuarioCadastroDTO;

import static io.restassured.RestAssured.given;

public class UsuarioService {
    // Chamadas
    private static final String baseUrl = "https://gestao-ensino-api.herokuapp.com/usuario";


    public String recuperarBearer(String jsonBody) {

        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl + "/login")
                .then()
                .log()
                .all()
                .extract().asString();// recuperar como String
    }

    public UsuarioCadastroDTO cadastroProfessorValido(String token, String jsonBody) {
        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl + "/cadastro-professor")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UsuarioCadastroDTO.class); // recuperar como String
    }

    public UsuarioCadastroDTO cadastroAlunoValido(String token, String jsonBody) {
        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl + "/cadastro-aluno")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UsuarioCadastroDTO.class); // recuperar como String
    }

    public UsuarioCadastroDTO cadastroAdminValido(String token, String jsonBody) {
        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl + "/cadastro-admin")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UsuarioCadastroDTO.class); // recuperar como String
    }

    public UsuarioCadastroDTO updateUsuario(String token, String jsonBody) {
        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                header("Authorization", token).
                log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl + "/update")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UsuarioCadastroDTO.class); // recuperar como String
    }
}
