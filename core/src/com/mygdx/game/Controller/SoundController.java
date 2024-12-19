package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.Enum.GameState;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.MyGdxGame;

public class SoundController {
    private MyGdxGame game;

    private Music background_music;
    
    GlyphLayout layout;
    BitmapFont font;
    String textFont;

    public void init(MyGdxGame game) {
        this.game = game;

        background_music = this.game.getGameAssetManager().getBackgroundMusic();
        background_music.setLooping(true);
        background_music.setVolume(0.8f);

        layout = new GlyphLayout();
        font = new BitmapFont();
        font.getData().setScale(6f);

        startCountSound();
    }

    public void startCountSound() {
        Sound fightSound = game.getGameAssetManager().getSoundFight();
        Sound sound_1 = game.getGameAssetManager().getSound1();
        Sound sound_2 = game.getGameAssetManager().getSound2();
        Sound sound_3 = game.getGameAssetManager().getSound3();

        textFont = "3";
        sound_3.play();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                textFont = "2";
                sound_2.play();
            }
        }, 1.0f);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                textFont = "1";
                sound_1.play();
            }
        }, 2.0f);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                textFont = "Fight!";
                fightSound.play();
            }
        }, 3.0f);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                textFont = "";
                background_music.play();

                game.setGameState( GameState.RUNNING );
            }
        }, 3.5f);
    }

    public void hadoukenSpeakSound() {
        Sound hadoukenSpeakSound = game.getGameAssetManager().getSoundHadoukenSpeak();
        hadoukenSpeakSound.play();
    }

    public void hadoukenSound() {
        Sound hadoukenSound = game.getGameAssetManager().getSoundHadoukenSound();
        hadoukenSound.play();
    }

    public void hadoukenOutScreenSound() {
        Sound hadoukenOutScreenSound = game.getGameAssetManager().getSoundHadoukenOutScreen();
        hadoukenOutScreenSound.play();
    }

    public void hadoukenHitSound() {
        Sound hadoukenHitSound = game.getGameAssetManager().getSoundHadoukenHit();
        hadoukenHitSound.play();
    }

    public void punchSound() {
        Sound punchSound = game.getGameAssetManager().getSoundPunch();
        punchSound.play();
    }

    public void punchHitSound() {
        Sound punchHitSound = game.getGameAssetManager().getSoundPunchHit();
        punchHitSound.play();
    }

    public void endGameSound(String namePlayer) {
        Sound ugghSound = game.getGameAssetManager().getSoundUggh();
        Sound end_game = game.getGameAssetManager().getSoundEndGame();

        background_music.pause();
        ugghSound.play();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                end_game.play();
                textFont = namePlayer + " perdeu!";
            }
        }, 1.0f);
    }

    public void render() {
        if (!textFont.isEmpty()) {
            float centerX = (Gdx.graphics.getWidth() - layout.width) / 2;
            float centerY = (Gdx.graphics.getHeight() + layout.height) / 2;

            layout.setText(font, textFont);
            font.draw(game.getBatch(), layout, centerX, centerY);
        }
    }

    public void dispose() {
        font.dispose();
    }
    
}
