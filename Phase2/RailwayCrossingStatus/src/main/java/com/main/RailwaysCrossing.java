package com.main;

public class RailwaysCrossing {
    private int id;
    private String name;
    private String address;
    private String landmark;
    private String trainSchedules;
    private String personInCharge;
    private int status;

    public RailwaysCrossing(int id, String name, String address, String landmark, String trainSchedules, String personInCharge, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.landmark = landmark;
        this.trainSchedules = trainSchedules;
        this.personInCharge = personInCharge;
        this.status = status;
    }

    // Getters and setters for the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getTrainSchedules() {
        return trainSchedules;
    }

    public void setTrainSchedules(String trainSchedules) {
        this.trainSchedules = trainSchedules;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
