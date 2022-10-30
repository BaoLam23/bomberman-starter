package uet.oop.bomberman.Level;

import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Menu.setTimeNumber;

public class Level3 {
    public Level3() {
        bomberman.setLife(true);
        bomberman.setThrough(false);
        bomberman.setBombPass(false);
        bomberman.setSprite(Sprite.player_right.getFxImage());
        bomberman.setX(32);
        bomberman.setY(32);
        entities.clear();
        stillObjects.clear();
        killObjects.clear();
        setTimeNumber(150);
        new CreateMap("res/levels/Level3.txt");
    }
}
