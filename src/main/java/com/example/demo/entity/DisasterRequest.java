package com.example.demo.entity;

public class DisasterRequest {
    private Integer idDisasterRequest=0;

    private String disasterID;

    private String disasterDate;

    private String disasterType;

    private Integer status;

    private String oURL;

    private String requestUnit;

    public DisasterRequest(Integer iddisasterrequest, String id, String disasterDate, String disasterType, Integer status, String oURL, String requestUnit) {
        this.idDisasterRequest = iddisasterrequest;
        this.disasterID = id;
        this.disasterDate = disasterDate;
        this.disasterType = disasterType;
        this.status = status;
        this.oURL = oURL;
        this.requestUnit = requestUnit;
    }

    public DisasterRequest() { super(); }


    public Integer getIdDisasterRequest() {
        return idDisasterRequest;
    }

    public void setIdDisasterRequest(Integer idDisasterRequest) {
        this.idDisasterRequest = idDisasterRequest;
    }


    public String getDisasterID() {
        return disasterID;
    }

    public void setDisasterID(String id) {
        this.disasterID = id == null ? null : id.trim();
    }



    public String getDisasterDate() {
        return disasterDate;
    }

    public void setDisasterDate(String disasterDate) {
        this.disasterDate = disasterDate == null ? null : disasterDate.trim();
    }



    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType == null ? null : disasterType.trim();
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    public String getoURL() {
        return oURL;
    }

    public void setoURL(String oURL) {
        this.oURL = oURL == null ? null : oURL.trim();
    }



    public String getRequestUnit() {
        return requestUnit;
    }

    public void setRequestUnit(String requestUnit) {
        this.requestUnit = requestUnit == null ? null : requestUnit.trim();
    }


    @Override
    public String toString(){
        return "自增id: " + idDisasterRequest + "," +
                "\n编码：" + disasterID + "," +
                "\n请求时间：" + disasterDate + ","+
                "\n类型： " + disasterType + "," +
                "\n状态： " + status + "," +
                "\n发送地址： " + oURL + "," +
                "\n请求单位： " + requestUnit;
    }

}
