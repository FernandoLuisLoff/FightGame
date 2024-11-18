package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.Balao;
import com.mygdx.game.Entity.Hadouken;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.GameAssetManager.GameAssetManager;

import java.util.ArrayList;
import java.util.Iterator;

public class BalaoController {
    private GameAssetManager gameAssetManager;

    private ArrayList<Balao> baloes;

    public ArrayList<Balao> getBaloes() {
        return baloes;
    }

    public void setBaloes(ArrayList<Balao> baloes) {
        this.baloes = baloes;
    }

    HadoukenController hadoukenController;

    public void init(HadoukenController hadoukenController, GameAssetManager gameAssetManager) {
        this.gameAssetManager = gameAssetManager;
        this.hadoukenController = hadoukenController;

        if (baloes == null) {
            baloes = new ArrayList<Balao>(4);
        }

        baloes.add( new Balao( gameAssetManager, 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 4, -100, 4) );
        baloes.add( new Balao( gameAssetManager, 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5, -50, 3) );
        baloes.add( new Balao( gameAssetManager, 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 3, -80, 5) );
        baloes.add( new Balao( gameAssetManager, 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 6, -90, 4) );
    }

    public boolean testHit(Balao balao) {
        Boolean test = false;
        for (Hadouken hadouken : hadoukenController.getHadoukens()) {
            Float x = hadouken.getImgX() + hadouken.getWidthImg();
            Float y = hadouken.getImgY() + hadouken.getHeightImg()/2;

            if ( balao.hit(x, y) ) {
                test = true;
                break;
            }
        }
        return test;
    }

    public void update(Balao balao) {
        if (!balao.isOffScreen()) {
            balao.setImgY( balao.getImgY() + balao.getSpeed() );
        } else {
            balao.setImgX( balao.getInitialImgX() );
            balao.setImgY( balao.getInitialImgY() );
        }
    }

    public void render(SpriteBatch batch) {
        Iterator<Balao> iterator = baloes.iterator();
        while (iterator.hasNext()) {
            Balao balao = iterator.next();
            update(balao);

            if (!testHit(balao)) {
                batch.draw(balao.getImg(), balao.getImgX() - balao.getWidthImg() / 2, balao.getImgY() - balao.getHeightImg() / 2, balao.getWidthImg(), balao.getHeightImg());
            } else {
                iterator.remove();
            }
        }
    }
}
