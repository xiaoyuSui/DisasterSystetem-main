package com.example.demo.entity;

import java.util.Arrays;

/**
 * @Data 2020/5/27 10:28
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class DisasterInfo {
    private int idDisasterInfo;
    private String disasterID;
    private String disasterDate;
    private String location;
    private Float longitude;
    private Float latitude;
    private Float depth;
    private Float magnitude;
    private byte[] picture;
    private String reportingUnit;

    public DisasterInfo() {
    }

    public void setIdDisasterInfo(int idDisasterInfo) {
        this.idDisasterInfo = idDisasterInfo;
    }

    public int getIdDisasterInfo() {
        return idDisasterInfo;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }

    @Override
    public String toString() {
        return "DisasterInfo{" +
                "idDisasterInfo=" + idDisasterInfo +
                ", disasterID='" + disasterID + '\'' +
                ", disasterDate='" + disasterDate + '\'' +
                ", location='" + location + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", depth=" + depth +
                ", magnitude=" + magnitude +
                ", picture=" + Arrays.toString(picture) +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
}
