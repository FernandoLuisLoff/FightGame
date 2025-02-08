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
    private float stateTime = 0;
    private String name;
    private int life;
    private int energy;

    private Sprite sprite;
    private AnimationPlayer animationPlayer;
    private PersonagemInputKeys inputKeys;

    private float widthImg;
    private float upperHeightImg;
    private float downHeightImg;

    private float imgX;
    private float imgY;

    private PersonagensPositions position;

    private boolean isRight;

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

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
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

    public Personagem(MyGdxGame game, String name, AnimationPlayer animationPlayer, boolean isRight, PersonagemInputKeys inputKeys, float widthImg, float heightImg, float imgX, float imgY) {
        this.game = game;
        this.name = name;
        this.animationPlayer = animationPlayer;
        this.isRight = isRight;
        this.position = PersonagensPositions.STOP;
        this.inputKeys = inputKeys;
        this.widthImg = widthImg;
        this.upperHeightImg = heightImg;
        this.downHeightImg = heightImg/2;
        this.imgX = imgX;
        this.imgY = imgY;
        this.ground = imgY;

        sprite = new Sprite(animationPlayer.getAnimationStop().getKeyFrame(stateTime));

        life = 100;
        energy = 0;
    }

    public Sprite getImg() {
        stateTime += Gdx.graphics.getDeltaTime();
        sprite.setPosition(imgX - widthImg/2, imgY - upperHeightImg/2);
        sprite.setSize(widthImg, upperHeightImg);

        switch (position) {
            case STOP:
                if (life > 25) {
                    sprite.setRegion(animationPlayer.getAnimationStop().getKeyFrame(stateTime));
                } else {
                    sprite.setRegion(animationPlayer.getAnimationStunned().getKeyFrame(stateTime));
                }
                break;
            case MOVE:
                sprite.setRegion(animationPlayer.getAnimationMove().getKeyFrame(stateTime));
                break;
            case JUMP:
                sprite.setRegion(animationPlayer.getFrameJump(jumpVelocity));
                break;
            case JUMP_MOVE:
                sprite.setRegion(animationPlayer.getFrameJump(jumpVelocity));
                break;
            case DOWNING:
                sprite.setRegion(animationPlayer.getAnimationDowning().getKeyFrame(stateTime));
                break;
            case UPPERING:
                sprite.setRegion(animationPlayer.getAnimationUppering().getKeyFrame(stateTime));
                if (stateTime > animationPlayer.getAnimationUppering().getAnimationDuration()) {
                    position = PersonagensPositions.STOP;
                    stateTime = 0;
                }
                break;
            case HITING:
                sprite.setRegion(animationPlayer.getAnimationHiting().getKeyFrame(stateTime));
                if (stateTime > animationPlayer.getAnimationHiting().getAnimationDuration()) {
                    position = PersonagensPositions.STOP;
                    stateTime = 0;
                }
                break;
            case PUNCH:
                sprite.setRegion(animationPlayer.getAnimationPunch().getKeyFrame(stateTime));
                if (stateTime > animationPlayer.getAnimationPunch().getAnimationDuration()) {
                    position = PersonagensPositions.STOP;
                    stateTime = 0;
                }
                break;
            case HADOUKEN_ATTACKING:
                sprite.setRegion(animationPlayer.getAnimationHadoukenAttack().getKeyFrame(stateTime));
                if (stateTime > animationPlayer.getAnimationHadoukenAttack().getAnimationDuration()) {
                    hadouken();
                    position = PersonagensPositions.STOP;
                    stateTime = 0;
                }
                break;
            case KO:
                sprite.setRegion(animationPlayer.getAnimationKO().getKeyFrame(stateTime));
                break;
            case WINNER:
                sprite.setRegion(animationPlayer.getAnimationWinner().getKeyFrame(stateTime));
                break;
            default:
                sprite.setRegion(animationPlayer.getAnimationStop().getKeyFrame(stateTime));
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
        if (!isDowning() && !isPunching() && !isHiting() && !isHadoukenAttacking() && !isHadoukenAttacking()) {
            if (!isJumping()) {
                position = PersonagensPositions.MOVE;
            } else {
                position = PersonagensPositions.JUMP_MOVE;
            }

            isRight = true;
            speed = 10;
        }
    }

    public void moveLeft() {
        if (!isDowning() && !isPunching() && !isHiting() && !isHadoukenAttacking() && !isHadoukenAttacking()) {
            if (!isJumping()) {
                position = PersonagensPositions.MOVE;
            } else {
                position = PersonagensPositions.JUMP_MOVE;
            }

            isRight = false;
            speed = -10;
        }
    }

    public void stopMove() {
        if (!isDowning() && !isPunching() && !isHiting() && !isHadoukenAttacking() && !isHadoukenAttacking()) {
            if (!isJumping()) {
                position = PersonagensPositions.STOP;
            } else {
                position = PersonagensPositions.JUMP;
            }

            speed = 0;
        }
    }

    public void jump() {
        if (!isJumping()) {
            if (position == PersonagensPositions.STOP) {
                position = PersonagensPositions.JUMP;
            } else if (position == PersonagensPositions.MOVE) {
                position = PersonagensPositions.JUMP_MOVE;
            }

            jumpVelocity = 30;
        }
    }

    public void down() {
        if (!isJumping() && !isPunching() && !isHiting() && !isHadoukenAttacking()) {
            speed = 0;
            position = PersonagensPositions.DOWNING;
        }
    }

    public void hadouken() {
        if (isRight()) {
            game.getHadoukenController().newHadouken(HadoukenPositions.RIGHT, imgX + 150, imgY + upperHeightImg / 5);
        } else if (isLeft()) {
            game.getHadoukenController().newHadouken(HadoukenPositions.LEFT, imgX - 150, imgY + upperHeightImg / 5);
        }
        energy = 0;

        game.getSoundController().hadoukenSpeakSound();
        game.getSoundController().hadoukenSound();
    }

    public void punch() {
        if (!isJumping()) {
            speed = 0;
            position = PersonagensPositions.PUNCH;
            game.getPersonagemController().testPunchHit(this);
        }
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isLeft() {
        return !isRight;
    }

    public boolean isJumping() {
        return EnumSet.of(
                PersonagensPositions.JUMP,
                PersonagensPositions.JUMP_MOVE
        ).contains(position);
    }

    public boolean isDowning() {
        return EnumSet.of(
                PersonagensPositions.DOWNING,
                PersonagensPositions.UPPERING
        ).contains(position);
    }

    public boolean isPunching() {
        return position == PersonagensPositions.PUNCH;
    }

    public boolean isHiting() {
        return position == PersonagensPositions.HITING;
    }

    public boolean isHadoukenAttacking() {
        return position == PersonagensPositions.HADOUKEN_ATTACKING;
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
