package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.EnumSet;

public class Personagem {
    SpriteBatch batch;
    Texture img;

    int widthImg;
    int heightImg;

    float imgX;
    float imgY;

    PersonagensPositions position;

    float speed = 0;

    // Atributos para o pulo
    float jumpVelocity = 0;
    float gravity = -1f;
    float groundY;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public PersonagensPositions getPosition() {
        return position;
    }

    public void setPosition(PersonagensPositions position) {
        this.position = position;
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

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public int getWidthImg() {
        return widthImg;
    }

    public void setWidthImg(int widthImg) {
        this.widthImg = widthImg;
    }

    public int getHeightImg() {
        return heightImg;
    }

    public void setHeightImg(int heightImg) {
        this.heightImg = heightImg;
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

    public Personagem(PersonagensPositions position, int widthImg, int heightImg, float imgX, float imgY) {
        this.position = position;
        this.batch = new SpriteBatch();
        this.img = getImgPosition();
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.imgX = imgX;
        this.imgY = imgY;
        this.groundY = imgY;
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

    public Texture getImgPosition() {
        switch (position) {
            case STOP_RIGHT:
                return new Texture("personagem/stop_right.png");
            case STOP_LEFT:
                return new Texture("personagem/stop_left.png");
            case MOVE_RIGHT:
                return new Texture("personagem/move_right.png");
            case MOVE_LEFT:
                return new Texture("personagem/move_left.png");
            case JUMP_RIGHT:
                return new Texture("personagem/jump_right.png");
            case JUMP_LEFT:
                return new Texture("personagem/jump_left.png");
            case JUMP_MOVE_RIGHT:
                return new Texture("personagem/jump_move_right.png");
            case JUMP_MOVE_LEFT:
                return new Texture("personagem/jump_move_left.png");
            case DOWN_RIGHT:
                return new Texture("personagem/down_right.png");
            case DOWN_LEFT:
                return new Texture("personagem/down_left.png");
            case PUNCH_RIGHT:
                return new Texture("personagem/punch_right.png");
            case PUNCH_LEFT:
                return new Texture("personagem/punch_left.png");
            default:
                return new Texture("personagem/stop_right.png");
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

    public void calcPosition() {
        if (!isOffScreen()) {
            imgX += speed;
        } else {
            if (imgX <= 0) {
                imgX += 1;
            } else if (imgX >= Gdx.graphics.getWidth()) {
                imgX -= 1;
            }
        }

        if (isJumping()) {
            imgY += jumpVelocity;
            jumpVelocity += gravity; // Acelerar para baixo (gravidade)

            if (imgY <= groundY) { // Se atingir o chão
                imgY = groundY;
                if (position == PersonagensPositions.JUMP_RIGHT) {
                    position = PersonagensPositions.STOP_RIGHT;
                } else if (position == PersonagensPositions.JUMP_LEFT) {
                    position = PersonagensPositions.STOP_LEFT;
                } else if (position == PersonagensPositions.JUMP_MOVE_RIGHT) {
                    position = PersonagensPositions.MOVE_RIGHT;
                } else if (position == PersonagensPositions.JUMP_MOVE_LEFT) {
                    position = PersonagensPositions.MOVE_LEFT;
                }
                updateImg(getImgPosition());
                jumpVelocity = 0;
            }
        }
    }

    public boolean isOffScreen() {
        return imgX > Gdx.graphics.getWidth() || imgX < 0;
    }

    public void updateImg(Texture newImg) {
        img.dispose();
        img = newImg;
    }

    public void draw() {
        calcPosition();

        batch.begin();
        batch.draw(img, imgX - widthImg/2, imgY - heightImg/2, widthImg, heightImg);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
