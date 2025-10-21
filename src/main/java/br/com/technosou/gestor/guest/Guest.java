package br.com.technosou.gestor.guest;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(length = 13)
    private String phone;

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

    public static Guest guestUpdate(GuestDTO dto, Guest entity) {
        entity.setNome(dto.getNome());
        entity.setPhone(dto.getPhone());
        entity.setVisitHistory(dto.getVisitHistory());
        entity.setActive(dto.isActive());
        return entity;
    }
}

