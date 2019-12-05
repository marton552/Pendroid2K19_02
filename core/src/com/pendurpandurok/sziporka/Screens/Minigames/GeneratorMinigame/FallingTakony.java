package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame.Takony;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FallingTakony extends OneSpriteStaticActor {

    float fallingSpeed;

    public FallingTakony(float fallingSpeed) {
        super(Assets.manager.get(Assets.TAKONY));
        this.fallingSpeed = fallingSpeed;

        setSize(getWidth() / 10, getHeight() / 10);
        addBaseCollisionCircleShape();

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setY(getY() - fallingSpeed);
    }
}
