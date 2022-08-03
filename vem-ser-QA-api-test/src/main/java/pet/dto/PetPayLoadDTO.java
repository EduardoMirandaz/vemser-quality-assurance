package pet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class PetPayLoadDTO {
    private String id;
    private CategoriaDTO category;
    private String name;
    private Object photoUrls;
    private List<TagsDTO> tags;
    private String status;
}
