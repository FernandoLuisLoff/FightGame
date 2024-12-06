package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameAssetManager.GameAssetManager;

public class StatusBar {
    private final GameAssetManager gameAssetManager;
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

    public StatusBar(GameAssetManager gameAssetManager, Personagem personagem, int heightLifeBar, int widthLifeBar, int heightEnergyBar, int widthEnergyBar, int imgX, int imgY) {
        this.gameAssetManager = gameAssetManager;
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
            return gameAssetManager.getManager().get("lifebar/life-bar_100.png", Texture.class);
        } else if (personagem.getLife() < 100 && personagem.getLife() >= 75) {
                return gameAssetManager.getManager().get("lifebar/life-bar_75.png", Texture.class);
        } else if (personagem.getLife() < 75 && personagem.getLife() >= 50) {
            return gameAssetManager.getManager().get("lifebar/life-bar_50.png", Texture.class);
        } else if (personagem.getLife() < 50 && personagem.getLife() >= 25) {
            return gameAssetManager.getManager().get("lifebar/life-bar_25.png", Texture.class);
        } else {
            return gameAssetManager.getManager().get("lifebar/life-bar_10.png", Texture.class);
        }
    }

    public Texture getEnergyBar() {
        if (personagem.getEnergy() >= 100) {
            return gameAssetManager.getManager().get("energybar/energyBar_100.png", Texture.class);
        } else if (personagem.getEnergy() <= 80 && personagem.getEnergy() > 60) {
            return gameAssetManager.getManager().get("energybar/energyBar_80.png", Texture.class);
        } else if (personagem.getEnergy() <= 60 && personagem.getEnergy() > 40) {
            return gameAssetManager.getManager().get("energybar/energyBar_60.png", Texture.class);
        } else if (personagem.getEnergy() <= 40 && personagem.getEnergy() > 20) {
            return gameAssetManager.getManager().get("energybar/energyBar_40.png", Texture.class);
        } else if (personagem.getEnergy() <= 20 && personagem.getEnergy() > 0) {
            return gameAssetManager.getManager().get("energybar/energyBar_20.png", Texture.class);
        } else {
            return gameAssetManager.getManager().get("energybar/energyBar_0.png", Texture.class);
        }
    }
}
