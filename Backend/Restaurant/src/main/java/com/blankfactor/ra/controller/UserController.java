package com.blankfactor.ra.controller;

import com.blankfactor.ra.dto.UpdateUserDto;
import com.blankfactor.ra.dto.UserDto;
import com.blankfactor.ra.model.AppUser;
import com.blankfactor.ra.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<AppUser> createUser(@RequestBody UserDto userDto) {
        AppUser createdAppUser = userService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppUser);
    }

    @PostMapping("/addRole")
    public ResponseEntity<AppUser> addRoleToUser(@RequestBody UserDto userDto) {
        AppUser createdAppUser = userService.addRoleToUser(userDto);

        return ResponseEntity.ok(createdAppUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<AppUser> getUserById(@PathVariable int userId) {
        AppUser appUser = userService.getUserById(userId);

        return ResponseEntity.ok(appUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<AppUser> updateUserById(@PathVariable int userId,
                                                  @RequestBody UpdateUserDto updateUserDto) {
        AppUser updatedAppUser = userService.updateUserById(userId, updateUserDto);

        return ResponseEntity.ok(updatedAppUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable int userId) {
        userService.deleteUserById(userId);

        return ResponseEntity.ok().build();
    }
}
