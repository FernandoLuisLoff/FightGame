package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameAssetManager.GameAssetManager;

public class ExitButton {
    private final GameAssetManager gameAssetManager;
    private int imgX;
    private int imgY;
    private int buttonWidth;
    private int buttonHeight;

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

    public ExitButton(GameAssetManager gameAssetManager, int buttonWidth, int buttonHeight) {
        this.gameAssetManager = gameAssetManager;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;

        imgX = Gdx.graphics.getWidth() - buttonHeight;
        imgY = Gdx.graphics.getHeight() - buttonHeight;
    }

    public void draw(SpriteBatch batch) {
        batch.draw( gameAssetManager.getManager().get("background/exit.png", Texture.class), imgX, imgY, buttonWidth, buttonHeight );
    }

}
