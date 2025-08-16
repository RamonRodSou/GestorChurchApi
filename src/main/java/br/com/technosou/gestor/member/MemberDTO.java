package br.com.technosou.gestor.member;

import br.com.technosou.gestor.batism.BatismDTO;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.group.GroupSummaryDTO;
import br.com.technosou.gestor.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Embedded;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class MemberDTO<T extends RepresentationModel<T>> extends RepresentationModel<T> {

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonSerialize(using = GenderSerializer.class)
    private Gender gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;

    private String email;

    private String phone;

    private GroupSummaryDTO group;

    @Embedded
    private BatismDTO batism;

    private boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public MemberDTO() {}

    public MemberDTO(Long id, String firstName, String lastName, Gender gender, Date birthdate, String email, String phone, GroupSummaryDTO group, BatismDTO batism, boolean isActive, boolean isImageAuthorized, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.group = group;
        this.batism = batism;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public GroupSummaryDTO getGroup() {
        return group;
    }

    public void setGroup(GroupSummaryDTO group) {
        this.group = group;
    }

    public BatismDTO getBatism() {
        return batism;
    }

    public void setBatism(BatismDTO batism) {
        this.batism = batism;
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
