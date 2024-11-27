package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class GameAssetManager {

    static AssetManager manager;

    public static AssetManager getManager() {
        return manager;
    }

    public void init () {
        manager = new AssetManager();

        manager.load("background/background.jpg", Texture.class);
        manager.load("background/exit.png", Texture.class);
        manager.load("hadouken/hadouken-left.png", Texture.class);
        manager.load("hadouken/hadouken-right.png", Texture.class);
        manager.load("players/player1/down_left.png", Texture.class);
        manager.load("players/player1/down_right.png", Texture.class);
        manager.load("players/player1/jump_left.png", Texture.class);
        manager.load("players/player1/jump_move_left.png", Texture.class);
        manager.load("players/player1/jump_move_right.png", Texture.class);
        manager.load("players/player1/jump_right.png", Texture.class);
        manager.load("players/player1/move_left.png", Texture.class);
        manager.load("players/player1/move_right.png", Texture.class);
        manager.load("players/player1/punch_left.png", Texture.class);
        manager.load("players/player1/punch_right.png", Texture.class);
        manager.load("players/player1/stop_left.png", Texture.class);
        manager.load("players/player1/stop_right.png", Texture.class);
        manager.load("players/player2/down_left.png", Texture.class);
        manager.load("players/player2/down_right.png", Texture.class);
        manager.load("players/player2/jump_left.png", Texture.class);
        manager.load("players/player2/jump_move_left.png", Texture.class);
        manager.load("players/player2/jump_move_right.png", Texture.class);
        manager.load("players/player2/jump_right.png", Texture.class);
        manager.load("players/player2/move_left.png", Texture.class);
        manager.load("players/player2/move_right.png", Texture.class);
        manager.load("players/player2/punch_left.png", Texture.class);
        manager.load("players/player2/punch_right.png", Texture.class);
        manager.load("players/player2/stop_left.png", Texture.class);
        manager.load("players/player2/stop_right.png", Texture.class);
        manager.load("lifebar/life-bar_10.png", Texture.class);
        manager.load("lifebar/life-bar_25.png", Texture.class);
        manager.load("lifebar/life-bar_50.png", Texture.class);
        manager.load("lifebar/life-bar_75.png", Texture.class);
        manager.load("lifebar/life-bar_100.png", Texture.class);

        manager.finishLoading();
    }

    public void dispose () {
        manager.dispose();
    }
}