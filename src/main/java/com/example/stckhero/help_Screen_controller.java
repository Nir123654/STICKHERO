package com.example.stckhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class help_Screen_controller {
    @FXML
    private Button crossButton;
    @FXML
    private ImageView titleImage;
    @FXML
    private Text help_text;
    @FXML
    private ImageView middleImage;
    @FXML
    private ImageView innerImage;
    @FXML
    private TextField txtfld;

    public void initialize() {
        Image titleimage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("background1.png")));
        titleImage.setImage(titleimage);
        Image middleimage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Rectangle 38.png")));
        middleImage.setImage(middleimage);
        Image innerimage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("A_black_image.jpg")));
        innerImage.setImage(innerimage);
        help_text.setText("HELP");
        txtfld.setText("Welcome to Stick Hero!Collect cherries to increase your score.");
        Image crossbuttonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("cross.png")));
        ImageView crossimageView = new ImageView(crossbuttonImage);
        crossButton.setGraphic(crossimageView);
    }
    @FXML
    protected void onCrossButtonClick() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene4 = new Scene(fxmlLoader1.load(), 800, 800);
//        Stage str= HelloApplication.primaryStage;
        Stage rdf3 = HelloApplication.primaryStage;
        rdf3.setScene(scene4);
        System.out.println("cross button clicked");

    }
}
