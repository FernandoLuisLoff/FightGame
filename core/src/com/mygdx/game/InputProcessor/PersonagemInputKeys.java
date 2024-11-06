package com.mygdx.game.InputProcessor;

public class PersonagemInputKeys {
    Integer keyRight;
    Integer keyLeft;
    Integer keyJump;
    Integer keyDown;
    Integer keyPunch;
    Integer keyHadouken;

    public Integer getKeyRight() {
        return keyRight;
    }

    public void setKeyRight(Integer keyRight) {
        this.keyRight = keyRight;
    }

    public Integer getKeyLeft() {
        return keyLeft;
    }

    public void setKeyLeft(Integer keyLeft) {
        this.keyLeft = keyLeft;
    }

    public Integer getKeyJump() {
        return keyJump;
    }

    public void setKeyJump(Integer keyJump) {
        this.keyJump = keyJump;
    }

    public Integer getKeyDown() {
        return keyDown;
    }

    public void setKeyDown(Integer keyDown) {
        this.keyDown = keyDown;
    }

    public Integer getKeyPunch() {
        return keyPunch;
    }

    public void setKeyPunch(Integer keyPunch) {
        this.keyPunch = keyPunch;
    }

    public Integer getKeyHadouken() {
        return keyHadouken;
    }

    public void setKeyHadouken(Integer keyHadouken) {
        this.keyHadouken = keyHadouken;
    }

    public PersonagemInputKeys(Integer keyRight, Integer keyLeft, Integer keyJump, Integer keyDown, Integer keyPunch, Integer keyHadouken) {
        this.keyRight = keyRight;
        this.keyLeft = keyLeft;
        this.keyJump = keyJump;
        this.keyDown = keyDown;
        this.keyPunch = keyPunch;
        this.keyHadouken = keyHadouken;
    }
}
