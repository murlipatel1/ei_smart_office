package com.smartoffice.patterns.command;

import com.smartoffice.model.Room;
import com.smartoffice.service.RoomBookingService;

public class CancelRoomCommand implements BookingCommand {

    private RoomBookingService roomBookingService;
    private Room room;

    public CancelRoomCommand(RoomBookingService roomBookingService, Room room) {
        this.roomBookingService = roomBookingService;
        this.room = room;
    }

    @Override
    public void execute() {
        roomBookingService.cancelRoomBooking(room);
        System.out.println("Room " + room.getRoomNumber() + " booking has been canceled.");
    }
}
