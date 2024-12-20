package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.MyGdxGame;

public class StatusBar {
    private MyGdxGame game;
    private Personagem personagem;
    private double timer;
    private int widthLifeBar;
    private int heightLifeBar;
    private int widthEnergyBar;
    private int heightEnergyBar;
    private int imgX;
    private int imgY;

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public double getTimer() {
        return timer;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }

    public int getWidthLifeBar() {
        return widthLifeBar;
    }

    public void setWidthLifeBar(int widthLifeBar) {
        this.widthLifeBar = widthLifeBar;
    }

    public int getHeightLifeBar() {
        return heightLifeBar;
    }

    public void setHeightLifeBar(int heightLifeBar) {
        this.heightLifeBar = heightLifeBar;
    }

    public int getWidthEnergyBar() {
        return widthEnergyBar;
    }

    public void setWidthEnergyBar(int widthEnergyBar) {
        this.widthEnergyBar = widthEnergyBar;
    }

    public int getHeightEnergyBar() {
        return heightEnergyBar;
    }

    public void setHeightEnergyBar(int heightEnergyBar) {
        this.heightEnergyBar = heightEnergyBar;
    }

    public void setheightLifeBar(int heightLifeBar) {
        this.heightLifeBar = heightLifeBar;
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

    public StatusBar(MyGdxGame game, Personagem personagem, int heightLifeBar, int widthLifeBar, int heightEnergyBar, int widthEnergyBar, int imgX, int imgY) {
        this.game = game;
        this.personagem = personagem;
        this.widthLifeBar = widthLifeBar;
        this.heightLifeBar = heightLifeBar;
        this.widthEnergyBar = widthEnergyBar;
        this.heightEnergyBar = heightEnergyBar;
        this.imgX = imgX;
        this.imgY = imgY;

        timer = 0.0;
    }

    public Texture getLifeBar() {
        if (personagem.getLife() >= 100) {
            return game.getGameAssetManager().getLifeBar100();
        } else if (personagem.getLife() < 100 && personagem.getLife() >= 75) {
                return game.getGameAssetManager().getLifeBar75();
        } else if (personagem.getLife() < 75 && personagem.getLife() >= 50) {
            return game.getGameAssetManager().getLifeBar50();
        } else if (personagem.getLife() < 50 && personagem.getLife() >= 25) {
            return game.getGameAssetManager().getLifeBar25();
        } else {
            return game.getGameAssetManager().getLifeBar10();
        }
    }

    public Texture getEnergyBar() {
        if (personagem.getEnergy() >= 100) {
            return game.getGameAssetManager().getEnergyBar100();
        } else if (personagem.getEnergy() <= 80 && personagem.getEnergy() > 60) {
            return game.getGameAssetManager().getEnergyBar80();
        } else if (personagem.getEnergy() <= 60 && personagem.getEnergy() > 40) {
            return game.getGameAssetManager().getEnergyBar60();
        } else if (personagem.getEnergy() <= 40 && personagem.getEnergy() > 20) {
            return game.getGameAssetManager().getEnergyBar40();
        } else if (personagem.getEnergy() <= 20 && personagem.getEnergy() > 0) {
            return game.getGameAssetManager().getEnergyBar20();
        } else {
            return game.getGameAssetManager().getEnergyBar0();
        }
    }
}
