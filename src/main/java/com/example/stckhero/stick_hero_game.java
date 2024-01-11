package com.example.stckhero;

import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.effect.DropShadow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.example.stckhero.HelloApplication.*;

public class stick_hero_game {
    public int current_score;
    private boolean ninja_fell;
    private RotateTransition rotateTransition;
    private boolean initSound=false;
    private AnimationTimer timer;
    public int hero_image_no=1;
    private Rectangle stick1;
    private Rectangle stick2;
    private double stickLength = 0;
    private double stickY = 595;
    private Image HeroImage;
    private Image cherryImage;
    private ImageView cherryImageView;
    private boolean game_state;
    private ImageView HeroImageView;

    private int totalscore=0;
    private hero init_hero;
    private boolean stickgrowing_flag;
    private boolean stick_rotating_flag;

    private ArrayList<PIllars> scenepillars=new ArrayList<>();


    private double x;
    private double y;
    public sound cherry,stick_drop,hit,walk;
    private ImageView gameover;
    public int background_no=1;

//    public int cherry_collected;
    private int total_cherry;
    private Pane rootPane;
    boolean flag=false;
    boolean gameflag;
    private Rectangle rectangle1;

    private Rectangle rectangle2;
    private Rectangle rectangle3;
    private Scene scene;
    private Text cherryText;
    private TextField textField1;
    private Text text1;

    public void initialise_game(int p) throws InterruptedException {


        if(p==1){

            System.out.println("Executing task...");
            String str1="file:src/main/resources/com/example/stckhero/background"+background_no+".png";
            Image backgroundImage = new Image(str1);
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(primaryStage.getWidth());
            rootPane = new Pane();
            rootPane.getChildren().add(backgroundImageView);

            cherryImage=new Image("file:src/main/resources/com/example/stckhero/cherry.png");
            cherryImageView=new ImageView(cherryImage);
            rootPane.getChildren().add(cherryImageView);

            String str="file:src/main/resources/com/example/stckhero/Avatar_"+hero_image_no+"-removebg-preview (Custom).png";
            HeroImage = new Image(str);
            HeroImageView = new ImageView(HeroImage);
            HeroImageView.setX(40);
            HeroImageView.setY(545);
            ninja_fell=false;
            stick_create stick11 = new stick_create();
            stick_create stick21 = new stick_create();

            // Create threads for each stick and start them
            Thread thread1 = new Thread(stick11);
            Thread thread2 = new Thread(stick21);

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            rootPane.getChildren().add(HeroImageView);
            cherryText = new Text(String.valueOf(cherry_collected));
            cherryText.setLayoutX(720);
            cherryText.setLayoutY(40);
            cherryText.setFont(Font.font("Arial", 24));
            cherryText.setFill(Color.BLACK );
            rootPane.getChildren().add(cherryText);
//        Rectangle rectangle1 = new Rectangle(50, 50, 100, 100);
//        rectangle1.setFill(Color.RED);
//        Rectangle rectangle2 = new Rectangle(200, 200, 150, 150);
//        rectangle2.setFill(Color.BLUE);
            text1 = new Text("0");
            text1.setLayoutX(370.0);
            text1.setLayoutY(150.0);
            text1.setOpacity(0.51);
            text1.setFont(Font.font("Arial", 72.0));

            Blend blend = new Blend();
            DropShadow dropShadow = new DropShadow();
            blend.setTopInput(dropShadow);
            text1.setEffect(blend);
            rootPane.getChildren().add(text1);

//        Blend blend = new Blend();
//        DropShadow dropShadow = new DropShadow();
//        blend.setTopInput(dropShadow);
//        textField1.setEffect(blend);


            rectangle1 = new Rectangle(0, 600, 100, 200);
            rectangle1.setX(0);
            rectangle1.setFill(Color.BLACK);
            PIllars pil2=create_pillars();
            rectangle2=pil2.getRectangle();

            System.out.println("Pillar X Position:   "+pil2.getxCoordinate());
//            PIllars pil2=create_pillars(rootPane);
//            Rectangle rectangle2=pil2.getRectangle();
//        rectangle2.setTranslateX(rectangle2.getX());
            rootPane.getChildren().addAll(rectangle1, rectangle2);
            System.out.println("Rectangle 2 width: "+rectangle2.getWidth());
            cherryImageView.setX(Random_X_Position(rectangle1.getX()+rectangle1.getWidth(),rectangle2.getX()));
            cherryImageView.setY(560);
            scene = new Scene(rootPane, 800, 800);
            stick1 = new Rectangle(5,1000);
            stick1.setX(90);
            stick1.setY(stickY);
            rootPane.getChildren().add(stick1);
            scene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.SPACE&&!flag) {
//                System.out.println("space key pressed");
                    //startGrowingStick();
                    if(!stickgrowing_flag){
                        growStick();
                    }

                }
            });
            scene.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.SPACE) {
                    stopGrowingStick(rectangle2);
                    startRotatingStick(rectangle2);
                }
            });

            primaryStage.setScene(scene);
            TestPillarGeneration();


        }
        else if (p==0){
            stickLength++;
        }






    }

    //    private void startGrowingStick() {
