package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture background;

	Personagem personagem;
	Hadouken hadouken;
	Balao balao;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background/background.jpeg");

		personagem = new Personagem( PersonagensPositions.STOP_RIGHT, 90, 180, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 4 );
		hadouken = new Hadouken( HadoukenPositions.RIGHT, 60, 60, Gdx.graphics.getWidth() + 100, Gdx.graphics.getHeight() / 2, 10 );
		balao = new Balao( new Texture("balao/balao.png"), 70, 120, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5, -100, 4);

		PersonagemInputProcessor personagemInputProcessor = new PersonagemInputProcessor(personagem, hadouken);
		Gdx.input.setInputProcessor(personagemInputProcessor);
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		int fps = Gdx.graphics.getFramesPerSecond();
		Gdx.graphics.setTitle("MyGdxGame - FPS: " + fps + " | Posição: " + personagem.position + " | X: " + personagem.imgX + " Y: " + personagem.imgY );

		personagem.draw();
		hadouken.draw();
		balao.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		personagem.dispose();
		hadouken.dispose();
		balao.dispose();
	}
}
