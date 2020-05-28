package com.example.demo.entity;

public class CivilStructure {
    private Integer idCivilStructure=0;

    private String disasterID;

    private String disasterDate;

    private String location;

    private String intactSquare=null;

    private String damagedSquare=null;

    private String destroyedSquare=null;

    private String note=null;

    private String reportingUnit;

    public CivilStructure(Integer idCivilStructure, String disasterID, String disasterDate, String location, String intactSquare, String damagedSquare, String destroyedSquare, String note, String reportingUnit){
        this.idCivilStructure=idCivilStructure;
        this.disasterID=disasterID;
        this.disasterDate=disasterDate;
        this.location=location;
        this.intactSquare=intactSquare;
        this.damagedSquare=damagedSquare;
        this.destroyedSquare=destroyedSquare;
        this.note=note;
        this.reportingUnit=reportingUnit;
    }

    public CivilStructure(){
        super();
    }

    public Integer getIdCivilStructure() {
        return idCivilStructure;
    }

    public void setIdCivilStructure(Integer idCivilStructure) {
        this.idCivilStructure = idCivilStructure;
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

    public String getDamagedSquare() {
        return damagedSquare;
    }

    public void setDamagedSquare(String damagedSquare) {
        this.damagedSquare = damagedSquare;
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
