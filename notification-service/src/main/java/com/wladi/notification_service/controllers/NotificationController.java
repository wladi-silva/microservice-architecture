package com.wladi.notification_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wladi.notification_service.models.Notification;
import com.wladi.notification_service.services.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> saveNotification(@RequestBody Notification notification) {
        notificationService.saveNotification(notification);
        return ResponseEntity.ok().build();
    }
    
}
