package com.wladi.room_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RoomManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomManagementServiceApplication.class, args);
	}

}
