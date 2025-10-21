package br.com.technosou.gestor.group;

import br.com.technosou.gestor.enums.WeekDays;
import br.com.technosou.gestor.location.Location;
import br.com.technosou.gestor.location.LocationDTO;
import br.com.technosou.gestor.member.adult.Adult;
import br.com.technosou.gestor.member.adult.AdultSummaryDTO;
import br.com.technosou.gestor.member.child.Child;
import br.com.technosou.gestor.member.child.ChildSummaryDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cell_groups")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "week_day", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private WeekDays weekDay;

    @Embedded
    private Location location;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_leaders",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "adult_leader_id")
    )
    private List<Adult> leaders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_members",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "adult_member_id")
    )
    private List<Adult> members;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_children",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<Child> children;

    @Column(nullable = false)
    private boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Group() {}

    public Group(Long id, String name, WeekDays weekDay, Location location, List<Adult> leaders, List<Adult> members, List<Child> children, boolean isActive, LocalDateTime createdAt) {
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

    public List<Adult> getLeaders() {
        return leaders;
    }

    public void setLeaders(List<Adult> adults) {
        this.leaders = leaders;
    }

    public List<Adult> getMembers() {
        return members;
    }

    public void setMembers(List<Adult> members) {
        this.members = members;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
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

    public static Group groupUpdate(GroupDTO dto, Group entity) {
        entity.setName(dto.getName());
        entity.setWeekDay(dto.getWeekDay());
        entity.setLocation(dto.getLocation());
        entity.setActive(dto.isActive());

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

        if (entity.getLeaders() != null) {
            var leaders = entity.getLeaders().stream()
                    .map(it -> new AdultSummaryDTO(
                            it.getId()
                    ))
                    .toList();
        }

        if (entity.getChildren() != null) {
            var members = entity.getChildren().stream()
                    .map(it -> new AdultSummaryDTO(
                            it.getId()
                    ))
                    .toList();
        }

        if (entity.getChildren() != null) {
            var children = entity.getChildren().stream()
                    .map(it -> new ChildSummaryDTO(
                            it.getId()
                    ))
                    .toList();
        }
        return entity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return isActive == group.isActive && Objects.equals(id, group.id) && Objects.equals(name, group.name) && weekDay == group.weekDay && Objects.equals(location, group.location) && Objects.equals(leaders, group.leaders) && Objects.equals(members, group.members) && Objects.equals(children, group.children) && Objects.equals(createdAt, group.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weekDay, location, leaders, members, children, isActive, createdAt);
    }

    @Override
    public String toString() {
        return "Group{" +
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
