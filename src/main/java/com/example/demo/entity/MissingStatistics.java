package com.example.demo.entity;

/**
 * @Data 2020/5/27 10:27
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class MissingStatistics {
    private Integer idMissingStatistics;

    private String disasterID;

    private String disasterDate;

    private String location;

    private Integer numberDeath;

    private String reportingUnit;

    public MissingStatistics() {
    }

    public Integer getIdMissingStatistics() {
        return idMissingStatistics;
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

    public Integer getNumberDeath() {
        return numberDeath;
    }

    public void setNumberDeath(Integer numberDeath) {
        this.numberDeath = numberDeath;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }

    @Override
    public String toString() {
        return "MissingStatistics{" +
                "idMissingStatistics=" + idMissingStatistics +
                ", disasterID='" + disasterID + '\'' +
                ", disasterDate='" + disasterDate + '\'' +
                ", location='" + location + '\'' +
                ", numberDeath=" + numberDeath +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
}
