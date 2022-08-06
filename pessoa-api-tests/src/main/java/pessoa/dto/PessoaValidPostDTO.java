package pessoa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class PessoaValidPostDTO {
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private Integer idPessoa;
}
