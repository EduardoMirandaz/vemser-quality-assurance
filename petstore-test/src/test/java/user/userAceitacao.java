// pacote
package user;

// bibliotecas


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.dto.UserCodeTypeMessageDTO;
import user.dto.UserCompleteDTO;
import user.service.UserService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


// classe
@Data
public class userAceitacao {

    private UserService userService = new UserService();

    /* JSONs / Massa de Dados */

    // POST DATA
    private static final String JSONuserUniquePost_1 = "src/test/resources/data/user/userUniquePost_1.json";
    private static final String JSONuserMultiplePost_1 = "src/test/resources/data/user/userMultiplePost_1.json";


    // PUT DATA
    private static final String JSONuserUniqueEdit_1 = "src/test/resources/data/user/userUniqueEdit_1.json";



    // metodo de teste
    @Test
    public void acidionarUsuario(){

        // Adicionando usuário
        UserCodeTypeMessageDTO userCodeTypeMessageDTO = acidionarUsuarioPeloJSON(JSONuserUniquePost_1);

        // Validação
        Assert.assertEquals(userCodeTypeMessageDTO.getCode(), Integer.toString(HttpStatus.SC_OK));

        // Recupero o usuario adicionado para conseguir o username
        String usernameAdicionado = recuperarUsernamePeloJSON(JSONuserUniquePost_1);

        // Deleto o usuario do banco através do username, após a adição
        userService.delete(usernameAdicionado);
    }

    @Test
    public void adicionarListaDeUsuarios1(){

        // Adicionando usuário
        UserCodeTypeMessageDTO userCodeTypeMessageDTO = acidionarUsuariosPeloJSONArray(JSONuserMultiplePost_1);

        // Validação
        Assert.assertEquals(userCodeTypeMessageDTO.getCode(), Integer.toString(HttpStatus.SC_OK));
        Assert.assertEquals(userCodeTypeMessageDTO.getMessage(), "ok");


        //TODO Deixar a deleção multipla dinâmica
//        // Recupero os usuarios adicionados para conseguir os usernames
//        ArrayList<String> usernamesAdicionados = recuperarUsernamesPeloJSON(JSONuserMultiplePost_1);
//
//        // Deleto o usuario do banco através do username, após a adição
//        usernamesAdicionados.stream()
//                        .peek(user -> userService.delete(user));


        userService.delete("gustavom");
        userService.delete("marikaori");

    }

    @Test
    public void adicionarListaDeUsuarios2(){

        // Adicionando usuário
        UserCodeTypeMessageDTO userCodeTypeMessageDTO = acidionarUsuariosPeloJSONList(JSONuserMultiplePost_1);

        // Validação
        Assert.assertEquals(userCodeTypeMessageDTO.getCode(), Integer.toString(HttpStatus.SC_OK));
        Assert.assertEquals(userCodeTypeMessageDTO.getMessage(), "ok");


        //TODO Deixar a deleção multipla dinâmica
//        // Recupero os usuarios adicionados para conseguir os usernames
//        ArrayList<String> usernamesAdicionados = recuperarUsernamesPeloJSON(JSONuserMultiplePost_1);
//
//        // Deleto o usuario do banco através do username, após a adição
//        usernamesAdicionados.stream()
//                        .peek(user -> userService.delete(user));


        userService.delete("gustavom");
        userService.delete("marikaori");

    }


    @Test
    public void editarUsuario(){

        // adiciono um pet antes de tentar editar
        acidionarUsuarioPeloJSON(JSONuserUniquePost_1);

        // Recupero o usuario adicionado para conseguir o username
        String usernameAdicionado = recuperarUsernamePeloJSON(JSONuserUniquePost_1);

        // executo a edição e recebo o retorno da API
        UserCodeTypeMessageDTO userCodeTypeMessageDTO = editarUsuarioPeloJSON(usernameAdicionado, JSONuserUniqueEdit_1);

        /*
         ****** VALIDACOES *******
         */

        // validando codigo da operacao
        Assert.assertEquals(userCodeTypeMessageDTO.getCode(), Integer.toString(HttpStatus.SC_OK));

        // validando id
        String id = recuperarIdPeloJSON(JSONuserUniqueEdit_1);
        Assert.assertEquals(userCodeTypeMessageDTO.getMessage(), id);

        //******************************//

        // Recupero o usuario adicionado para conseguir o username
        String usernameEditado = recuperarUsernamePeloJSON(JSONuserUniqueEdit_1);

        // Deleto o usuario do banco após a consulta
        userService.delete(usernameEditado);

    }

    @Test
    public void consultarUsuarioSemEditar(){

        // adiciono um usuario antes de tentar deletar
        acidionarUsuarioPeloJSON(JSONuserUniquePost_1);

        // Recupero o usuario adicionado para conseguir o username
        String usernameAdicionado = recuperarUsernamePeloJSON(JSONuserUniquePost_1);

        // Post- Chamada para o servico, recupera a resposta da API
        UserCompleteDTO userAdicionado = userService.consultarUsuario(usernameAdicionado);

        /*
         ****** VALIDACOES *******
         */

        // Recupero o usuario adicionado no teste como json;
        JSONObject jsonAdicionado = recuperarUserPeloJSON(JSONuserUniquePost_1);

        // Validando id
        Assert.assertEquals(userAdicionado.getId().toString(), jsonAdicionado.get("id").toString());
        // Validando username
        Assert.assertEquals(userAdicionado.getUsername(), usernameAdicionado);
        // Validando first name
        Assert.assertEquals(userAdicionado.getFirstName(), jsonAdicionado.get("firstName"));
        // Validando last name
        Assert.assertEquals(userAdicionado.getLastName(), jsonAdicionado.get("lastName"));
        // Validando email
        Assert.assertEquals(userAdicionado.getEmail(), jsonAdicionado.get("email"));
        // Validando password
        Assert.assertEquals(userAdicionado.getPassword(), jsonAdicionado.get("password"));
        // Validando phone
        Assert.assertEquals(userAdicionado.getPhone(), jsonAdicionado.get("phone"));
        // Validando userStatus
        Assert.assertEquals(userAdicionado.getUserStatus().toString(), jsonAdicionado.get("userStatus").toString());


        // Deleto o usuario do banco através do username, após a consulta
        userService.delete(usernameAdicionado);

    }

