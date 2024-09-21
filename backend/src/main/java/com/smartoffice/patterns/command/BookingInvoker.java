package com.smartoffice.patterns.command;


public class BookingInvoker {

    private BookingCommand bookingCommand;

    public void setBookingCommand(BookingCommand bookingCommand) {
        this.bookingCommand = bookingCommand;
    }

    public void executeCommand() {
        bookingCommand.execute();
    }
}
