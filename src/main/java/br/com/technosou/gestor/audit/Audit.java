package br.com.technosou.gestor.audit;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audits")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String action;
    private String classRef;
    private String userId;
    private boolean isActive = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Audit() { }

    public Audit(Long id, String action, String classRef, String userId, boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.action = action;
        this.classRef = classRef;
        this.userId = userId;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getClassRef() {
        return classRef;
    }

    public void setClassRef(String classRef) {
        this.classRef = classRef;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
