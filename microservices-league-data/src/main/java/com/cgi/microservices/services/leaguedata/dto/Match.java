
package com.cgi.microservices.services.leaguedata.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("MatchID")
    @Expose
    private Integer matchID;
    @SerializedName("MatchDateTime")
    @Expose
    private String matchDateTime;
    @SerializedName("TimeZoneID")
    @Expose
    private String timeZoneID;
    @SerializedName("LeagueId")
    @Expose
    private Integer leagueId;
    @SerializedName("MatchDateTimeUTC")
    @Expose
    private String matchDateTimeUTC;
    @SerializedName("Group")
    @Expose
    private Group group;
    @SerializedName("Team1")
    @Expose
    private Team1 team1;
    @SerializedName("Team2")
    @Expose
    private Team2 team2;
    @SerializedName("LastUpdateDateTime")
    @Expose
    private String lastUpdateDateTime;
    @SerializedName("MatchIsFinished")
    @Expose
    private Boolean matchIsFinished;
    @SerializedName("MatchResults")
    @Expose
    private List<MatchResult> matchResults = null;
    @SerializedName("Goals")
    @Expose
    private List<Goal> goals = null;
    @SerializedName("Location")
    @Expose
    private Location location;
    @SerializedName("NumberOfViewers")
    @Expose
    private Integer numberOfViewers;

    public Integer getMatchID() {
        return matchID;
    }

    public void setMatchID(Integer matchID) {
        this.matchID = matchID;
    }

    public String getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(String matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    public String getTimeZoneID() {
        return timeZoneID;
    }

    public void setTimeZoneID(String timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getMatchDateTimeUTC() {
        return matchDateTimeUTC;
    }

    public void setMatchDateTimeUTC(String matchDateTimeUTC) {
        this.matchDateTimeUTC = matchDateTimeUTC;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Team1 getTeam1() {
        return team1;
    }

    public void setTeam1(Team1 team1) {
        this.team1 = team1;
    }

    public Team2 getTeam2() {
        return team2;
    }

    public void setTeam2(Team2 team2) {
        this.team2 = team2;
    }

    public String getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(String lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public Boolean getMatchIsFinished() {
        return matchIsFinished;
    }

    public void setMatchIsFinished(Boolean matchIsFinished) {
        this.matchIsFinished = matchIsFinished;
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(List<MatchResult> matchResults) {
        this.matchResults = matchResults;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(Integer numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }

}
