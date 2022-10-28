package uet.oop.bomberman.entities.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

import static uet.oop.bomberman.BombermanGame.stillObjects;

public abstract class Item extends Entity {
    private boolean getItem = false;
    //private boolean hidden = true;
    public Item(int x, int y, Image img) {
        super(x, y, img);
    }

    public Item() {}
    public Item(boolean getItem) {
        this.getItem = getItem;
    }

    public boolean isGetItem() {
        return getItem;
    }

    public void setGetItem(boolean getItem) {
        this.getItem = getItem;
    }

//    public void check() {
//        for (Entity entity : stillObjects) {
//
//        }
//    }

    @Override
    public void setSprite(Image newSprite) {
    }

    @Override
    public void update() {

    }
}
