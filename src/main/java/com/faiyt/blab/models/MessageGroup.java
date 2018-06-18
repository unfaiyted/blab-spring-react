package com.faiyt.blab.models;


import com.faiyt.blab.models.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class MessageGroup extends Message {

    @ManyToOne
    private Group sentTo;

    public MessageGroup(User sentBy, LocalDateTime createdAt, LocalDateTime sentAt, String message, Group sentTo) {
        super(sentBy, createdAt, sentAt, message);
        this.sentTo = sentTo;
    }
}
