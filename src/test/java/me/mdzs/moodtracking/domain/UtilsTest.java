package me.mdzs.moodtracking.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    Tracker tracker = new Tracker(0, "фыва", "2021-09-01", "12:00");

    @Test
    void writeObjectOfTrackerToJsonFile() {
        Utils.writeObjectOfTrackerToJsonFile(tracker, "ListOfData.json");
    }

}