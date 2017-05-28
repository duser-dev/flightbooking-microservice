
package com.cgi.microservices.league.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team1 {

    @SerializedName("TeamId")
    @Expose
    private Integer teamId;
    @SerializedName("TeamName")
    @Expose
    private String teamName;
    @SerializedName("ShortName")
    @Expose
    private String shortName;
    @SerializedName("TeamIconUrl")
    @Expose
    private String teamIconUrl;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTeamIconUrl() {
        return teamIconUrl;
    }

    public void setTeamIconUrl(String teamIconUrl) {
        this.teamIconUrl = teamIconUrl;
    }

}
