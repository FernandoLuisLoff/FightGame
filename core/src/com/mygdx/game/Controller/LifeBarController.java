package com.mygdx.game.Controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.LifeBar;
import com.mygdx.game.GameAssetManager.GameAssetManager;

import java.util.ArrayList;

public class LifeBarController {
    private PersonagemController personagemController;
    private ArrayList<LifeBar> lifeBars;

    private BitmapFont font;

    public ArrayList<LifeBar> getLifeBars() {
        return lifeBars;
    }

    public void init(GameAssetManager gameAssetManager, PersonagemController personagemController) {
        this.personagemController = personagemController;

        font = new BitmapFont();
        font.getData().setScale(2.5f);

        if (lifeBars == null) {
            lifeBars = new ArrayList<LifeBar>(2);
        }

        lifeBars.add( new LifeBar(gameAssetManager, this.personagemController.getPersonagens().get(0), 60, 500, 100, Gdx.graphics.getHeight() - 150 ));
        lifeBars.add( new LifeBar(gameAssetManager, this.personagemController.getPersonagens().get(1), 60, 500, Gdx.graphics.getWidth() - 600, Gdx.graphics.getHeight() - 150 ));
    }

    public void render(SpriteBatch batch) {
        for (LifeBar lifeBar : lifeBars) {
            font.draw(batch, lifeBar.getPersonagem().getName(), lifeBar.getImgX() + 120, lifeBar.getImgY() + 80);
            batch.draw( lifeBar.getImg(), lifeBar.getImgX(), lifeBar.getImgY(), lifeBar.getWidthImg(), lifeBar.getHeightImg() );
        }
    }

    public void dispose() {
        font.dispose();
    }
}
