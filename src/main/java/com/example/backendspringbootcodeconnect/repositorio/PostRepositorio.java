package com.example.backendspringbootcodeconnect.repositorio;

import com.example.backendspringbootcodeconnect.model.Notification;
import com.example.backendspringbootcodeconnect.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepositorio extends JpaRepository<Post, Long> {




}
