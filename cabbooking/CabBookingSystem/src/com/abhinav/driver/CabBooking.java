package com.abhinav.driver;

import java.lang.*;
import java.util.*;

import com.abhinav.model.User;
import com.abhinav.service.CabBookingApplication;

public class CabBooking {
    public static void main(String[] args) {
        CabBookingApplication cabApp = new CabBookingApplication();

        cabApp.addUser("Abhishek", "M", 23);
        cabApp.addUser("Rahul", "M", 29);
        cabApp.addUser("Nandini", "F", 22);

        cabApp.addDriver("Driver1", "M", 22, "Swift", "KA-01-12345", new int[]{10, 1});
        cabApp.addDriver("Driver2", "M", 29, "Swift", "KA-01-12345", new int[]{11, 10});
        cabApp.addDriver("Driver3", "M", 24, "Swift", "KA-01-12345", new int[]{5, 3});

        cabApp.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1});
        cabApp.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3});
        cabApp.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4});
    }
}
