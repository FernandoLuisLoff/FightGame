package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controller.HadoukenController;
import com.mygdx.game.Controller.SoundController;
import com.mygdx.game.Controller.StatusBarController;
import com.mygdx.game.Controller.PersonagemController;
import com.mygdx.game.Entity.ExitButton;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.InputProcessor.InputProcessor;

public class MyGdxGame extends Game {
	private final GameAssetManager gameAssetManager = new GameAssetManager();

	private SpriteBatch batch;

	private ExitButton exitButton;

	private final SoundController soundController = new SoundController();
	private final PersonagemController personagemController = new PersonagemController();
	private final HadoukenController hadoukenController = new HadoukenController();
	private final StatusBarController statusBarController = new StatusBarController();

	private GameState gameState = GameState.PAUSED;

	public GameAssetManager getGameAssetManager() {
		return gameAssetManager;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public ExitButton getExitButton() {
		return exitButton;
	}

	public SoundController getSoundController() {
		return soundController;
	}

	public PersonagemController getPersonagemController() {
		return personagemController;
	}

	public HadoukenController getHadoukenController() {
		return hadoukenController;
	}

	public StatusBarController getStatusBarController() {
		return statusBarController;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void create () {
		gameAssetManager.init();

		batch = new SpriteBatch();
		exitButton = new ExitButton(this);

		hadoukenController.init(this);
		personagemController.init(this);
		statusBarController.init(this);
		soundController.init(this);

		Gdx.input.setInputProcessor( new InputProcessor(this) );
	}

	@Override
	public void render () {
		Gdx.graphics.setTitle("FightGame");

		batch.begin();
		batch.draw(gameAssetManager.getBackground(), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		exitButton.draw();
		personagemController.render();
		hadoukenController.render();
		statusBarController.render();
		soundController.render();

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameAssetManager.dispose();
		statusBarController.dispose();
		soundController.dispose();
	}
}