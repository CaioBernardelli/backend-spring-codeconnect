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

    public List<Notification> getNotification(){
        return this.notificationRepositorio.findAll();
    }


     public Notification getNotificationPorId (Long idNotification){
        return this.notificationRepositorio.findById(idNotification).orElse(null);

     }


    @Transactional
    public Notification inserirOuAtualizar(Notification notification) {
        // Verifica o limite de caracteres da mensagem
        if (notification.getMessage().length() > 255) {
            throw new RuntimeException("O limite de caracteres para a mensagem é de 255");
        }

        // Salvando a notificação
        Notification notificationInserida = this.notificationRepositorio.save(notification);

        // Verifica alguma lógica adicional, se necessário (exemplo: menor de idade, se for relevante)
        // if (alguma_condicao) {
        //     throw new RuntimeException("Alguma condição não permitida");
        // }

        return notificationInserida;
    }

    public void apagar(Long id) {
        this.notificationRepositorio.deleteById(id);
    }


}
