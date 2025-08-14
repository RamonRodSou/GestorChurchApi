package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.serializer.GenderSerializer;
import br.com.technosou.gestor.member.child.Child;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Embedded;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdultDTO extends RepresentationModel<AdultDTO> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phone;

    private String groupId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String zipCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String street;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String houseNumber;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String city;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String state;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String neighborhood;

    @Embedded
    private Batism batism;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private CivilStatus civilStatus;

    private Adult spouse;

    private List<Child> children;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Role role;

    private boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AdultDTO AdultDTO = (AdultDTO) o;
        return isActive == AdultDTO.isActive && isImageAuthorized == AdultDTO.isImageAuthorized && Objects.equals(id, AdultDTO.id) && Objects.equals(firstName, AdultDTO.firstName) && Objects.equals(lastName, AdultDTO.lastName) && Objects.equals(gender, AdultDTO.gender) && Objects.equals(birthdate, AdultDTO.birthdate) && Objects.equals(cpf, AdultDTO.cpf) && Objects.equals(email, AdultDTO.email) && Objects.equals(phone, AdultDTO.phone) && Objects.equals(groupId, AdultDTO.groupId) && Objects.equals(zipCode, AdultDTO.zipCode) && Objects.equals(street, AdultDTO.street) && Objects.equals(houseNumber, AdultDTO.houseNumber) && Objects.equals(city, AdultDTO.city) && Objects.equals(state, AdultDTO.state) && Objects.equals(neighborhood, AdultDTO.neighborhood) && Objects.equals(batism, AdultDTO.batism) && civilStatus == AdultDTO.civilStatus && Objects.equals(spouse, AdultDTO.spouse) && Objects.equals(children, AdultDTO.children) && role == AdultDTO.role && Objects.equals(createdAt, AdultDTO.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, birthdate, cpf, email, phone, groupId, zipCode, street, houseNumber, city, state, neighborhood, batism, civilStatus, spouse, children, role, isActive, isImageAuthorized, createdAt);
    }

}
