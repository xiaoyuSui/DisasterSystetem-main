package com.example.demo.entity;

import java.util.Arrays;

/**
 * @Data 2020/5/27 10:24
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class TrafficDisaster {
    private int idTrafficDisaster;
    private String disasterID;
    private String disasterDate;
    private String location;
    private String disasterType;
    private String grade;
    private byte[] picture;
    private String note;
    private String reportingUnit;

    public TrafficDisaster() {
    }

    public int getIdTrafficDisaster() {
        return idTrafficDisaster;
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

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
        return "TrafficDisaster{" +
                "idTrafficDisaster=" + idTrafficDisaster +
                ", disasterID='" + disasterID + '\'' +
                ", disasterDate='" + disasterDate + '\'' +
                ", location='" + location + '\'' +
                ", disasterType='" + disasterType + '\'' +
                ", grade='" + grade + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", note='" + note + '\'' +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
}
