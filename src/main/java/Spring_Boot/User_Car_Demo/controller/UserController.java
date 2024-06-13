package Spring_Boot.User_Car_Demo.controller;

import Spring_Boot.User_Car_Demo.dto.UserRequest;
import Spring_Boot.User_Car_Demo.dto.UserResponse;
import Spring_Boot.User_Car_Demo.model.User;
import Spring_Boot.User_Car_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-car-demo/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/create-user")
    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    ResponseEntity<UserResponse> readUserById(@PathVariable("userId") Long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.FOUND);
    }
    @PutMapping(path = "/{userId}")
    User updateUser(@RequestBody UserRequest userRequest,
                    @PathVariable("userId") Long id){
        return userService.updateUser(userRequest, id);
    }
    @DeleteMapping(path = "/{userId}")
    void deleteUser(@PathVariable("userId") Long id){
        userService.deleteUserById(id);
    }
}
