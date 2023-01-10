package com.example.userlogin.users;

import com.example.userlogin.users.dtos.CreateUserDto;
import com.example.userlogin.users.dtos.UpdateUserDto;
import com.example.userlogin.users.dtos.UserResponseDto;
import com.example.userlogin.users.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    UsersRepository usersRepository;
    ModelMapper modelMapper;
    PasswordEncoder passwordEncoder;

    public UsersService(
            UsersRepository usersRepository,
            ModelMapper modelMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto createUser(CreateUserDto requestDto) {
        UsersEntity user = modelMapper.map(requestDto, UsersEntity.class);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        UsersEntity savedUser = usersRepository.save(user);
        UserResponseDto responseDto = modelMapper.map(savedUser, UserResponseDto.class);

        //todo: create token and set it in the responseDto

        return responseDto;
    }

    public UsersEntity findUser(Long userId) {
        return usersRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public List<UserResponseDto> getAllUsers() {
        List<UsersEntity> users = usersRepository.findAll();
        List<UserResponseDto> responseDto = new ArrayList<>();
        for(UsersEntity user: users) {
            responseDto.add(modelMapper.map(user, UserResponseDto.class));
        }

        return responseDto;
    }

    public UserResponseDto getUserById(Long id) {
        return modelMapper.map(findUser(id), UserResponseDto.class);
    }


    public UserResponseDto updateUser(Long id, UpdateUserDto updateUserDto) {
        // todo:
        return null;
    }

    public void deleteUser(Long id) {
        // todo:
    }
}
