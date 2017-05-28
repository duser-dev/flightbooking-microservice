
package com.cgi.microservices.services.leaguedata.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchResult {

    @SerializedName("ResultID")
    @Expose
    private Integer resultID;
    @SerializedName("ResultName")
    @Expose
    private String resultName;
    @SerializedName("PointsTeam1")
    @Expose
    private Integer pointsTeam1;
    @SerializedName("PointsTeam2")
    @Expose
    private Integer pointsTeam2;
    @SerializedName("ResultOrderID")
    @Expose
    private Integer resultOrderID;
    @SerializedName("ResultTypeID")
    @Expose
    private Integer resultTypeID;
    @SerializedName("ResultDescription")
    @Expose
    private String resultDescription;

    public Integer getResultID() {
        return resultID;
    }

    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public Integer getPointsTeam1() {
        return pointsTeam1;
    }

    public void setPointsTeam1(Integer pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    public Integer getPointsTeam2() {
        return pointsTeam2;
    }

    public void setPointsTeam2(Integer pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    public Integer getResultOrderID() {
        return resultOrderID;
    }

    public void setResultOrderID(Integer resultOrderID) {
        this.resultOrderID = resultOrderID;
    }

    public Integer getResultTypeID() {
        return resultTypeID;
    }

    public void setResultTypeID(Integer resultTypeID) {
        this.resultTypeID = resultTypeID;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

}
