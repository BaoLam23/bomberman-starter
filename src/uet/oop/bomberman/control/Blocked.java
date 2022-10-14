package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Animals.Animal;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.stillObjects;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Blocked {
    public static boolean blockedUp(Animal animal) {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (animal.getX() == e.getX() && animal.getY() - SCALED_SIZE == e.getY()) {
                return true;
            }
        }
        return false;
    }
    public static boolean blockedDown(Animal animal) {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (animal.getX() == e.getX() && animal.getY() + SCALED_SIZE == e.getY()) {
                return true;
            }
        }
        return false;
    }

    public static boolean blockedLeft(Animal animal) {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (animal.getX() - SCALED_SIZE == e.getX() && animal.getY() == e.getY()) {
                return true;
            }
        }
        return false;
    }

    public static boolean blockedRight(Animal animal) {
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (animal.getX() + SCALED_SIZE == e.getX() && animal.getY()== e.getY()) {
                return true;
            }
        }
        return false;
    }
}
