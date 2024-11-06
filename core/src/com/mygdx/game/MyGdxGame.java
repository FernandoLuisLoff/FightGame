package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controller.BalaoController;
import com.mygdx.game.Controller.HadoukenController;
import com.mygdx.game.Controller.PersonagemController;
import com.mygdx.game.Entity.ExitButton;
import com.mygdx.game.InputProcessor.InputProcessor;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture background;

	private ExitButton exitButton;
	private final PersonagemController  personagemController = new PersonagemController();
	private final HadoukenController hadoukenController = new HadoukenController();
	private final BalaoController balaoController = new BalaoController();

	@Override
	public void create () {
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

		batch = new SpriteBatch();
		background = new Texture("background/background.jpg");
		exitButton = new ExitButton( new Texture("background/exit.png"), 100, 100 );

		personagemController.init();
		hadoukenController.init();
		balaoController.init();

		InputProcessor personagemInputProcessor = new InputProcessor(personagemController, hadoukenController, exitButton);
		Gdx.input.setInputProcessor(personagemInputProcessor);
	}

	@Override
	public void render () {
		Gdx.graphics.setTitle("FightGame - FPS: " + Gdx.graphics.getFramesPerSecond());

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		exitButton.draw(batch);
		personagemController.render(batch);
		hadoukenController.render(batch);
		balaoController.render(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		exitButton.dispose();
		personagemController.dispose();
		hadoukenController.dispose();
		balaoController.dispose();
	}
}