package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame.Takony;

public class FallingTakony extends Takony {

    float fallingSpeed;

    public FallingTakony(float fallingSpeed) {
        super();
        this.fallingSpeed = fallingSpeed;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setY(getY() - fallingSpeed);
    }
}
