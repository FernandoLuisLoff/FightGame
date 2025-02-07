package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Enum.HadoukenPositions;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.GameAssetManager.AnimationPlayer;
import com.mygdx.game.GameAssetManager.TexturesPlayer;
import com.mygdx.game.InputProcessor.PersonagemInputKeys;
import com.mygdx.game.MyGdxGame;

import java.util.EnumSet;

public class Personagem {
    private MyGdxGame game;
    private float stateTime;
    private String name;
    private int life;
    private int energy;

    private Sprite sprite;
    private TexturesPlayer playerTextures;
    private AnimationPlayer animationPlayer;
    private PersonagemInputKeys inputKeys;

    private float widthImg;
    private float upperHeightImg;
    private float downHeightImg;

    private float imgX;
    private float imgY;

    private PersonagensPositions position;

    private float speed = 0;

    // Atributos para o pulo
    private float jumpVelocity = 0;
    private float gravity = -1f;
    private float ground;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setDownHeightImg(float downHeightImg) {
        this.downHeightImg = downHeightImg;
    }

    public PersonagemInputKeys getInputKeys() {
        return inputKeys;
    }

    public void setInputKeys(PersonagemInputKeys inputKeys) {
        this.inputKeys = inputKeys;
    }

    public float getWidthImg() {
        return widthImg;
    }

    public void setWidthImg(float widthImg) {
        this.widthImg = widthImg;
    }

    public float getUpperHeightImg() {
        return upperHeightImg;
    }

    public void setUpperHeightImg(float upperHeightImg) {
        this.upperHeightImg = upperHeightImg;
    }

    public float getDownHeightImg() {
        return downHeightImg;
    }

    public void setDownHeightImg(int downHeightImg) {
        this.downHeightImg = downHeightImg;
    }

    public float getImgX() {
        return imgX;
    }

    public void setImgX(float imgX) {
        this.imgX = imgX;
    }

    public float getImgY() {
        return imgY;
    }

    public void setImgY(float imgY) {
        this.imgY = imgY;
    }

    public PersonagensPositions getPosition() {
        return position;
    }

