package br.com.technosou.gestor.user.child;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.AgeGroup;
import br.com.technosou.gestor.enums.ChildRole;
import jakarta.persistence.*;
import br.com.technosou.gestor.user.User;
import br.com.technosou.gestor.user.member.Member;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Child extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthdate;
    private String email;
    private String phone;
    private String groupId;

    @OneToOne(cascade = CascadeType.ALL)
    private Batism batism;

    @ManyToMany
    @JoinTable(
            name = "child_parents",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<Member> parents;
    private ChildRole role;
    public AgeGroup ageGroup;
    public String medication;
    public String specialNeed;
    public String allergy;
    private boolean isImageAuthorized = true;
    private  boolean isActive = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String password;

    public Batism getBatism() {
        return batism;
    }

    public void setBatism(Batism batism) {
        this.batism = batism;
    }

    public Child() { }

    public Child(Long id, String name, Date birthdate, String email, String phone, String groupId, Batism batism, List<Member> parents, ChildRole role, AgeGroup ageGroup, String medication, String specialNeed, String allergy, boolean isImageAuthorized, boolean isActive, LocalDateTime createdAt, String password) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.groupId = groupId;
        this.batism = batism;
        this.parents = parents;
        this.role = role;
        this.ageGroup = ageGroup;
        this.medication = medication;
        this.specialNeed = specialNeed;
        this.allergy = allergy;
        this.isImageAuthorized = isImageAuthorized;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.password = password;
    }

    public Child(Long id, String name, String phone, String password, LocalDateTime createdAt, Long id1, String name1, Date birthdate, String email, String phone1, String groupId, Batism batism, List<Member> parents, ChildRole role, AgeGroup ageGroup, String medication, String specialNeed, String allergy, boolean isImageAuthorized, boolean isActive, LocalDateTime createdAt1, String password1) {
        super(id, name, phone, password, createdAt);
        this.id = id1;
        this.name = name1;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone1;
        this.groupId = groupId;
        this.batism = batism;
        this.parents = parents;
        this.role = role;
        this.ageGroup = ageGroup;
        this.medication = medication;
        this.specialNeed = specialNeed;
        this.allergy = allergy;
        this.isImageAuthorized = isImageAuthorized;
        this.isActive = isActive;
        this.createdAt = createdAt1;
        this.password = password1;
    }
}
