package com.wladi.scheduling_service.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.wladi.scheduling_service.models.Schedule;
import com.wladi.scheduling_service.services.SchedulingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/schedules")
public class SchedulingController {
    
    private SchedulingService schedulingService;

    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    public ResponseEntity<Schedule> reserveRoom(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(schedulingService.reserveRoom(schedule));
    }

}