    public void setPosition(PersonagensPositions position) {
        this.position = position;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getJumpVelocity() {
        return jumpVelocity;
    }

    public void setJumpVelocity(float jumpVelocity) {
        this.jumpVelocity = jumpVelocity;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getGround() {
        return ground;
    }

    public void setGround(float ground) {
        this.ground = ground;
    }

    public Personagem(MyGdxGame game, String name, AnimationPlayer animationPlayer, TexturesPlayer playerTextures, PersonagensPositions position, PersonagemInputKeys inputKeys, float widthImg, float heightImg, float imgX, float imgY) {
        this.game = game;
        this.name = name;
        this.animationPlayer = animationPlayer;
        this.playerTextures = playerTextures;
        this.position = position;
        this.inputKeys = inputKeys;
        this.widthImg = widthImg;
        this.upperHeightImg = heightImg;
        this.downHeightImg = heightImg/2;
        this.imgX = imgX;
        this.imgY = imgY;
        this.ground = imgY;

        sprite = new Sprite(this.playerTextures.getPlayerStop());

        life = 100;
        energy = 0;
    }

    public Sprite getImg() {
        stateTime += Gdx.graphics.getDeltaTime();
        sprite.setPosition(imgX - widthImg/2, imgY - upperHeightImg/2);
        sprite.setSize(widthImg, getHeightImg());

        switch (position) {
            case STOP_RIGHT:
                sprite.setRegion(animationPlayer.getAnimationStop().getKeyFrame(stateTime));
                break;
            case STOP_LEFT:
                sprite.setRegion(animationPlayer.getAnimationStop().getKeyFrame(stateTime));
                break;
            case MOVE_RIGHT:
                sprite.setRegion(animationPlayer.getAnimationMove().getKeyFrame(stateTime));
                break;
            case MOVE_LEFT:
                sprite.setRegion(animationPlayer.getAnimationMove().getKeyFrame(stateTime));
                break;
            case JUMP_RIGHT:
                sprite.setTexture(playerTextures.getPlayerJump());
                break;
            case JUMP_LEFT:
                sprite.setTexture(playerTextures.getPlayerJump());
                break;
            case JUMP_MOVE_RIGHT:
                sprite.setTexture(playerTextures.getPlayerJumpMove());
                break;
            case JUMP_MOVE_LEFT:
                sprite.setTexture(playerTextures.getPlayerJumpMove());
                break;
            case DOWN_RIGHT:
                sprite.setTexture(playerTextures.getPlayerDown());
                break;
            case DOWN_LEFT:
                sprite.setTexture(playerTextures.getPlayerDown());
                break;
            case PUNCH_RIGHT:
                sprite.setTexture(playerTextures.getPlayerPunch());
                break;
            case PUNCH_LEFT:
                sprite.setTexture(playerTextures.getPlayerPunch());
                break;
            default:
                sprite.setTexture(playerTextures.getPlayerStop());
        }

        if ((isRight() && sprite.isFlipX()) || (isLeft() && !sprite.isFlipX())) {
            sprite.flip(true, false);
        }

        return sprite;
    }

    public float getHeightImg() {
        if (isDowning()) {
            return downHeightImg;
        } else {
            return upperHeightImg;
        }
    }

    public void moveRight() {
        if (!isDowning() && !isPunching()) {
            if (!isJumping()) {
                position = PersonagensPositions.MOVE_RIGHT;
            } else {
                position = PersonagensPositions.JUMP_MOVE_RIGHT;
            }
            speed = 10;
        }
    }

    public void stopMoveRight() {
        if (!isDowning() && !isPunching()) {
            if (!isJumping()) {
                position = PersonagensPositions.STOP_RIGHT;
            } else {
                position = PersonagensPositions.JUMP_RIGHT ;
            }
            speed = 0;
        }
    }

    public void moveLeft() {
        if (!isDowning() && !isPunching()) {
            if (!isJumping()) {
                position = PersonagensPositions.MOVE_LEFT;
            } else {
                position = PersonagensPositions.JUMP_MOVE_LEFT;
            }
            speed = -10;
        }
    }

    public void stopMoveLeft() {
        if (!isDowning() && !isPunching()) {
            if (!isJumping()) {
                position = PersonagensPositions.STOP_LEFT;
            } else {
                position = PersonagensPositions.JUMP_LEFT;
            }
            speed = 0;
        }
    }

    public void jump() {
        if (!isJumping()) {
            if (position == PersonagensPositions.STOP_RIGHT) {
                position = PersonagensPositions.JUMP_RIGHT;
            } else if (position == PersonagensPositions.STOP_LEFT) {
                position = PersonagensPositions.JUMP_LEFT;
            } else if (position == PersonagensPositions.MOVE_RIGHT) {
                position = PersonagensPositions.JUMP_MOVE_RIGHT;
            } else if (position == PersonagensPositions.MOVE_LEFT) {
                position = PersonagensPositions.JUMP_MOVE_LEFT;
            }

            jumpVelocity = 30;
        }
    }

    public void down() {
        if (!isJumping()) {
            speed = 0;
            if (isRight()) {
                position = PersonagensPositions.DOWN_RIGHT;
            } else if (isLeft()) {
                position = PersonagensPositions.DOWN_LEFT;
            }
        }
    }

    public void hadouken() {
        if (energy >= 100 && !isDowning()) {
            if (isRight()) {
                game.getHadoukenController().newHadouken(HadoukenPositions.RIGHT, imgX + 150, imgY + upperHeightImg / 3);
            } else if (isLeft()) {
                game.getHadoukenController().newHadouken(HadoukenPositions.LEFT, imgX - 150, imgY + upperHeightImg / 3);
            }
            energy = 0;

            game.getSoundController().hadoukenSpeakSound();
            game.getSoundController().hadoukenSound();
        }
    }

    public void punch() {
        if (!isJumping()) {
            speed = 0;
            if (isRight()) {
                position = PersonagensPositions.PUNCH_RIGHT;
            } else if (isLeft()) {
                position = PersonagensPositions.PUNCH_LEFT;
            }

            game.getPersonagemController().testPunchHit(this);
        }
    }

    public void stopHadoukenOrPunch() {
        if (!isJumping()) {
            if (isRight()) {
                position = PersonagensPositions.STOP_RIGHT;
            } else if (isLeft()) {
                position = PersonagensPositions.STOP_LEFT;
            }
        }
    }

    public boolean isRight() {
        return EnumSet.of(
                PersonagensPositions.STOP_RIGHT,
                PersonagensPositions.MOVE_RIGHT,
                PersonagensPositions.JUMP_RIGHT,
                PersonagensPositions.JUMP_MOVE_RIGHT,
                PersonagensPositions.DOWN_RIGHT,
                PersonagensPositions.PUNCH_RIGHT
        ).contains(position);
    }

    public boolean isLeft() {
        return EnumSet.of(
                PersonagensPositions.STOP_LEFT,
                PersonagensPositions.MOVE_LEFT,
                PersonagensPositions.JUMP_LEFT,
                PersonagensPositions.JUMP_MOVE_LEFT,
                PersonagensPositions.DOWN_LEFT,
                PersonagensPositions.PUNCH_LEFT
        ).contains(position);
    }

    public boolean isJumping() {
        return EnumSet.of(
                PersonagensPositions.JUMP_LEFT,
                PersonagensPositions.JUMP_RIGHT,
                PersonagensPositions.JUMP_MOVE_LEFT,
                PersonagensPositions.JUMP_MOVE_RIGHT
        ).contains(position);
    }

    public boolean isDowning() {
        return EnumSet.of(
                PersonagensPositions.DOWN_RIGHT,
                PersonagensPositions.DOWN_LEFT
        ).contains(position);
    }

    public boolean isPunching() {
        return EnumSet.of(
                PersonagensPositions.PUNCH_RIGHT,
                PersonagensPositions.PUNCH_LEFT
        ).contains(position);
    }

    public boolean hit(float x, float y) {
        if (!isDowning()) {
            float heightImg = getHeightImg();
            Boolean widthHitBoxTest = x > (imgX - widthImg/2) &&  x < (imgX + widthImg/2);
            Boolean heightHitBoxTest = y > (imgY - heightImg/2) && y < (imgY + heightImg/2);
            return widthHitBoxTest && heightHitBoxTest;
        } else {
            return false;
        }
    }

    public boolean isOffScreen() {
        return imgX > Gdx.graphics.getWidth() || imgX < 0;
    }
}
