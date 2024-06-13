package com.wladi.scheduling_service.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wladi.scheduling_service.clients.NotificationClient;
import com.wladi.scheduling_service.clients.RoomClient;
import com.wladi.scheduling_service.models.Notification;
import com.wladi.scheduling_service.models.Room;
import com.wladi.scheduling_service.models.Schedule;
import com.wladi.scheduling_service.repositories.ScheduleRepository;

@Service
public class SchedulingService {

    private ScheduleRepository scheduleRepository;

    private NotificationClient notificationClient;

    private RoomClient roomClient;

    public SchedulingService(ScheduleRepository scheduleRepository, NotificationClient notificationClient, RoomClient roomClient) {
        this.scheduleRepository = scheduleRepository;
        this.notificationClient = notificationClient;
        this.roomClient = roomClient;
    }

    public Schedule reserveRoom(Schedule schedule) {
        Optional<Room> reservedRoom = roomClient.getRoomById(schedule.getRoomId());
        Room room = reservedRoom.get();
        room.setStatus("ocupada");
        roomClient.updateRoom(schedule.getRoomId(), room);
        if (room.getStatus().equals("disponivel")) {
            scheduleRepository.save(schedule);
        } else {
            notificationClient.notify(new Notification("ocupada", room.getId(), LocalDateTime.now()));
        }
        return schedule;
    }

}
