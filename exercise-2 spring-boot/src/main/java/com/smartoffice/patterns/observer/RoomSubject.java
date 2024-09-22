package com.smartoffice.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class RoomSubject {

    private List<RoomObserver> observers = new ArrayList<>();
    private boolean isOccupied;

    public void addObserver(RoomObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RoomObserver observer) {
        observers.remove(observer);
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
        notifyObservers();
    }

    private void notifyObservers() {
        for (RoomObserver observer : observers) {
            observer.update(isOccupied);
        }
    }
}
