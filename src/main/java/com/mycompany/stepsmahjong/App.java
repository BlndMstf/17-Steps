package com.mycompany.stepsmahjong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    static FullSet fullset = new FullSet();
    
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        RiichiMahjongTile testTile = new RiichiMahjongTile(RiichiMahjongTile.Suit.DRAGON, RiichiMahjongTile.Rank.WHITE);
        RiichiMahjongTile testTile1 = new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.TWO);

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ". " + testTile.toString() + testTile1.toString());
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        fullset.fill();
        fullset.shuffle();
        launch();
        for (RiichiMahjongTile tile : fullset.getTiles()){
            System.out.println(tile.toString());
        }
    }

}