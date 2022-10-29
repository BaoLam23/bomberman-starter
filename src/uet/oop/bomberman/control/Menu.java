package uet.oop.bomberman.control;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Level.Level1;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.root;

import static uet.oop.bomberman.BombermanGame.*;

public class Menu {
    private static ImageView statusGame;
    public static Text level, bomb, time;
    public static int bombNumber = 20, timeNumber = 120;
    private static int timeChanger = 0;

    public static void createMenu(Group root) {
        level = new Text("Level: 1");
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.WHITE);
        level.setX(20);
        level.setY(20);
        bomb = new Text("Bombs: 20");
        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bomb.setFill(Color.WHITE);
        bomb.setX(100);
        bomb.setY(20);
        time = new Text("Time: 120");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.WHITE);
        time.setX(100);
        time.setY(20);

        //Image newGame = new Image("newGame.png");
        Image newGame = new Image(new File("res/textures/start.png").toURI().toString());
        statusGame = new ImageView(newGame);
        statusGame.setX(850);
        statusGame.setY(-14);
        statusGame.setScaleX(0.5);
        statusGame.setScaleY(0.5);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, time, statusGame);
        pane.setMinSize(Sprite.SCALED_SIZE * WIDTH, 20);
        //pane.setMaxSize(800, 480);
        pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);


        statusGame.setOnMouseClicked(event -> {
            if (bomberman.isLife()) {
                running = !running;
            } else {
                new Level1();
                running = true;
            }
            updateMenu();
        });

    }

    public static void updateMenu() {
        timeChanger++;
        if (timeChanger > 60) {
            timeNumber--;
            timeChanger = 0;
        }

        level.setText("Level: " + _level);
        bomb.setText("Bombs: " + bombNumber);
        time.setText("Time: " + timeNumber);

        if (bomberman.isLife())
            if (running) {
                Image pauseGame = new Image(new File("res/textures/pause.png").toURI().toString());
                statusGame.setImage(pauseGame);
                root.getChildren().remove(authorView);
            } else {
                Image playGame = new Image(new File("res/textures/play.png").toURI().toString());
                statusGame.setImage(playGame);
            }
        else {
            Image newGame = new Image(new File("res/textures/start.png").toURI().toString());
            statusGame.setImage(newGame);
//            Image gameOver = new Image(new File("res/textures/gameOver.png").toURI().toString());
//            authorView.setImage(gameOver);
//            if (!root.getChildren().contains(authorView)) {
//                root.getChildren().add(authorView);
//            }
        }

    }
}
