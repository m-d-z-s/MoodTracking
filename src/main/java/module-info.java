module me.mdzs.moodtracking {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens me.mdzs.moodtracking to javafx.fxml;
    exports me.mdzs.moodtracking;
    exports me.mdzs.moodtracking.domain;
    opens me.mdzs.moodtracking.domain to javafx.fxml;
}