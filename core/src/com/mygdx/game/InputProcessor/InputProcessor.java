package com.mygdx.game.InputProcessor;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Controller.HadoukenController;
import com.mygdx.game.Controller.PersonagemController;
import com.mygdx.game.Entity.ExitButton;
import com.mygdx.game.Entity.Personagem;
import com.mygdx.game.Enum.GameState;
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
                if (i == personagem.getInputKeys().keyJump) {
                    personagem.jump();
                } else if (i == personagem.getInputKeys().keyRight) {
                    personagem.moveRight();
                } else if (i == personagem.getInputKeys().keyLeft) {
                    personagem.moveLeft();
                } else if (i == personagem.getInputKeys().keyHadouken) {
                    personagem.hadouken(game.getHadoukenController());
                } else if (i == personagem.getInputKeys().keyDown) {
                    personagem.down();
                } else if (i == personagem.getInputKeys().keyPunch) {
                    personagem.punch();
                    game.getPersonagemController().testPunchHit(personagem);
                }
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        if (game.getGameState() == GameState.RUNNING) {
            for (Personagem personagem : game.getPersonagemController().getPersonagens()) {
                if (i == personagem.getInputKeys().keyRight) {
                    personagem.stopMoveRight();
                } else if (i == personagem.getInputKeys().keyLeft) {
                    personagem.stopMoveLeft();
                } else if (i == personagem.getInputKeys().keyDown || i == personagem.getInputKeys().keyPunch) {
                    personagem.stopHadoukenOrPunch();
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
