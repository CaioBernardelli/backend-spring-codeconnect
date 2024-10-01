package com.example.backendspringbootcodeconnect.repositorio;

import com.example.backendspringbootcodeconnect.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepositorio extends JpaRepository<Notification, Long> {

    public List<Notification> findByDate(String date);

    // Notificações para administradores (relacionadas a alterações em usuários ou cursos)
    public List<Notification> findByType(String type);

    // Consulta JPQL para retornar notificações de um tipo específico
    @Query("SELECT n FROM Notification n WHERE n.type = ?1")
    public List<Notification> getNotificationsByType(String type);
}

