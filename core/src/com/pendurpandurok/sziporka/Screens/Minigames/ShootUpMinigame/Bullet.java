package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Bullet extends OneSpriteStaticActor {

    float dirY = 20;

    public Bullet() {
        super(Assets.manager.get(Assets.AMMO));

        setSize(getWidth() / 20, getHeight() / 20);
        addBaseCollisionRectangleShape();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setY(getY() + dirY);
    }
}
