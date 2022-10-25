package uet.oop.bomberman.Level;

import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame._level;
import static uet.oop.bomberman.entities.Portal.isPortal;
public class LevelUp {
    public static boolean win;

    public static void levelUp() {
        if (win) {
            //Image waitToNext = new Image("images/levelUp.png");
            //authorView.setImage(waitToNext);
            //long now = System.currentTimeMillis();
            switch (_level) {
                case 1:
                    isPortal = false;
                    new Level2();
                    break;
//                case 2:
//                    new Level3();
//                    break;
//                case 3:
//                    new Level1();
            }
            win = false;
        }
    }
}
