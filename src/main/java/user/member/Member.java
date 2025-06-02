package user.member;

import batism.Batism;
import enums.CivilStatus;
import enums.Role;
import jakarta.persistence.*;
import user.User;
import user.child.ChildSummary;

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

    //private MemberSummary spouse;

    private List<ChildSummary> children;
    private Role role;
    private  boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Member() { }

    public Member(Long id, String name, String phone, String password, LocalDateTime createdAt, Long id1, String name1, Date birthdate, String cpf, String email, String phone1, String groupId, String street, String houseNumber, String city, String state, String zipCode, String neighborhood, Batism batism, CivilStatus civilStatus, MemberSummary spouse, List<ChildSummary> children, Role role, boolean isActive, boolean isImageAuthorized, LocalDateTime createdAt1) {
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
        //this.spouse = spouse;
        this.children = children;
        this.role = role;
        this.isActive = isActive;
        this.isImageAuthorized = isImageAuthorized;
        this.createdAt = createdAt1;
    }
}
