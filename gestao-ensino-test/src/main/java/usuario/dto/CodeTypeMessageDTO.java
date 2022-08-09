package usuario.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CodeTypeMessageDTO {
    private String code;
    private String type;
    private String message;
}
