package uet.oop.bomberman.Level;

import static uet.oop.bomberman.BombermanGame.*;

public class Level2 {
    public Level2() {
        bomberman.setLife(true);
        bomberman.setX(32);
        bomberman.setY(32);
        entities.clear();
        stillObjects.clear();
        killObjects.clear();
        new CreateMap("res/levels/Level2.txt");
    }
}
