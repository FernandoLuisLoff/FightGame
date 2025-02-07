package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHadouken {
    private MyAnimationUtils animationUtils = new MyAnimationUtils();
    private GameAssetManager manager;
    private Animation<TextureRegion> animationHadouken;

    public AnimationHadouken(GameAssetManager manager) {
        this.manager = manager;
        initAnimationHadouken();
    }

    private void initAnimationHadouken() {
        Texture hadoukenSheet = manager.getHadouken();
        animationHadouken = animationUtils.createAnimation(hadoukenSheet, 7, 1, 0.1f, Animation.PlayMode.LOOP);
    }

    public Animation<TextureRegion> getAnimation() {
        return animationHadouken;
    }
}
