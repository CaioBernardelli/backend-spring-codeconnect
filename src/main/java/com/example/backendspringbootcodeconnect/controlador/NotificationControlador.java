package com.example.backendspringbootcodeconnect.controlador;

import com.example.backendspringbootcodeconnect.model.Notification;
import com.example.backendspringbootcodeconnect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationControlador {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/tipo/{type}")
    public ResponseEntity<List<Notification>> getNotificationsByType(@PathVariable String type) {
        List<Notification> notifications = notificationService.getNotificationsByType(type);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getNotification() {
        List<Notification> notifications = notificationService.getNotification();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationPorId(id);
        if (notification != null) {
            return ResponseEntity.ok(notification);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        boolean wasDeleted = notificationService.apagar(id);
        if (wasDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Notification> createOrUpdateNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.inserirOuAtualizar(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNotification);
    }

}
