package uet.oop.bomberman.Level;

import static uet.oop.bomberman.BombermanGame.*;

public class Level1 {
    public Level1() {
        bomberman.setLife(true);
        entities.clear();
        stillObjects.clear();
        killObjects.clear();
        new CreateMap("res/levels/Level1.txt");
    }
}
