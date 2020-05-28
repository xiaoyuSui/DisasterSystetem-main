package com.example.demo.entity;

import java.util.Arrays;

public class CollRecord {
    private int idCollRecord;
    private String disasterID;
    private String location;
    private String disasterDate;
    private String disasterType;
    private String status;
    private String note;
    private String picture;
    private String reportingUnit;

    public CollRecord() {
    }
    public CollRecord(int idCollRecord, String disasterID, String location, String disasterDate, String disasterType, String status, String note, String picture, String reportingUnit) {
        this.idCollRecord = idCollRecord;
        this.disasterID = disasterID;
        this.location = location;
        this.disasterDate = disasterDate;
        this.disasterType = disasterType;
        this.status = status;
        this.note = note;
        this.picture = picture;
        this.reportingUnit = reportingUnit;
    }

    public CollRecord(String disasterID) {
        this.disasterID = disasterID;
    }

    public int getIdCollRecord() {
        return idCollRecord;
    }

    public void setIdCollRecord(int idCollRecord) {
        this.idCollRecord = idCollRecord;
    }

    public String getDisasterID() {
        return disasterID;
    }

    public void setDisasterID(String disasterID) {
        this.disasterID = disasterID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDisasterDate() {
        return disasterDate;
    }

    public void setDisasterDate(String disasterDate) {
        this.disasterDate = disasterDate;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
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
        return "CollRecord{" +
                "idCollRecord=" + idCollRecord +
                ", disasterID='" + disasterID + '\'' +
                ", location='" + location + '\'' +
                ", disasterDate='" + disasterDate + '\'' +
                ", disasterType='" + disasterType + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", picture=" + picture + '\'' +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
}
