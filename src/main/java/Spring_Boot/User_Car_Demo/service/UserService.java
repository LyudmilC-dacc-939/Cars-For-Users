package Spring_Boot.User_Car_Demo.service;

import Spring_Boot.User_Car_Demo.dto.UserRequest;
import Spring_Boot.User_Car_Demo.dto.UserResponse;
import Spring_Boot.User_Car_Demo.model.User;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse findUserById(Long id);

    User updateUser(UserRequest userRequest, Long userId);

    void deleteUserById(Long id);
}
