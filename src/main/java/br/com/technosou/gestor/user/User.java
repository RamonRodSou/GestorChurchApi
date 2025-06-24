package br.com.technosou.gestor.user;

import java.time.LocalDateTime;

public abstract class User {

    private Long id;
    private String name;
    private String phone;
    private String password;
    private LocalDateTime createdAt;

    public User() { }

    public User(Long id, String name, String phone, String password, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.createdAt = createdAt;
    }
}

