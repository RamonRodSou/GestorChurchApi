package user.member;

import batism.Batism;
import enums.CivilStatus;
import enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import user.child.ChildSummary;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class NewMemberDTO {

    private String name;

    @NotBlank
    private Date birthdate;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;
    private String groupId;

    @NotBlank
    private String street;

    @NotBlank
    private String houseNumber;

    @NotBlank
    private String city;

    @NotEmpty
    @Size(min = 2, max = 3)
    private String state;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String neighborhood;
    private Batism batism;

    private CivilStatus civilStatus;
    //private MemberSummary spouse;
    private List<ChildSummary> children;
    private Role role;
    private  boolean isActive = true;
    private boolean isImageAuthorized = true;
    private LocalDateTime createdAt = LocalDateTime.now();
}
