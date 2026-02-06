package org.example.demoamin.restTemplateProject.controller;

import org.example.demoamin.restTemplateProject.dto.PostDto;
import org.example.demoamin.restTemplateProject.dto.UserDto;
import org.example.demoamin.restTemplateProject.service.PostService;
import org.example.demoamin.restTemplateProject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDto>> getUserPosts(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostsByUserId(id));
    }
}
