package org.example.demoamin.restTemplateProject.service;

import org.example.demoamin.restTemplateProject.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getCommentsByPostId(Long postId);

    CommentDto getCommentById(Long id);
}
