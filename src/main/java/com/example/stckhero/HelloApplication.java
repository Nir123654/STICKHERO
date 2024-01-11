package com.example.stckhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class HelloApplication extends Application {
    public static int cherry_collected=0;
    public static stick_hero_game init_stick_hero=new stick_hero_game();

public static int global_score=0;

    public Avatar_controller avatarController;

    public static sound NewSound=new sound();

    public static Stage primaryStage;
    public static boolean GAME_SET;





//    private Parent createContent() {
//        Pane root = new Pane();
//
////        ImageView title = new ImageView(new Image(getClass().getResource("/images/title.png").toExternalForm()));
////        title.setFitWidth(178);
////        title.setFitHeight(50);
////        title.setLayoutX(200);
////        title.setLayoutY(50);
//
////        ImageView flappyBird = new ImageView(new Image(getClass().getResource("/images/bird2.png").toExternalForm()));
////        flappyBird.setFitWidth(50);
////        flappyBird.setFitHeight(45);
////        flappyBird.setLayoutX(260);
////        flappyBird.setLayoutY(120);
//
////        Rectangle bg = new Rectangle(600, 300);
////        bg.setFill(Color.rgb(78,192,202));
//
//        Text inst = new Text("Use the Space Bar or\nMouse Click to Start");
//        inst.setFont(Font.font("Courier", FontWeight.EXTRA_BOLD, 25));
//        inst.setFill(Color.WHITE);
//        inst.setStroke(Color.BLACK);
//        inst.setLayoutX(140);
//        inst.setLayoutY(230);
//
////        root.getChildren().addAll(bg, title, flappyBird, inst);
//        return root;
//    }

    public void startGame() {
        if (!GAME_SET) {
            GAME_SET = true;
            stick_hero_game game = new stick_hero_game();
            Stage st = new Stage();
            try {
                game.start(st);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image icon16 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon16.png")));
        Image icon32 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon32.png")));
        Image icon48 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon48.png")));
        Image icon128 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon128.png")));





//        Scene scene = new Scene(createContent());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        scene.setOnKeyPressed(e -> {
            startGame();
        });
        scene.setOnMousePressed(e -> {
            startGame();
        });
        primaryStage.setTitle("Stick Hero");
        primaryStage.getIcons().addAll(icon16, icon32, icon48, icon128);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
        HelloApplication.primaryStage =primaryStage;

    }
    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}