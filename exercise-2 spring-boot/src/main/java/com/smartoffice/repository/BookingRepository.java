package com.smartoffice.repository;

import com.smartoffice.model.Booking;
import com.smartoffice.model.Room;
import com.smartoffice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Find all bookings for a specific user
    List<Booking> findByUser(User user);

    // Find all bookings for a specific room
    List<Booking> findByRoom(Room room);

    // Find active bookings
    List<Booking> findByIsActive(boolean isActive);

}
