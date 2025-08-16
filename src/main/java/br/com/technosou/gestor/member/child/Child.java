package br.com.technosou.gestor.member.child;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.AgeGroup;
import br.com.technosou.gestor.enums.ChildRole;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.group.Group;
import br.com.technosou.gestor.member.Member;
import br.com.technosou.gestor.member.adult.AdultSummaryDTO;
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

    @Embedded
    private Batism batism;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER)
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

    public Child() {
        super();
    }

    public Child(Long id, String firstName, String lastName, Date birthdate, Gender gender, String email, String phone, Group group, Batism batism, boolean isImageAuthorized, boolean isActive, LocalDateTime createdAt, Batism batism1, List<Adult> parents, ChildRole role, AgeGroup ageGroup, String medication, String specialNeed, String allergy) {
        super(id, firstName, lastName, birthdate, gender, email, phone, group, batism, isImageAuthorized, isActive, createdAt);
        this.batism = batism1;
        this.parents = parents;
        this.role = role;
        this.ageGroup = ageGroup;
        this.medication = medication;
        this.specialNeed = specialNeed;
        this.allergy = allergy;
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

    public static Child childUpdate(ChildDTO dto, Child entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthdate(dto.getBirthdate());
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setRole(dto.getRole());
        entity.setAgeGroup(dto.getAgeGroup());
        entity.setMedication(dto.getMedication());
        entity.setSpecialNeed(dto.getSpecialNeed());
        entity.setAllergy(dto.getAllergy());

        if (entity.getParents() != null) {
            var parent = entity.getParents().stream()
                    .map(it -> new AdultSummaryDTO(
                            it.getId(),
                            it.getFirstName(),
                            it.getLastName(),
                            it.getBirthdate(),
                            it.getEmail(),
                            it.getPhone()
                    ))
                    .toList();
        }

        return entity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(batism, child.batism) && Objects.equals(parents, child.parents) && role == child.role && ageGroup == child.ageGroup && Objects.equals(medication, child.medication) && Objects.equals(specialNeed, child.specialNeed) && Objects.equals(allergy, child.allergy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batism, parents, role, ageGroup, medication, specialNeed, allergy);
    }

    @Override
    public String toString() {
        return "Child{" +
                "batism=" + batism +
                ", parents=" + parents +
                ", role=" + role +
                ", ageGroup=" + ageGroup +
                ", medication='" + medication + '\'' +
                ", specialNeed='" + specialNeed + '\'' +
                ", allergy='" + allergy + '\'' +
                '}';
    }
}
