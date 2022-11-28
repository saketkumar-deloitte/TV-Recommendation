package com.subscribe.mainp.service;

import com.subscribe.mainp.dto.UserDto;
import com.subscribe.mainp.entity.User;

import java.util.List;

public interface UserService {

    //create
    User createUser(UserDto userDto);

    //update
    UserDto updateUser(UserDto userDto, Integer userId);

    //delete
    void deleteUser(Integer userId);
    //getById
    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();
}
