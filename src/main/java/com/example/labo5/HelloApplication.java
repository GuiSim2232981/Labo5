package com.example.labo5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class HelloApplication extends Application{


    ConnexionGroup cg = new ConnexionGroup();
    InscriptionGroup ig = new InscriptionGroup();

    Dino dino = new Dino();
    Scene igs = new Scene(ig);
    Scene cgs = new Scene(cg);
    Scene dinos = new Scene(dino);

    File file = new File("src/main/resources/Donnee.csv");

    String[][] donne;



    @Override
    public void start(Stage stage) throws IOException {

        donne = readFile(file);


        dinos.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.SPACE) {
                dino.Jump();
            }
            event.consume();
        });




        stage.setWidth(600);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.setTitle("Labo 5");
        stage.setScene(cgs);
        stage.show();

        cg.button1.setOnAction(event -> {
            stage.setScene(igs);
        });

        cg.button.setOnAction(event -> {

            String user = cg.tf.getText();
            String motDePasse = cg.pf.getText();

            boolean correspond = false;

            String[] info = new String[0];

            for (int i = 0; i< donne.length; i++){
                if (donne[i][2] != null) {
                    if (donne[i][2].equals(user)) {
                        if (Integer.parseInt(donne[i][3]) == (motDePasse.hashCode())) {
                            correspond = true;
                            info = donne[i];
                        }
                    }
                }
            }

            if (correspond){
                stage.setScene(new Scene(new LoadingScreen(info)));
            }else {
                cg.errorLabel1.setText("Mot de passe ou nom utilisateur Invalide");
            }



        });

        ig.button3.setOnAction(event -> {
            stage.setScene(cgs);
        });
        ig.button1.setOnAction(event ->{
            if (ig.prenom.getText().equals("")){
                ig.errorLabel.setText("Prenom Invalide");
            } else if (ig.nomDeFamille.getText().equals("")) {
                ig.errorLabel.setText("Nom de Famille Invalide");
            } else if (ig.nomUtilisateur.getText().equals("")) {
                ig.errorLabel.setText("Nom Utilisateur invalide");
            }else if (!verifNomUtilisateurDispo(ig.nomUtilisateur.getText(),donne)){
                ig.errorLabel.setText("Nom utilisateur non disponible");
            } else if (ig.motDePasse.getText().equals("")) {
                ig.errorLabel.setText("Mot de passe invalide");
            } else if (!ig.valideMotDePasse.getText().equals(ig.motDePasse.getText())) {
                ig.errorLabel.setText("Les mots de passe ne correspondent pas");
            } else if (!ig.radioButton1.isSelected() && !ig.radioButton2.isSelected() && !ig.radioButton3.isSelected()) {
                ig.errorLabel.setText("Veuillez choisir un genre");
            } else if (!ig.cb.isSelected()) {
                ig.errorLabel.setText("Veuillez accpeter les conditions d'utilisation");
            }else {
                String account = null;
                try {
                    account =  Files.readString(file.toPath()) + ";" + ig.prenom.getText() + "," + ig.nomDeFamille.getText() + "," + ig.nomUtilisateur.getText() + "," + ig.motDePasse.getText().hashCode() + ",";
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (ig.radioButton1.isSelected()){
                    account += "H,";
                }else if (ig.radioButton2.isSelected()){
                    account += "F,";
                }else {
                    account += "A,";
                }
                account += ig.spinner.getValue().toString();

                try {
                    Files.write(file.toPath(), account.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setScene(cgs);

                try {
                    donne = readFile(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }

    public boolean verifNomUtilisateurDispo(String nomUtilisateur, String[][] donnee){

        for (int i = 0; i < donnee.length; i++){
            if (donnee[i][2] != null){
                if (donnee[i][2].equals(nomUtilisateur)){
                    return false;
                }
            }
        }
        return true;
    }

    public String[][] readFile(File file) throws IOException {
        //Files.write(file.toPath(),"HELLO".getBytes());
        String[] s = Files.readString(file.toPath()).split(";");

        String[][] donne = new String[s.length][6];

        for (int i = 0; i < s.length; i++){
            if (s[i] != null) {
                String[] e = s[i].split(",");
                for (int j = 0; j < e.length; j++) {
                    if (e[j] == null){
                        donne[i][j] = "";
                    }else {
                        donne[i][j] = e[j];
                    }
                }
            }
        }

        return donne;
    }


    public static void main(String[] args) {
        launch();
    }
}