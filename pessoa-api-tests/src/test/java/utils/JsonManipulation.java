package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class JsonManipulation{

    public static void criarJsonCadastro(Map<String, String> cadastro, String pathJson){
        JSONObject file = new JSONObject();
        file.put("nome", cadastro.get("nome"));
        file.put("dataNascimento", cadastro.get("dataNascimento"));
        file.put("cpf", cadastro.get("cpf"));
        file.put("email", cadastro.get("email"));
        file.put("idPessoa", cadastro.get("idPessoa"));

        try (PrintWriter out = new PrintWriter(new FileWriter(pathJson))) {
            out.write(file.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static @NotNull Map<String, String> recuperarCadastro(String pathJson){

        // Recuperando o usuario completo em formato de json
        JSONObject jsonObject = recuperarUserPeloJSON(pathJson);
        String nome = (String) jsonObject.get("nome");
        String dataNascimento = (String) jsonObject.get("dataNascimento");
        String cpf = (String) jsonObject.get("cpf");
        String email = (String) jsonObject.get("email");

        Map<String, String> cadastro = new HashMap<>();
        cadastro.put("nome", nome);
        cadastro.put("dataNascimento", dataNascimento);
        cadastro.put("cpf", cpf);
        cadastro.put("email", email);

        return cadastro;

    }

    private static JSONObject recuperarUserPeloJSON(String jsonPath){
        Object parse;
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
