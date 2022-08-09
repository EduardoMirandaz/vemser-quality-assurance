package user.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UserCompleteDTO {
      private Integer id;
      private String username;
      private String firstName;
      private String lastName;
      private String email;
      private String password;
      private String phone;
      private Integer userStatus;
}
