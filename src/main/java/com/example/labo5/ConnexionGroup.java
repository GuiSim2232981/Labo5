package com.example.labo5;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ConnexionGroup extends Group {


    Button button1 = new Button("S'inscrire");
    Button button = new Button("Se Connecter");
    TextField tf = new TextField();
    PasswordField pf = new PasswordField();
    Label errorLabel1 = new Label();
    ConnexionGroup(){

        Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,12);

        Label label1 = new Label("Nom Utilisateur");
        label1.setFont(font);
        label1.setTranslateX(225);
        label1.setTranslateY(180);
        tf.setTranslateX(225);
        tf.setTranslateY(200);
        tf.setPromptText("Nom Utilisateur");
        Label label2 = new Label("Mot De Passe");
        label2.setFont(font);
        label2.setTranslateX(225);
        label2.setTranslateY(255);
        pf.setTranslateX(225);
        pf.setTranslateY(275);
        pf.setPromptText("Mot De Passe");

        button.setTranslateX(215);
        button.setTranslateY(325);

        button1.setTranslateX(315);
        button1.setTranslateY(325);

        errorLabel1.setFont(font);
        errorLabel1.setTextFill(Color.RED);
        errorLabel1.setTranslateX(175);
        errorLabel1.setTranslateY(375);



     getChildren().addAll(tf,pf,label1,label2, button,button1,errorLabel1);
    }

}
