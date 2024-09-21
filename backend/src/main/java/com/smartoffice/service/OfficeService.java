package com.smartoffice.service;

import com.smartoffice.patterns.singleton.OfficeSingleton;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    // Singleton instance to manage office resources
    private final OfficeSingleton officeSingleton;

    public OfficeService() {
        this.officeSingleton = OfficeSingleton.getInstance();
    }

    public void manageOfficeResources() {
        // OfficeSingleton will handle resource management
        officeSingleton.manageOffice();
    }
}
