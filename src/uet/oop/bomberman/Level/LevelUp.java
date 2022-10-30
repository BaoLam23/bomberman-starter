package uet.oop.bomberman.Level;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Portal.isPortal;
public class LevelUp {
    public static boolean win;

    public static void levelUp() {
        if (win) {
            switch (_level) {
                case 0: {
                    isPortal = false;
                    entities.remove(portal);
                    new Level1();
                    break;
                }
                case 1: {
                    isPortal = false;
                    entities.remove(portal);
                    new Level2();
                    break;
                }
                case 2: {
                    isPortal = false;
                    entities.remove(portal);
                    new Level3();
                    break;
                }
                case 3: {
                    isPortal = false;
                    entities.remove(portal);
                    new Level0();
                }
            }
            win = false;
        }
    }
}
