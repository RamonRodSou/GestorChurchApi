package br.com.technosou.gestor.group;

import br.com.technosou.gestor.enums.WeekDays;
import br.com.technosou.gestor.member.adult.AdultSummaryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "groups")
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupSummaryDTO extends RepresentationModel<GroupSummaryDTO>  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    private List<AdultSummaryDTO> leaders;

    @Enumerated(EnumType.STRING)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private WeekDays weekDay;

    private boolean isActive = true;

    public GroupSummaryDTO() {}

    public GroupSummaryDTO(Long id, String name, List<AdultSummaryDTO> leaders, WeekDays weekDay, boolean isActive) {
        this.id = id;
        this.leaders = leaders;
        this.name = name;
        this.weekDay = weekDay;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AdultSummaryDTO> getLeaders() {
        return leaders;
    }

    public void setLeaders(List<AdultSummaryDTO> leaders) {
        this.leaders = leaders;
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


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
