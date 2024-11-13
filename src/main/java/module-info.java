module org.olesya.musicaldevapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires static lombok;
    requires java.sql;
    requires org.slf4j;
    requires java.desktop;
    requires jdk.compiler;

    exports org.olesya.musicaldevapp;
    exports org.olesya.musicaldevapp.data.repository;
    exports org.olesya.musicaldevapp.data.entity;
    exports org.olesya.musicaldevapp.utils;

    opens org.olesya.musicaldevapp to javafx.fxml;
    opens org.olesya.musicaldevapp.data.repository to javafx.fxml;
    opens org.olesya.musicaldevapp.data.entity to javafx.fxml;
    opens org.olesya.musicaldevapp.utils to javafx.fxml;
}