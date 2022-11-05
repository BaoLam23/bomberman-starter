package uet.oop.bomberman.control;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.Level.Level0;
import uet.oop.bomberman.Level.Level1;
import uet.oop.bomberman.graphics.Sprite;
import java.io.File;

import static uet.oop.bomberman.BombermanGame.root;
import static uet.oop.bomberman.BombermanGame.*;

public class Menu {
    private static ImageView statusGame;
    public static Text level, time, traps, info;
    private static int timeNumber;
    private static int timeChanger = 0;

    public static void setTimeNumber(int timeNumber) {
        Menu.timeNumber = timeNumber;
    }

    public static int getTimeNumber() {
        return timeNumber;
    }


    public static void createMenu(Group root) {
        level = new Text("Level:");
        level.setFont(Font.loadFont("file:res/fonts/PixeloidSansBold-RpeJo.ttf", 14));
        level.setFill(Color.WHITE);
        level.setX(20);
        level.setY(20);

        time = new Text("Time:");
        time.setFont(Font.loadFont("file:res/fonts/PixeloidSansBold-RpeJo.ttf", 14));
        time.setFill(Color.WHITE);
        time.setX(120);
        time.setY(20);

        traps = new Text("Traps Left:");
        traps.setFont(Font.loadFont("file:res/fonts/PixeloidSansBold-RpeJo.ttf", 14));
        traps.setFill(Color.WHITE);
        traps.setX(230);
        traps.setY(20);

        info = new Text("SPACE for Bombs, SHIFT for Traps");
        info.setFont(Font.loadFont("file:res/fonts/PixeloidSansBold-RpeJo.ttf", 14));
        info.setFill(Color.WHITE);
        info.setX(500);
        info.setY(20);

        Image newGame = new Image(new File("res/textures/start.png").toURI().toString());
        statusGame = new ImageView(newGame);
        statusGame.setX(850);
        statusGame.setY(-14);
        statusGame.setScaleX(0.5);
        statusGame.setScaleY(0.5);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, time, traps, info, statusGame);
        pane.setMinSize(Sprite.SCALED_SIZE * WIDTH, 20);
        pane.setStyle("-fx-background-color: black");

        root.getChildren().add(pane);

        statusGame.setOnMouseClicked(event -> {
            if (bomberman.isLife()) {
                running = !running;
            } else {
                new Level0();
                running = true;
            }
            updateMenu();
        });

    }

    public static void updateMenu() {
        if (timeNumber > 0 && bomberman.isLife()) {
            timeChanger++;
            if (timeChanger > 60) {
                timeNumber--;
                timeChanger = 0;
            }
        }

        if (timeNumber == 60 && timeChanger == 0)
            Sound.sixtySecs();

        if (timeNumber == 30 && timeChanger == 0)
            Sound.thirtySecs();

        if (timeNumber == 10 && timeChanger == 0)
            Sound.tenSecs();

        level.setText("Level: " + _level);
        time.setText("Time: " + timeNumber);
        traps.setText("Traps Left: " + numOfTraps);

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
        }

    }
}
