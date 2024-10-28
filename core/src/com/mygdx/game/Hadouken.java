package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hadouken {
    SpriteBatch batch;
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

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
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

    public Hadouken(HadoukenPositions position, int widthImg, int heightImg, float imgX, float imgY, float speed) {
        this.position = position;
        this.batch = new SpriteBatch();
        this.img = getImgPosition();
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.imgX = imgX;
        this.imgY = imgY;
        this.speed = speed;
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

    public void calcPosition() {
        if (position == HadoukenPositions.RIGHT) {
            imgX += speed;
        } else if (position == HadoukenPositions.LEFT) {
            imgX -= speed;
        }
    }

    public boolean isOffScreen() {
        return imgX > Gdx.graphics.getWidth() + 50 || imgX < -50;
    }

    public void draw() {
        if (!isOffScreen()) {
            calcPosition();

            batch.begin();
            batch.draw(img, imgX - widthImg / 2, imgY - heightImg / 2, widthImg, heightImg);
            batch.end();
        }
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
