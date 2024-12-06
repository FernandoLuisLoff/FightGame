package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.MyGdxGame;

public class ExitButton {
    private MyGdxGame game;

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

    public ExitButton(MyGdxGame game) {
        this.game = game;
        this.buttonWidth = 100;
        this.buttonHeight = 100;

        imgX = Gdx.graphics.getWidth() - buttonHeight;
        imgY = Gdx.graphics.getHeight() - buttonHeight;
    }

    public void draw() {
        game.getBatch().draw( game.getGameAssetManager().getManager().get("background/exit.png", Texture.class), imgX, imgY, buttonWidth, buttonHeight );
    }

}
