package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationPlayer {
    private MyAnimationUtils animation = new MyAnimationUtils();
    private Animation<TextureRegion> animationStop;

    private Animation<TextureRegion> animationMove;

    public AnimationPlayer(TexturesPlayer texturesPlayer) {
        animationStop = animation.createAnimation(texturesPlayer.getPlayerStop(), 4, 1, 0.1f, Animation.PlayMode.LOOP);
        animationMove = animation.createAnimation(texturesPlayer.getPlayerMove(), 5, 1, 0.1f, Animation.PlayMode.LOOP);
    }

    public Animation<TextureRegion> getAnimationStop() {
        return animationStop;
    }

    public Animation<TextureRegion> getAnimationMove() {
        return animationMove;
    }
}
