package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Enum.HadoukenPositions;
import com.mygdx.game.MyGdxGame;

public class Hadouken {
    private MyGdxGame game;

    private Animation<TextureRegion> animation;
    private float stateTime;
    private Sprite sprite;

    private int widthImg;
    private int heightImg;

    private float imgX;
    private float imgY;

    private HadoukenPositions position;
    private ParticleEffect particleEffect;

    private float speed;

    public HadoukenPositions getPosition() {
        return position;
    }

    public void setPosition(HadoukenPositions position) {
        this.position = position;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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

    public Hadouken(MyGdxGame game, HadoukenPositions position, int widthImg, int heightImg, float imgX, float imgY, float speed) {
        this.game = game;
        this.position = position;
        this.widthImg = widthImg;
        this.heightImg = heightImg;
        this.imgX = imgX;
        this.imgY = imgY;
        this.speed = speed;

        particleEffect = new ParticleEffect();
        particleEffect.load(Gdx.files.internal("particles/hadouken_particles.p"), Gdx.files.internal("particles/"));
        particleEffect.setPosition(this.imgX - this.widthImg / 2, this.imgY - this.heightImg / 2);
        particleEffect.start();


        stateTime = 0f;
        animation = game.getGameAssetManager().getAnimationHadouken().getAnimation();
        sprite = new Sprite(animation.getKeyFrame(stateTime));
    }

    public boolean isOffScreen() {
        return imgX > Gdx.graphics.getWidth() + 50 || imgX < -50;
    }

    public void render() {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(stateTime);

        sprite.setRegion(currentFrame);
        sprite.setSize(widthImg, heightImg);
        sprite.setPosition(imgX - widthImg / 2, imgY - heightImg / 2);


        switch (position) {
            case RIGHT:
                if (sprite.isFlipX()) {
                    sprite.flip(true, false);
                }
                break;
            case LEFT:
                if (!sprite.isFlipX()) {
                    sprite.flip(true, false);
                }
                break;
        }

        sprite.draw(game.getBatch());

        particleEffect.setPosition(imgX - widthImg / 2, imgY - heightImg / 2);
        particleEffect.update(Gdx.graphics.getDeltaTime());
        particleEffect.draw(game.getBatch());
    }

    public void dispose() {
        particleEffect.dispose();
    }
}
