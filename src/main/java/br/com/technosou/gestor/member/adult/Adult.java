package br.com.technosou.gestor.member.adult;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.batism.BatismDTO;
import br.com.technosou.gestor.enums.CivilStatus;
import br.com.technosou.gestor.enums.Gender;
import br.com.technosou.gestor.enums.Role;
import br.com.technosou.gestor.group.Group;
import br.com.technosou.gestor.location.Location;
import br.com.technosou.gestor.location.LocationDTO;
import br.com.technosou.gestor.member.Member;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import br.com.technosou.gestor.member.child.Child;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adults")
public class Adult extends Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Embedded
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(name = "civil_status", nullable = false)
    private CivilStatus civilStatus;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Adult spouse;

    @ManyToMany(mappedBy = "parents", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Child> children;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public Adult() {
        super();
    }

    public Adult(Long id, String firstName, String lastName, Date birthdate, Gender gender, String email, String phone, Group group, Batism batism, boolean isImageAuthorized, boolean isActive, LocalDateTime createdAt, String cpf, Location location, CivilStatus civilStatus, Adult spouse, List<Child> children, Role role) {
        super(id, firstName, lastName, birthdate, gender, email, phone, group, batism, isImageAuthorized, isActive, createdAt);
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public static Adult adultUpdate(AdultDTO dto, Adult entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthdate(dto.getBirthdate());
        entity.setGender(dto.getGender());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setCivilStatus(dto.getCivilStatus());
        entity.setRole(dto.getRole());
        entity.setImageAuthorized(dto.isImageAuthorized());
        entity.setActive(dto.isActive());
        entity.setCreatedAt(dto.getCreatedAt());

        if (entity.getSpouse() != null) {
            var spouse = new AdultSummaryDTO(
                    entity.getSpouse().getId(),
                    entity.getSpouse().getFirstName(),
                    entity.getSpouse().getLastName(),
                    entity.getSpouse().getBirthdate(),
                    entity.getSpouse().getEmail(),
                    entity.getSpouse().getPhone()
            );
        }

        if (entity.getChildren() != null) {
           var children = entity.getChildren().stream()
                    .map(it -> new ChildSummaryDTO(
                            it.getId(),
                            it.getFirstName(),
                            it.getLastName(),
                            it.getPhone()
                    ))
                    .toList();
        }

        if (entity.getBatism() != null) {
            var batism = new BatismDTO(
                    entity.getBatism().getChurchName(),
                    entity.getBatism().getLeaderName(),
                    entity.getBatism().getBaptismDate()
            );
        };

        if (entity.getLocation() != null) {
           var location = new LocationDTO(
                    entity.getLocation().getZipCode(),
                    entity.getLocation().getStreet(),
                    entity.getLocation().getHouseNumber(),
                    entity.getLocation().getCity(),
                    entity.getLocation().getState(),
                    entity.getLocation().getNeighborhood()
            );
        }
        return entity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Adult adult = (Adult) o;
        return Objects.equals(cpf, adult.cpf) && Objects.equals(location, adult.location) && civilStatus == adult.civilStatus && Objects.equals(spouse, adult.spouse) && Objects.equals(children, adult.children) && role == adult.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, location, civilStatus, spouse, children, role);
    }

    @Override
    public String toString() {
        return "Adult{" +
                "cpf='" + cpf + '\'' +
                ", location=" + location +
                ", civilStatus=" + civilStatus +
                ", spouse=" + spouse +
                ", children=" + children +
                ", role=" + role +
                '}';
    }
}

