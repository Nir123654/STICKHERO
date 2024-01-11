package com.example.stckhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    Stage str;
    private boolean mutebuttonstate;
    @FXML
    private Button circularButton;
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView titleImageView;
    @FXML
    private ImageView stickheroinitial;
    @FXML
    private Button backgroundSelect;
    @FXML
    private Button help;
    @FXML
    private Button Avatarselect;
    public void initialize() {
        String str1="background"+HelloApplication.init_stick_hero.background_no+".png";
        // Set image for the ImageView from the resources
        Image titleImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(str1)));
        titleImageView.setImage(titleImage);
        Image soundbuttonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SOUND_ON.png")));
        ImageView soundimageView = new ImageView(soundbuttonImage);
        circularButton.setGraphic(soundimageView);
        Image initstickhero = new Image(Objects.requireNonNull(getClass().getResourceAsStream("stick_hero_static.png")));
        stickheroinitial.setImage(initstickhero);


        Image backgroundbuttonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("gallery1.png")));
        ImageView backgroundimageView = new ImageView(backgroundbuttonImage);
        backgroundSelect.setGraphic(backgroundimageView);

        Image helpbuttonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("information1.png")));
        ImageView helpimageView = new ImageView(helpbuttonImage);
        help.setGraphic(helpimageView);

        Image avatarbuttonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Stick_hero_static3.png")));
        ImageView avatarimageView = new ImageView(avatarbuttonImage);
        Avatarselect.setGraphic(avatarimageView);


    }

    @FXML
    protected void onHelloButtonClick() throws IOException, InterruptedException {
        onCircularButtonClick();
        System.out.println("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSoundClick() {
        if (mutebuttonstate == false) {
            Image soundbuttonImage1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("mute.png")));
            ImageView soundimageView1 = new ImageView(soundbuttonImage1);
            circularButton.setGraphic(soundimageView1);
            mutebuttonstate=true;
        } else {
            Image soundbuttonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SOUND_ON.png")));
            ImageView soundimageView = new ImageView(soundbuttonImage);
            circularButton.setGraphic(soundimageView);
            mutebuttonstate=false;
        }
    }
    @FXML
    protected void onCircularButtonClick() throws IOException, InterruptedException {
        System.out.println("namit");
        HelloApplication.init_stick_hero.initialise_game(1);
//        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("game_screen.fxml"));
//        Scene scene1 = new Scene(fxmlLoader1.load(), 800, 800);
//
//        Stage rdf = HelloApplication.primaryStage;
//        rdf.setScene(scene1);

    }

    @FXML
    protected void onAvatarButtonClick() throws IOException {
        System.out.println("namit");
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Avatar_Screen.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 800, 800);
//        Stage str= HelloApplication.primaryStage;
        Stage rdf = HelloApplication.primaryStage;
        rdf.setScene(scene1);
    }


    @FXML
    protected void onhelpButtonClick() throws IOException {
        System.out.println("namit");
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("helpscreen.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 800, 800);
//        Stage str= HelloApplication.primaryStage;
        Stage rdf = HelloApplication.primaryStage;
        rdf.setScene(scene1);
    }


    @FXML
    protected void ongallaryButtonClick() throws IOException {
        System.out.println("namit");
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Gallary_Screen.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 800, 800);
//        Stage str= HelloApplication.primaryStage;
        Stage rdf = HelloApplication.primaryStage;
        rdf.setScene(scene1);
    }




}
