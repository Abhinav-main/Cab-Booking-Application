package com.abhinav.service;

import com.abhinav.model.Driver;
import com.abhinav.model.User;

import java.util.*;
import java.lang.*;

public class CabBookingApplication {
    List<User> users = new ArrayList<>();
    List<Driver> drivers = new ArrayList<>();

    public void addUser(String name, String gender, int age) {
        User user = new User(name, gender, age);
        users.add(user);
    }

    public void addDriver(String name, String gender, int age, String vehicle, String plate, int[] location) {
        Driver driver = new Driver(name, gender, age, vehicle, plate, location);
        drivers.add(driver);
    }

    public List<Driver> findRide(String username, int[] source, int[] destination) {
        List<Driver> availableRides = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.available && isWithinDistance(driver.location, source, 5)) {
                availableRides.add(driver);
            }
        }
        for (Driver driver: availableRides){
            System.out.println(driver.getName());
        }
        return availableRides;
    }

    private boolean isWithinDistance(int[] location1, int[] location2, int distance) {
        int deltaX = location1[0] - location2[0];
        int deltaY = location1[1] - location2[1];
        double distanceBetweenPoints = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return distanceBetweenPoints <= distance;
    }

    public void chooseRide(String username, String driverName) {
        for (Driver driver : drivers) {
            if (driver.name.equals(driverName)) {
                driver.available = false;
                System.out.println(username + " chose " + driverName + "'s ride.");
                return;
            }
        }
        System.out.println("Invalid driver name.");
    }
}
