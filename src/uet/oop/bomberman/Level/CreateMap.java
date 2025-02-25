package uet.oop.bomberman.Level;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Animals.Balloom;
import uet.oop.bomberman.entities.Animals.Doll;
import uet.oop.bomberman.entities.Animals.Minvo;
import uet.oop.bomberman.entities.Animals.Oneal;
import uet.oop.bomberman.entities.Decor.Flag;
import uet.oop.bomberman.entities.Decor.Torch;
import uet.oop.bomberman.entities.Items.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static uet.oop.bomberman.BombermanGame.*;

public class CreateMap {
    public CreateMap(String path) {
        try {
            FileReader reader = new FileReader(path);
            BufferedReader buffRead = new BufferedReader(reader);
            String firstLine = buffRead.readLine();
            int L = 0, R = 0, C = 0;

            String[] tokens = firstLine.split(" ");
            L = Integer.parseInt(tokens[0]);
            R = Integer.parseInt(tokens[1]);
            C = Integer.parseInt(tokens[2]);

            _level = L;

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
//                            object = new Grass(j, i, Sprite.grass.getFxImage());
//                            stillObjects.add(object);
                            if (i == R - 1)
                                object = new Wall(j, i, Sprite.wall_bottom.getFxImage());

                            else if (i == 0 && j == 2)
                                object = new Wall(j, i, Sprite.gate_left.getFxImage());
                            else if (i == 0 && j == 3)
                                object = new Wall(j, i, Sprite.gate_right.getFxImage());

                            else if(i !=0 && j != 0 && i != R - 1 && j != C - 1)
                                object = new Wall(j, i, Wall.selectWall());
                            else
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
                        case '&': {
                            object = new Wall(j, i, Sprite.wall.getFxImage());
                            stillObjects.add(object);
                            object = new Torch(j, i, Sprite.torch.getFxImage());
                            stillObjects.add(object);
                            break;
                        }
                        case '%': {
                            object = new Wall(j, i, Sprite.wall.getFxImage());
                            stillObjects.add(object);
                            object = new Flag(j, i, Sprite.flag.getFxImage());
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
                            object = new Doll(j, i, Sprite.doll_left1.getFxImage());
                            entities.add(object);
                            break;
                        }
                        case '3': {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                            stillObjects.add(object);
                            object = new Minvo(j, i, Sprite.minvo_left1.getFxImage());
                            entities.add(object);
                            break;
                        }
                        case '4': {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                            stillObjects.add(object);
                            object = new Oneal(j, i, Sprite.oneal_left1.getFxImage());
                            entities.add(object);
                            break;
                        }
                        case 'b': {
                            object = new Bombpass(j, i, Sprite.powerup_bombpass.getFxImage());
                            itemsList.add(object);
                            object = new Vase(j, i, Sprite.vase.getFxImage());
                            stillObjects.add(object);
                            break;
                        }
                        case 'w': {
                            object = new Wallpass(j, i, Sprite.powerup_wallpass.getFxImage());
                            itemsList.add(object);
                            object = new Vase(j, i, Sprite.vase.getFxImage());
                            stillObjects.add(object);
                            break;
                        }

                        case 'f': {
                            object = new FlameSpread(j, i, Sprite.powerup_flames.getFxImage());
                            itemsList.add(object);
                            object = new Vase(j, i, Sprite.vase.getFxImage());
                            stillObjects.add(object);
                            break;
                        }

                        case '?': {
                            object = new Random(j, i, Sprite.powerup_random.getFxImage());
                            itemsList.add(object);
                            object = new Vase(j, i, Sprite.vase.getFxImage());
                            stillObjects.add(object);
                            break;
                        }
                        case 't': {
                            object = new ExtraTime(j, i, Sprite.powerup_extratime.getFxImage());
                            itemsList.add(object);
                            object = new Vase(j, i, Sprite.vase.getFxImage());
                            stillObjects.add(object);
                            break;
                        }

                        case '^': {
                            object = new ExtraTrap(j, i, Sprite.powerup_extratrap.getFxImage());
                            itemsList.add(object);
                            object = new Vase(j, i, Sprite.vase.getFxImage());
                            stillObjects.add(object);
                            break;
                        }

                        case 'l': {
                            object = new ExtraLife(j, i, Sprite.powerup_extralife.getFxImage());
                            itemsList.add(object);
                            object = new Vase(j, i, Sprite.vase.getFxImage());
                            stillObjects.add(object);
                            break;
                        }

                        default: {
                            object = new Grass(j, i, Grass.selectGrass());
                            stillObjects.add(object);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
