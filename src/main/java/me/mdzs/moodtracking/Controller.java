package me.mdzs.moodtracking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import me.mdzs.moodtracking.domain.Tracker;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private final String PathToJson = "src/main/java/me/mdzs/moodtracking/Moods.json";

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
            return hours.getValue().toString() + ":" + minutes.getValue().toString();
        }
    }


    @FXML
    public void send(ActionEvent event) {
        int markOfMood = GetMarkOfMood();
        String description = "init";
        String date = GetDate();
        String time = GetTime();
        Tracker tracker = new Tracker(markOfMood, description, date, time);
        recordTrackerToJson(tracker);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }

    @FXML
    private void recordTrackerToJson(Tracker tracker) {// 1. Создание json файла, если его нет. 2. Запись в json список tracker
        //TODO:"Запись в json список tracker";
//        try {
//            if (Files.notExists(Paths.get(PathToJson))) {
//                Files.createFile(Paths.get(PathToJson));
//            }
//            TrackerList trackerList = new TrackerList();
//            trackerList.addTracker(tracker);
//            trackerList.writeToJson(PathToJson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}