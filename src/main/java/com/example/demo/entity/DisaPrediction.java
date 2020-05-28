package com.example.demo.entity;

import java.util.Arrays;

public class DisaPrediction {
    private int idDisaPrediction;
    private String disasterID;
    private String disasterDate;
    private String location;
    private Float longitude;
    private Float latitude;
    private Float depth;
    private Float magnitude;
    private String intensity;
    private String disasterType;
    private byte[] picture;
    private String note;
    private String reportingUnit;

    public DisaPrediction() {
    }

    public DisaPrediction(String disasterID, String disasterDate, String location, Float longitude, Float latitude, Float depth, Float magnitude, String intensity, String disasterType, String note, String reportingUnit) {
        this.disasterID = disasterID;
        this.disasterDate = disasterDate;
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.depth = depth;
        this.magnitude = magnitude;
        this.intensity = intensity;
        this.disasterType = disasterType;
        this.note = note;
        this.reportingUnit = reportingUnit;
    }

    public DisaPrediction(int idDisaPrediction, String disasterID, String disasterDate, String location, Float longitude, Float latitude, Float depth, Float magnitude, String intensity, String disasterType, String note, String reportingUnit) {
        this.idDisaPrediction = idDisaPrediction;
        this.disasterID = disasterID;
        this.disasterDate = disasterDate;
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.depth = depth;
        this.magnitude = magnitude;
        this.intensity = intensity;
        this.disasterType = disasterType;
        this.note = note;
        this.reportingUnit = reportingUnit;
    }

    public DisaPrediction(int idDisaPrediction, String disasterID, String disasterDate, String location, Float longitude, Float latitude, Float depth, Float magnitude, String intensity, String disasterType, byte[] picture, String note, String reportingUnit) {
        this.idDisaPrediction = idDisaPrediction;
        this.disasterID = disasterID;
        this.disasterDate = disasterDate;
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.depth = depth;
        this.magnitude = magnitude;
        this.intensity = intensity;
        this.disasterType = disasterType;
        this.picture = picture;
        this.note = note;
        this.reportingUnit = reportingUnit;
    }

    public int getIdDisaPrediction() {
        return idDisaPrediction;
    }

    public void setIdDisaPrediction(int idDisaPrediction) {
        this.idDisaPrediction = idDisaPrediction;
    }

    public String getDisasterID() {
        return disasterID;
    }

    public void setDisasterID(String disasterID) {
        this.disasterID = disasterID;
    }

    public String getDisasterDate() {
        return disasterDate;
    }

    public void setDisasterDate(String disasterDate) {
        this.disasterDate = disasterDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Float magnitude) {
        this.magnitude = magnitude;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }

    @Override
    public String toString() {
        return "DisaPrediction{" +
                "idDisaPrediction=" + idDisaPrediction +
                ", disasterID='" + disasterID + '\'' +
                ", disasterDate='" + disasterDate + '\'' +
                ", location='" + location + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", depth=" + depth +
                ", magnitude=" + magnitude +
                ", intensity='" + intensity + '\'' +
                ", disasterType='" + disasterType + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", note='" + note + '\'' +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
}
