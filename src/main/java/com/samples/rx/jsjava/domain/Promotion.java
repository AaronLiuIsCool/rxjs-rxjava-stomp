package com.samples.rx.jsjava.domain;

import java.time.LocalDateTime;

public class Promotion {
    private String name;
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;

    public Promotion(String name, LocalDateTime startsAt, LocalDateTime endsAt) {
        this.name = name;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }
}
