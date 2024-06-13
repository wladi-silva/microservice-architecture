package com.wladi.notification_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.wladi.notification_service.models.Notification;

@FeignClient(name = "notification-service")
public interface NotificationClient {

    @PostMapping("/notifications/notify")
    void notify(Notification notification);
    
}
