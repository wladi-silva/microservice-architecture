package com.wladi.room_management_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wladi.room_management_service.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    
}

