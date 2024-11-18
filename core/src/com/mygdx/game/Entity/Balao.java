package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameAssetManager.GameAssetManager;

public class Balao {
    private final GameAssetManager gameAssetManager;

    int widthImg;
    int heightImg;

    float imgX;
    float imgY;

    float initialImgX;
    float initialImgY;

    float speed;

    public float getInitialImgX() {
        return initialImgX;
    }

    public void setInitialImgX(float initialImgX) {
        this.initialImgX = initialImgX;
    }

    public float getInitialImgY() {
        return initialImgY;
    }

    public void setInitialImgY(float initialImgY) {
        this.initialImgY = initialImgY;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isOffScreen() {
        return imgY > Gdx.graphics.getHeight() + 100;
    }

    public Balao( GameAssetManager gameAssetManager, int widthImg, int heightImg, float imgX, float imgY, float speed) {
        this.gameAssetManager = gameAssetManager;
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.initialImgX = imgX;
        this.initialImgY = imgY;
        this.imgX = imgX;
        this.imgY = imgY;
        this.speed = speed;
    }

    public Texture getImg() {
        return gameAssetManager.getManager().get("balao/balao.png", Texture.class);
    }

    public boolean hit(float x, float y) {
        return ( ( x > imgX && x < imgX + widthImg ) && (y > imgY && y < imgY + heightImg ) );
    }
}
