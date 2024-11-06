package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ExitButton {
    private Texture img;
    private int imgX;
    private int imgY;
    private int buttonWidth;
    private int buttonHeight;

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
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

    public int getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public ExitButton(Texture img, int buttonWidth, int buttonHeight) {
        this.img = img;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;

        imgX = Gdx.graphics.getWidth() - buttonHeight;
        imgY = Gdx.graphics.getHeight() - buttonHeight;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(img, imgX, imgY, buttonWidth, buttonHeight);
    }

    public void dispose() {
        img.dispose();
    }
}
