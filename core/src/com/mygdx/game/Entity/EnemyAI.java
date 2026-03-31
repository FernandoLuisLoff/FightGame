package com.mygdx.game.Entity;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Enum.GameState;
import com.mygdx.game.Enum.PersonagensPositions;

public class EnemyAI {
    private MyGdxGame game;

    private Personagem enemy;
    private Personagem player;

    private float timer = 0;
    private float reactionTime = 0.25f;
    private float hadoukenCooldown = 0;

    public EnemyAI(MyGdxGame game, Personagem enemy, Personagem player) {
        this.game = game;
        this.enemy = enemy;
        this.player = player;
    }

    public void update(float delta) {
        if (game.getGameState() != GameState.RUNNING) {
            return;
        } 

        timer += delta;
        hadoukenCooldown -= delta;

        if (timer < reactionTime) return;
        timer = 0;

        think();
    }

    private void think() {
        float distance = player.getImgX() - enemy.getImgX();
        float absDistance = Math.abs(distance);

        boolean canAct =
                !enemy.isDowning() &&
                !enemy.isPunching() &&
                !enemy.isHiting() &&
                !enemy.isHadoukenAttacking();

        if (!canAct) return;

        if (enemy.getPosition() == PersonagensPositions.DOWNING && absDistance > 0.7) {
            enemy.setPosition(PersonagensPositions.UPPERING);
        }

        // 🔄 Virar pro lado certo
        if (distance > 0) {
            enemy.setRight(true);
        } else {
            enemy.setRight(false);
        }

        // 🛫 Anti-air
        if (player.isJumping()) {
            if (Math.random() < 0.7) {
                enemy.punch();
                reset();
            }
            return;
        }

        // 🔥 Long range
        if (absDistance > 200) {
            if (enemy.getEnergy() >= 100 && hadoukenCooldown <= 0) {
                enemy.setPosition(PersonagensPositions.HADOUKEN_ATTACKING);
                hadoukenCooldown = 2f;
                reset();
            } else {
                approach(distance);
            }
            return;
        }

        // 🚶 Mid range
        if (absDistance > 80) {
            approach(distance);
            return;
        }

        // 🥊 Close combat
        closeCombat();
    }

    private void approach(float distance) {
        if (distance > 0) {
            enemy.moveRight();
        } else {
            enemy.moveLeft();
        }
        reset();
    }

    private void closeCombat() {
        double r = Math.random();

        if (r < 0.5) {
            enemy.punch();
        } else if (r < 0.7) {
            enemy.down();
        } else {
            enemy.jump();
        }

        reset();
    }

    private void reset() {
        enemy.setStateTime(0);
    }
}