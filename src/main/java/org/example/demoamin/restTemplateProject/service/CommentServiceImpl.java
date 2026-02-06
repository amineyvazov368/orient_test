package org.example.demoamin.restTemplateProject.service;


import org.example.demoamin.restTemplateProject.dto.CommentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private String BASE_URL = "https://jsonplaceholder.typicode.com";

    private RestTemplate restTemplate;

    public CommentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        String url = BASE_URL + "/posts/" + postId + "/comments";
        CommentDto[] res = restTemplate.getForObject(url, CommentDto[].class);
        return Arrays.asList(res);
    }

    @Override
    public CommentDto getCommentById(Long id) {
        String url = BASE_URL + "/comments/" + id;
        CommentDto res = restTemplate.getForObject(url, CommentDto.class);
        return res;
    }
}
