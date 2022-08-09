package usuario.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UsuarioCadastroDTO {
    private Integer idUsuario;
    private String login;

    public void deleteUsuario(int parseInt) {

    }
}
