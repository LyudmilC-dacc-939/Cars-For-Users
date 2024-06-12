package Spring_Boot.User_Car_Demo.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
}
