package br.com.technosou.gestor.guest;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(length = 13)
    private String phone;

    @JdbcTypeCode(SqlTypes.JSON)
    public List<String> visitHistory = new ArrayList<String>();

    private boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Guest() { }

    public Guest(Long id, String name, String phone, List<String> visitHistory, boolean isActive, LocalDateTime createdAt) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public static Guest guestUpdate(GuestDTO dto, Guest entity) {
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setVisitHistory(dto.getVisitHistory());
        entity.setActive(dto.isActive());
        return entity;
    }
}

