package me.mdzs.moodtracking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import me.mdzs.moodtracking.domain.Tracker;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private final String PathToJson = "src/main/java/me/mdzs/moodtracking/Moods.json";
    @FXML
    public TextArea description;

    @FXML
    private DatePicker date;

    @FXML
    private CheckBox autoDate;

    @FXML
    private Spinner<Integer> hours;

    @FXML
    private Spinner<Integer> minutes;

    @FXML
    private Button send;

    @FXML
    private ChoiceBox<String> moodPicker;


    @FXML
    public void initialize() {
        // настроения на английском
        moodPicker.getItems().addAll("Awful", "Bad", "Normal", "Good", "Excellent");
        moodPicker.setValue("Normal");
        hours.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 12));
        minutes.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        date.setValue(LocalDate.now());
    }

    @FXML
    private int GetMarkOfMood() {
        switch (moodPicker.getValue()) {
            case "Awful":
                return -2;
            case "Bad":
                return -1;
            case "Normal":
                return 0;
            case "Good":
                return 1;
            case "Excellent":
                return 2;
            default:
                return 0;
        }
    }

    private String GetDescription() {
        return description.getText();
    }

    private String GetDate() {
        if (autoDate.isSelected()) {
            return LocalDate.now().toString();
        } else {
            return date.getValue().toString();
        }
    }

    private String GetTime() {
        if (autoDate.isSelected()) {
            return LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
        } else {
            if (minutes.getValue() < 10)
                return hours.getValue().toString() + ":0" + minutes.getValue().toString();
            else return hours.getValue().toString() + ":" + minutes.getValue().toString();
        }
    }

    @FXML
    public void send(ActionEvent event) {
        int markOfMood = GetMarkOfMood();
        String description = GetDescription();
        String date = GetDate();
        String time = GetTime();
        Tracker tracker = new Tracker(markOfMood, description, date, time);
        addTrackerToJsonFile(tracker);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }



    private void addTrackerToJsonFile(Tracker newTracker) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File file = new File(PathToJson);

        try {
            List<Tracker> trackerList;

            if (!file.exists()) {
                trackerList = new ArrayList<>();
            } else {
                FileReader reader = new FileReader(file);
                Type type = new com.google.gson.reflect.TypeToken<List<Tracker>>() {}.getType();
                trackerList = gson.fromJson(reader, type);
                reader.close();
            }

            trackerList.add(newTracker);

            FileWriter writer = new FileWriter(file);

            String json = gson.toJson(trackerList);
            writer.write(json);

            writer.close();

            System.out.println("Объект Tracker успешно добавлен в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}