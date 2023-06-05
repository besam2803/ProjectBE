package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.model.dto.UserDto;
import com.example.capstoneprojectbe.model.response.RoleEntity;
import com.example.capstoneprojectbe.model.response.UserEntity;
import com.example.capstoneprojectbe.service.RoleService;
import com.example.capstoneprojectbe.service.UserService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    private ResponseEntity getUserByUserID(@PathVariable String id) {
        UserEntity entity = userService.getUserByUserID(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping("/login")
    private ResponseEntity checkLogin(@RequestParam String id, @RequestParam String password) {
        UserEntity entity = userService.checkLogin(id,password);
        if(entity == null){
            return ResponseEntity.badRequest().body("Wrong username & password");
        }
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping()
    public ResponseEntity createNewUser(@RequestBody UserEntity entity) {
        if(userService.isExisted(entity.getUserID())){
            return ResponseEntity.badRequest().body("User Id is duplicated");
        }
        return ResponseEntity.ok().body(userService.createNewUser(entity));
    }

    @PutMapping
    private ResponseEntity updateExistedUser(@RequestBody UserEntity entity) {
        return ResponseEntity.ok().body(userService.updateExistedUser(entity));
    }

    @DeleteMapping()
    private ResponseEntity deleteExistedUser(@RequestParam String id) {
        return ResponseEntity.ok().body(userService.deleteExistedUser(id));
    }
}
