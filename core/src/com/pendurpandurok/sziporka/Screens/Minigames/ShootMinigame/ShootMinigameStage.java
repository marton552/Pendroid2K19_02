package com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.MyGdxGame;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class ShootMinigameStage extends MyStage {

    ArrayList<Goblin> goblins = new ArrayList<>();

    public ShootMinigameStage(MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), game);



    }

    @Override
    public void init() {

    }
}
