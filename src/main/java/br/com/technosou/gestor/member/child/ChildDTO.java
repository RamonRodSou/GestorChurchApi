package br.com.technosou.gestor.member.child;

import br.com.technosou.gestor.batism.BatismDTO;
import br.com.technosou.gestor.enums.AgeGroup;
import br.com.technosou.gestor.enums.ChildRole;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.group.GroupSummaryDTO;
import br.com.technosou.gestor.member.MemberDTO;
import br.com.technosou.gestor.member.adult.AdultSummaryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Enumerated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "children")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChildDTO extends MemberDTO<ChildDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AdultSummaryDTO> parents;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ChildRole role;

    @Enumerated
    private AgeGroup ageGroup;
    private String medication;
    private String specialNeed;
    private String allergy;

    public ChildDTO() {}

    public ChildDTO(Long id, String firstName, String lastName, Gender gender, Date birthdate, String email, String phone, GroupSummaryDTO group, BatismDTO batism, boolean isActive, boolean isImageAuthorized, LocalDateTime createdAt, List<AdultSummaryDTO> parents, ChildRole role, AgeGroup ageGroup, String medication, String specialNeed, String allergy) {
        super(id, firstName, lastName, gender, birthdate, email, phone, group, batism, isActive, isImageAuthorized, createdAt);
        this.parents = parents;
        this.role = role;
        this.ageGroup = ageGroup;
        this.medication = medication;
        this.specialNeed = specialNeed;
        this.allergy = allergy;
    }

    public List<AdultSummaryDTO> getParents() {
        return parents;
    }

    public void setParents(List<AdultSummaryDTO> parents) {
        this.parents = parents;
    }

    public ChildRole getRole() {
        return role;
    }

    public void setRole(ChildRole role) {
        this.role = role;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getSpecialNeed() {
        return specialNeed;
    }

    public void setSpecialNeed(String specialNeed) {
        this.specialNeed = specialNeed;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
