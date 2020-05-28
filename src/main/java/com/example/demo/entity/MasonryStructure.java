package com.example.demo.entity;

/**
 * @Data 2020/5/27 10:27
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class MasonryStructure {
    private Integer idMasonryStructure;

    private String disasterID;

    private String disasterDate;

    private String location;

    private String intactSquare;

    private String slightDamagedSquare;

    private String moderateDamagedSquare;

    private String seriousDamagedSquare;

    private String destroyedSquare;

    private String note;

    private String reportingUnit;

    public MasonryStructure() {
    }

    public Integer getIdMasonryStructure() {
        return idMasonryStructure;
    }

    public void setIdMasonryStructure(Integer idMasonryStructure) {
        this.idMasonryStructure = idMasonryStructure;
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

    public String getIntactSquare() {
        return intactSquare;
    }

    public void setIntactSquare(String intactSquare) {
        this.intactSquare = intactSquare;
    }

    public String getSlightDamagedSquare() {
        return slightDamagedSquare;
    }

    public void setSlightDamagedSquare(String slightDamagedSquare) {
        this.slightDamagedSquare = slightDamagedSquare;
    }

    public String getModerateDamagedSquare() {
        return moderateDamagedSquare;
    }

    public void setModerateDamagedSquare(String moderateDamagedSquare) {
        this.moderateDamagedSquare = moderateDamagedSquare;
    }

    public String getSeriousDamagedSquare() {
        return seriousDamagedSquare;
    }

    public void setSeriousDamagedSquare(String seriousDamagedSquare) {
        this.seriousDamagedSquare = seriousDamagedSquare;
    }

    public String getDestroyedSquare() {
        return destroyedSquare;
    }

    public void setDestroyedSquare(String destroyedSquare) {
        this.destroyedSquare = destroyedSquare;
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
}
