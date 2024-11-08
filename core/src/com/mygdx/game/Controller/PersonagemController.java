package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.InputProcessor.PersonagemInputKeys;

import java.util.ArrayList;

public class PersonagemController {
    private ArrayList<Personagem> personagens;

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(ArrayList<Personagem> personagens) {
        this.personagens = personagens;
    }

    public void init() {
        if (personagens == null) {
            personagens = new ArrayList<Personagem>(2);
        }

        float widhtImg = 240;
        float heightImg = 420;

        PersonagemInputKeys player1InputKey = new PersonagemInputKeys(Input.Keys.D, Input.Keys.A, Input.Keys.W, Input.Keys.S, Input.Keys.C, Input.Keys.V);
        personagens.add( new Personagem( "player1", PersonagensPositions.STOP_RIGHT, player1InputKey, widhtImg, heightImg, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4 ));

        PersonagemInputKeys player2InputKey = new PersonagemInputKeys(Input.Keys.RIGHT, Input.Keys.LEFT, Input.Keys.UP, Input.Keys.DOWN, Input.Keys.N, Input.Keys.M);
        personagens.add( new Personagem( "player2", PersonagensPositions.STOP_LEFT, player2InputKey, widhtImg, heightImg, Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4 ));
    }

    public void update(Personagem personagem) {
        if (!personagem.isOffScreen()) {
            personagem.setImgX(personagem.getImgX() + personagem.getSpeed());
        } else {
            if (personagem.getImgX() <= 0) {
                personagem.setImgX(personagem.getImgX() + 1);
            } else if (personagem.getImgX() >= Gdx.graphics.getWidth()) {
                personagem.setImgX(personagem.getImgX() - 1);
            }
        }

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
                personagem.updateImg(personagem.getImgPosition());
                personagem.setJumpVelocity(0);
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (Personagem personagem : personagens) {
            update(personagem);

            Float heightImg;
            if (personagem.isDowning()) {
                heightImg = personagem.getDownHeightImg();
            } else {
                heightImg = personagem.getUpperHeightImg();
            }

            batch.draw( personagem.getImg(), personagem.getImgX() - personagem.getWidthImg()/2, personagem.getImgY() - personagem.getUpperHeightImg()/2, personagem.getWidthImg(), heightImg );
        }
    }

    public void dispose() {
        for (Personagem personagem : personagens) {
            personagem.dispose();
        }
    }
}
