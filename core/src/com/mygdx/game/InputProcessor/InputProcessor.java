package com.mygdx.game.InputProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Controller.HadoukenController;
import com.mygdx.game.Controller.PersonagemController;
import com.mygdx.game.Entity.ExitButton;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.MyGdxGame;

public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    private MyGdxGame game;

    public InputProcessor(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int i) {
        if (game.getGameState() == GameState.RUNNING) {
            for (Personagem personagem : game.getPersonagemController().getPersonagens()) {
                boolean resetTime = false;
                boolean canResetTime = !personagem.isDowning() && !personagem.isPunching() && !personagem.isHiting() && !personagem.isHadoukenAttacking();

                if (i == personagem.getInputKeys().keyJump) {
                    personagem.jump();
                    resetTime = true;
                } else if (i == personagem.getInputKeys().keyRight) {
                    personagem.moveRight();
                    resetTime = true;
                } else if (i == personagem.getInputKeys().keyLeft) {
                    personagem.moveLeft();
                    resetTime = true;
                } else if (i == personagem.getInputKeys().keyHadouken) {
                    if (!personagem.isJumping() && !personagem.isDowning() && !personagem.isPunching() && !personagem.isHiting() && !personagem.isHadoukenAttacking()) {
                        if (personagem.getEnergy() >= 100) {
                            personagem.setPosition(PersonagensPositions.HADOUKEN_ATTACKING);
                            resetTime = true;
                        }
                    }
                } else if (i == personagem.getInputKeys().keyDown) {
                    if (!personagem.isDowning() && !personagem.isPunching() && !personagem.isHiting() && !personagem.isHadoukenAttacking()) {
                        personagem.down();
                        resetTime = true;
                    }
                } else if (i == personagem.getInputKeys().keyPunch) {
                    if (!personagem.isDowning() && !personagem.isPunching() && !personagem.isHiting() && !personagem.isHadoukenAttacking()) {
                        personagem.punch();
                        resetTime = true;
                    }
                }

                if (resetTime && canResetTime) {
                    personagem.setStateTime(0);
                }
            }
        } else if (game.getGameState() == GameState.END_GAME) {
            if (i == Input.Keys.ENTER) {
                game.create();
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        if (game.getGameState() == GameState.RUNNING) {
            for (Personagem personagem : game.getPersonagemController().getPersonagens()) {
                boolean resetTime = false;
                boolean canResetTime = !personagem.isDowning() && !personagem.isPunching() && !personagem.isHadoukenAttacking();

                if (i == personagem.getInputKeys().keyRight || i == personagem.getInputKeys().keyLeft) {
                    personagem.stopMove();
                    resetTime = true;
                } else if (i == personagem.getInputKeys().keyDown && personagem.isDowning()) {
                    personagem.setPosition(PersonagensPositions.UPPERING);
                    resetTime = true;
                }

                if (resetTime && canResetTime) {
                    personagem.setStateTime(0);
                }
            }
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c) { return false; }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int invertedY = Gdx.graphics.getHeight() - screenY;
        if (screenX >= game.getExitButton().getImgX() && screenX <= game.getExitButton().getImgX() + game.getExitButton().getButtonWidth() &&
                invertedY >= game.getExitButton().getImgY() && invertedY <= game.getExitButton().getImgY() + game.getExitButton().getButtonHeight()) {
            Gdx.app.exit();
        }
        return true;
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
