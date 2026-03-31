package com.mygdx.game.InputProcessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.MyGdxGame;

public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    private MyGdxGame game;
    
    private int resetKey = Input.Keys.ENTER;
    private int pauseKey = Input.Keys.P;

    private int keyJump = Input.Keys.W;
    private int keyDown = Input.Keys.S;
    private int keyRight = Input.Keys.D;
    private int keyLeft = Input.Keys.A;
    private int keyHadouken = Input.Keys.H;
    private int keyPunch = Input.Keys.J;
    private Personagem personagem;

    public InputProcessor(MyGdxGame game) {
        this.game = game;
        this.personagem = this.game.getPersonagemController().getPersonagens().get(0);
    }

    @Override
    public boolean keyDown(int i) {
        if (game.getGameState() == GameState.PAUSED) {
            if (i == pauseKey) {
                game.setGameState(GameState.RUNNING);
            }
        } else if (game.getGameState() == GameState.RUNNING) {
            boolean resetTime = false;
            boolean notTakingAction = !personagem.isDowning() 
                && !personagem.isPunching()
                && !personagem.isHiting()
                && !personagem.isHadoukenAttacking();
                
            if (i == pauseKey) {
                game.setGameState(GameState.PAUSED);
            }
            if (i == keyJump) {
                personagem.jump();
                resetTime = true;
            }
            if (i == keyRight) {
                personagem.moveRight();
                resetTime = true;
            }
            if (i == keyLeft) {
                personagem.moveLeft();
                resetTime = true;
            }
            if (notTakingAction) {
                if (i == keyHadouken) {
                    if (personagem.getEnergy() >= 100) {
                        personagem.setPosition(PersonagensPositions.HADOUKEN_ATTACKING);
                        resetTime = true;
                    }
                }
                if (i == keyDown) {
                    personagem.down();
                    resetTime = true;
                }
                if (i == keyPunch) {
                    personagem.punch();
                    resetTime = true;
                }
            }

            if (resetTime && notTakingAction) {
                personagem.setStateTime(0);
            }
        } else if (game.getGameState() == GameState.END_GAME) {
            if (i == resetKey) {
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
                boolean notTakingAction = !personagem.isDowning() 
                    && !personagem.isPunching()
                    && !personagem.isHiting()
                    && !personagem.isHadoukenAttacking();

                if (i == keyRight || i == keyLeft) {
                    personagem.stopMove();
                    resetTime = true;
                } 
                if (i == keyDown && personagem.isDowning()) {
                    personagem.setPosition(PersonagensPositions.UPPERING);
                    resetTime = true;
                }
                if (resetTime && notTakingAction) {
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
