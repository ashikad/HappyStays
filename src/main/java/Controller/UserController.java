package Controller;


import Entity.User;
import Service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserServiceImpl userService;

   // @PostMapping("/createUser")


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        Optional<User> user = userService.getUserbyId(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }





}
