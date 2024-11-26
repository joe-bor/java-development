package com.pluralsight.week9.jdbc.sakila;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Actor {
    private final int actorId;
    private final String firstName;
    private final String lastName;
    private LocalDateTime lastUpdate;

    @Override
    public String toString() {
        return """
                
                Actor
                -----------------
                actorId: %d
                firstName: %s
                lastName: %s
                
                """.formatted(this.getActorId(), this.getFirstName(), this.lastName);
    }
}
