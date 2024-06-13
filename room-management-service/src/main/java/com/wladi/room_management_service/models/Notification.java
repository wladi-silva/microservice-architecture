package com.wladi.room_management_service.models;

import java.time.LocalDateTime;

public class Notification {
    
    private Long id;
    private String status;
    private Long recipientId;
    private LocalDateTime timestamp;

    public Notification() {

    }

    public Notification(String status, Long recipientId, LocalDateTime timestamp) {
        this.status = status;
        this.recipientId = recipientId;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
