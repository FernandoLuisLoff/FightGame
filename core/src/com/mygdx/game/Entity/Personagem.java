package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Controller.HadoukenController;
import com.mygdx.game.Enum.HadoukenPositions;
import com.mygdx.game.Enum.PersonagensPositions;
import com.mygdx.game.InputProcessor.PersonagemInputKeys;

import java.util.EnumSet;

public class Personagem {
    public static Personagem self;
    private String pathSprites;
    private Texture img;
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
    private float groundY;

    public static Personagem getSelf() {
        return self;
    }

    public static void setSelf(Personagem self) {
        Personagem.self = self;
    }

    public String getPathSprites() {
        return pathSprites;
    }

    public void setPathSprites(String pathSprites) {
        this.pathSprites = pathSprites;
    }

    public void setDownHeightImg(float downHeightImg) {
        this.downHeightImg = downHeightImg;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
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

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getGroundY() {
        return groundY;
    }

    public void setGroundY(float groundY) {
        this.groundY = groundY;
    }

    public Personagem(String pathSprites, PersonagensPositions position, PersonagemInputKeys inputKeys, float widthImg, float heightImg, float imgX, float imgY) {
        this.pathSprites = pathSprites;
        this.position = position;
        this.inputKeys = inputKeys;
        this.img = getImgPosition();
        this.widthImg = widthImg;
        this.upperHeightImg = heightImg;
        this.downHeightImg = heightImg/2;
        this.imgX = imgX;
        this.imgY = imgY;
        this.groundY = imgY;
        self = this;
    }

    public Texture getImgPosition() {
        switch (position) {
            case STOP_RIGHT:
                return new Texture(pathSprites + "/stop_right.png");
            case STOP_LEFT:
                return new Texture(pathSprites + "/stop_left.png");
            case MOVE_RIGHT:
                return new Texture(pathSprites + "/move_right.png");
            case MOVE_LEFT:
                return new Texture(pathSprites + "/move_left.png");
            case JUMP_RIGHT:
                return new Texture(pathSprites + "/jump_right.png");
            case JUMP_LEFT:
                return new Texture(pathSprites + "/jump_left.png");
            case JUMP_MOVE_RIGHT:
                return new Texture(pathSprites + "/jump_move_right.png");
            case JUMP_MOVE_LEFT:
                return new Texture(pathSprites + "/jump_move_left.png");
            case DOWN_RIGHT:
                return new Texture(pathSprites + "/down_right.png");
            case DOWN_LEFT:
                return new Texture(pathSprites + "/down_left.png");
            case PUNCH_RIGHT:
                return new Texture(pathSprites + "/punch_right.png");
            case PUNCH_LEFT:
                return new Texture(pathSprites + "/punch_left.png");
            default:
                return new Texture(pathSprites + "/stop_right.png");
        }
    }

    public void moveRight() {
        if (!isDowning() && !isPunching()) {
            if (!isJumping()) {
                position = PersonagensPositions.MOVE_RIGHT;
            } else {
                position = PersonagensPositions.JUMP_MOVE_RIGHT;
            }
            updateImg(getImgPosition());
            speed = 5;
        }
    }

    public void stopMoveRight() {
        if (!isDowning() && !isPunching()) {
            if (!isJumping()) {
                position = PersonagensPositions.STOP_RIGHT;
            } else {
                position = PersonagensPositions.JUMP_RIGHT ;
            }
            updateImg(getImgPosition());
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
            updateImg(getImgPosition());
            speed = -5;
        }
    }

    public void stopMoveLeft() {
        if (!isDowning() && !isPunching()) {
            if (!isJumping()) {
                position = PersonagensPositions.STOP_LEFT;
            } else {
                position = PersonagensPositions.JUMP_LEFT;
            }
            updateImg(getImgPosition());
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

            updateImg(getImgPosition());

            jumpVelocity = 25;
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
            updateImg(getImgPosition());
        }
    }

    public void hadouken(HadoukenController hadoukenController) {
        if (!isDowning()) {
            if (isRight()) {
                hadoukenController.newHadouken(HadoukenPositions.RIGHT, imgX + 25, imgY + upperHeightImg / 3);
            } else if (isLeft()) {
                hadoukenController.newHadouken(HadoukenPositions.LEFT, imgX - 25, imgY + upperHeightImg / 3);
            }
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
            updateImg(getImgPosition());
        }
    }

    public void stopHadoukenOrPunch() {
        if (!isJumping()) {
            if (isRight()) {
                position = PersonagensPositions.STOP_RIGHT;
            } else if (isLeft()) {
                position = PersonagensPositions.STOP_LEFT;
            }
            updateImg(getImgPosition());
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

    public boolean isOffScreen() {
        return imgX > Gdx.graphics.getWidth() || imgX < 0;
    }

    public void updateImg(Texture newImg) {
        img.dispose();
        img = newImg;
    }

    public void dispose() {
        img.dispose();
    }
}
