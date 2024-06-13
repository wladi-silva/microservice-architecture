package com.wladi.scheduling_service.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wladi.scheduling_service.models.Room;

@FeignClient(name = "room-management-service")
public interface RoomClient {

    @PutMapping("rooms/{id}")
    void updateRoom(@PathVariable Long id, @RequestBody Room room); 

    @GetMapping("rooms/{id}")
    Optional<Room> getRoomById(@PathVariable Long id);

}
