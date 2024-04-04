package com.crio.starterapp.Controller;

import com.crio.starterapp.Entity.User;
import com.crio.starterapp.Exchange.UserRequest;
import com.crio.starterapp.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> retrieveUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> retrieveUser(@PathVariable String userId){
        Optional<User> user = userService.getUser(userId);
        return user.isPresent() ?ResponseEntity.ok(user.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserRequest userRequest){
        if(userService.registerUser(userRequest).isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body("USER CREATED SUCCESSFULLY");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USER ALREADY EXISTS");
    }

    @PutMapping("/{userId}/score")
    public ResponseEntity<String> modify(@PathVariable String userId,  @RequestParam int score){
        if(userService.modifyUser(userId, score).isPresent()){
            return ResponseEntity.ok("UPDATED "+ userId +" SUCCESSFUL");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        if(userService.removeUser(userId).isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("USER " +userId+" DELETED SUCCESSFULLY");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
