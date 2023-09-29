package com.example.labo5;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Dino extends Group {


    Rectangle dino = new Rectangle(50,225,20,40);
    Rectangle cactus = new Rectangle(500,225,40,40);
    TranslateTransition tt;
    boolean isjumping = false;
    Dino(){

        tt = new TranslateTransition(Duration.millis(500),dino);
        tt.setFromY(0);
        tt.setToY(-100);
        tt.setCycleCount(2);
        tt.setAutoReverse(true);
        tt.setOnFinished(event -> isjumping = false);



        TranslateTransition ttCactus = new TranslateTransition(Duration.seconds(3),cactus);
        ttCactus.setFromX(0);
        ttCactus.setToX(-600);
        ttCactus.setCycleCount(Animation.INDEFINITE);
        ttCactus.play();

        Timeline tm = new Timeline(new KeyFrame(Duration.millis(16), event -> {

            VerifierCollision(dino,cactus);


        }));
        tm.setCycleCount(Animation.INDEFINITE);
        tm.play();



        Line line  = new Line(0,265,600,265);
        line.setStrokeWidth(5);


        getChildren().addAll(dino,line,cactus);
    }

    public void Jump(){
        if (!isjumping){
            isjumping = true;
            tt.play();
        }
    }

    public void VerifierCollision(Rectangle rect1, Rectangle rect2){

        if ((cactus.getX() + cactus.getTranslateX()) > dino.getX() && (cactus.getX() + cactus.getTranslateX() + 40) < (dino.getX())){
            System.out.println("pos not good");
            if (((dino.getY() + dino.getTranslateY() + 40) > cactus.getY())){
                System.out.println("Collision  Dino : " + dino.getX() + "," + (dino.getY() + dino.getTranslateY()) + "  Cactus : " +( cactus.getX() + cactus.getTranslateX()) + "," + cactus.getY());
            }
        }




    }





}
