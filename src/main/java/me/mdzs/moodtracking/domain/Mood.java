package me.mdzs.moodtracking.domain;

import java.util.Date;
import java.time.LocalTime;
import java.time.LocalDate;

public class Mood {
    private String mood;
    private String description;//сделать отдельный класс который будет хранить оценку настроения
    private LocalDate date;
    private LocalTime time;

    public Mood(String mood, LocalDate date, LocalTime time) {
        this.mood = mood;
        this.description = "";
        this.date = date;
        this.time = time;
    }
    public String getMood() {
        return mood;
    }
    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
