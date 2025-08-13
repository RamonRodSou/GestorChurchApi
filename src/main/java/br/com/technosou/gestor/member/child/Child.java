package br.com.technosou.gestor.member.child;

import br.com.technosou.gestor.batism.Batism;
import br.com.technosou.gestor.enums.AgeGroup;
import br.com.technosou.gestor.enums.ChildRole;
import br.com.technosou.gestor.member.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import br.com.technosou.gestor.member.adult.Adult;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "children")
public class Child extends Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = true, length = 13)
    private String phone;

    private String groupId;

    @OneToOne(cascade = CascadeType.ALL)
    private Batism batism;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "child_parents",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<Adult> parents;

    private ChildRole role;
    public AgeGroup ageGroup;

    @Column(nullable = true, length = 300)
    public String medication;

    @Column(nullable = true, length = 300)
    public String specialNeed;

    @Column(nullable = true, length = 300)
    public String allergy;

    private boolean isImageAuthorized = true;
    private boolean isActive = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Child() {
        super();
    }


}