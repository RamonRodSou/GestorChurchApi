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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isImageAuthorized() {
        return isImageAuthorized;
    }

    public void setImageAuthorized(boolean imageAuthorized) {
        isImageAuthorized = imageAuthorized;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getSpecialNeed() {
        return specialNeed;
    }

    public void setSpecialNeed(String specialNeed) {
        this.specialNeed = specialNeed;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public ChildRole getRole() {
        return role;
    }

    public void setRole(ChildRole role) {
        this.role = role;
    }

    public List<Member> getParents() {
        return parents;
    }

    public void setParents(List<Member> parents) {
        this.parents = parents;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
