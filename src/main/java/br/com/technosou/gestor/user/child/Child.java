package br.com.technosou.gestor.user.child;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.AgeGroup;
import br.com.technosou.gestor.enums.ChildRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
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

    public Child() {
        super();
    }

    public Child(Long id, String name, String phone, String password, LocalDateTime createdAt, Long id1) {
        super(id, name, phone, password, createdAt);
        this.id = id1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Batism getBatism() {
        return batism;
    }

    public void setBatism(Batism batism) {
        this.batism = batism;
    }

    public List<Member> getParents() {
        return parents;
    }

    public void setParents(List<Member> parents) {
        this.parents = parents;
    }

    public ChildRole getRole() {
        return role;
    }

    public void setRole(ChildRole role) {
        this.role = role;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getSpecialNeed() {
        return specialNeed;
    }

    public void setSpecialNeed(String specialNeed) {
        this.specialNeed = specialNeed;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public boolean isImageAuthorized() {
        return isImageAuthorized;
    }

    public void setImageAuthorized(boolean imageAuthorized) {
        isImageAuthorized = imageAuthorized;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
