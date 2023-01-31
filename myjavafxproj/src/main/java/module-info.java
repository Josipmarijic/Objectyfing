module com.example.myjavafxproj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires json.simple;

    opens com.example.myjavafxproj to javafx.fxml;
    exports com.example.myjavafxproj;
}