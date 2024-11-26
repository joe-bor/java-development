package com.pluralsight.week9.jdbc.sakila;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Film {
    private final int filmId;
    private final String title;
    private final String description;
    private final int releaseYear;
    private final int lengthInMinutes;

    @Override
    public String toString(){
        return """
                
                Film
                ---------------------------
                filmId: %d
                title: %s
                description: %s
                releaseYear: %d
                length: %d
                
                """.formatted(this.getFilmId(), this.getTitle(), this.getDescription(), this.getReleaseYear(), this.getLengthInMinutes());
    }
}
