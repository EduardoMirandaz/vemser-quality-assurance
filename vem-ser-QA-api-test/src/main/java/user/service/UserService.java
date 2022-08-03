package user.service;

import io.restassured.http.ContentType;
import user.dto.UserCodeTypeMessageDTO;
import user.dto.UserCompleteDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

// alterar
// consultar
// alterar;


public class UserService {
    // definicao da interface de chamadas
    private String baseUrl = "https://petstore.swagger.io/v2/user";


    public UserCodeTypeMessageDTO adicionarUsuario(String jsonBody){
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
                .statusCode(200)
                .extract().as(UserCodeTypeMessageDTO.class); // recuperar como UserCodeTypeMessageDTO
    }

    public UserCodeTypeMessageDTO adicionarUsuariosArray(String jsonBody){

        String novoUrl = baseUrl + "/createWithArray";

        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                log().all()
                .body(jsonBody)
                .when()
                .post(novoUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserCodeTypeMessageDTO.class); // recuperar como UserCodeTypeMessageDTO
    }

    public UserCodeTypeMessageDTO adicionarUsuariosList(String jsonBody){

        String novoUrl = baseUrl + "/createWithList";

        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                log().all()
                .body(jsonBody)
                .when()
                .post(novoUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserCodeTypeMessageDTO.class); // recuperar como UserCodeTypeMessageDTO
    }

    public UserCodeTypeMessageDTO editarUsuario(String username, String jsonBody){


        String putUrl = baseUrl + "/" + username;

        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                log().all()
                .body(jsonBody)
                .when()
                .put(putUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserCodeTypeMessageDTO.class); // recuperar como UserCodeTypeMessageDTO
    }

    public UserCompleteDTO consultarUsuario(String username){

        // Novo URL
        String getUrl = baseUrl + "/" + username;

        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                log().all()
                .when()
                .get(getUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserCompleteDTO.class); // recuperar como UserCompleteDTO
    }

    public UserCodeTypeMessageDTO delete(String username){
        // Novo URL
        String deleteUrl = baseUrl + "/" + username;

        // REST-ASSURED
        //dado isso
        UserCodeTypeMessageDTO usuarioDeletado = given().
                contentType(ContentType.JSON).
                log().all()
                .when()
                .delete(deleteUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserCodeTypeMessageDTO.class);

        return usuarioDeletado; // recuperar como UserCodeTypeMessageDTO
    }

    public UserCodeTypeMessageDTO login(String username, String password){

        // Mapeando o login
        Map<String, String> login = new HashMap<>();
        login.put("username", username);
        login.put("password", password);

        // novo URL
        String novoUrl = baseUrl + "/login";

        // REST-ASSURED
        //dado isso
        return given().
                log().all()
                .params(login)
                .when()
                .get(novoUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserCodeTypeMessageDTO.class); // recuperar como UserCompleteDTO
    }

    public UserCodeTypeMessageDTO logout(){

        // novo URL
        String novoUrl = baseUrl + "/logout";

        // REST-ASSURED
        //dado isso
        return given().
                log().all()
                .when()
                .get(novoUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserCodeTypeMessageDTO.class); // recuperar como UserCompleteDTO
    }

}
