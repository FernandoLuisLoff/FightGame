package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationPlayer {
    private MyAnimationUtils animation = new MyAnimationUtils();

    private Animation<TextureRegion> animationStop;
    private Animation<TextureRegion> animationStunned;
    private Animation<TextureRegion> animationMove;
    private Animation<TextureRegion> animationPunch;
    private Animation<TextureRegion> animationDowning;
    private Animation<TextureRegion> animationUppering;
    private Animation<TextureRegion> animationHiting;
    private Animation<TextureRegion> animationHadoukenAttack;
    private Animation<TextureRegion> animationKO;
    private Animation<TextureRegion> animationWinner;
    private TextureRegion[][] jumpFrames;

    public AnimationPlayer(TexturesPlayer texturesPlayer) {
        animationStop = animation.createAnimation(texturesPlayer.getPlayerStop(), 4, 1, 0.1f, Animation.PlayMode.LOOP);
        animationStunned = animation.createAnimation(texturesPlayer.getPlayerStunned(), 3, 1, 0.2f, Animation.PlayMode.LOOP);
        animationMove = animation.createAnimation(texturesPlayer.getPlayerMove(), 5, 1, 0.1f, Animation.PlayMode.LOOP);
        animationPunch = animation.createAnimation(texturesPlayer.getPlayerPunch(), 5, 1, 0.1f, Animation.PlayMode.NORMAL);
        animationDowning = animation.createAnimation(texturesPlayer.getPlayerDown(), 2, 1, 0.1f, Animation.PlayMode.NORMAL);
        animationUppering = animation.createAnimation(texturesPlayer.getPlayerDown(), 2, 1, 0.1f, Animation.PlayMode.REVERSED);
        animationHiting = animation.createAnimation(texturesPlayer.getPlayerHiting(), 4, 1, 0.1f, Animation.PlayMode.NORMAL);
        animationHadoukenAttack = animation.createAnimation(texturesPlayer.getPlayerHadoukenAttack(), 4, 1, 0.1f, Animation.PlayMode.NORMAL);
        animationKO = animation.createAnimation(texturesPlayer.getPlayerKO(), 3, 1, 0.1f, Animation.PlayMode.NORMAL);
        animationWinner = animation.createAnimation(texturesPlayer.getPlayerWinner(), 3, 1, 0.1f, Animation.PlayMode.NORMAL);

        jumpFrames = TextureRegion.split(texturesPlayer.getPlayerJump(), texturesPlayer.getPlayerJump().getWidth() / 3, texturesPlayer.getPlayerJump().getHeight());
    }

    public Animation<TextureRegion> getAnimationStop() {
        return animationStop;
    }

    public Animation<TextureRegion> getAnimationStunned() {
        return animationStunned;
    }

    public Animation<TextureRegion> getAnimationMove() {
        return animationMove;
    }

    public Animation<TextureRegion> getAnimationPunch() {
        return animationPunch;
    }

    public Animation<TextureRegion> getAnimationDowning() {
        return animationDowning;
    }

    public Animation<TextureRegion> getAnimationUppering() {
        return animationUppering;
    }

    public Animation<TextureRegion> getAnimationHiting() {
        return animationHiting;
    }

    public Animation<TextureRegion> getAnimationHadoukenAttack() {
        return animationHadoukenAttack;
    }

    public Animation<TextureRegion> getAnimationKO() {
        return animationKO;
    }

    public Animation<TextureRegion> getAnimationWinner() {
        return animationWinner;
    }

    public TextureRegion getFrameJump(Float speed) {
        if (speed > 20 || speed < -20) {
            return jumpFrames[0][0];
        } else if ((speed <= 20 && speed > 10) || (speed >= -20 && speed < -10)) {
            return jumpFrames[0][1];
        } else if (speed <= 10 && speed >= 0 || speed >= -10) {
            return jumpFrames[0][2];
        } else {
            return jumpFrames[0][0];
        }
    }
}
