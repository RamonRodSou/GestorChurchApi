package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.batism.BatismDTO;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.group.GroupSummaryDTO;
import br.com.technosou.gestor.location.LocationDTO;
import br.com.technosou.gestor.member.MemberDTO;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embedded;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "adults")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdultDTO extends MemberDTO<AdultDTO> implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cpf;

    @Embedded
    private LocationDTO location;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private CivilStatus civilStatus;

    private AdultSummaryDTO spouse;

    private List<ChildSummaryDTO> children;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Role role;

    public AdultDTO() {
        super();
    }

    public AdultDTO(Long id, String firstName, String lastName, Gender gender, Date birthdate, String email, String phone, GroupSummaryDTO group, BatismDTO batism, boolean isActive, boolean isImageAuthorized, LocalDateTime createdAt, String cpf, LocationDTO location, CivilStatus civilStatus, AdultSummaryDTO spouse, List<ChildSummaryDTO> children, Role role) {
        super(id, firstName, lastName, gender, birthdate, email, phone, group, batism, isActive, isImageAuthorized, createdAt);
        this.cpf = cpf;
        this.location = location;
        this.civilStatus = civilStatus;
        this.spouse = spouse;
        this.children = children;
        this.role = role;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
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
}