//        // Check if the timer is already running to avoid starting multiple timers
//        if (timer == null) {
//            timer = new AnimationTimer() {
//                @Override
//                public void handle(long now) {
//                    growStick();
//                }
//            };
//            timer.start();
//        }
//    }
    public void growStick() {
        // Adjust the movement speed as needed
        stick1.setY(stickY);
        stickY -= 5;
        stickLength+=5;
        stick1.setHeight(stickLength);
//        stickLength += 5; // Adjust the growth speed as needed
//        stick1.setWidth(10); // Set the stick width (adjust as needed)
//        stick1.setHeight(stickLength);
    }

    private void stopGrowingStick(Rectangle rectangle2) {
        if (timer != null) {
            timer.stop();
            timer = null;
            flag=true;
//            stick1=null;
//            stick1=new Rectangle(5,2*stickLength);
//            stick1.setFill(Color.BLACK);
//            stick1.setX(80);
//            stick1.setY(580);
            System.out.println("stick height: "+stick1.getHeight());
            startRotatingStick(rectangle2);
        }
    }

    private void startRotatingStick(Rectangle rectangle2) {

        if(!stick_rotating_flag){
            Rotate r = new Rotate();
            r.setAngle(0);
            r.setPivotX(stick1.getX());
            r.setPivotY(stick1.getY() + stickLength);

            stick1.getTransforms().add(r);

            KeyValue keyValue = new KeyValue(r.angleProperty(), 90); // Adjust the final angle as needed
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue); // Set the duration to 3 seconds

            Timeline timeline = new Timeline(keyFrame);
            timeline.setCycleCount(1);
//        timeline.setInterpolator(Interpolator.EASE_BOTH);
            timeline.setOnFinished(event -> {
                try {
                    stopRotatingStick(rectangle2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            timeline.play();


        }

    }
    private void stopRotatingStick(Rectangle rectangle2) throws IOException {
        stick_rotating_flag=true;
        stickgrowing_flag=true;
//        stick1.setTranslateX();
        stick1.setFill(Color.BLACK);
        HelloApplication.NewSound.setHitSound(true);
//        rootPane.getChildren().remove(stick1);
//        stickY = 580;
//        stickLength = 0;
        ninja_moving(rectangle2);
        // Other reset actions if needed



    }
    public void ninja_moving(Rectangle rectangle) throws IOException {
        HelloApplication.NewSound.setHitSound(false);

        System.out.println("Stick Length check:   "+  stickLength+rectangle1.getX());
        System.out.println("rectangle coord:  "+(rectangle2.getX() - 100));
        if (stickLength+rectangle1.getX() < rectangle2.getX() - 100 || stickLength+rectangle1.getX()>rectangle2.getX()+rectangle2.getWidth()-100) {
            System.out.println("i am in ninja moving");
            double speed = 100;
            double durationInSeconds = stickLength / speed;
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(durationInSeconds), HeroImageView);
            translateTransition.setToX(stickLength + HeroImage.getWidth());

            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));

            translateTransition.setOnFinished(actionEvent ->fall_animation());

            translateTransition.play();

        }
        else if(stickLength+rectangle1.getX()<=rectangle2.getX()+rectangle2.getWidth()-100){
            HelloApplication.NewSound.setWalk_Sound(true);
            double speed = 100;
            double durationInSeconds = (rectangle2.getX() + rectangle2.getWidth()) / speed;

            KeyValue keyValue = new KeyValue(HeroImageView.translateXProperty(), rectangle2.getX() + rectangle2.getWidth() - 100 - rectangle1.getX());
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(durationInSeconds), keyValue);

            Timeline timeline = new Timeline(keyFrame);
            timeline.setCycleCount(Animation.INDEFINITE);
            System.out.println("Stick Length: "+stickLength);
            System.out.println("rectangle width: "+rectangle2.getWidth());
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(durationInSeconds), HeroImageView);
            translateTransition.setToX(rectangle2.getX()+rectangle2.getWidth()-100-rectangle1.getX() );

            AtomicBoolean cherry_flag= new AtomicBoolean(false);
            translateTransition.setOnFinished(actionEvent -> {
                cherry_flag.set(true);
                HelloApplication.NewSound.setWalk_Sound(false);
                rootPane.getChildren().remove(cherryImageView);
                 // Check for cherry collection after the player moves
                next_block_transition(rectangle2);
            });




            translateTransition.play();


        }
        else {
            System.out.println("OUT of Range");

        }


    }
    public void next_block_transition(Rectangle rectangle){
        current_score++;
        text1.setText(String.valueOf(current_score));
        cherry_collected++;
        cherryText.setText(String.valueOf(cherry_collected));
        if(current_score>HelloApplication.global_score){
            HelloApplication.global_score=current_score;
        }
        double diff=-rectangle2.getX()-rectangle2.getWidth()+rectangle1.getWidth()+rectangle1.getX();
        System.out.println("-----------------\n------------------");
        System.out.println(diff);
        System.out.println("-----------------\n------------------");
        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(2), HeroImageView);
        translateTransition1.setToX(0);
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(2), rectangle2 );
        translateTransition2.setByX(diff);
        TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(2), stick1 );
        translateTransition3.setByX(diff-100);
        TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(2),rectangle1);
        translateTransition4.setByX(diff-100);
