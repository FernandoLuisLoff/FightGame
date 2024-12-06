package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.Hadouken;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.GameAssetManager.GameAssetManager;
import com.mygdx.game.InputProcessor.PersonagemInputKeys;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonagemController {
    private MyGdxGame game;

    private ArrayList<Personagem> personagens;

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public void init(MyGdxGame game) {
        this.game = game;

        if (personagens == null) {
            personagens = new ArrayList<Personagem>(2);
        }

        float widhtImg = 240;
        float heightImg = 420;

        PersonagemInputKeys player1InputKey = new PersonagemInputKeys(Input.Keys.D, Input.Keys.A, Input.Keys.W, Input.Keys.S, Input.Keys.C, Input.Keys.V);
        personagens.add( new Personagem( "Player 1", game.getGameAssetManager(), "players/player1", PersonagensPositions.STOP_RIGHT, player1InputKey, widhtImg, heightImg, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4 ));

        PersonagemInputKeys player2InputKey = new PersonagemInputKeys(Input.Keys.RIGHT, Input.Keys.LEFT, Input.Keys.UP, Input.Keys.DOWN, Input.Keys.N, Input.Keys.M);
        personagens.add( new Personagem( "Player 2", game.getGameAssetManager(), "players/player2", PersonagensPositions.STOP_LEFT, player2InputKey, widhtImg, heightImg, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4 ));
    }

    public void testPunchHit(Personagem personagem) {
        for (Personagem outroPersonagem : personagens) {
            if (outroPersonagem != personagem) {
                float x = 0;
                if (personagem.isRight()) {
                    x = personagem.getImgX() + 50;
                } else if (personagem.isLeft()) {
                    x = personagem.getImgX() - 50;
                }

                if (outroPersonagem.hit(x, personagem.getImgY() + personagem.getUpperHeightImg()/2)) {
                    outroPersonagem.setLife(outroPersonagem.getLife() - 10);
                }
            }
        }
    }

    public void testHadoukenHit(Personagem personagem) {
        Iterator<Hadouken> iterator = game.getHadoukenController().getHadoukens().iterator();
        while (iterator.hasNext()) {
            Hadouken hadouken = iterator.next();

            if (personagem.hit(hadouken.getImgX(), hadouken.getImgY())) {
                personagem.setLife(personagem.getLife() - 50);
                iterator.remove();
            }
        }
    }

    public void update(Personagem personagem) {
        if (game.getGameState() == GameState.RUNNING) {
            // Tratamento de saida de tela
            if (!personagem.isOffScreen()) {
                personagem.setImgX(personagem.getImgX() + personagem.getSpeed());
            } else {
                if (personagem.getImgX() <= 0) {
                    personagem.setImgX(personagem.getImgX() + 1);
                } else if (personagem.getImgX() >= Gdx.graphics.getWidth()) {
                    personagem.setImgX(personagem.getImgX() - 1);
                }
            }

            // Tratamento do pulo do personagem
            if (personagem.isJumping()) {
                personagem.setImgY(personagem.getImgY() + personagem.getJumpVelocity());
                personagem.setJumpVelocity(personagem.getJumpVelocity() + personagem.getGravity()); // Acelerar para baixo (gravidade)

                if (personagem.getImgY() <= personagem.getGroundY()) { // Se atingir o chão
                    personagem.setImgY(personagem.getGroundY());
                    if (personagem.getPosition() == PersonagensPositions.JUMP_RIGHT) {
                        personagem.setPosition(PersonagensPositions.STOP_RIGHT);
                    } else if (personagem.getPosition() == PersonagensPositions.JUMP_LEFT) {
                        personagem.setPosition(PersonagensPositions.STOP_LEFT);
                    } else if (personagem.getPosition() == PersonagensPositions.JUMP_MOVE_RIGHT) {
                        personagem.setPosition(PersonagensPositions.MOVE_RIGHT);
                    } else if (personagem.getPosition() == PersonagensPositions.JUMP_MOVE_LEFT) {
                        personagem.setPosition(PersonagensPositions.MOVE_LEFT);
                    }
                    personagem.setJumpVelocity(0);
                }
            }

            testHadoukenHit(personagem);
        }
    }

    public void render() {
        Personagem personagemDeath = null;
        for (Personagem personagem : personagens) {
            update(personagem);

            float heightImg;
            if (personagem.isDowning()) {
                heightImg = personagem.getDownHeightImg();
            } else {
                heightImg = personagem.getUpperHeightImg();
            }

            game.getBatch().draw( personagem.getImg(), personagem.getImgX() - personagem.getWidthImg()/2, personagem.getImgY() - personagem.getUpperHeightImg()/2, personagem.getWidthImg(), heightImg );


            if (personagem.getLife() <= 0 && personagemDeath == null) {
                personagemDeath = personagem;
            }
        }

        if (personagemDeath != null) {
            endGame(personagemDeath);
        }
    }

    public void endGame(Personagem personagem) {
        if (game.getGameState() == GameState.RUNNING) {
            game.getSoundController().endGameSound(personagem.getName());
            game.setGameState( GameState.END_GAME );
        }
    }
}
