package com.pms.pms.Controller;
import com.pms.pms.Dto.UserDto;
import com.pms.pms.Entity.User;
import com.pms.pms.service.CommentService;
import com.pms.pms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/auth")
//@Slf4j
public class UserController {

    @Autowired
    private final UserService userService;
    private final CommentService commentService;

    public UserController(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    @PostMapping("/addUser")
//    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
      //  log.info("userDto  == >>>  {}", userDto);
        User newUser = userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }





    @GetMapping("/user")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUser();
    }


    //build get all staff by id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        Optional<User> user = userService.getUserById(id);
        return new ResponseEntity<User>(user.get(),HttpStatus.OK);
    }

    // build update user api
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id , User user){
        User userResponse =  userService.updateUser(user, id);
        return  new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    //build delete staff api
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id, User user){
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
