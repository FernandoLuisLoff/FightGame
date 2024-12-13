package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class TexturesPlayer {
    private static AssetManager manager;
    private String pathPlayerDown;
    private String pathPlayerJumpMove;
    private String pathPlayerJump;
    private String pathPlayerMove;
    private String pathPlayerPunch;
    private String pathPlayerStop;

    public TexturesPlayer(AssetManager manager, String pathPlayerDown, String pathPlayerJumpMove, String pathPlayerJump, String pathPlayerMove, String pathPlayerPunch, String pathPlayerStop) {
        this.manager = manager;
        this.pathPlayerDown = pathPlayerDown;
        this.pathPlayerJumpMove = pathPlayerJumpMove;
        this.pathPlayerJump = pathPlayerJump;
        this.pathPlayerMove = pathPlayerMove;
        this.pathPlayerPunch = pathPlayerPunch;
        this.pathPlayerStop = pathPlayerStop;
    }

    public Texture getPlayerDown() {
        return manager.get(pathPlayerDown, Texture.class);
    }

    public Texture getPlayerJumpMove() {
        return manager.get(pathPlayerJumpMove, Texture.class);
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
}
