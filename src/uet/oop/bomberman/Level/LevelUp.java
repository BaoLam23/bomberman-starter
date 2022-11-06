package uet.oop.bomberman.Level;

import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Items.FlameSpread;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Portal.isPortal;
public class LevelUp {
    public static boolean win;

    public static void levelUp() {
        if (win) {
            FlameSpread.setRemainingPasses(0);
            switch (_level) {
                case 0: {
                    isPortal = false;
                    entities.remove(portal);
                    new Level1();
                    Sound.startJingle();
                    break;
                }
                case 1: {
                    isPortal = false;
                    entities.remove(portal);
                    new Level2();
                    Sound.startJingle();
                    break;
                }
                case 2: {
                    isPortal = false;
                    entities.remove(portal);
                    new Level3();
                    Sound.startJingle();
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
