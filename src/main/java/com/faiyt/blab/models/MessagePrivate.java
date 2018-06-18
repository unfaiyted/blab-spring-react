package com.faiyt.blab.models;

import com.faiyt.blab.models.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Data
@Entity
public class MessagePrivate extends Message {

    @ManyToOne
    private User sentTo;

    public MessagePrivate(User sentBy, LocalDateTime createdAt, LocalDateTime sentAt, String message, User sentTo) {
        super(sentBy, createdAt, sentAt, message);
        this.sentTo = sentTo;
    }
}
