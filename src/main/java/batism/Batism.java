package batism;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Batism {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
