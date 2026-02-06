package org.example.demoamin.restTemplateProject.service;

import org.example.demoamin.restTemplateProject.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);


}
