package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.batism.BatismDTO;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.group.GroupSummaryDTO;
import br.com.technosou.gestor.location.LocationDTO;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import br.com.technosou.gestor.serializer.GenderSerializer;
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

@XmlRootElement(name = "adults")
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

    private GroupSummaryDTO group;

    @Embedded
    private LocationDTO location;

    @Embedded
    private BatismDTO batism;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private CivilStatus civilStatus;

    private AdultSummaryDTO spouse;

    private List<ChildSummaryDTO> children;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Role role;

    private boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public AdultDTO() {}

    public AdultDTO(Long id, String firstName, String lastName, String gender, Date birthdate, String cpf, String email, String phone, GroupSummaryDTO group, LocationDTO location, BatismDTO batism, CivilStatus civilStatus, AdultSummaryDTO spouse, List<ChildSummaryDTO> children, Role role, boolean isActive, boolean isImageAuthorized, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.group = group;
        this.location = location;
        this.batism = batism;
        this.civilStatus = civilStatus;
        this.spouse = spouse;
        this.children = children;
        this.role = role;
        this.isActive = isActive;
        this.isImageAuthorized = isImageAuthorized;
        this.createdAt = createdAt;
    }

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

    public GroupSummaryDTO getGroup() {
        return group;
    }

    public void setGroup(GroupSummaryDTO group) {
        this.group = group;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public BatismDTO getBatism() {
        return batism;
    }

    public void setBatism(BatismDTO batism) {
        this.batism = batism;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public AdultSummaryDTO getSpouse() {
        return spouse;
    }

    public void setSpouse(AdultSummaryDTO spouse) {
        this.spouse = spouse;
    }

    public List<ChildSummaryDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ChildSummaryDTO> children) {
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
