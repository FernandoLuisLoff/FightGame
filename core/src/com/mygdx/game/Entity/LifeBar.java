package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameAssetManager.GameAssetManager;

public class LifeBar {
    private final GameAssetManager gameAssetManager;
    private Personagem personagem;
    private int widthImg;
    private int heightImg;
    private int imgX;
    private int imgY;

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public int getWidthImg() {
        return widthImg;
    }

    public int getHeightImg() {
        return heightImg;
    }

    public void setHeightImg(int heightImg) {
        this.heightImg = heightImg;
    }

    public int getImgX() {
        return imgX;
    }

    public void setImgX(int imgX) {
        this.imgX = imgX;
    }

    public int getImgY() {
        return imgY;
    }

    public void setImgY(int imgY) {
        this.imgY = imgY;
    }

    public LifeBar(GameAssetManager gameAssetManager, Personagem personagem, int heightImg, int widthImg, int imgX, int imgY) {
        this.gameAssetManager = gameAssetManager;
        this.personagem = personagem;
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.imgX = imgX;
        this.imgY = imgY;
    }

    public Texture getImg() {
        if (personagem.getLife() > 75) {
            return gameAssetManager.getManager().get("lifebar/life-bar_100.png", Texture.class);
        } else if (personagem.getLife() <= 75 && personagem.getLife() > 50) {
                return gameAssetManager.getManager().get("lifebar/life-bar_75.png", Texture.class);
        } else if (personagem.getLife() <= 50 && personagem.getLife() > 25) {
            return gameAssetManager.getManager().get("lifebar/life-bar_50.png", Texture.class);
        } else if (personagem.getLife() <= 25 && personagem.getLife() > 10) {
            return gameAssetManager.getManager().get("lifebar/life-bar_25.png", Texture.class);
        } else {
            return gameAssetManager.getManager().get("lifebar/life-bar_10.png", Texture.class);
        }
    }
}
