package user.member;

import batism.Batism;
import enums.CivilStatus;
import enums.Role;
import user.child.ChildSummary;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class MemberResponse {
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
    private Batism batism;
    private CivilStatus civilStatus;
    //private MemberSummary spouse;
    private List<ChildSummary> children;
    private Role role;
    private boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Role getRole() {
        return role;
    }

    public List<ChildSummary> getChildren() {
        return children;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public Batism getBatism() {
        return batism;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setBatism(Batism batism) {
        this.batism = batism;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public void setChildren(List<ChildSummary> children) {
        this.children = children;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setImageAuthorized(boolean imageAuthorized) {
        isImageAuthorized = imageAuthorized;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public MemberRequest toDto() {
        MemberRequest dto = new MemberRequest();
        dto.setName(getName());
        dto.setBirthdate(getBirthdate());
        dto.setCpf(getCpf());
        dto.setEmail(getEmail());
        dto.setPhone(getPhone());
        dto.setGroupId(getGroupId());
        dto.setStreet(getStreet());
        dto.setHouseNumber(getHouseNumber());
        dto.setCity(getCity());
        dto.setState(getState());
        dto.setZipCode(getZipCode());
        dto.setNeighborhood(getNeighborhood());
        dto.setBatism(getBatism());
        dto.setCivilStatus(getCivilStatus());
        dto.setChildren(getChildren());
        dto.setRole(getRole());
        dto.setCreatedAt(getCreatedAt());
        return dto;
    }

    public MemberRequest toSummaryDTO() {
        MemberRequest dto = new MemberRequest();
        dto.setName(getName());
        dto.setEmail(getEmail());
        return dto;
    }
}
