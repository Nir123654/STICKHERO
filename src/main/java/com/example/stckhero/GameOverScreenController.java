package com.example.stckhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.stckhero.HelloApplication.cherry_collected;

public class GameOverScreenController {
    @FXML
    private Text gameoverlabel;
    @FXML
    private ImageView titleimage1;
    @FXML
    private ImageView titleimage2;
    @FXML
    private ImageView titleimage3;
    @FXML
    private Text scoretext;
    @FXML
    private Text scoretextnum;
    @FXML
    private Text besttext;
    @FXML
    private Text besttextnum;
    @FXML
    private ImageView homeImage1;
    @FXML
    private ImageView restartImage1;
    @FXML
    private ImageView homeImage2;
    @FXML
    private ImageView restartImage2;
    @FXML
    private Button homebutton;
    @FXML
    private Button restartButton;
    @FXML
    private ImageView cherryImage;
    @FXML
    private Text cherrytext;


    public void initialize(){
        String str1="background"+HelloApplication.init_stick_hero.background_no+".png";
        Image titleImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(str1)));
        titleimage1.setImage(titleImage);
        Image titleImage2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("black_bg.jpg")));
        titleimage2.setImage(titleImage2);
        Image titleImage3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Rectangle 38.png")));
        titleimage3.setImage(titleImage3);
        gameoverlabel.setText("GAME OVER!");
        scoretextnum.setText(String.valueOf(HelloApplication.init_stick_hero.current_score));
        HelloApplication.init_stick_hero.current_score=0;
        besttext.setText("BEST");
        scoretext.setText("SCORE");
        besttextnum.setText(String.valueOf(HelloApplication.global_score));
        cherrytext.setText(String.valueOf(cherry_collected));
        Image homeimage1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("home.png")));
        homeImage1.setImage(homeimage1);
        Image restartimage1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("restart.png")));
        restartImage1.setImage(restartimage1);
        Image homeimage2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("home.png")));
//        homeImage2.setImage(homeimage2);
        ImageView homeimageView = new ImageView(homeimage2);
        homebutton.setGraphic(homeimageView);
        Image restartimage2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("restart.png")));
//        restartImage2.setImage(restartimage2);
        ImageView restartimageView = new ImageView(homeimage2);
        restartButton.setGraphic(restartimageView);
        Image cherryimage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("cherry.png")));
        cherryImage.setImage(cherryimage);
    }

    @FXML
    protected void onRestartButtonClick() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("game_screen.fxml"));
        Scene scene11 = new Scene(fxmlLoader1.load(), 800, 800);
//        Stage str= HelloApplication.primaryStage;
        Stage rdf1 = HelloApplication.primaryStage;
        rdf1.setScene(scene11);
        System.out.println("restart");
    }
    @FXML
    protected void onHomeButtonClick() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene11 = new Scene(fxmlLoader1.load(), 800, 800);
//        Stage str= HelloApplication.primaryStage;
        Stage rdf1 = HelloApplication.primaryStage;
        rdf1.setScene(scene11);
        System.out.println("Home");
    }







}
