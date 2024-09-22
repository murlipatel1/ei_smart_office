package com.smartoffice.patterns.observer;

import com.smartoffice.model.Room;

public class ACControl implements RoomObserver {

    @Override
    public void update(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Turning on the AC.");
        } else {
            System.out.println("Turning off the AC.");
        }
    }
}

