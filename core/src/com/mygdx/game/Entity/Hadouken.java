package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Enum.HadoukenPositions;

public class Hadouken {
    Texture img;

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

    public Texture getImg() {
        return img;
    }

    public Hadouken(Texture img) {
        this.img = img;
    }

    public void setImg(Texture img) {
        this.img = img;
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

    public Hadouken(HadoukenPositions position, int widthImg, int heightImg, float imgX, float imgY, float speed) {
        this.position = position;
        this.img = getImgPosition();
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.imgX = imgX;
        this.imgY = imgY;
        this.speed = speed;
    }

    public Texture getImgPosition() {
        switch (position) {
            case RIGHT:
                return new Texture("hadouken/hadouken-right.png");
            case LEFT:
                return new Texture("hadouken/hadouken-left.png");
            default:
                return new Texture("hadouken/hadouken-right.png");
        }
    }

    public void updateImg(Texture newImg) {
        img.dispose();
        img = newImg;
    }

    public boolean isOffScreen() {
        return imgX > Gdx.graphics.getWidth() + 50 || imgX < -50;
    }

    public void dispose() {
        img.dispose();
    }
}
