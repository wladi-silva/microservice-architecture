package com.wladi.room_management_service.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wladi.room_management_service.clients.NotificationClient;
import com.wladi.room_management_service.models.Notification;
import com.wladi.room_management_service.models.Room;
import com.wladi.room_management_service.repositories.RoomRepository;

@Service
public class RoomService {
  
    private RoomRepository roomRepository;

    private NotificationClient notificationClient;

    public RoomService(RoomRepository roomRepository, NotificationClient notificationClient) {
        this.roomRepository = roomRepository;
        this.notificationClient = notificationClient;
    }

    public Room saveRoom(Room room) {
        Room savedRoom = roomRepository.save(room);
        Notification notification = new Notification("disponivel", savedRoom.getId(), LocalDateTime.now());
        notificationClient.notify(notification);
        return savedRoom;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room updateRoom(Long id, Room roomDetails) {
        Room room = roomRepository.findById(id).orElseThrow();
        room.setName(roomDetails.getName());
        room.setStatus(roomDetails.getStatus());
        Room updatedRoom = roomRepository.save(room);
        return updatedRoom;
    }

    public Room setRoomMaintenance(Long id) {
        Room room = roomRepository.findById(id).orElseThrow();
        room.setStatus("indisponível");
        Room updatedRoom = roomRepository.save(room);
        Notification notification = new Notification(room.getStatus(), room.getId(), LocalDateTime.now());
        notificationClient.notify(notification);
        return updatedRoom;
    }
    
}
