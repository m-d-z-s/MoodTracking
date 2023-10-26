package me.mdzs.moodtracking.domain;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {
    Tracker tracker = new Tracker(1, "test","2021-09-01", "12:00" );


    @org.junit.jupiter.api.Test
        void getMarkOfMood() {
            assertEquals(1, tracker.getMarkOfMood());
        }

        @org.junit.jupiter.api.Test
        void getDescription() {
            assertEquals("test", tracker.getDescription());
        }

        @org.junit.jupiter.api.Test
        void getDate() {
            assertEquals("2021-09-01", tracker.getStringDate());
        }

        @org.junit.jupiter.api.Test
        void getTime() {
            assertEquals("12:00", tracker.getStringTime());
        }

}