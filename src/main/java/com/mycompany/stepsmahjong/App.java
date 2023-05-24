package com.mycompany.stepsmahjong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;


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
        ArrayList<RiichiMahjongTile> testHand = new ArrayList<>();
        fullset.fill();
        fullset.arrange(fullset.getTiles());
        /*
        for (RiichiMahjongTile tile : fullset.getTiles()){
            System.out.println(
                    tile.toString() +
                    " (Honor/terminal tile: " + tile.isHonorOrTerminal() + ")" +
                    " (Green tile: " + tile.isGreen() + ")" +
                    " (Red tile: " + tile.isRedFive() + ")");
        }
        */
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.ONE));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.ONE));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.ONE));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.TWO));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.TWO));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.TWO));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.THREE));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.THREE));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.THREE));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.FOUR));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.FOUR));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.FOUR));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.DRAGON, RiichiMahjongTile.Rank.GREEN));
        testHand.add(new RiichiMahjongTile(RiichiMahjongTile.Suit.DRAGON, RiichiMahjongTile.Rank.GREEN));
        //Collections.sort(testHand);
        Collections.shuffle(testHand);
        for (int i = 0; i < testHand.size(); i++){
            System.out.print(testHand.get(i)+", ");
            if (i + 1 % 7 == 0){
                System.out.print("\n");
            }
        }
        System.out.println();
        //System.out.println(Collections.frequency(testHand, new RiichiMahjongTile(RiichiMahjongTile.Suit.MAN, RiichiMahjongTile.Rank.TWO)));
        if (HandValidator.ValidateHand(testHand, 0, 0, 0)){
            System.out.println("Valid hand");
        }
        else {
            System.out.println("Invalid hand");
        }

        //System.out.println(HandValidator.ValidateHand(testHand, 0, 0, 0));
        
        launch();
    }
}