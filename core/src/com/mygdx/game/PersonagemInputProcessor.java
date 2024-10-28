package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PersonagemInputProcessor implements InputProcessor {
    Personagem personagem;
    Hadouken hadouken;

    public PersonagemInputProcessor(Personagem personagem, Hadouken hadouken) {
        this.personagem = personagem;
        this.hadouken = hadouken;
    }

    @Override
    public boolean keyDown(int i) {
        if (i == Input.Keys.W) {
            personagem.jump();
        } else if (i == Input.Keys.D) {
            if (!personagem.isDowning() && !personagem.isPunching()) {
                if (!personagem.isJumping()) {
                    personagem.position = PersonagensPositions.MOVE_RIGHT;
                } else {
                    personagem.position = PersonagensPositions.JUMP_MOVE_RIGHT;
                }
                personagem.updateImg(personagem.getImgPosition());
                personagem.setSpeed(5);
            }
        } else if (i == Input.Keys.A) {
            if (!personagem.isDowning() && !personagem.isPunching()) {
                if (!personagem.isJumping()) {
                    personagem.position = PersonagensPositions.MOVE_LEFT;
                } else {
                    personagem.position = PersonagensPositions.JUMP_MOVE_LEFT;
                }
                personagem.updateImg(personagem.getImgPosition());
                personagem.setSpeed(-5);
            }
        } else if (i == Input.Keys.H) {
            if (hadouken.isOffScreen()) {
                hadouken.setImgY(personagem.getImgY());
                if (personagem.isRight()) {
                    hadouken.position = HadoukenPositions.RIGHT;
                    hadouken.setImgX(personagem.getImgX() + 50);
                } else if (personagem.isLeft()) {
                    hadouken.position = HadoukenPositions.LEFT;
                    hadouken.setImgX(personagem.getImgX() - 50);
                }
                hadouken.updateImg(hadouken.getImgPosition());
            }
        } else if (i == Input.Keys.S) {
            if (!personagem.isJumping()) {
                personagem.setSpeed(0);
                if (personagem.isRight()) {
                    personagem.position = PersonagensPositions.DOWN_RIGHT;
                } else if (personagem.isLeft()) {
                    personagem.position = PersonagensPositions.DOWN_LEFT;
                }
                personagem.updateImg(personagem.getImgPosition());
            }
        } else if (i == Input.Keys.P) {
            if (!personagem.isJumping()) {
                personagem.setSpeed(0);
                if (personagem.isRight()) {
                    personagem.position = PersonagensPositions.PUNCH_RIGHT;
                } else if (personagem.isLeft()) {
                    personagem.position = PersonagensPositions.PUNCH_LEFT;
                }
                personagem.updateImg(personagem.getImgPosition());
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        if (i == Input.Keys.D) {
            if (!personagem.isDowning() && !personagem.isPunching()) {
                if (!personagem.isJumping()) {
                    personagem.position = PersonagensPositions.STOP_RIGHT;
                } else {
                    personagem.position = PersonagensPositions.JUMP_RIGHT;
                }
                personagem.updateImg(personagem.getImgPosition());
                personagem.setSpeed(0);
            }
        } else if (i == Input.Keys.A) {
            if (!personagem.isDowning() && !personagem.isPunching()) {
                if (!personagem.isJumping()) {
                    personagem.position = PersonagensPositions.STOP_LEFT;
                } else {
                    personagem.position = PersonagensPositions.JUMP_LEFT;
                }
                personagem.updateImg(personagem.getImgPosition());
                personagem.setSpeed(0);
            }
        } else if (i == Input.Keys.S || i == Input.Keys.P) {
            if (!personagem.isJumping()) {
                if (personagem.isRight()) {
                    personagem.position = PersonagensPositions.STOP_RIGHT;
                } else if (personagem.isLeft()) {
                    personagem.position = PersonagensPositions.STOP_LEFT;
                }
                personagem.updateImg(personagem.getImgPosition());
            }
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c) { return false; }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
