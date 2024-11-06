package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Entity.Hadouken;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.InputProcessor.PersonagemInputProcessor;

import java.util.ArrayList;

public class PersonagemController {
    private ArrayList<Personagem> personagens;

    public void init(Hadouken hadouken) {
        if (personagens == null) {
            personagens = new ArrayList<Personagem>(2);
        }

        personagens.add( new Personagem( PersonagensPositions.STOP_RIGHT, 90, 180, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 4 ));

		PersonagemInputProcessor personagemInputProcessor = new PersonagemInputProcessor(personagens.get(0), hadouken);
		Gdx.input.setInputProcessor(personagemInputProcessor);
    }
}
