package br.com.technosou.gestor.group;

import br.com.technosou.gestor.enums.WeekDays;
import br.com.technosou.gestor.location.Location;
import br.com.technosou.gestor.location.LocationDTO;
import br.com.technosou.gestor.member.adult.AdultSummaryDTO;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement(name = "groups")
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupDTO extends RepresentationModel<GroupDTO>  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @Enumerated(EnumType.STRING)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private WeekDays weekDay;

    @Embedded
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Location location;

    private List<AdultSummaryDTO> leaders;

    private List<AdultSummaryDTO> members;

    private List<ChildSummaryDTO> children;

    private boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public GroupDTO() {}

    public GroupDTO(Long id, String name, WeekDays weekDay, Location location, List<AdultSummaryDTO> leaders, List<AdultSummaryDTO> members, List<ChildSummaryDTO> children, boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.weekDay = weekDay;
        this.location = location;
        this.leaders = leaders;
        this.members = members;
        this.children = children;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeekDays getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDays weekDay) {
        this.weekDay = weekDay;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<AdultSummaryDTO> getLeaders() {
        return leaders;
    }

    public void setLeaders(List<AdultSummaryDTO> leaders) {
        this.leaders = leaders;
    }

    public List<AdultSummaryDTO> getMembers() {
        return members;
    }

    public void setMembers(List<AdultSummaryDTO> members) {
        this.members = members;
    }

    public List<ChildSummaryDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ChildSummaryDTO> children) {
        this.children = children;
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
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weekDay=" + weekDay +
                ", location=" + location +
                ", leaders=" + leaders +
                ", members=" + members +
                ", children=" + children +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }
}
