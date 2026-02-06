package org.example.demoamin.restTemplateProject.service;

import org.example.demoamin.restTemplateProject.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private String BASE_URL = "https://jsonplaceholder.typicode.com";

    private RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<UserDto> getAllUsers() {
        String url = BASE_URL + "/users";
        UserDto[] res= restTemplate.getForObject(url, UserDto[].class);
        return Arrays.asList(res);
    }

    @Override
    public UserDto getUserById(Long id) {
        String url = BASE_URL + "/users/" + id;
        UserDto res= restTemplate.getForObject(url, UserDto.class);
        return res;
    }
}
