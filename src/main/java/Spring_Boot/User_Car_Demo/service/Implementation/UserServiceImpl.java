package Spring_Boot.User_Car_Demo.service.Implementation;

import Spring_Boot.User_Car_Demo.converter.UserConverter;
import Spring_Boot.User_Car_Demo.dto.UserRequest;
import Spring_Boot.User_Car_Demo.dto.UserResponse;
import Spring_Boot.User_Car_Demo.model.User;
import Spring_Boot.User_Car_Demo.repository.UserRepository;
import Spring_Boot.User_Car_Demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = userConverter.toUser(userRequest);
        for(User user1: userRepository.findAll()){
            if(user.getEmail().toUpperCase().equals(user1.getEmail().toUpperCase())){
                log.error(String.format("User with %s email address already exists", user.getEmail()));
                return null;
            }
        }
        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(savedUser, userResponse);
        return userResponse;
    }

    @Override
    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

    @Override
    public User updateUser(UserRequest userRequest, Long userId) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isEmpty()) {
            log.error(String.format("User with id %s not exist", userId));
            return new User();
        }
        User user = existingUser.get();

        if (userRequest.getFirstName() != null) {
            user.setFirstName(userRequest.getFirstName());
        }
        if (userRequest.getLastName() != null) {
            user.setLastName(userRequest.getLastName());
        }
        if (userRequest.getPassword() != null) {
            user.setPassword(userRequest.getPassword());
        }
        if (userRequest.getEmail() != null) {
            user.setEmail(userRequest.getEmail());
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
