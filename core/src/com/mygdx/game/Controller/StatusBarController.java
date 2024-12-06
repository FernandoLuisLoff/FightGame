package com.mygdx.game.Controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.Entity.StatusBar;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

public class StatusBarController {
    private MyGdxGame game;
    private ArrayList<StatusBar> statusBars;

    private BitmapFont font;
    public ArrayList<StatusBar> getstatusBars() {
        return statusBars;
    }

    public void init(MyGdxGame game) {
        this.game = game;

        font = new BitmapFont();
        font.getData().setScale(2.5f);

        if (statusBars == null) {
            statusBars = new ArrayList<StatusBar>(2);
        }

        statusBars.add( new StatusBar(game.getGameAssetManager(), game.getPersonagemController().getPersonagens().get(0), 60, 500, 50, 270, 100, Gdx.graphics.getHeight() - 150 ));
        statusBars.add( new StatusBar(game.getGameAssetManager(), game.getPersonagemController().getPersonagens().get(1), 60, 500, 50, 270, Gdx.graphics.getWidth() - 600, Gdx.graphics.getHeight() - 150 ));
    }

    public void update(StatusBar statusBar) {
        if (game.getGameState() == GameState.RUNNING) {
            double time = 1.0;
            if (statusBar.getTimer() >= time) {
                int actualEnergy = statusBar.getPersonagem().getEnergy();
                if (actualEnergy < 100) {
                    statusBar.getPersonagem().setEnergy(actualEnergy + 20);
                }
                statusBar.setTimer(statusBar.getTimer() - time);
            }

            statusBar.setTimer(statusBar.getTimer() + Gdx.graphics.getDeltaTime());
        }
    }

    public void render() {
        for (StatusBar statusBar : statusBars) {
            update(statusBar);
            font.draw(game.getBatch(), statusBar.getPersonagem().getName(), statusBar.getImgX() + 120, statusBar.getImgY() + 80);
            game.getBatch().draw( statusBar.getLifeBar(), statusBar.getImgX(), statusBar.getImgY(), statusBar.getWidthLifeBar(), statusBar.getHeightLifeBar() );
            game.getBatch().draw( statusBar.getEnergyBar(), statusBar.getImgX()+50, statusBar.getImgY()-40, statusBar.getWidthEnergyBar(), statusBar.getHeightEnergyBar() );
        }
    }

    public void dispose() {
        font.dispose();
    }
}
