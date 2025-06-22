package user.child;

import batism.Batism;
import enums.AgeGroup;
import enums.ChildRole;
import user.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Child extends User {

    private Long id;
    private String name;
    private Date birthdate;
    private String email;
    private String phone;
    private String groupId;
    private Batism batism;
    private List<MemberSummary> parents;
    private ChildRole role;
    public AgeGroup ageGroup;
    public String medication;
    public String specialNeed;
    public String allergy;
    private boolean isImageAuthorized = true;
    private  boolean isActive = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String password;
    public Child() { }


}
