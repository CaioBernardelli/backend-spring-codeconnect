package com.example.backendspringbootcodeconnect.controlador;


import com.example.backendspringbootcodeconnect.model.Notification;
import com.example.backendspringbootcodeconnect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class NotificationControlador {

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/notification")
    public List<Notification> getNotification(){
        return new ArrayList<>();
    }


}
