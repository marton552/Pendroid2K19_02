package com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame;

import com.badlogic.gdx.graphics.Texture;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Goblin extends OneSpriteStaticActor {
    public Goblin() {
        super(Assets.manager.get(Assets.manager.get(Assets.GOBLIN_1)));
    }
}
