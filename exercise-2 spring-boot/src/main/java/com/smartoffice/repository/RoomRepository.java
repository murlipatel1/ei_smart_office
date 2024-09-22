package com.smartoffice.repository;

import com.smartoffice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    // Find a room by its room number
    Optional<Room> findByRoomNumber(int roomNumber);

    // Find rooms by their booking status
    Optional<Room> findByIsBooked(boolean isBooked);
}
