package com.example.stckhero;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PIllars {
    private Rectangle rectangle;


    private int pillar_width;

    private int default_height=50;

    public int X_position;

    private double xCoordinate;
    private double yCoordinate;
    private double width;

    private double height;


public PIllars(int width,int position){
    this.X_position=position;
    this.pillar_width=width;
    this.rectangle= new Rectangle(pillar_width,default_height);
    this.rectangle.setFill(Color.BLACK);
}

    public PIllars(double xCoordinate, double yCoordinate, double width, double height) {
    this.xCoordinate=xCoordinate;
    this.yCoordinate=yCoordinate;
    this.width=width;
    this.height=height;

    this.rectangle= new Rectangle(xCoordinate, yCoordinate, width, height);
    this.rectangle.setX(xCoordinate);
    this.rectangle.setFill(Color.BLACK);

//    rectangle.setTranslateY(yCoordinate);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    private ImageView pillar_image;


//    public int getX_position() {
//        return X_position;
//
//    }

//    public int getPillar_width() {
//        return pillar_width;
//    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

}
