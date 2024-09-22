package com.smartoffice.patterns.singleton;

public class OfficeSingleton {

    // Static variable to hold the single instance of the class
    private static OfficeSingleton instance;

    // Private constructor to prevent instantiation
    private OfficeSingleton() {}

    // Public method to provide access to the single instance
    public static OfficeSingleton getInstance() {
        if (instance == null) {
            synchronized (OfficeSingleton.class) {
                if (instance == null) {
                    instance = new OfficeSingleton();
                }
            }
        }
        return instance;
    }

    // Example method: Add office-related functionality here
    public void manageOffice() {
        System.out.println("Managing office resources...");
    }
}
