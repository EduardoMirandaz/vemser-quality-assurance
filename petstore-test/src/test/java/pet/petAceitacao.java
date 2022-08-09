// pacote
package pet;

// bibliotecas


import io.restassured.http.ContentType;
import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pet.dto.DeletePetDTO;
import pet.dto.PetPayLoadDTO;
import pet.service.PetService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// classe
@Data
public class petAceitacao {

    PetService petService = new PetService();

    // massa de dados para o body
    public String lerJson(String pathJson) throws IOException {
        // caminho da massa de dados
        return new String(Files.readAllBytes(Paths.get(pathJson)));
    }



    // metodo de teste
    @Test
    public void incluirPet() throws IOException {

        PetPayLoadDTO petPayLoadDTO = adicionarPetPeloJSON();

        // Validação
        Assert.assertEquals(petPayLoadDTO.getId(), "13112131");
        Assert.assertEquals(petPayLoadDTO.getName(), "Dogaomic");
        Assert.assertEquals(petPayLoadDTO.getStatus(), "available");


        // Deleto o pet do banco após a consulta
        petService.delete(Integer.parseInt(petPayLoadDTO.getId()));
    }

    @Test
    public void editarPet() throws IOException {

        // adiciono um pet antes de tentar editar
        PetPayLoadDTO petPayLoadDTOAntigo = adicionarPetPeloJSON();

        // Le a massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet/petEdit_1.json");

        // Put- Chamada para o servico
        PetPayLoadDTO petPayLoadDTO = petService.editarPet(jsonBody);


        // Validação
        Assert.assertEquals(petPayLoadDTO.getName(), "GatoMaluco");
        Assert.assertEquals(petPayLoadDTO.getId(), "13112131");
        Assert.assertEquals(petPayLoadDTO.getTags().get(0).getId(), "123131");

        // Deleto o pet do banco após a consulta
        petService.delete(Integer.parseInt(petPayLoadDTO.getId()));

    }

    @Test
    public void consultarPet() throws IOException {

        // adiciono um pet antes de tentar consultar
        adicionarPetPeloJSON();

        Integer idPet = 13112131;

        // Post- Chamada para o servico
        PetPayLoadDTO petPayLoadDTO = petService.consultarPet(idPet);

        // Validação
        Assert.assertEquals(petPayLoadDTO.getId(), "13112131");
        Assert.assertEquals(petPayLoadDTO.getTags().get(0).getId(), "123131");
        Assert.assertEquals(petPayLoadDTO.getCategory().getName(), "Hulk");
        Assert.assertEquals(petPayLoadDTO.getStatus(), "available");

        // Deleto o pet do banco após a consulta
        petService.delete(idPet);

    }

    @Test
    public void deletarPet() throws IOException {

        // adiciono um pet antes de tentar deletar
        adicionarPetPeloJSON();

        Integer idPet = 13112131;

        // Delete- Chamada para o servico
        DeletePetDTO delete = petService.delete(idPet);

        // Validação
        Assert.assertEquals(delete.getCode(), "200");

    }

    /* UTILS */
    private PetPayLoadDTO adicionarPetPeloJSON() throws IOException {
        // Le a massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet/petPost_1.json");

        // Post- Chamada para o servico
        return petService.adicionarPet(jsonBody);
    }




}
