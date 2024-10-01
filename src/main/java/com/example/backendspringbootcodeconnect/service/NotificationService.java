package com.example.backendspringbootcodeconnect.service;

import com.example.backendspringbootcodeconnect.model.Notification;
import com.example.backendspringbootcodeconnect.repositorio.NotificationRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepositorio notificationRepositorio;

    public List<Notification> getNotification() {
        return this.notificationRepositorio.findAll();
    }

    public List<Notification> getNotificationsByType(String type) {
        return this.notificationRepositorio.findByType(type);
    }

    public Notification getNotificationPorId(Long idNotification) {
        return this.notificationRepositorio.findById(idNotification).orElse(null);
    }

    @Transactional
    public Notification inserirOuAtualizar(Notification notification) {
        if (notification.getMessage().length() > 255) {
            throw new RuntimeException("O limite de caracteres para a mensagem é de 255");
        }
        return this.notificationRepositorio.save(notification);
    }


    public boolean apagar(Long id) {
        if (notificationRepositorio.existsById(id)) {
            notificationRepositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
