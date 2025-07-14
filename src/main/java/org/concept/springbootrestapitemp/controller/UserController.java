package org.concept.springbootrestapitemp.controller;

import org.concept.springbootrestapitemp.exception.UserNotFoundException;
import org.concept.springbootrestapitemp.model.User;
import org.concept.springbootrestapitemp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    /*private static Map<String, User> users = new HashMap<>();
    static {
        User temp1 = new User("1", "John", "Doe");
        User temp2 = new User("2", "Jane", "Doe");
        users.put(temp1.getId(), temp1);
        users.put(temp2.getId(), temp2);
    }*/
    private final UserRepository userRepository;

    public UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<User> exception(UserNotFoundException exception) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /*@RequestMapping(path = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable String id, @RequestBody User user) {
        if (!users.containsKey(id)) {
            throw new UserNotFoundException();
        }
        users.remove(id);
        user.setId(id);
        users.put(id, user);
        return new ResponseEntity<>("User is updated successfully.", HttpStatus.OK);
    }*/
}
