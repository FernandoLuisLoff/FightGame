package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.Balao;

import java.util.ArrayList;

public class BalaoController {
    private ArrayList<Balao> baloes;

    public void init() {
        if (baloes == null) {
            baloes = new ArrayList<Balao>(4);
        }

        baloes.add( new Balao( new Texture("balao/balao.png"), 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 4, -100, 4) );
        baloes.add( new Balao( new Texture("balao/balao.png"), 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5, -50, 3) );
        baloes.add( new Balao( new Texture("balao/balao.png"), 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 3, -80, 5) );
        baloes.add( new Balao( new Texture("balao/balao.png"), 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 6, -90, 4) );
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
        for (Balao balao : baloes) {
            update(balao);
            batch.draw(
                balao.getImg(),
                balao.getImgX() - balao.getWidthImg() / 2,
                balao.getImgY() - balao.getHeightImg() / 2,
                balao.getWidthImg(),
                balao.getHeightImg()
            );
        }
    }

    public void dispose() {
        for (Balao balao : baloes) {
            balao.dispose();
        }
    }
}
