package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controller.BalaoController;
import com.mygdx.game.Controller.HadoukenController;
import com.mygdx.game.Controller.PersonagemController;
import com.mygdx.game.Entity.ExitButton;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.InputProcessor.InputProcessor;

public class MyGdxGame extends ApplicationAdapter {
	private final GameAssetManager gameAssetManager = new GameAssetManager();

	private SpriteBatch batch;

	private ExitButton exitButton;
	private final PersonagemController  personagemController = new PersonagemController();
	private final HadoukenController hadoukenController = new HadoukenController();
	private final BalaoController balaoController = new BalaoController();

	@Override
	public void create () {
		gameAssetManager.init();

		batch = new SpriteBatch();

		exitButton = new ExitButton( gameAssetManager, 100, 100 );

		hadoukenController.init(gameAssetManager);
		personagemController.init(gameAssetManager, hadoukenController);
		balaoController.init(hadoukenController, gameAssetManager);

		InputProcessor personagemInputProcessor = new InputProcessor(personagemController, hadoukenController, exitButton);
		Gdx.input.setInputProcessor(personagemInputProcessor);
	}

	@Override
	public void render () {
		Gdx.graphics.setTitle("FightGame");

		batch.begin();
		batch.draw( gameAssetManager.getManager().get("background/background.jpg", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		exitButton.draw(batch);
		personagemController.render(batch);
		hadoukenController.render(batch);
		balaoController.render(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameAssetManager.dispose();
	}
}