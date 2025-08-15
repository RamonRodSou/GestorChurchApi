package br.com.technosou.gestor.member;

import br.com.technosou.gestor.group.Group;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private Date birthdate;

    @Column(nullable = false, length = 6)
    private String gender;

    @Column(length = 100)
    private String email;

    @Column(length = 13)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonManagedReference
    private Group group;

    @Column(nullable = false)
    private boolean isImageAuthorized = true;

    @Column(nullable = false)
    private boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Member() {}

    public Member(Long id, String firstName, String lastName, Date birthdate, String gender, String email, String phone, Group group, boolean isImageAuthorized, boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.group = group;
        this.isImageAuthorized = isImageAuthorized;
        this.isActive = isActive;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
        Member member = (Member) o;
        return isImageAuthorized == member.isImageAuthorized && isActive == member.isActive && Objects.equals(id, member.id) && Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(birthdate, member.birthdate) && Objects.equals(gender, member.gender) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone) && Objects.equals(group, member.group) && Objects.equals(createdAt, member.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthdate, gender, email, phone, group, isImageAuthorized, isActive, createdAt);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", group=" + group +
                ", isImageAuthorized=" + isImageAuthorized +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }
}
