package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.MyGdxGame;

public class Timer {
    private MyGdxGame game;
    private BitmapFont font;
    private GlyphLayout layout;
    private double stateTime;

    public Timer(MyGdxGame game) {
        this.game = game;

        font = new BitmapFont();
        font.getData().setScale(3f);
        layout = new GlyphLayout();
        this.stateTime = 0;
    }

    public void update() {
        stateTime += Gdx.graphics.getDeltaTime();
    }

    public void render() {
        if( game.getGameState() == GameState.RUNNING) {
            update();
        }

        int minutes = (int) (stateTime / 60);
        int seconds = (int) (stateTime % 60);
        String timeString = String.format("%02d:%02d", minutes, seconds);

        layout.setText(font, timeString);

        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = Gdx.graphics.getHeight() - 25;

        font.draw(game.getBatch(), timeString, x, y);
    }

    public void dispose() {
        font.dispose();
    }
}
