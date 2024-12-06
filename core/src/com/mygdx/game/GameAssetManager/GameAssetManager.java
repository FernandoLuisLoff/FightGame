package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GameAssetManager {

    static AssetManager manager;

    public static AssetManager getManager() {
        return manager;
    }

    public void init () {
        manager = new AssetManager();

        // BackGround
        manager.load("background/background.jpg", Texture.class);

        // Exit
        manager.load("background/exit.png", Texture.class);

        // Hadouken
        manager.load("hadouken/hadouken-left.png", Texture.class);
        manager.load("hadouken/hadouken-right.png", Texture.class);

        // Player 1
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

        // PLayer 2
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

        // LifeBar
        manager.load("lifebar/life-bar_10.png", Texture.class);
        manager.load("lifebar/life-bar_25.png", Texture.class);
        manager.load("lifebar/life-bar_50.png", Texture.class);
        manager.load("lifebar/life-bar_75.png", Texture.class);
        manager.load("lifebar/life-bar_100.png", Texture.class);

        // EnergyBar
        manager.load("energybar/energyBar_0.png", Texture.class);
        manager.load("energybar/energyBar_20.png", Texture.class);
        manager.load("energybar/energyBar_40.png", Texture.class);
        manager.load("energybar/energyBar_60.png", Texture.class);
        manager.load("energybar/energyBar_80.png", Texture.class);
        manager.load("energybar/energyBar_100.png", Texture.class);

        // Sounds
        manager.load("sounds/background_music.mp3", Music.class);
        manager.load("sounds/1.mp3", Sound.class);
        manager.load("sounds/2.mp3", Sound.class);
        manager.load("sounds/3.mp3", Sound.class);
        manager.load("sounds/end_game.wav", Sound.class);
        manager.load("sounds/fight.mp3", Sound.class);
        manager.load("sounds/grunt.mp3", Sound.class);
        manager.load("sounds/hadooken.mp3", Sound.class);
        manager.load("sounds/hadouken_out_screen.wav", Sound.class);
        manager.load("sounds/hadouken_sound.wav", Sound.class);
        manager.load("sounds/punch_sound.wav", Sound.class);
        manager.load("sounds/uggh.mp3", Sound.class);

        manager.finishLoading();
    }

    public void dispose () {
        manager.dispose();
    }
}