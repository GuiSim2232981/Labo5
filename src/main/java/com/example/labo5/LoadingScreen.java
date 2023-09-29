package com.example.labo5;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LoadingScreen extends Group {

    LoadingScreen(String[] info){

        ProgressIndicator pi = new ProgressIndicator();
        Label label = new Label("Chargement du Contenu");
        Label lb = new Label(info[0] + " " + info[1] + " " + info[4] + " " + info[5]);
        label.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,12));

        VBox vb = new VBox(pi,label,lb);
        vb.setAlignment(Pos.CENTER);
        vb.setTranslateX(225);
        vb.setTranslateY(225);
        vb.setSpacing(25);




        getChildren().addAll(vb);
    }

}
