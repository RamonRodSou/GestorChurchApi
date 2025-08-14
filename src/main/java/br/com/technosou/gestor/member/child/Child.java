package br.com.technosou.gestor.member.child;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.AgeGroup;
import br.com.technosou.gestor.enums.ChildRole;
import br.com.technosou.gestor.member.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import br.com.technosou.gestor.member.adult.Adult;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "children")
public class Child extends Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = true, length = 13)
    private String phone;

    private String groupId;

    @Embedded
    private Batism batism;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "child_parents",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<Adult> parents;

    @Enumerated(EnumType.STRING)
    @Column(name = "child_role", nullable = false)
    private ChildRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_group", nullable = false)
    public AgeGroup ageGroup;

    @Column(nullable = true, length = 300)
    public String medication;

    @Column(nullable = true, length = 300)
    public String specialNeed;

    @Column(nullable = true, length = 300)
    public String allergy;

    private boolean isImageAuthorized = true;
    private boolean isActive = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Child() {
        super();
    }

    public Child(Long id, String firstName, String lastName, Date birthdate, String gender, String email, String phone, String groupId, String phone1, String groupId1, Batism batism, List<Adult> parents, ChildRole role, AgeGroup ageGroup, String medication, String specialNeed, String allergy, boolean isImageAuthorized, boolean isActive, LocalDateTime createdAt) {
        super(id, firstName, lastName, birthdate, gender, email, phone, groupId);
        this.phone = phone1;
        this.groupId = groupId1;
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
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Batism getBatism() {
        return batism;
    }

    public void setBatism(Batism batism) {
        this.batism = batism;
    }

    public List<Adult> getParents() {
        return parents;
    }

    public void setParents(List<Adult> parents) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return isImageAuthorized == child.isImageAuthorized && isActive == child.isActive && Objects.equals(phone, child.phone) && Objects.equals(groupId, child.groupId) && Objects.equals(batism, child.batism) && Objects.equals(parents, child.parents) && role == child.role && ageGroup == child.ageGroup && Objects.equals(medication, child.medication) && Objects.equals(specialNeed, child.specialNeed) && Objects.equals(allergy, child.allergy) && Objects.equals(createdAt, child.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, groupId, batism, parents, role, ageGroup, medication, specialNeed, allergy, isImageAuthorized, isActive, createdAt);
    }
}