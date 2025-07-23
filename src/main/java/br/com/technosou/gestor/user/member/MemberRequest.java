package br.com.technosou.gestor.user.member;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.user.child.Child;
import br.com.technosou.gestor.user.child.ChildSummary;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class MemberRequest {

    private String name;
    private Date birthdate;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String cpf;
    private String email;
    private String phone;
    private String groupId;
    private String street;
    private String houseNumber;
    private String city;
    @Size(min = 2, max = 3)
    private String state;
    private String zipCode;
    private String neighborhood;
    private Batism batism;

    private CivilStatus civilStatus;
    private MemberSummaryDTO spouse;
    private List<ChildSummary> children;
    private Role role;
    private  boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

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

    public MemberSummaryDTO getSpouse() {
        return spouse;
    }

    public void setSpouse(MemberSummaryDTO spouse) {
        this.spouse = spouse;
    }

    public List<ChildSummary> getChildren() {
        return children;
    }

    public void setChildren(List<ChildSummary> children) {
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

    public Member toEntity() {
        Member entity = new Member();
        entity.setName(name);
        entity.setBirthdate(birthdate);
        entity.setCpf(cpf);
        entity.setEmail(email);
        entity.setPhone(phone);
        entity.setGroupId(groupId);
        entity.setStreet(street);
        entity.setHouseNumber(houseNumber);
        entity.setCity(city);
        entity.setState(state);
        entity.setZipCode(zipCode);
        entity.setNeighborhood(neighborhood);
        entity.setBatism(batism);
        entity.setCivilStatus(civilStatus);
        entity.setSpouse(toSpouse());
        entity.setChildren(toChild());
        entity.setRole(role);
        entity.setCreatedAt(createdAt);
        return entity;
    }

    private Member toSpouse() {
        if (spouse != null) {
            Member member = new Member(
                    spouse.getId(),
                    spouse.getName(),
                    spouse.getEmail()
            );
            return member;
        }
        return null;
    }

    private List<Child> toChild() {
        if(children == null) return null;
        return children.stream()
                .map(childSummary -> {
                    Child child = new Child();
                    child.setId(childSummary.getId());
                    child.setName(childSummary.getName());
                    child.setPhone(childSummary.getPhone());
                    return child;
                })
                .toList();
    }

}

