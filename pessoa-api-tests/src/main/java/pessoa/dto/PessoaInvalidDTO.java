package pessoa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class PessoaInvalidDTO {
    private String timestamp;
    private String status;
    private String[] errors;
    private String error;
    private String message;
    private String path;
}
