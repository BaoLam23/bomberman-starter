package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Animals.Animal;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Wall;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.stillObjects;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Blocked {
    public static boolean blockedUp(Animal animal) {
        if (animal.isThrough()) {
            for (Entity e : stillObjects) {
                if (e instanceof Wall) {
                    if (e.getY() == 0 && animal.getY() - SCALED_SIZE == e.getY()) {
                        return true;
                    }
                }
            }
            return false;
        }
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
        if (animal.isThrough()) {
            for (Entity e : stillObjects) {
                if (e instanceof Wall) {
                    if (e.getY() == 384 && animal.getY() + SCALED_SIZE == e.getY()) {
                        return true;
                    }
                }
            }
            return false;
        }
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
        if (animal.isThrough()) {
            for (Entity e : stillObjects) {
                if (e instanceof Wall) {
                    if (e.getX() == 0 && animal.getX() - SCALED_SIZE == e.getX()) {
                        return true;
                    }
                }
            }
            return false;
        }
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
        if (animal.isThrough()) {
            for (Entity e : stillObjects) {
                if (e instanceof Wall) {
                    if (e.getX() == 960 && animal.getX() + SCALED_SIZE == e.getX()) {
                        return true;
                    }
                }
            }
            return false;
        }
        for (Entity e : stillObjects) {
            if (e instanceof Grass) {
                continue;
            } else if (animal.getX() + SCALED_SIZE == e.getX() && animal.getY()== e.getY()) {
                return true;
            }
        }
        return false;
    }
//    public static boolean blockedAround(Animal animal) {
//        for (Entity e : stillObjects) {
//            if (e instanceof Wall) {
//                if (e.getX() == 32 || e.getX() == 960 || e.getY() == 32 || e.getY() == 384) {
//                    return true;
//                }
//            }
//        }
//    }
}
