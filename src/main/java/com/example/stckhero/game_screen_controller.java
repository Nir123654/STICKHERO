package com.example.stckhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class game_screen_controller {


    private int count1=0;
    private int count2=0;
    @FXML
    private Button quit;

    @FXML
    private ImageView titleImageView1;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private ImageView ninja_image;

    public void initialize() {
        // Set image for the ImageView from the resources
        Image titleImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("background1.png")));
        titleImageView1.setImage(titleImage);
        Image initstickhero2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("stick_hero_static.png")));
        ninja_image.setImage(initstickhero2);

        // Set initial text for text fields
        textField1.setText(String.valueOf(count1++));
        textField2.setText(String.valueOf(count2++));

        Image quitbuttonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("quit.png")));
        ImageView quitimageView = new ImageView(quitbuttonImage);
        quit.setGraphic(quitimageView);

    }
    @FXML
    protected void onQuitButtonClick() throws IOException {
        System.out.println("namit");
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("game_over_screen.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 800, 800);
//        Stage str= HelloApplication.primaryStage;
        Stage rdf = HelloApplication.primaryStage;
        rdf.setScene(scene1);
    }
    @FXML
    private void updateTextBox1() {
        // Update the text in the text field
        textField1.setText("1");
    }

    @FXML
    private void updateTextBox2() {
        // Update the text in the text field
        textField2.setText("1");
    }
}
