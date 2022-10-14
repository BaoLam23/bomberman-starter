package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Animals.Animal;
import uet.oop.bomberman.entities.Animals.Balloom;
import uet.oop.bomberman.entities.Animals.Bomber;
import uet.oop.bomberman.entities.Animals.Oneal;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;
    
    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static List<Entity> killObjects = new ArrayList<>();
    public static Animal bomberman;


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();


        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        // play background music
        Sound.backgroundMusic();

        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        //entities.add(bomberman);

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        switch (e.getCode()) {
                            case UP: {
                                ((Bomber) bomberman).moveUp();
                                if(bomberman.getSpriteNum() == 1)
                                    bomberman.setSprite(Sprite.player_up.getFxImage());

                                if(bomberman.getSpriteNum() == 2)
                                    bomberman.setSprite(Sprite.player_up_1.getFxImage());

                                if(bomberman.getSpriteNum() == 3)
                                    bomberman.setSprite(Sprite.player_up_2.getFxImage());
                                break;
                            }
                            case DOWN: {
                                ((Bomber) bomberman).moveDown();
                                if(bomberman.getSpriteNum() == 1)
                                    bomberman.setSprite(Sprite.player_down.getFxImage());

                                if(bomberman.getSpriteNum() == 2)
                                    bomberman.setSprite(Sprite.player_down_1.getFxImage());

                                if(bomberman.getSpriteNum() == 3)
                                    bomberman.setSprite(Sprite.player_down_2.getFxImage());
                                break;
                            }
                            case LEFT: {
                                ((Bomber) bomberman).moveLeft();
                                if(bomberman.getSpriteNum() == 1)
                                    bomberman.setSprite(Sprite.player_left.getFxImage());

                                if(bomberman.getSpriteNum() == 2)
                                    bomberman.setSprite(Sprite.player_left_1.getFxImage());

                                if(bomberman.getSpriteNum() == 3)
                                    bomberman.setSprite(Sprite.player_left_2.getFxImage());
                                break;
                            }
                            case RIGHT: {
                                ((Bomber) bomberman).moveRight();
                                if(bomberman.getSpriteNum() == 1)
                                    bomberman.setSprite(Sprite.player_right.getFxImage());

                                if(bomberman.getSpriteNum() == 2)
                                    bomberman.setSprite(Sprite.player_right_1.getFxImage());

                                if(bomberman.getSpriteNum() == 3)
                                    bomberman.setSprite(Sprite.player_right_2.getFxImage());
                                break;
                            }
                            case SPACE: {
                                Bomb.putBomb();
                                break;
                            }

                        }
                    }
                });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();

            }
        };

        timer.start();

        createMap();


    }

    public void createMap() {
        try {
            FileReader reader = new FileReader("res/levels/Level1.txt");
            BufferedReader buffRead = new BufferedReader(reader);
            String firstLine = buffRead.readLine();
            System.out.println(firstLine);
            int L = 0, R = 0, C = 0;

            String[] tokens = firstLine.split(" ");
            L = Integer.parseInt(tokens[0]);
            R = Integer.parseInt(tokens[1]);
            C = Integer.parseInt(tokens[2]);

            char[][] matrix = null;

            matrix = new char[R][C];

            for (int i = 0; i < R; i++) {
                String line = buffRead.readLine();
                for (int j = 0; j < C; j++) {
                    char character = line.charAt(j);
                    matrix[i][j] = character;
                }


            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    Entity object = null;
                    switch (matrix[i][j]) {
                        case '#': {
                            object = new Wall(j, i, Sprite.wall.getFxImage());
                            stillObjects.add(object);
                            break;
                        }
                        case '*': {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                            stillObjects.add(object);
                            object = new Brick(j, i, Sprite.brick.getFxImage());
                            stillObjects.add(object);
                            break;
                        }
                        case 'x': {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                            stillObjects.add(object);
                            object = new Portal(j, i, Sprite.portal.getFxImage());
                            stillObjects.add(object);
                            break;
                        }
                        case '1': {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                            stillObjects.add(object);
                            object = new Balloom(j, i, Sprite.balloom_left1.getFxImage());
                            entities.add(object);
                            break;
                        }
                        case '2': {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                            stillObjects.add(object);
                            object = new Oneal(j, i, Sprite.oneal_left1.getFxImage());
                            entities.add(object);
                            break;
                        }
                        default: {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                            stillObjects.add(object);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public void update() {
        entities.forEach(Entity::update);
        stillObjects.forEach(Entity::update);
        killObjects.forEach(Entity::update);
        bomberman.update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        killObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
