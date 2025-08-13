package br.com.technosou.gestor.batism;

import java.util.Date;

public class Batism {

    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
