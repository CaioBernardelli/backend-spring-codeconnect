package com.example.backendspringbootcodeconnect.controlador;


import com.example.backendspringbootcodeconnect.model.Notification;
import com.example.backendspringbootcodeconnect.model.Post;
import com.example.backendspringbootcodeconnect.service.NotificationService;
import com.example.backendspringbootcodeconnect.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/posts")
public class PostControlador {


    @Autowired
    private PostService postService;


    @GetMapping
    public ResponseEntity<List<Post>> getPost() {
        List<Post> post = postService.getPost();
        return ResponseEntity.ok(post);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        boolean wasDeleted = postService.apagar(id);
        if (wasDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Post> createOrUpdateNotification(@RequestBody Post post) {
        Post savedPost = postService.inserirOuAtualizar(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
}
