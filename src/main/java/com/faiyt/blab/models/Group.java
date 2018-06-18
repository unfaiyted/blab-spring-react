package com.faiyt.blab.models;


import com.faiyt.blab.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    @ManyToMany
    private List<User> members;

    public Group(User owner, List<User> members) {
        this.owner = owner;
        this.members = members;
    }
}
