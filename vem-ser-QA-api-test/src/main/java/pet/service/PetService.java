package pet.service;

import io.restassured.http.ContentType;
import pet.dto.DeletePetDTO;
import pet.dto.PetPayLoadDTO;

import static io.restassured.RestAssured.given;

// alterar
// consultar
// alterar;



public class PetService {
    // definicao da interface de chamadas
    private String baseUrl = "https://petstore.swagger.io/v2/pet";


    public PetPayLoadDTO adicionarPet(String jsonBody){
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
                .extract().as(PetPayLoadDTO.class); // recuperar como PetPayLoad
    }

    public PetPayLoadDTO editarPet(String jsonBody){
        // REST-ASSURED
        //dado isso
        return given().
                contentType(ContentType.JSON).
                log().all()
                .body(jsonBody)
                .when()
                .put(baseUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PetPayLoadDTO.class); // recuperar como PetPayLoad
    }

    public PetPayLoadDTO consultarPet(Integer petId){

        // Novo URL
        String getUrl = baseUrl + "/" + petId;

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
                .extract().as(PetPayLoadDTO.class); // recuperar como PetPayLoad
    }

    public DeletePetDTO delete(Integer petId){
        // Novo URL
        String deleteUrl = baseUrl + "/" + petId;

        // REST-ASSURED
        //dado isso
        DeletePetDTO petDeletado = given().
                contentType(ContentType.JSON).
                log().all()
                .when()
                .delete(deleteUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(DeletePetDTO.class);

        return petDeletado; // recuperar como PetPayLoad
    }

}
