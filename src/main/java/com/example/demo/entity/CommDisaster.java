package com.example.demo.entity;

public class CommDisaster {
    private int idCommDisaster;
    private String disasterID;
    private String disasterDate;
    private String location;
    private String disasterType;
    private String grade;
    private byte[] picture;
    private String note;
    private String reportingUnit;

    public CommDisaster() {
    }

    public CommDisaster(String disasterID, String disasterDate, String location, String disasterType, String grade, String reportingUnit) {
        this.disasterID = disasterID;
        this.disasterDate = disasterDate;
        this.location = location;
        this.disasterType = disasterType;
        this.grade = grade;
        this.reportingUnit = reportingUnit;
    }


    public CommDisaster(String disasterID, String disasterDate, String location, String disasterType, String grade, byte[] picture, String note, String reportingUnit) {
        this.disasterID = disasterID;
        this.disasterDate = disasterDate;
        this.location = location;
        this.disasterType = disasterType;
        this.grade = grade;
        this.picture = picture;
        this.note = note;
        this.reportingUnit = reportingUnit;
    }
    public CommDisaster(String disasterID, String disasterDate, String location, String disasterType, String grade, String note, String reportingUnit) {
        this.disasterID = disasterID;
        this.disasterDate = disasterDate;
        this.location = location;
        this.disasterType = disasterType;
        this.grade = grade;
        this.note = note;
        this.reportingUnit = reportingUnit;
    }
    public int getIdCommDisaster() {
        return idCommDisaster;
    }

    public void setIdCommDisaster(int idCommDisaster) {
        this.idCommDisaster = idCommDisaster;
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
        return "CommDisaster{" +
                "idCommDisaster=" + idCommDisaster +
                ", disasterID=" + disasterID +
                ", disasterDate='" + disasterDate + '\'' +
                ", location='" + location + '\'' +
                ", disasterType='" + disasterType + '\'' +
                ", grade='" + grade + '\'' +
                ", picture='" + picture + '\'' +
                ", note='" + note + '\'' +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }


}
