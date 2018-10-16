
package com.cgi.microservices.services.leaguedata.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("LocationID")
    @Expose
    private Integer locationID;
    @SerializedName("LocationCity")
    @Expose
    private String locationCity;
    @SerializedName("LocationStadium")
    @Expose
    private String locationStadium;

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationStadium() {
        return locationStadium;
    }

    public void setLocationStadium(String locationStadium) {
        this.locationStadium = locationStadium;
    }

}
