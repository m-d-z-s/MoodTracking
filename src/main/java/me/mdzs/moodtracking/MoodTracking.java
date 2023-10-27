package me.mdzs.moodtracking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MoodTracking extends Application {
    private static final int PANE_WIDTH = 700;
    private static final int PANE_HEIGHT = 500;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MoodTracking.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), PANE_WIDTH, PANE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}