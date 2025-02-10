package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controller.HadoukenController;
import com.mygdx.game.Controller.SoundController;
import com.mygdx.game.Controller.StatusBarController;
import com.mygdx.game.Controller.PersonagemController;
import com.mygdx.game.Entity.ExitButton;
import com.mygdx.game.Entity.Timer;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.InputProcessor.InputProcessor;

public class MyGdxGame extends Game {
	private final GameAssetManager gameAssetManager = new GameAssetManager();

	private SpriteBatch batch;

	private ExitButton exitButton;
	private Timer timer;

	private SoundController soundController;
	private PersonagemController personagemController;
	private HadoukenController hadoukenController;
	private StatusBarController statusBarController;

	private GameState gameState;

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
		timer = new Timer(this);
		gameState = GameState.PAUSED;

		soundController = new SoundController();
		hadoukenController = new HadoukenController();
		personagemController = new PersonagemController();
		statusBarController = new StatusBarController();

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
		timer.render();
		soundController.render();

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameAssetManager.dispose();
		statusBarController.dispose();
		timer.dispose();
		soundController.dispose();
	}
}