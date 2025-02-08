package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class TexturesPlayer {
    private static AssetManager manager;
    private String pathPlayerDown;
    private String pathPlayerJump;
    private String pathPlayerMove;
    private String pathPlayerPunch;
    private String pathPlayerStop;
    private String pathPlayerStunned;
    private String pathPlayerHiting;
    private String pathPlayerHadoukenAttack;
    private String pathPlayerKO;
    private String pathPlayerWinner;

    public TexturesPlayer(AssetManager manager, String pathPlayerDown, String pathPlayerJump, String pathPlayerMove, String pathPlayerPunch, String pathPlayerStop, String pathPlayerStunned, String pathPlayerHiting, String pathPlayerHadoukenAttack, String pathPlayerKO, String pathPlayerWinner) {
        this.manager = manager;
        this.pathPlayerDown = pathPlayerDown;
        this.pathPlayerJump = pathPlayerJump;
        this.pathPlayerMove = pathPlayerMove;
        this.pathPlayerPunch = pathPlayerPunch;
        this.pathPlayerStop = pathPlayerStop;
        this.pathPlayerStunned = pathPlayerStunned;
        this.pathPlayerHiting = pathPlayerHiting;
        this.pathPlayerHadoukenAttack = pathPlayerHadoukenAttack;
        this.pathPlayerKO = pathPlayerKO;
        this.pathPlayerWinner = pathPlayerWinner;
    }

    public Texture getPlayerDown() {
        return manager.get(pathPlayerDown, Texture.class);
    }

    public Texture getPlayerJump() {
        return manager.get(pathPlayerJump, Texture.class);
    }

    public Texture getPlayerMove() {
        return manager.get(pathPlayerMove, Texture.class);
    }

    public Texture getPlayerPunch() {
        return manager.get(pathPlayerPunch, Texture.class);
    }

    public Texture getPlayerStop() {
        return manager.get(pathPlayerStop, Texture.class);
    }

    public Texture getPlayerStunned() {
        return manager.get(pathPlayerStunned, Texture.class);
    }

    public Texture getPlayerHiting() {
        return manager.get(pathPlayerHiting, Texture.class);
    }

    public Texture getPlayerHadoukenAttack() {
        return manager.get(pathPlayerHadoukenAttack, Texture.class);
    }

    public Texture getPlayerWinner() { return manager.get(pathPlayerWinner, Texture.class); }

    public Texture getPlayerKO() { return manager.get(pathPlayerKO, Texture.class); }
}
