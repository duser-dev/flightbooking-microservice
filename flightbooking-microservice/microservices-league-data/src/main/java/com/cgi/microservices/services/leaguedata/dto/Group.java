
package com.cgi.microservices.services.leaguedata.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("GroupName")
    @Expose
    private String groupName;
    @SerializedName("GroupOrderID")
    @Expose
    private Integer groupOrderID;
    @SerializedName("GroupID")
    @Expose
    private Integer groupID;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupOrderID() {
        return groupOrderID;
    }

    public void setGroupOrderID(Integer groupOrderID) {
        this.groupOrderID = groupOrderID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

}
