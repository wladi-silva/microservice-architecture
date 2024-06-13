package com.wladi.notification_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wladi.notification_service.models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
