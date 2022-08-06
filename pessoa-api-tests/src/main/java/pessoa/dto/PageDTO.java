package pessoa.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PageDTO {
      private String totalElements;
      private String totalPages;
      private String page;
      private String size;
      private PessoaValidPostDTO[] content;

}
