package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.Hadouken;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.HadoukenPositions;
import com.mygdx.game.GameAssetManager.GameAssetManager;

import java.util.ArrayList;
import java.util.Iterator;

public class HadoukenController {
    private GameAssetManager gameAssetManager;

    private ArrayList<Hadouken> hadoukens;

    private Boolean paused = false;

    public ArrayList<Hadouken> getHadoukens() {
        return hadoukens;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public void init(GameAssetManager gameAssetManager) {
        this.gameAssetManager = gameAssetManager;

        if (hadoukens == null) {
            hadoukens = new ArrayList<Hadouken>();
        }
    }

    public void newHadouken(HadoukenPositions hadoukenPositions, Float imgX, Float imgY) {
        hadoukens.add( new Hadouken( gameAssetManager, hadoukenPositions, 160, 160, imgX, imgY, 10));
    }

    public void update(Hadouken hadouken) {
        if (!paused) {
            if (hadouken.getPosition() == HadoukenPositions.RIGHT) {
                hadouken.setImgX(hadouken.getImgX() + hadouken.getSpeed());
            } else if (hadouken.getPosition() == HadoukenPositions.LEFT) {
                hadouken.setImgX(hadouken.getImgX() - hadouken.getSpeed());
            }
        }
    }

    public void render(SpriteBatch batch) {
        Iterator<Hadouken> iterator = hadoukens.iterator();
        while (iterator.hasNext()) {
            Hadouken hadouken = iterator.next();
            if (!hadouken.isOffScreen()) {
                update(hadouken);
                batch.draw( hadouken.getImg(), hadouken.getImgX() - hadouken.getWidthImg() / 2, hadouken.getImgY() - hadouken.getHeightImg() / 2, hadouken.getWidthImg(), hadouken.getHeightImg() );
            } else {
                iterator.remove();
            }
        }
    }
}
