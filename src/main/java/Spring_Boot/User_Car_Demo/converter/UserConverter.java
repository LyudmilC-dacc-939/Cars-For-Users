package Spring_Boot.User_Car_Demo.converter;

import Spring_Boot.User_Car_Demo.dto.UserRequest;
import Spring_Boot.User_Car_Demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toUser(UserRequest userRequest){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }
}
