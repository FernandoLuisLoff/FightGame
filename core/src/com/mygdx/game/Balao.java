package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Balao {

    public Balao(Texture img, int widthImg, int heightImg, float imgX, float imgY, float speed) {
        this.batch = new SpriteBatch();
        this.img = img;
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.initialImgX = imgX;
        this.initialImgY = imgY;
        this.imgX = imgX;
        this.imgY = imgY;
        this.speed = speed;
    }

    SpriteBatch batch;
    Texture img;

    int widthImg;
    int heightImg;

    float imgX;
    float imgY;

    float initialImgX;
    float initialImgY;

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

    float speed;

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Texture getImg() {
        return img;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void calcPosition() {
        if (!isOffScreen()) {
            imgY += speed;
        } else {
            imgX = initialImgX;
            imgY = initialImgY;
        }
    }

    public boolean isOffScreen() {
        return imgY > Gdx.graphics.getHeight() + 100;
    }

    public void draw() {
        calcPosition();

        batch.begin();
        batch.draw(img, imgX - widthImg/2, imgY - heightImg/2, widthImg, heightImg);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