    @Test
    public void deletarUsuarioSemEditar(){

        // adiciono um usuario antes de tentar deletar
        acidionarUsuarioPeloJSON(JSONuserUniquePost_1);

        // Recupero o usuario adicionado para conseguir o username
        String usernameAdicionado = recuperarUsernamePeloJSON(JSONuserUniquePost_1);

        // Delete- Chamada para o servico
        UserCodeTypeMessageDTO resultadoDelete = userService.delete(usernameAdicionado);

        // Validação
        Assert.assertEquals(resultadoDelete.getCode(), Integer.toString(HttpStatus.SC_OK));

    }

    @Test
    public void logarValido(){

        // adiciono um usuario antes de tentar deletar
        acidionarUsuarioPeloJSON(JSONuserUniquePost_1);

        // Recupero o usuario adicionado para conseguir o username
        String usernameAdicionado = recuperarUsernamePeloJSON(JSONuserUniquePost_1);
        // Recupero a senha adicionada para conseguir o username
        String senhaAdicionada = recuperarSenhaPeloJSON(JSONuserUniquePost_1);

        // Login- Chamada para o servico
        UserCodeTypeMessageDTO resultadoLogin = userService.login(usernameAdicionado, senhaAdicionada);

        // Validação
        Assert.assertEquals(resultadoLogin.getCode(), Integer.toString(HttpStatus.SC_OK));

    }

    @Test
    public void deslogarLogado(){

        // adiciono um usuario antes de tentar deletar
        acidionarUsuarioPeloJSON(JSONuserUniquePost_1);

        // Recupero o usuario adicionado para conseguir o username
        String usernameAdicionado = recuperarUsernamePeloJSON(JSONuserUniquePost_1);
        // Recupero a senha adicionada para conseguir o username
        String senhaAdicionada = recuperarSenhaPeloJSON(JSONuserUniquePost_1);
        // Faço login nesse usuário
        userService.login(usernameAdicionado, senhaAdicionada);

        // Deslogar - Chamada para o servico
        UserCodeTypeMessageDTO resultadoLogout = userService.logout();

        // Validação
        Assert.assertEquals(resultadoLogout.getCode(), Integer.toString(HttpStatus.SC_OK));

    }


    /* UTILS */

    private UserCodeTypeMessageDTO acidionarUsuarioPeloJSON(String jsonPath){
        // Le a massa de dados
        String jsonBody = null;
        try {
            jsonBody = lerJson(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Post- Chamada para o servico
        return userService.adicionarUsuario(jsonBody);
    }

    private UserCodeTypeMessageDTO acidionarUsuariosPeloJSONArray(String jsonPath){
        // Le a massa de dados
        String jsonBody = null;
        try {
            jsonBody = lerJson(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Post- Chamada para o servico
        return userService.adicionarUsuariosArray(jsonBody);
    }

    private UserCodeTypeMessageDTO acidionarUsuariosPeloJSONList(String jsonPath){
        // Le a massa de dados
        String jsonBody = null;
        try {
            jsonBody = lerJson(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Post- Chamada para o servico
        return userService.adicionarUsuariosList(jsonBody);
    }

    private UserCodeTypeMessageDTO editarUsuarioPeloJSON(String usernameASerEditado, String jsonPath){
        // Le a massa de dados
        String jsonBody = null;
        try {
            jsonBody = lerJson(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // PUT - Chamada para o servico de edicao, recebe o retorno da API
        return userService.editarUsuario(usernameASerEditado, jsonBody);
    }


    private String recuperarUsernamePeloJSON(String jsonPath){
        // Recuperando o usuario completo em formato de json
        JSONObject jsonObject = recuperarUserPeloJSON(jsonPath);

        //Retorna o username extraido do JSON
        return (String) jsonObject.get("username");
    }

    private String recuperarSenhaPeloJSON(String jsonPath){
        // Recuperando o usuario completo em formato de json
        JSONObject jsonObject = recuperarUserPeloJSON(jsonPath);

        //Retorna o username extraido do JSON
        return (String) jsonObject.get("password");
    }

    private String recuperarIdPeloJSON(String jsonPath){
        // Recuperando o usuario completo em formato de json
        JSONObject jsonObject = recuperarUserPeloJSON(jsonPath);

        //Retorna o username extraido do JSON
        return Long.toString((Long) jsonObject.get("id"));
    }

    private JSONObject recuperarUserPeloJSON(String jsonPath){
        Object parse = null;
        try {
            parse = JSONValue.parse(new FileReader(
                    jsonPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Converte o JSONParser para JSONObject
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(parse, JSONObject.class);
    }

    // UTIL

    public String lerJson(String pathJson) throws IOException {
        // recebe por parametro o caminho da massa de dados
        return new String(Files.readAllBytes(Paths.get(pathJson)));
    }


}
