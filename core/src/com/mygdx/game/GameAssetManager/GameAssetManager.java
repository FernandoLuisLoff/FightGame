package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameAssetManager {
    private static AssetManager manager;

    public static AssetManager getManager() {
        return manager;
    }

    private final String pathBackground = "background/background.jpg";
    private final String pathExit = "background/exit.png";

    private AnimationHadouken animationHadouken;
    private final String pathHadouken = "hadouken/hadouken.png";

    private TexturesPlayer player1Textures;
    private AnimationPlayer animationPlayer1;
    private final String pathPlayer1Down = "players/player1/player_down.png";
    private final String pathPlayer1Jump = "players/player1/player_jump.png";
    private final String pathPlayer1Move = "players/player1/player_move.png";
    private final String pathPlayer1Punch = "players/player1/player_punch.png";
    private final String pathPlayer1Stop = "players/player1/player_stop.png";
    private final String pathPlayer1Stunned = "players/player1/player_stunned.png";
    private final String pathPlayer1Hiting = "players/player1/player_hiting.png";
    private final String pathPlayer1HadoukenAttack = "players/player1/player_hadouken_attack.png";
    private final String pathPlayer1KO = "players/player1/player_ko.png";
    private final String pathPlayer1Winner = "players/player1/player_winner.png";

    private TexturesPlayer player2Textures;

    private AnimationPlayer animationPlayer2;
    private final String pathPlayer2Down = "players/player2/player_down.png";
    private final String pathPlayer2Jump = "players/player2/player_jump.png";
    private final String pathPlayer2Move = "players/player2/player_move.png";
    private final String pathPlayer2Punch = "players/player2/player_punch.png";
    private final String pathPlayer2Stop = "players/player2/player_stop.png";
    private final String pathPlayer2Stunned = "players/player2/player_stunned.png";
    private final String pathPlayer2Hiting = "players/player2/player_hiting.png";
    private final String pathPlayer2HadoukenAttack = "players/player2/player_hadouken_attack.png";
    private final String pathPlayer2KO = "players/player2/player_ko.png";
    private final String pathPlayer2Winner = "players/player2/player_winner.png";

    private final String pathLifeBar10 = "lifebar/life-bar_10.png";
    private final String pathLifeBar25 = "lifebar/life-bar_25.png";
    private final String pathLifeBar50 = "lifebar/life-bar_50.png";
    private final String pathLifeBar75 = "lifebar/life-bar_75.png";
    private final String pathLifeBar100 = "lifebar/life-bar_100.png";

    private final String pathEnergyBar0 = "energybar/energyBar_0.png";
    private final String pathEnergyBar20 = "energybar/energyBar_20.png";
    private final String pathEnergyBar40 = "energybar/energyBar_40.png";
    private final String pathEnergyBar60 = "energybar/energyBar_60.png";
    private final String pathEnergyBar80 = "energybar/energyBar_80.png";
    private final String pathEnergyBar100 = "energybar/energyBar_100.png";

    private final String pathBackgroundMusic = "sounds/background_music.mp3";
    private final String pathSound1 = "sounds/1.mp3";
    private final String pathSound2 = "sounds/2.mp3";
    private final String pathSound3 = "sounds/3.mp3";
    private final String pathSoundEndGame = "sounds/end_game.wav";
    private final String pathSoundFight = "sounds/fight.mp3";
    private final String pathSoundHadoukenSpeak = "sounds/hadouken_speak.mp3";
    private final String pathSoundHadoukenOutScreen = "sounds/hadouken_out_screen.wav";
    private final String pathSoundHadoukenSound = "sounds/hadouken_sound.wav";
    private final String pathSoundHadoukenHit = "sounds/hadouken_hit.wav";
    private final String pathSoundPunch = "sounds/punch.mp3";
    private final String pathSoundPunchHit = "sounds/punch_hit.wav";
    private final String pathSoundUggh = "sounds/uggh.mp3";

    public void init () {
        manager = new AssetManager();

        // BackGround
        manager.load(pathBackground, Texture.class);

        // Exit
        manager.load(pathExit, Texture.class);

        // Hadouken
        manager.load(pathHadouken, Texture.class);

        // Player 1
        manager.load(pathPlayer1Down, Texture.class);
        manager.load(pathPlayer1Jump, Texture.class);
        manager.load(pathPlayer1Move, Texture.class);
        manager.load(pathPlayer1Punch, Texture.class);
        manager.load(pathPlayer1Stop, Texture.class);
        manager.load(pathPlayer1Stunned, Texture.class);
        manager.load(pathPlayer1Hiting, Texture.class);
        manager.load(pathPlayer1HadoukenAttack, Texture.class);
        manager.load(pathPlayer1KO, Texture.class);
        manager.load(pathPlayer1Winner, Texture.class);

        player1Textures = new TexturesPlayer(
                manager,
                pathPlayer1Down,
                pathPlayer1Jump,
                pathPlayer1Move,
                pathPlayer1Punch,
                pathPlayer1Stop,
                pathPlayer1Stunned,
                pathPlayer1Hiting,
                pathPlayer1HadoukenAttack,
                pathPlayer1KO,
                pathPlayer1Winner
        );

        // Player 2
        manager.load(pathPlayer2Down, Texture.class);
        manager.load(pathPlayer2Jump, Texture.class);
        manager.load(pathPlayer2Move, Texture.class);
        manager.load(pathPlayer2Punch, Texture.class);
        manager.load(pathPlayer2Stop, Texture.class);
        manager.load(pathPlayer2Stunned, Texture.class);
        manager.load(pathPlayer2Hiting, Texture.class);
        manager.load(pathPlayer2HadoukenAttack, Texture.class);
        manager.load(pathPlayer2KO, Texture.class);
        manager.load(pathPlayer2Winner, Texture.class);

        player2Textures = new TexturesPlayer(
                manager,
                pathPlayer2Down,
                pathPlayer2Jump,
                pathPlayer2Move,
                pathPlayer2Punch,
                pathPlayer2Stop,
                pathPlayer2Stunned,
                pathPlayer2Hiting,
                pathPlayer2HadoukenAttack,
                pathPlayer2KO,
                pathPlayer2Winner
        );

        // LifeBar
        manager.load(pathLifeBar10, Texture.class);
        manager.load(pathLifeBar25, Texture.class);
        manager.load(pathLifeBar50, Texture.class);
        manager.load(pathLifeBar75, Texture.class);
        manager.load(pathLifeBar100, Texture.class);

        // EnergyBar
        manager.load(pathEnergyBar0, Texture.class);
        manager.load(pathEnergyBar20, Texture.class);
        manager.load(pathEnergyBar40, Texture.class);
        manager.load(pathEnergyBar60, Texture.class);
        manager.load(pathEnergyBar80, Texture.class);
        manager.load(pathEnergyBar100, Texture.class);

        // Sounds
        manager.load(pathBackgroundMusic, Music.class);
        manager.load(pathSound1, Sound.class);
        manager.load(pathSound2, Sound.class);
        manager.load(pathSound3, Sound.class);
        manager.load(pathSoundEndGame, Sound.class);
        manager.load(pathSoundFight, Sound.class);
        manager.load(pathSoundHadoukenSpeak, Sound.class);
        manager.load(pathSoundHadoukenOutScreen, Sound.class);
        manager.load(pathSoundHadoukenSound, Sound.class);
        manager.load(pathSoundHadoukenHit, Sound.class);
        manager.load(pathSoundPunch, Sound.class);
        manager.load(pathSoundPunchHit, Sound.class);
        manager.load(pathSoundUggh, Sound.class);

        manager.finishLoading();

        animationPlayer1 = new AnimationPlayer(player1Textures);
        animationPlayer2 = new AnimationPlayer(player2Textures);
        animationHadouken = new AnimationHadouken(this);
    }

    public Texture getBackground() {
        return manager.get(pathBackground, Texture.class);
    }

    public Texture getExit() {
        return manager.get(pathExit, Texture.class);
    }

    public AnimationHadouken getAnimationHadouken() {
        return animationHadouken;
    }

    public Texture getHadouken() {
        return manager.get(pathHadouken, Texture.class);
    }

    public TexturesPlayer getPlayer1Textures() {
        return player1Textures;
    }

    public TexturesPlayer getPlayer2Textures() {
        return player2Textures;
    }

    public AnimationPlayer getAnimationPlayer1() {
        return animationPlayer1;
    }

    public AnimationPlayer getAnimationPlayer2() {
        return animationPlayer2;
    }

    public Texture getLifeBar10() {
        return manager.get(pathLifeBar10, Texture.class);
    }

    public Texture getLifeBar25() {
        return manager.get(pathLifeBar25, Texture.class);
    }

    public Texture getLifeBar50() {
        return manager.get(pathLifeBar50, Texture.class);
    }

    public Texture getLifeBar75() {
        return manager.get(pathLifeBar75, Texture.class);
    }

    public Texture getLifeBar100() {
        return manager.get(pathLifeBar100, Texture.class);
    }

    public Texture getEnergyBar0() {
        return manager.get(pathEnergyBar0, Texture.class);
    }

    public Texture getEnergyBar20() {
        return manager.get(pathEnergyBar20, Texture.class);
    }

    public Texture getEnergyBar40() {
        return manager.get(pathEnergyBar40, Texture.class);
    }

    public Texture getEnergyBar60() {
        return manager.get(pathEnergyBar60, Texture.class);
    }

    public Texture getEnergyBar80() {
        return manager.get(pathEnergyBar80, Texture.class);
    }

    public Texture getEnergyBar100() {
        return manager.get(pathEnergyBar100, Texture.class);
    }

    public Music getBackgroundMusic() {
        return manager.get(pathBackgroundMusic, Music.class);
    }

    public Sound getSound1() {
        return manager.get(pathSound1, Sound.class);
    }

    public Sound getSound2() {
        return manager.get(pathSound2, Sound.class);
    }

    public Sound getSound3() {
        return manager.get(pathSound3, Sound.class);
    }

    public Sound getSoundEndGame() {
        return manager.get(pathSoundEndGame, Sound.class);
    }

    public Sound getSoundFight() {
        return manager.get(pathSoundFight, Sound.class);
    }

    public Sound getSoundHadoukenSpeak() {
        return manager.get(pathSoundHadoukenSpeak, Sound.class);
    }

    public Sound getSoundHadoukenOutScreen() {
        return manager.get(pathSoundHadoukenOutScreen, Sound.class);
    }

    public Sound getSoundHadoukenSound() {
        return manager.get(pathSoundHadoukenSound, Sound.class);
    }

    public Sound getSoundHadoukenHit() {
        return manager.get(pathSoundHadoukenHit, Sound.class);
    }

    public Sound getSoundPunch() {
        return manager.get(pathSoundPunch, Sound.class);
    }

    public Sound getSoundPunchHit() {
        return manager.get(pathSoundPunchHit, Sound.class);
    }

    public Sound getSoundUggh() {
        return manager.get(pathSoundUggh, Sound.class);
    }

    public void dispose () {
        manager.dispose();
    }
}