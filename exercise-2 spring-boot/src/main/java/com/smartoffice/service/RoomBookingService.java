package com.smartoffice.service;

import com.smartoffice.model.Room;
import com.smartoffice.patterns.command.BookRoomCommand;
import com.smartoffice.patterns.command.BookingCommand;
import com.smartoffice.patterns.command.CancelRoomCommand;
import com.smartoffice.patterns.command.BookingInvoker;
import com.smartoffice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomBookingService {

    @Autowired
    private RoomRepository roomRepository;

    private final BookingInvoker bookingInvoker;

    public RoomBookingService() {
        this.bookingInvoker = new BookingInvoker();
    }

    // Method to book a room
    public void bookRoom(Room room) {
        if (!room.isBooked()) {
            // Mark room as booked
            room.setBooked(true);
            roomRepository.save(room);

            // Execute book command
            BookingCommand bookRoomCommand = new BookRoomCommand(this, room);
            bookingInvoker.setBookingCommand(bookRoomCommand);
            bookingInvoker.executeCommand();
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is already booked.");
        }
    }

    // Method to cancel room booking
    public void cancelRoomBooking(Room room) {
        if (room.isBooked()) {
            // Mark room as not booked
            room.setBooked(false);
            roomRepository.save(room);

            // Execute cancel command
            BookingCommand cancelRoomCommand = new CancelRoomCommand(this, room);
            bookingInvoker.setBookingCommand(cancelRoomCommand);
            bookingInvoker.executeCommand();
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is not booked.");
        }
    }

    // Helper method to find a room by ID
    public Optional<Room> findRoomById(Long roomId) {
        return roomRepository.findById(roomId);
    }
}
