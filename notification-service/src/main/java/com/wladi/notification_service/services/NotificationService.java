package com.wladi.notification_service.services;

import org.springframework.stereotype.Service;

import com.wladi.notification_service.models.Notification;
import com.wladi.notification_service.repositories.NotificationRepository;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void saveNotification(Notification notification) {
        Notification savedNotification = notificationRepository.save(notification);
        sendNotification(savedNotification.toString());
    }

    public void sendNotification(String dataNotification) {
        System.out.println("Mensagem para coordenador do curso e ao administrador: " + dataNotification);
    }

}
