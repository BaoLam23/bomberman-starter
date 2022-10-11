package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.stillObjects;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Blocked {
    public static boolean blockedUp() {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (bomberman.getX() == e.getX() && bomberman.getY() - SCALED_SIZE == e.getY()) {
                return true;
            }
        }
        return false;
    }
    public static boolean blockedDown() {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (bomberman.getX() == e.getX() && bomberman.getY() + SCALED_SIZE == e.getY()) {
                return true;
            }
        }
        return false;
    }

    public static boolean blockedLeft() {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (bomberman.getX() - SCALED_SIZE == e.getX() && bomberman.getY() == e.getY()) {
                return true;
            }
        }
        return false;
    }

    public static boolean blockedRight() {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (bomberman.getX() + SCALED_SIZE == e.getX() && bomberman.getY()== e.getY()) {
                return true;
            }
        }
        return false;
    }
}
