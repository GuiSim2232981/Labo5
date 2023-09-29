package com.example.labo5;

import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class InscriptionGroup extends Group {


    Button button1 = new Button("S'inscrire");
    Button button2 = new Button("Effacer");
    Button button3 = new Button("Retour");
    CheckBox cb = new CheckBox("J'accepte les conditions d'utilisation");
    TextField prenom = new TextField();
    TextField nomDeFamille = new TextField();
    TextField nomUtilisateur = new TextField();
    PasswordField motDePasse = new PasswordField();
    PasswordField valideMotDePasse = new PasswordField();
    RadioButton radioButton1 = new RadioButton("Homme   ");
    RadioButton radioButton2 = new RadioButton("Femme   ");
    RadioButton radioButton3 = new RadioButton("Autre   ");
    Spinner spinner = new Spinner<>(0,99,18);
    Label errorLabel = new Label();

    InscriptionGroup(){

        Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,12);

        prenom.setPromptText("Prenom");
        Label labelPrenom = new Label("Prenom");
        labelPrenom.setFont(font);
        prenom.setTranslateX(225);
        prenom.setTranslateY(30);
        labelPrenom.setTranslateX(225);
        labelPrenom.setTranslateY(10);

        nomDeFamille.setPromptText("Nom De Famille");
        Label labelNomDeFamille = new Label("Nom De Famille");
        labelNomDeFamille.setFont(font);
        nomDeFamille.setTranslateX(225);
        nomDeFamille.setTranslateY(80);
        labelNomDeFamille.setTranslateX(225);
        labelNomDeFamille.setTranslateY(60);

        nomUtilisateur.setPromptText("Nom Utilisateur");
        Label labelNomUtilisateur = new Label("Nom Utilisateur");
        labelNomUtilisateur.setFont(font);
        nomUtilisateur.setTranslateX(225);
        nomUtilisateur.setTranslateY(130);
        labelNomUtilisateur.setTranslateX(225);
        labelNomUtilisateur.setTranslateY(110);

        motDePasse.setPromptText("Mot De Passe");
        Label labelMotDePasse = new Label("Mot De Passe");
        labelMotDePasse.setFont(font);
        motDePasse.setTranslateX(225);
        motDePasse.setTranslateY(180);
        labelMotDePasse.setTranslateX(225);
        labelMotDePasse.setTranslateY(160);

        valideMotDePasse.setPromptText("Mot De Passe");
        Label labelValideMotDePasse = new Label("Confirmer Mot De Passe");
        labelValideMotDePasse.setFont(font);
        valideMotDePasse.setTranslateX(225);
        valideMotDePasse.setTranslateY(230);
        labelValideMotDePasse.setTranslateX(225);
        labelValideMotDePasse.setTranslateY(210);

        ToggleGroup tg = new ToggleGroup();
        radioButton1.setToggleGroup(tg);
        radioButton2.setToggleGroup(tg);
        radioButton3.setToggleGroup(tg);
        HBox hb = new HBox(radioButton1,radioButton2,radioButton3);
        Label labelGenre = new Label("Genre");
        labelGenre.setFont(font);
        labelGenre.setTranslateX(225);
        labelGenre.setTranslateY(260);
        hb.setTranslateX(225);
        hb.setTranslateY(280);

        spinner.setTranslateX(225);
        spinner.setTranslateY(330);
        Label labelAge = new Label("Age");
        labelAge.setFont(font);
        labelAge.setTranslateX(225);
        labelAge.setTranslateY(310);

        cb.setTranslateX(225);
        cb.setTranslateY(370);

        button1.setTranslateY(410);
        button1.setTranslateX(225);

        button2.setTranslateX(300);
        button2.setTranslateY(410);

        button2.setOnAction(event ->{
            prenom.setText("");
            nomDeFamille.setText("");
            nomUtilisateur.setText("");
            motDePasse.setText("");
            valideMotDePasse.setText("");
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);
            radioButton3.setSelected(false);
            spinner.getValueFactory().setValue(18);
            cb.setSelected(false);
        });

        button3.setTranslateX(365);
        button3.setTranslateY(410);

        errorLabel.setFont(font);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setTranslateX(225);
        errorLabel.setTranslateY(450);

        getChildren().addAll(prenom,labelPrenom, nomDeFamille, labelNomDeFamille, nomUtilisateur, labelNomUtilisateur, motDePasse,labelMotDePasse, valideMotDePasse, labelValideMotDePasse,hb,labelGenre,button1,button2,button3,cb,spinner,labelAge,errorLabel);
    }

}
