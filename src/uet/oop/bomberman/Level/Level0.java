package uet.oop.bomberman.Level;

import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Menu.setTimeNumber;

public class Level0 {
    public Level0() {
        bomberman.setLife(true);
        bomberman.setNumOfLives(3);
        bomberman.setThrough(false);
        bomberman.setBombPass(false);
        bomberman.setSprite(Sprite.player_right.getFxImage());
        bomberman.setX(32);
        bomberman.setY(32);
        numOfTraps = 3;
        entities.clear();
        stillObjects.clear();
        killObjects.clear();
        itemsList.clear();
        setTimeNumber(70);
        new CreateMap("res/levels/Level0.txt");
    }
}
