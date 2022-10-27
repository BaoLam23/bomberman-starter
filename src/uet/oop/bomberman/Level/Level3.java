package uet.oop.bomberman.Level;

import static uet.oop.bomberman.BombermanGame.*;

public class Level3 {
    public Level3() {
        bomberman.setLife(true);
        bomberman.setX(32);
        bomberman.setY(32);
        entities.clear();
        stillObjects.clear();
        killObjects.clear();
        new CreateMap("res/levels/Level3.txt");
    }
}