//        Timeline timeline = new Timeline();
//
//        for (int i = 0; i < 20; i++) {
//            double durationInSeconds = 1.0 / 20.0; // 1 second divided by the number of steps
//
//            KeyFrame keyFrame = new KeyFrame(Duration.seconds(durationInSeconds * (i + 1)), event -> {
//                stickLength -= 5;
//                stick1.setHeight(stickLength);
//                stick1.setY(stick1.getY()-2.5);
//            });
//
//            timeline.getKeyFrames().add(keyFrame);
//        }
//
//        timeline.play();


        translateTransition4.setOnFinished(actionEvent -> next_scene_creation());




        translateTransition1.play();
        translateTransition2.play();
        translateTransition3.play();
        translateTransition4.play();


    }
    public void checkCherryCollection() {
        if (cherryImageView.getBoundsInParent().intersects(HeroImageView.getBoundsInParent())) {
            // Cherry collected
            cherry_collected++;
            cherryText.setText(String.valueOf(cherry_collected));
            // You can also add additional logic or animations here if needed
        }
    }
    public void create_new_pillar(){

    }
    public void reset_parameters(){

    }
    public void next_scene_creation(){
        rectangle1.setX(rectangle2.getX()+100);
        rectangle1.setY(rectangle2.getY());
        rectangle1.setHeight(rectangle2.getHeight());
        rectangle1.setWidth(rectangle2.getWidth());

        rectangle1.setFill(rectangle2.getFill());

        PIllars pil_next=create_pillars();
        rectangle3=pil_next.getRectangle();
        System.out.println("platform x: "+rectangle3.getX());
        rectangle2.setX(rectangle3.getX()+rectangle1.getX()+100);
        rectangle2.setY(rectangle3.getY());
        rectangle2.setHeight(rectangle3.getHeight());
        rectangle2.setWidth(rectangle3.getWidth());
        rectangle2.setFill(rectangle3.getFill());
        cherryImageView=new ImageView(cherryImage);
        //cherryImageView.setX(Random_X_Position(rectangle1.getX()+rectangle1.getWidth(),rectangle2.getX()-rectangle2.getWidth()));
        cherryImageView.setY(560);
        rootPane.getChildren().add(cherryImageView);
        Rotate r = new Rotate();
        r.setAngle(270);
        r.setPivotX(stick1.getX());
        r.setPivotY(stick1.getY() + stickLength);
        stick2=new Rectangle(5,1000);
        stick1.setX(rectangle1.getX()+rectangle1.getWidth()-5);
        stick1.setY(595);
        stick1.setHeight(stick2.getHeight());
        stick1.setWidth(stick2.getWidth());

        stick1.getTransforms().add(r);
        stickLength=0;
        stickY=595;
//        stick1.setY(stickY);

        stickgrowing_flag=false;
        stick_rotating_flag=false;

//        stick1.setX(90);
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.SPACE&&!flag) {
////                System.out.println("space key pressed");
//                //startGrowingStick();
//                if(!stickgrowing_flag){
//                    growStick();
//                }

//            }
//        });
//        scene.setOnKeyReleased(event -> {
//            if (event.getCode() == KeyCode.SPACE) {
//                stopGrowingStick(rectangle2);
//                startRotatingStick(rectangle2);
//            }
//        });

    }
    public void setGameover() throws IOException {
        HelloApplication.NewSound.setPlayerfall_sound(false);
        HelloApplication.NewSound.setPlayer_hit_sound(true);
        stick_rotating_flag=false;
        stickgrowing_flag=false;
        gameflag=true;
        stickLength=0;
        stickY=595;
        FXMLLoader gameover=new FXMLLoader(getClass().getResource("game_over_screen.fxml"));
        Scene game_over=new Scene(gameover.load(),800,800);
        primaryStage.setScene(game_over);
        HelloApplication.NewSound.setPlayer_hit_sound(false);

    }
    public void fall_animation(){
        double duration_of_fall = 1;
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration_of_fall), HeroImageView);
        translateTransition.setToY(800);
        translateTransition.setOnFinished(actionEvent -> {
            try {
                setGameover();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        HelloApplication.NewSound.setPlayerfall_sound(true);
        translateTransition.play();




    }







    public void start(Stage primaryStage) throws Exception {
        initialise_game(1);





    }

    private void setKeyFunctions(Scene scene){




    }

    private void game_state_changer(){


    }
    private void setPosition(){

    }
    private void floor(){

    }

    private void startGame(){

    }
    private void resetVariables(){

    }
    private void scoreIncrease(){
        init_hero.getIs_up();

    }
    public void moveFrame(){

    }
    public void hitAnimation(){

    }
    public  void hitsound(){
        HelloApplication.NewSound.setHitSound(true);


    }
    public PIllars create_pillars(){
        int random_width=RandomWidth();
        int random_x_pillar=Random_X_Position(50,100);
        Random random = new Random();
        double xCoordinategen = random.nextDouble() * (700 - 50);

        double min_x_coordinate=150;
        double xCoordinate=Math.max(min_x_coordinate,xCoordinategen);
        double minWidth = 100;
        double maxWidth = 300;
        double maxWidthForWidth = maxWidth ;
        double width = Math.max(minWidth, random.nextDouble(maxWidthForWidth));
        double height = 200;
        double yCoordinate = 800 - height;
        PIllars pil = new PIllars(xCoordinate, yCoordinate, width, height);

        scenepillars.add(pil);
        return pil;

    }
    public int RandomWidth(){
        return 0;
    }

    public int Random_X_Position(int min, int max){
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;


    }

    public double Random_X_Position(double min, double max) {
        Random random = new Random();
        return random.nextDouble(max - min) + 1 + min;
    }

    public void TestPillarGeneration(){
        for(int i=0;i<200;i++){
            PIllars pil3=create_pillars();
            if(pil3.getxCoordinate()<100){
                System.out.println("Pillar X Position:   "+pil3.getxCoordinate());
                System.out.println("Test Failed");
                break;
            }
            else{
                System.out.println("Pillar X Position:   "+pil3.getxCoordinate());
            }
        }
        System.out.println("Test Pass");

    }


    public boolean isStickGrowing() {
        return stickLength > 0;
    }

    public boolean isGameover() {
        return gameflag;
    }

    public boolean isWalkSoundPlaying() {
        return HelloApplication.NewSound.getWalk_Sound();
    }
}

