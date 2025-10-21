package br.com.technosou.gestor.batism;

import java.util.Date;

public class BatismDTO {
    private String churchName;
    private String leaderName;
    private Date baptismDate;

    public BatismDTO() {}

    public BatismDTO(String churchName, String leaderName, Date baptismDate) {
        this.churchName = churchName;
        this.leaderName = leaderName;
        this.baptismDate = baptismDate;
    }

    public String getChurchName() { return churchName; }
    public void setChurchName(String churchName) { this.churchName = churchName; }
    public String getLeaderName() { return leaderName; }
    public void setLeaderName(String leaderName) { this.leaderName = leaderName; }
    public Date getBaptismDate() { return baptismDate; }
    public void setBaptismDate(Date baptismDate) { this.baptismDate = baptismDate; }
}
