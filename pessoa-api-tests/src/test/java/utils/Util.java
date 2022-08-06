package utils;

import pessoa.dto.PessoaValidPostDTO;
import pessoa.service.UsuarioService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static massaDeDados.PostPaths.adminLoginPostPath;

public class Util {

    public static String dataNascimentoInvalida = "dataNascimento: must not be null";
    public static String nomeInvalido = "nome: must not be blank";

    public static String idPessoaNaoEncontrado = "ID da pessoa nao encontrada";

    static UsuarioService usuarioService = new UsuarioService();

    public String gerarLoginRandomico(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return myRandom.substring(0,25);
    }

    public static String login(String path){
        String bearer = recuperarBearerPeloJSON(path);
        return bearer.replace("Bearer ", "");
    }

    public static String loginAdmin(){
        String bearer = recuperarBearerPeloJSON(adminLoginPostPath);
        return bearer.replace("Bearer ", "");
    }

    private Map<String, String> mapPessoaPostDTO(PessoaValidPostDTO pessoaValidPostDTO) {
        Map<String, String> pessoaMapeada = new HashMap<>();
        pessoaMapeada.put("nome", pessoaValidPostDTO.getNome());
        pessoaMapeada.put("dataNascimento", pessoaValidPostDTO.getDataNascimento().toString());
        pessoaMapeada.put("cpf", pessoaValidPostDTO.getCpf());
        pessoaMapeada.put("email", pessoaValidPostDTO.getEmail());
        pessoaMapeada.put("idPessoa", pessoaValidPostDTO.getIdPessoa().toString());

        return  pessoaMapeada;
    }

    public static String converterJsonParaArrayDeBytes(String pathJson){
        // caminho da massa de dados
        try {
            return new String(Files.readAllBytes(Paths.get(pathJson)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String recuperarBearerPeloJSON(String jsonPath){
        // Le a massa de dados
        String jsonBody = null;
        jsonBody = converterJsonParaArrayDeBytes(jsonPath);

        // Post- Chamada para o servico
        return usuarioService.recuperarBearer(jsonBody);
    }
}
