package uet.oop.bomberman;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.control.Menu;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Animals.Animal;
import uet.oop.bomberman.entities.Animals.Bomber;
import uet.oop.bomberman.entities.Items.FlameSpread;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.Level.LevelUp.levelUp;
import static uet.oop.bomberman.Level.LevelUp.win;
import static uet.oop.bomberman.control.Menu.updateMenu;
import static uet.oop.bomberman.entities.Portal.isPortal;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static Group root;
    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static List<Entity> killObjects = new ArrayList<>();
    public static List<Entity> itemsList = new ArrayList<>();
    public static Entity portal = null;
    public static Animal bomberman;


    public static boolean running;
    public static ImageView authorView;
    public static int _level = 1;
    public static Stage mainStage = null;

    private int bomberSpeed = 0;
    public static int numOfTraps = 3;
    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        canvas.setTranslateY(32);
        gc = canvas.getGraphicsContext2D();
        Image author = new Image(new File("res/textures/mainMenu.png").toURI().toString());
        authorView = new ImageView(author);
        authorView.setY(32);

        root = new Group();
        Menu.createMenu(root);
        root.getChildren().add(canvas);
        root.getChildren().add(authorView);

        // Tao scene
        Scene scene = new Scene(root);


        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        bomberSpeed++;
                        if (true) {
                            switch (e.getCode()) {
                                case UP: {
                                    if (bomberSpeed < bomberman.getSpeed()) {
                                        bomberman.moveUp();
                                        if (bomberman.getSpriteNum() == 1) {
                                            bomberman.setSprite(Sprite.player_up.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_up_blue.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 2) {
                                            bomberman.setSprite(Sprite.player_up_1.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_up_blue1.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 3) {
                                            bomberman.setSprite(Sprite.player_up_2.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_up_blue2.getFxImage());
                                        }

                                        Sound.walking();

                                    }
                                    break;
                                }
                                case DOWN: {
                                    if (bomberSpeed < bomberman.getSpeed()) {
                                        bomberman.moveDown();
                                        if (bomberman.getSpriteNum() == 1) {
                                            bomberman.setSprite(Sprite.player_down.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_down_blue.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 2) {
                                            bomberman.setSprite(Sprite.player_down_1.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_down_1_blue.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 3) {
                                            bomberman.setSprite(Sprite.player_down_2.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_down_2_blue.getFxImage());
                                        }

                                        Sound.walking();

                                    }
                                    break;
                                }
                                case LEFT: {
                                    if (bomberSpeed < bomberman.getSpeed()) {
                                        bomberman.moveLeft();
                                        if (bomberman.getSpriteNum() == 1) {
                                            bomberman.setSprite(Sprite.player_left.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_left_blue.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 2) {
                                            bomberman.setSprite(Sprite.player_left_1.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_left_1_blue.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 3) {
                                            bomberman.setSprite(Sprite.player_left_2.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_left_2_blue.getFxImage());
                                        }

                                        Sound.walking();

                                    }
                                    break;
                                }
                                case RIGHT: {
                                    if (bomberSpeed < bomberman.getSpeed()) {
                                        bomberman.moveRight();
                                        if (bomberman.getSpriteNum() == 1) {
                                            bomberman.setSprite(Sprite.player_right.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_right_blue.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 2) {
                                            bomberman.setSprite(Sprite.player_right_1.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_right_1_blue.getFxImage());
                                        }

                                        if (bomberman.getSpriteNum() == 3) {
                                            bomberman.setSprite(Sprite.player_right_2.getFxImage());
                                            if (FlameSpread.getRemainingPasses() > 0)
                                                bomberman.setSprite(Sprite.player_right_2_blue.getFxImage());
                                        }

                                        Sound.walking();

                                    }
                                    break;
                                }
                                case SPACE: {
                                    Bomb.putBomb();
                                    break;
                                }
                                case SHIFT: {
                                    Trap.putTrap();
                                    break;
                                }

                            }


                            CompletableFuture.delayedExecutor(120, TimeUnit.MILLISECONDS).execute(() -> bomberSpeed--);
                        }
                    }


                });
        // Them scene vao stage
        stage.setScene(scene);
        mainStage = stage;
        mainStage.show();
        //stage.show();

//        Sound.startJingle();
        Sound.gameStart();

        // play background music
        Sound.backgroundNoise();

        CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS).execute(() -> {
            Sound.backgroundMusic();
            Sound.backgroundNoise2();
        });



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (running) {
                    render();
                    update();
                    updateMenu();
                }

            }
        };
        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());

        bomberman.setLife(false);
        timer.start();

    }


    public void update() {

        itemsList.forEach(Entity::update);
        entities.forEach(Entity::update);
        stillObjects.forEach(Entity::update);
        killObjects.forEach(Entity::update);
        bomberman.update();

        if (entities.size() == 0 && !isPortal && !win) {
            portal = new Portal(3, 4, Sprite.portal.getFxImage());
            isPortal = true;
            entities.add(portal);
        }
        if (portal != null && isPortal) {
            if (bomberman.getX() == portal.getX() && bomberman.getY() == portal.getY()) {
                win = true;
            }
        }

        levelUp();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        itemsList.forEach(g -> g.render(gc));
        stillObjects.forEach(g -> g.render(gc));
        killObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
