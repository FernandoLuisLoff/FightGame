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

    // 🧠 PERSONALIDADE
    private float aggressiveness = 0.7f; // 0 = defensivo | 1 = agressivo

    // 🧠 MEMÓRIA
    private float lastActionTime = 0;
    private float actionCooldown = 0.2f;

    public EnemyAI(MyGdxGame game, Personagem enemy, Personagem player) {
        this.game = game;
        this.enemy = enemy;
        this.player = player;
    }

    public void update(float delta) {
        if (game.getGameState() != GameState.RUNNING) return;

        timer += delta;
        hadoukenCooldown -= delta;
        lastActionTime -= delta;

        if (timer < reactionTime) return;

        // 🎲 Tempo de reação variável (mais humano)
        reactionTime = 0.15f + (float)Math.random() * 0.2f;

        timer = 0;

        think();
    }

    private void think() {
        float distance = player.getImgX() - enemy.getImgX();
        float absDistance = Math.abs(distance);

        // 🔄 Levantar se estiver abaixado
        if (enemy.getPosition() == PersonagensPositions.DOWNING) {
            if (Math.random() < (1 - aggressiveness)) {
                enemy.setPosition(PersonagensPositions.UPPERING);
                reset();
                return;
            }
        }

        boolean canAct = !enemy.isDowning()
                && !enemy.isPunching()
                && !enemy.isHiting()
                && !enemy.isHadoukenAttacking();

        if (!canAct || lastActionTime > 0) return;

        // 🔄 Virar pro lado certo
        enemy.setRight(distance > 0);

        // =========================
        // 🧠 DEFESA / REAÇÃO
        // =========================
        if (player.isPunching() || player.isHadoukenAttacking()) {
            if (Math.random() < (1 - aggressiveness)) {
                enemy.down(); // esquiva
                reset();
                return;
            }
        }

        // =========================
        // 🎯 PUNISH (punir erro)
        // =========================
        if (player.isPunching() && !player.isHiting()) {
            if (Math.random() < 0.6) {
                enemy.punch();
                reset();
                return;
            }
        }

        // =========================
        // 🛫 ANTI-AIR
        // =========================
        if (player.isJumping()) {
            if (Math.random() < 0.75f) {
                enemy.punch();
                reset();
            }
            return;
        }

        // =========================
        // 🔥 LONG RANGE
        // =========================
        if (absDistance > 200) {
            if (enemy.getEnergy() >= 100 && hadoukenCooldown <= 0) {
                if (Math.random() < aggressiveness) {
                    enemy.setPosition(PersonagensPositions.HADOUKEN_ATTACKING);
                    hadoukenCooldown = 2f;
                    reset();
                    return;
                }
            }

            // Às vezes não vai direto (fake movement)
            if (Math.random() < 0.8f) {
                approach(distance);
            }
            return;
        }

        // =========================
        // 🚶 MID RANGE
        // =========================
        if (absDistance > 80) {
            if (Math.random() < aggressiveness) {
                approach(distance);
            } else {
                // movimento fake (anda e para)
                if (Math.random() < 0.5) {
                    approach(distance);
                }
            }
            return;
        }

        // =========================
        // 🥊 CLOSE COMBAT
        // =========================
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

        if (r < 0.5 * aggressiveness) {
            enemy.punch();
        } else if (r < 0.7) {
            enemy.down();
        } else if (r < 0.9) {
            enemy.jump();
        } else {
            // 🎲 erro proposital (fica parado)
        }

        reset();
    }

    private void reset() {
        enemy.setStateTime(0);
        lastActionTime = actionCooldown;
    }
}