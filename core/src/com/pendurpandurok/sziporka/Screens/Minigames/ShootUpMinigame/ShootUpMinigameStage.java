package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class ShootUpMinigameStage extends MyStage {
    public ShootUpMinigameStage(Batch batch, MyGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);
    }

    @Override
    public void init() {

    }
}
