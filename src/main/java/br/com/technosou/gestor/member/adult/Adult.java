package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.member.Member;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import br.com.technosou.gestor.member.child.Child;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "adults")
public class Adult extends Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 11)
    private String cpf;

    private String groupId;

    @Column(nullable = false, length = 500)
    private String zipCode;

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 50)
    private String houseNumber;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(nullable = false, length = 100)
    private String neighborhood;

    @Embedded
    private Batism batism;

    @Enumerated(EnumType.STRING)
    @Column(name = "civil_status", nullable = false)
    private CivilStatus civilStatus;

//    @Column(name = "spouse_id", nullable = true, length = 100)
//    private String spouseId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Adult spouse;

    @ManyToMany(mappedBy = "parents", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Child> children;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Adult() {
        super();
    }

    public Adult(Long id, String firstName, String lastName, Date birthdate, String gender, String email, String phone, String groupId, String cpf, String groupId1, String zipCode, String street, String houseNumber, String city, String state, String neighborhood, Batism batism, CivilStatus civilStatus, Adult spouse, List<Child> children, Role role, boolean isActive, boolean isImageAuthorized, LocalDateTime createdAt) {
        super(id, firstName, lastName, birthdate, gender, email, phone, groupId);
        this.cpf = cpf;
        this.groupId = groupId1;
        this.zipCode = zipCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.batism = batism;
        this.civilStatus = civilStatus;
        this.spouse = spouse;
        this.children = children;
        this.role = role;
        this.isActive = isActive;
        this.isImageAuthorized = isImageAuthorized;
        this.createdAt = createdAt;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Batism getBatism() {
        return batism;
    }

    public void setBatism(Batism batism) {
        this.batism = batism;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

//    public String getSpouseId() { return spouseId; }
//
//    public void setSpouseId(String spouseId) { this.spouseId = spouseId; }


    public Adult getSpouse() {
        return spouse;
    }

    public void setSpouse(Adult spouse) {
        this.spouse = spouse;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Adult AdultUpdate(AdultDTO dto, Adult entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthdate(dto.getBirthdate());
        entity.setGender(dto.getGender());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setGroupId(dto.getGroupId());
        entity.setZipCode(dto.getZipCode());
        entity.setStreet(dto.getStreet());
        entity.setHouseNumber(dto.getHouseNumber());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setNeighborhood(dto.getNeighborhood());
//        entity.setBatism(dto.getBatism());
        entity.setCivilStatus(dto.getCivilStatus());
//        entity.spouse(dto.getSpouseId());
//        entity.setChildren(dto.getChildrenIds());
        entity.setRole(dto.getRole());
        entity.setImageAuthorized(dto.isImageAuthorized());
        entity.setActive(dto.isActive());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}

