package Spring_Boot.User_Car_Demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    @NotNull
    private String password;
    @Email
    @NotNull
    private String email;
}
