package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.GameAssetManager.GameAssetManager;
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

        background_music = this.game.getGameAssetManager().getManager().get("sounds/background_music.mp3", Music.class);

        layout = new GlyphLayout();
        font= new BitmapFont();
        font.getData().setScale(6f);

        initCount();
    }

    public void initCount() {
        Sound fightSound = game.getGameAssetManager().getManager().get("sounds/fight.mp3", Sound.class);
        Sound sound_1 = game.getGameAssetManager().getManager().get("sounds/1.mp3", Sound.class);
        Sound sound_2 = game.getGameAssetManager().getManager().get("sounds/2.mp3", Sound.class);
        Sound sound_3 = game.getGameAssetManager().getManager().get("sounds/3.mp3", Sound.class);

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
                background_music.setLooping(true);
                background_music.setVolume(0.6f);
                background_music.play();

                game.setGameState( GameState.RUNNING );
            }
        }, 4.0f);
    }

    public void endGameSound(String namePlayer) {
        Sound ugghSound = game.getGameAssetManager().getManager().get("sounds/uggh.mp3", Sound.class);
        Sound end_game = game.getGameAssetManager().getManager().get("sounds/end_game.wav", Sound.class);

        background_music.pause();
        ugghSound.play();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                end_game.play();
                textFont = namePlayer + " levou uma surra!";
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
