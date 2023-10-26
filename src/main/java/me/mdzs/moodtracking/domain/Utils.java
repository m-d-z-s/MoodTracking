package me.mdzs.moodtracking.domain;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Utils {
    static Tracker tracker;
    public static void writeObjectOfTrackerToJsonFile(Tracker tracker, String filePath) {
        // Check if the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            // Create a new file and write the tracker object as a list
            List<Tracker> trackerList = new ArrayList<>();
            trackerList.add(tracker);
            writeJsonToFile(trackerList, filePath);
        } else {
            try {
                // Read the existing JSON file
                String json = new String(Files.readAllBytes(Paths.get(filePath)));

                // Deserialize the JSON into a list of Tracker objects
                Type trackerListType = new TypeToken<List<Tracker>>() {}.getType();
                List<Tracker> existingTrackerList = new Gson().fromJson(json, trackerListType);

                // Add the new tracker object to the existing list
                existingTrackerList.add(tracker);

                // Write the updated list to the file
                writeJsonToFile(existingTrackerList, filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeJsonToFile(List<Tracker> trackerList, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Serialize the list of Tracker objects to JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(trackerList);

            // Write the JSON to the file
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
