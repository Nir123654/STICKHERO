module com.example.stckhero {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;


    opens com.example.stckhero to javafx.fxml;
    exports com.example.stckhero;
}
