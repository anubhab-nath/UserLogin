package com.example.userlogin.users;

import com.example.userlogin.users.dtos.CreateUserDto;
import com.example.userlogin.users.dtos.UpdateUserDto;
import com.example.userlogin.users.dtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody CreateUserDto userDto) {
        UserResponseDto responseDto = usersService.createUser(userDto);

        return ResponseEntity
                .created(URI.create("/users/" + responseDto.getUserId()))
                .body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateTask(
            @PathVariable("id") Long id,
            @RequestBody UpdateUserDto updateUserDto
    ) {
        return ResponseEntity.ok(usersService.updateUser(id, updateUserDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
