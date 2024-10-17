package com.example.backendspringbootcodeconnect.service;



import com.example.backendspringbootcodeconnect.model.Notification;
import com.example.backendspringbootcodeconnect.model.Post;
import com.example.backendspringbootcodeconnect.repositorio.PostRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepositorio postRepositorio;

    public List<Post> getPost() {
        return this.postRepositorio.findAll();
    }

    @Transactional
    public Post inserirOuAtualizar(Post post) {
        if (post.getMessage().length() > 255) {
            throw new RuntimeException("O limite de caracteres para a mensagem é de 255");
        }
        return this.postRepositorio.save(post);
    }


    public boolean apagar(Long id){
            if (postRepositorio.existsById(id)) {
                postRepositorio.deleteById(id);
                return true;
            } else {
                return false;
            }
        }
    }

