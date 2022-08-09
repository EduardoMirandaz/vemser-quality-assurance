package usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;
import org.testng.annotations.Test;
import usuario.dto.UsuarioCadastroDTO;
import usuario.service.UsuarioService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class userTests {

    UsuarioService usuarioService = new UsuarioService();
    private static final String adminLoginPostPath = "src/test/resources/data/admin/adminLoginPost.json";
    private static final String adminLoginUpdatePath = "src/test/resources/data/admin/adminLoginUpdate.json";

    // CADASTROS
    private static final String cadastroAdmin = "src/test/resources/data/usuario/cadastroAdmin.json";
    private static final String cadastroAluno = "src/test/resources/data/usuario/cadastroAluno.json";
    private static final String cadastroProfessor = "src/test/resources/data/usuario/cadastroProfessor.json";


    public String login(String path){
        String bearer = recuperarBearerPeloJSON(path);
        return bearer.replace("Bearer ", "");
    }


    @Test
    public void cadastroProfessorValido(){

        String login = gerarLoginRandomico();

        UsuarioCadastroDTO usuarioCadastroDTO =
                usuarioService.cadastroProfessorValido(login(adminLoginPostPath),
                        criarJsonCadastro(cadastroProfessor, login));

        Assert.assertEquals(usuarioCadastroDTO.getLogin(), login);

    }


    @Test
    public void cadastroAlunoValido(){

        String login = gerarLoginRandomico();

        UsuarioCadastroDTO usuarioCadastroDTO =
                usuarioService.cadastroAlunoValido(login(adminLoginPostPath),
                        criarJsonCadastro(cadastroAluno, login));

        Assert.assertEquals(usuarioCadastroDTO.getLogin(), login);

    }

    @Test
    public void cadastroAdminValido(){

        String login = gerarLoginRandomico();

        UsuarioCadastroDTO usuarioCadastroDTO =
                usuarioService.cadastroAdminValido(login(adminLoginPostPath),
                        criarJsonCadastro(cadastroAluno, login));

        Assert.assertEquals(usuarioCadastroDTO.getLogin(), login);

    }

    @Test
    public void updateUsuario(){

        String login = gerarLoginRandomico();

        UsuarioCadastroDTO usuarioCadastroDTO =
                usuarioService.updateUsuario(login(adminLoginPostPath),
                        criarJsonCadastro(adminLoginUpdatePath, login));

        Assert.assertEquals(usuarioCadastroDTO.getLogin(), login);

//        usuarioService.updateUsuario(login(adminLoginUpdatePath), criarJsonCadastro(adminLoginPostPath, "admin"));


    }



    // *********************************************
    //       [  UTILS  ]


    public String gerarLoginRandomico(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return myRandom.substring(0,25);
    }


    // massa de dados para o body
    public String lerJson(String pathJson){
        // caminho da massa de dados
        try {
            return new String(Files.readAllBytes(Paths.get(pathJson)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String criarJsonCadastro(String pathJson, String login){
        // caminho da massa de dados
        try {

            JSONObject file = new JSONObject();
            file.put("login", login);
            file.put("senha", "senh@d0c@d@str0");

            try (PrintWriter out = new PrintWriter(new FileWriter(pathJson))) {
                out.write(file.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new String(Files.readAllBytes(Paths.get(pathJson)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String recuperarBearerPeloJSON(String jsonPath){
        // Le a massa de dados
        String jsonBody = null;
        jsonBody = lerJson(jsonPath);

        // Post- Chamada para o servico
        return usuarioService.recuperarBearer(jsonBody);
    }

    private String recuperarLoginPeloJSON(String jsonPath) {
        // Recuperando o usuario completo em formato de json
        JSONObject jsonObject = recuperarUserPeloJSON(jsonPath);
        String oldLogin = (String) jsonObject.get("login");
        jsonObject.replace("login", oldLogin, oldLogin+"@");
        //Retorna o username extraido do JSON
        return oldLogin+"@";
    }

    private String recuperarIdPeloJSON(String jsonPath) {
        // Recuperando o usuario completo em formato de json
        JSONObject jsonObject = recuperarUserPeloJSON(jsonPath);

        //Retorna o username extraido do JSON
        return (String) jsonObject.get("id");
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

}
