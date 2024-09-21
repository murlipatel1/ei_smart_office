package com.smartoffice.patterns.observer;

import com.smartoffice.model.Room;

public interface RoomObserver {
    void update(boolean isOccupied);
}

