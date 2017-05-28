
package com.cgi.microservices.league.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goal {

    @SerializedName("GoalID")
    @Expose
    private Integer goalID;
    @SerializedName("ScoreTeam1")
    @Expose
    private Integer scoreTeam1;
    @SerializedName("ScoreTeam2")
    @Expose
    private Integer scoreTeam2;
    @SerializedName("MatchMinute")
    @Expose
    private Integer matchMinute;
    @SerializedName("GoalGetterID")
    @Expose
    private Integer goalGetterID;
    @SerializedName("GoalGetterName")
    @Expose
    private String goalGetterName;
    @SerializedName("IsPenalty")
    @Expose
    private Boolean isPenalty;
    @SerializedName("IsOwnGoal")
    @Expose
    private Boolean isOwnGoal;
    @SerializedName("IsOvertime")
    @Expose
    private Boolean isOvertime;
    @SerializedName("Comment")
    @Expose
    private String comment;

    public Integer getGoalID() {
        return goalID;
    }

    public void setGoalID(Integer goalID) {
        this.goalID = goalID;
    }

    public Integer getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(Integer scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public Integer getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(Integer scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public Integer getMatchMinute() {
        return matchMinute;
    }

    public void setMatchMinute(Integer matchMinute) {
        this.matchMinute = matchMinute;
    }

    public Integer getGoalGetterID() {
        return goalGetterID;
    }

    public void setGoalGetterID(Integer goalGetterID) {
        this.goalGetterID = goalGetterID;
    }

    public String getGoalGetterName() {
        return goalGetterName;
    }

    public void setGoalGetterName(String goalGetterName) {
        this.goalGetterName = goalGetterName;
    }

    public Boolean getIsPenalty() {
        return isPenalty;
    }

    public void setIsPenalty(Boolean isPenalty) {
        this.isPenalty = isPenalty;
    }

    public Boolean getIsOwnGoal() {
        return isOwnGoal;
    }

    public void setIsOwnGoal(Boolean isOwnGoal) {
        this.isOwnGoal = isOwnGoal;
    }

    public Boolean getIsOvertime() {
        return isOvertime;
    }

    public void setIsOvertime(Boolean isOvertime) {
        this.isOvertime = isOvertime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
