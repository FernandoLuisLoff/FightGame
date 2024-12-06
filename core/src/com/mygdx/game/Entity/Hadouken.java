package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Enum.HadoukenPositions;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.MyGdxGame;

public class Hadouken {
    private MyGdxGame game;

    int widthImg;
    int heightImg;

    float imgX;
    float imgY;

    HadoukenPositions position;

    float speed;

    public HadoukenPositions getPosition() {
        return position;
    }

    public void setPosition(HadoukenPositions position) {
        this.position = position;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


    public int getWidthImg() {
        return widthImg;
    }

    public void setWidthImg(int widthImg) {
        this.widthImg = widthImg;
    }

    public int getHeightImg() {
        return heightImg;
    }

    public void setHeightImg(int heightImg) {
        this.heightImg = heightImg;
    }

    public float getImgX() {
        return imgX;
    }

    public void setImgX(float imgX) {
        this.imgX = imgX;
    }

    public float getImgY() {
        return imgY;
    }

    public void setImgY(float imgY) {
        this.imgY = imgY;
    }

    public Hadouken(MyGdxGame game, HadoukenPositions position, int widthImg, int heightImg, float imgX, float imgY, float speed) {
        this.game = game;
        this.position = position;
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.imgX = imgX;
        this.imgY = imgY;
        this.speed = speed;
    }

    public Texture getImg() {
        switch (position) {
            case RIGHT:
                return game.getGameAssetManager().getManager().get("hadouken/hadouken-right.png", Texture.class);
            case LEFT:
                return game.getGameAssetManager().getManager().get("hadouken/hadouken-left.png", Texture.class);
            default:
                return game.getGameAssetManager().getManager().get("hadouken/hadouken-right.png", Texture.class);
        }
    }

    public boolean isOffScreen() {
        return imgX > Gdx.graphics.getWidth() + 50 || imgX < -50;
    }
}
