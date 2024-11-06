package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.Hadouken;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.HadoukenPositions;

import java.util.ArrayList;
import java.util.Iterator;

public class HadoukenController {
    private ArrayList<Hadouken> hadoukens;

    public ArrayList<Hadouken> getHadoukens() {
        return hadoukens;
    }

    public void setHadoukens(ArrayList<Hadouken> hadoukens) {
        this.hadoukens = hadoukens;
    }

    public void init() {
        if (hadoukens == null) {
            hadoukens = new ArrayList<Hadouken>();
        }
    }

    public void newHadouken(HadoukenPositions hadoukenPositions, Float imgX, Float imgY) {
        hadoukens.add( new Hadouken( hadoukenPositions, 80, 80, imgX, imgY, 10));
    }

    public void update(Hadouken hadouken) {
        if (hadouken.getPosition() == HadoukenPositions.RIGHT) {
            hadouken.setImgX(hadouken.getImgX() + hadouken.getSpeed());
        } else if (hadouken.getPosition() == HadoukenPositions.LEFT) {
            hadouken.setImgX(hadouken.getImgX() - hadouken.getSpeed());
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
                hadouken.dispose();
                iterator.remove();
            }
        }
    }

    public void dispose() {
        for (Hadouken hadouken : hadoukens) {
            hadouken.dispose();
        }
    }
}
