package com.smartoffice.service;

import com.smartoffice.model.Room;
import com.smartoffice.patterns.observer.ACControl;
import com.smartoffice.patterns.observer.LightControl;
import com.smartoffice.patterns.observer.RoomObserver;
import com.smartoffice.patterns.observer.RoomSubject;
import com.smartoffice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OccupancyService {

    @Autowired
    private RoomRepository roomRepository;

    private final RoomSubject roomSubject;

    public OccupancyService() {
        // Initialize RoomSubject and attach observers
        this.roomSubject = new RoomSubject();
        RoomObserver acControl = new ACControl();
        RoomObserver lightControl = new LightControl();

        roomSubject.addObserver(acControl);
        roomSubject.addObserver(lightControl);
    }

    // Method to update room occupancy status and notify observers
    public void updateRoomOccupancy(Long roomId, boolean isOccupied) {
        Optional<Room> roomOptional = roomRepository.findById(roomId);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            room.setOccupied(isOccupied);
            roomRepository.save(room);

            // Notify observers about the change in room occupancy
            roomSubject.setOccupied(isOccupied);

            System.out.println("Room " + room.getRoomNumber() + " occupancy updated: " + isOccupied);
        } else {
            System.out.println("Room with ID " + roomId + " not found.");
        }
    }

    // Helper method to get room by ID
    public Optional<Room> findRoomById(Long roomId) {
        return roomRepository.findById(roomId);
    }
}
