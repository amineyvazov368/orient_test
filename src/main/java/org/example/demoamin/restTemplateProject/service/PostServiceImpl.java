package org.example.demoamin.restTemplateProject.service;

import org.example.demoamin.restTemplateProject.dto.PostDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private String BASE_URL ="https://jsonplaceholder.typicode.com";

    private RestTemplate restTemplate ;

    public PostServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PostDto> getAllPosts() {
        String url = BASE_URL + "/posts";
      PostDto[] res= restTemplate.getForObject(url, PostDto[].class);
      return Arrays.asList(res);

    }

    @Override
    public PostDto getPostById(Long id) {
        String url = BASE_URL + "/posts/" + id;
        PostDto res= restTemplate.getForObject(url, PostDto.class);
        return res;
    }

    @Override
    public List<PostDto> getPostsByUserId(Long userId) {
        String url = BASE_URL + "/posts?userId=" + userId;
        PostDto[] res= restTemplate.getForObject(url, PostDto[].class);
        return Arrays.asList(res);
    }
}
