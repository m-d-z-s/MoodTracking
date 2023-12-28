package me.mdzs.moodtracking.domain;

import java.time.LocalTime;
import java.time.LocalDate;

public class Tracker {
    public final int markOfMood;//оценка настроения от -2 до 2 (ужасное, плохое, среднее, хорошее, отличное)
    public final String description;//краткое описание дня по желанию
    //public final LocalDate date;//дата
    public final String date;//дата
    //public final LocalTime time;//точное время оценки настроения
    public final String time;//точное время оценки настроения
    @Override
    public String toString() {
        return "Tracker{" +
                "markOfMood=" + markOfMood +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    public Tracker(int markOfMood, String description, String date, String time) {
        this.markOfMood = markOfMood;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public int getMarkOfMood() {
        return markOfMood;
    }
    public String getDescription() {
        return description;
    }

    public String getStringDate() {
        return date.toString();
    }

    public String getStringTime() {
        return time.toString();
    }
}
