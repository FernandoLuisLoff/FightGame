package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controller.BalaoController;
import com.mygdx.game.Controller.PersonagemController;
import com.mygdx.game.Entity.Balao;
import com.mygdx.game.Entity.Hadouken;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.HadoukenPositions;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.InputProcessor.PersonagemInputProcessor;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture background;
	Hadouken hadouken;
	PersonagemController  personagemController = new PersonagemController();
	BalaoController balaoController = new BalaoController();

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background/background.jpeg");

		hadouken = new Hadouken( HadoukenPositions.RIGHT, 60, 60, Gdx.graphics.getWidth() + 100, Gdx.graphics.getHeight() / 2, 10 );
		personagemController.init(hadouken);
		balaoController.init();
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		int fps = Gdx.graphics.getFramesPerSecond();
		Gdx.graphics.setTitle("MyGdxGame - FPS: " + fps );

		hadouken.draw();
		balaoController.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		balaoController.dispose();
	}
}
