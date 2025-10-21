package br.com.technosou.gestor.guest;

import br.com.technosou.gestor.group.GroupDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "guests")
@XmlAccessorType(XmlAccessType.FIELD)
public class GuestDTO extends RepresentationModel<GroupDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    public List<String> visitHistory = new ArrayList<String>();

    private boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public GuestDTO() { }

    public GuestDTO(Long id, String name, String phone, List<String> visitHistory, boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.visitHistory = visitHistory;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getVisitHistory() {
        return visitHistory;
    }

    public void setVisitHistory(List<String> visitHistory) {
        this.visitHistory = visitHistory;
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
}

