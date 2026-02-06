package org.example.demoamin.restTemplateProject.service;

import org.example.demoamin.restTemplateProject.dto.PostDto;

import java.util.List;

public interface PostService {

     List<PostDto> getAllPosts();

     PostDto getPostById(Long id);

     List<PostDto> getPostsByUserId(Long userId);



}
