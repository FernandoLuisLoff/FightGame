package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Entity.Hadouken;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.Enum.HadoukenPositions;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;
import java.util.Iterator;

public class HadoukenController {
    private MyGdxGame game;

    private ArrayList<Hadouken> hadoukens;

    public ArrayList<Hadouken> getHadoukens() {
        return hadoukens;
    }

    public void init(MyGdxGame game) {
        this.game = game;

        if (hadoukens == null) {
            hadoukens = new ArrayList<Hadouken>();
        }
    }

    public void newHadouken(HadoukenPositions hadoukenPositions, Float imgX, Float imgY) {
        hadoukens.add( new Hadouken( game, hadoukenPositions, 160, 160, imgX, imgY, 10));
    }

    public void update(Hadouken hadouken) {
        if (game.getGameState() == GameState.RUNNING) {
            if (hadouken.getPosition() == HadoukenPositions.RIGHT) {
                hadouken.setImgX(hadouken.getImgX() + hadouken.getSpeed());
            } else if (hadouken.getPosition() == HadoukenPositions.LEFT) {
                hadouken.setImgX(hadouken.getImgX() - hadouken.getSpeed());
            }
        }
    }

    public void render() {
        Iterator<Hadouken> iterator = hadoukens.iterator();
        while (iterator.hasNext()) {
            Hadouken hadouken = iterator.next();
            if (!hadouken.isOffScreen()) {
                update(hadouken);
                hadouken.render();
            } else {
                iterator.remove();
                game.getSoundController().hadoukenOutScreenSound();
            }
        }
    }
}
