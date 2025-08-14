package br.com.technosou.gestor.batism;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public class Batism {

    private String churchName;
    private boolean ourChurch = true;
    public String leaderName;
    public Date baptismDate;

    public Batism() { }

    public Batism(String churchName, boolean ourChurch, String leaderName, Date baptismDate) {
        this.churchName = churchName;
        this.ourChurch = ourChurch;
        this.leaderName = leaderName;
        this.baptismDate = baptismDate;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public boolean isOurChurch() {
        return ourChurch;
    }

    public void setOurChurch(boolean ourChurch) {
        this.ourChurch = ourChurch;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Date getBaptismDate() {
        return baptismDate;
    }

    public void setBaptismDate(Date baptismDate) {
        this.baptismDate = baptismDate;
    }
}
