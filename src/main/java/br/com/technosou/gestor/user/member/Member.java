package br.com.technosou.gestor.user.member;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import br.com.technosou.gestor.user.User;
import br.com.technosou.gestor.user.child.Child;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Member extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthdate;
    private String cpf;
    private String email;
    private String phone;
    private String groupId;
    private String street;
    private String houseNumber;
    private String city;
    private String state;
    private String zipCode;
    private String neighborhood;

    @OneToOne(cascade = CascadeType.ALL)
    private Batism batism;

    private CivilStatus civilStatus;

    @OneToOne
    @JoinColumn(name = "spouse_id")
    private Member spouse;

    @JsonManagedReference
    @ManyToMany(mappedBy = "parents")
    private List<Child> children;

    private Role role;
    private  boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Member() { }

    public Member(Long id, String name, String phone, String password, LocalDateTime createdAt, Long id1, String name1, Date birthdate, String cpf, String email, String phone1, String groupId, String street, String houseNumber, String city, String state, String zipCode, String neighborhood, Batism batism, CivilStatus civilStatus, List<Child> children, Role role, boolean isActive, boolean isImageAuthorized, LocalDateTime createdAt1) {
        super(id, name, phone, password, createdAt);
        this.id = id1;
        this.name = name1;
        this.birthdate = birthdate;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone1;
        this.groupId = groupId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
        this.batism = batism;
        this.civilStatus = civilStatus;
        this.spouse = spouse;
        this.children = children;
        this.role = role;
        this.isActive = isActive;
        this.isImageAuthorized = isImageAuthorized;
        this.createdAt = createdAt1;
    }

    public Member(Long id, String name, String email) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public Member getSpouse() {
        return spouse;
    }

    public void setSpouse(Member spouse) {
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
}
