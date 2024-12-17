package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHadouken {
    private GameAssetManager manager;

    private Animation<TextureRegion> animation;
    private Animation<TextureRegion> animationHit;

    public AnimationHadouken(GameAssetManager manager) {
        this.manager = manager;
        initAnimationHadouken();
    }

    private void initAnimationHadouken() {
        Texture hadoukenSheet = manager.getHadouken();
        TextureRegion[][] tempFrames = TextureRegion.split(hadoukenSheet, hadoukenSheet.getWidth() / 7, hadoukenSheet.getHeight());

        TextureRegion[] frames = new TextureRegion[7];
        for (int i=0; i < tempFrames[0].length; i++) {
            frames[i] = tempFrames[0][i];
        }

        animation = new Animation<>(0.1f, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public Animation<TextureRegion> getAnimationHit() {
        return animationHit;
    }
}
