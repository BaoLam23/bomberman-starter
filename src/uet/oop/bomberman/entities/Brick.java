package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {
    private String type;
    public boolean isBroken = false;
    public Brick() {}
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void chooseType() {
        int tmp = (int) (Math.random() * 10 + 1);
        switch (tmp) {
            case 1: {
                this.setType("TABLE");
                break;
            }
            case 2: {
                this.setType("CHAIR");
                break;
            }
            default: {
                this.setType("BRICK");
            }
        }
    }

    public Image selectType() {
        String tmp = this.getType();
        Image img = null;
        switch (tmp) {
            case "TABLE": {
                img = Sprite.table.getFxImage();
                return img;
            }
            case "CHAIR": {
                img = Sprite.chair.getFxImage();
                return img;
            }
            case "BRICK": {
                img = Sprite.brick.getFxImage();
                return img;
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 100) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }
        //System.out.println(isBroken);

        if (isBroken) {
            //System.out.println(4);
            if (getSpriteNum() == 1)
                setSprite(Sprite.brick_exploded.getFxImage());
            if (getSpriteNum() == 2)
                setSprite(Sprite.brick_exploded1.getFxImage());
            if (getSpriteNum() == 3)
                setSprite(Sprite.brick_exploded2.getFxImage());
//            if (this.getType() != null) {
//                System.out.println(this.getType());
//                switch (this.getType()) {
//                    case "BRICK":
//                        System.out.println(2);
//                        if (getSpriteNum() == 1)
//                            setSprite(Sprite.brick_exploded.getFxImage());
//
//                        if (getSpriteNum() == 2)
//                            setSprite(Sprite.brick_exploded1.getFxImage());
//
//                        if (getSpriteNum() == 3)
//                            setSprite(Sprite.brick_exploded2.getFxImage());
//                        System.out.println(3);
//                        break;
//                    case "TABLE":
//                        if (getSpriteNum() == 1)
//                            setSprite(Sprite.table.getFxImage());
//
//                        if (getSpriteNum() == 2)
//                            setSprite(Sprite.table_exploded.getFxImage());
//
//                        if (getSpriteNum() == 3)
//                            setSprite(Sprite.table_exploded2.getFxImage());
//                        break;
//                    case "CHAIR":
//                        if (getSpriteNum() == 1)
//                            setSprite(Sprite.chair.getFxImage());
//
//                        if (getSpriteNum() == 2)
//                            setSprite(Sprite.chair_exploded.getFxImage());
//
//                        if (getSpriteNum() == 3)
//                            setSprite(Sprite.chair_exploded2.getFxImage());
//                        break;
//                }
//            }

        }
    }
}
