package com.example.backendspringbootcodeconnect.repositorio;

import com.example.backendspringbootcodeconnect.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Interface que faz os metodos crud , sem precisar dos códigos.
public interface NotificationRepositorio extends JpaRepository<Notification, Long> {


    public List<Notification> findByDate(String date);


    // consulta mais complexa em jpql  // anotação query e metodo public
    @Query("SELECT n FROM Notification n WHERE n.date = '2011-10-10'")
    public List<Notification> getNotificationByDate();
}