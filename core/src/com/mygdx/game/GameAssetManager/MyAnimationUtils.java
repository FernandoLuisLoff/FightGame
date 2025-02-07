package com.mygdx.game.GameAssetManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnimationUtils {
        public com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> createAnimation(Texture texture, int frameCols, int frameRows, float frameDuration, com.badlogic.gdx.graphics.g2d.Animation.PlayMode playMode) {
        TextureRegion[][] tempFrames = TextureRegion.split(texture, texture.getWidth() / frameCols, texture.getHeight() / frameRows);

        TextureRegion[] frames = new TextureRegion[frameCols * frameRows];
        int index = 0;
        for (int i = 0; i < frameRows; i++) {
            for (int j = 0; j < frameCols; j++) {
                frames[index++] = tempFrames[i][j];
            }
        }

        com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> animation = new com.badlogic.gdx.graphics.g2d.Animation<>(frameDuration, frames);
        animation.setPlayMode(playMode);
        return animation;
    }
}
