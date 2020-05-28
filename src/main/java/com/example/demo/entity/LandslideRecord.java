package com.example.demo.entity;

import java.util.Arrays;

/**
 * @Data 2020/5/27 10:28
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class LandslideRecord {
    private int idLandslideRecord;
    private String disasterID;
    private String location;
    private String disasterDate;
    private String disasterType;
    private String status;
    private String note;
    private byte[] picture;
    private String reportingUnit;

    public LandslideRecord() {
    }

    public int getIdLandslideRecord() {
        return idLandslideRecord;
    }

    public void setIdLandslideRecord(int idLandslideRecord) {
        this.idLandslideRecord = idLandslideRecord;
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
        return "LandslideRecordMapper{" +
                "idLandslideRecord=" + idLandslideRecord +
                ", disasterID='" + disasterID + '\'' +
                ", location='" + location + '\'' +
                ", disasterDate='" + disasterDate + '\'' +
                ", disasterType='" + disasterType + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
}
