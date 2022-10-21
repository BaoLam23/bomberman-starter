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
import uet.oop.bomberman.Level.Level1;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Menu {
    public static Button button = new Button();
    private static ImageView statusGame;
    public static Text level, bomb, time;
    public static int bombNumber = 20, timeNumber = 120;

    public static void createMenu(Group root) {
        level = new Text("Level: 1");
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.WHITE);
        level.setX(416);
        level.setY(20);
        bomb = new Text("Bombs: 20");
        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bomb.setFill(Color.WHITE);
        bomb.setX(512);
        bomb.setY(20);
        time = new Text("Times: 120");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.WHITE);
        time.setX(608);
        time.setY(20);

        Image newGame = new Image("newGame.png");
        //Image newGame = new Image("/textures/newGame.png");
        statusGame = new ImageView(newGame);
        statusGame.setX(-75);
        statusGame.setY(-10);
        statusGame.setScaleX(0.5);
        statusGame.setScaleY(0.5);


//        //Setting text to the button
//        button.setText("New game");
//        //Setting the location of the button
//        button.setTranslateX(150);
//        button.setTranslateY(10);


        Pane pane = new Pane();
        pane.getChildren().addAll(level, bomb, time, statusGame);
        pane.setMinSize(Sprite.SCALED_SIZE * WIDTH, 20);
        //pane.setMaxSize(800, 480);
        pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);

        button.setOnMouseClicked(actionEvent -> {
            if (bomberman.isLife()) {
                running = !running;
            } else {
                new Level1();
                running = true;
            }
            //button.setFocusTraversable(true);
            updateMenu();
//            pane.removeEventFilter(MouseEvent.MOUSE_CLICKED,
//                    new EventHandler<MouseEvent>() {
//                        public void handle(MouseEvent e) {
//                            System.out.println("mouse clicked");
//                        };
//                    });
        });
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
        level.setText("Level: " + _level);
        bomb.setText("Bombs: " + bombNumber);

        if (bomberman.isLife())
            if (running) {
                Image pauseGame = new Image("pauseGame.png");
                statusGame.setImage(pauseGame);
            } else {
                Image playGame = new Image("playGame.png");
                statusGame.setImage(playGame);
            }
        else {
            Image newGame = new Image("newGame.png");
            statusGame.setImage(newGame);
        }
//        if (bomberman.isLife())
//            if (running) {
//                button.setText("Pause");
//            } else {
//                button.setText("Play");
//            }
//        else {
//            button.setText("New");
//        }
    }
}
