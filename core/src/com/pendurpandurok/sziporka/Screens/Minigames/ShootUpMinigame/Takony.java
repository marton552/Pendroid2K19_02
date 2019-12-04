package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Takony extends OneSpriteStaticActor {
    public Takony() {
        super(Assets.manager.get(Assets.TAKONY));

        setSize(getWidth() / 10, getHeight() / 10);
        addBaseCollisionRectangleShape();
    }
}
