package com.smartoffice.patterns.command;

import com.smartoffice.model.Room;
import com.smartoffice.service.RoomBookingService;

public class BookRoomCommand implements BookingCommand {

    private RoomBookingService roomBookingService;
    private Room room;

    public BookRoomCommand(RoomBookingService roomBookingService, Room room) {
        this.roomBookingService = roomBookingService;
        this.room = room;
    }

    @Override
    public void execute() {
        roomBookingService.bookRoom(room);
        System.out.println("Room " + room.getRoomNumber() + " has been booked.");
    }
}
