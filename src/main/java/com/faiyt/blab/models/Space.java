package com.faiyt.blab.models;


import com.faiyt.blab.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private User owner;

    private LocalDate createdDate = LocalDate.now();

    public Space() {}

    public Space(String name) {
        this.name = name;
    }

    public Space(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }
}
