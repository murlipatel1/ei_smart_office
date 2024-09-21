package com.smartoffice.controller;

import com.smartoffice.model.Room;
import com.smartoffice.service.OfficeService;
import com.smartoffice.service.OccupancyService;
import com.smartoffice.service.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private RoomBookingService roomBookingService;

    @Autowired
    private OccupancyService occupancyService;

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Backend application is running");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API to manage office resources (Singleton example)
    @PostMapping("/manage")
    public ResponseEntity<Map<String, Object>> manageOffice() {
        officeService.manageOfficeResources();

        // Create a response JSON
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Office resources managed successfully");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API to book a room (Command Pattern example)
    @PostMapping("/bookRoom/{roomId}")
    public ResponseEntity<Map<String, Object>> bookRoom(@PathVariable Long roomId) {
        Optional<Room> roomOptional = roomBookingService.findRoomById(roomId);

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            roomBookingService.bookRoom(room);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Room booked successfully");
            response.put("roomNumber", room.getRoomNumber());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Room not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    // API to cancel a room booking (Command Pattern example)
    @PostMapping("/cancelRoom/{roomId}")
    public ResponseEntity<Map<String, Object>> cancelRoom(@PathVariable Long roomId) {
        Optional<Room> roomOptional = roomBookingService.findRoomById(roomId);

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            roomBookingService.cancelRoomBooking(room);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Room booking cancelled successfully");
            response.put("roomNumber", room.getRoomNumber());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Room not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    // API to update room occupancy (Observer Pattern example)
    @PostMapping("/updateOccupancy/{roomId}")
    public ResponseEntity<Map<String, Object>> updateRoomOccupancy(@PathVariable Long roomId, @RequestParam boolean isOccupied) {
        Optional<Room> roomOptional = occupancyService.findRoomById(roomId);

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            occupancyService.updateRoomOccupancy(roomId, isOccupied);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Room occupancy updated successfully");
            response.put("roomNumber", room.getRoomNumber());
            response.put("isOccupied", isOccupied);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Room not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    // API to get room information by ID (for debugging or client requests)
    @GetMapping("/room/{roomId}")
    public ResponseEntity<Map<String, Object>> getRoomById(@PathVariable Long roomId) {
        Optional<Room> roomOptional = roomBookingService.findRoomById(roomId);

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("roomNumber", room.getRoomNumber());
            response.put("isBooked", room.isBooked());
            response.put("isOccupied", room.isOccupied());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Room not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    // Fallback handler for undefined API routes
    @GetMapping("/fallback")
    public ResponseEntity<Map<String, Object>> fallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "API route not found. Check the request URL.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
