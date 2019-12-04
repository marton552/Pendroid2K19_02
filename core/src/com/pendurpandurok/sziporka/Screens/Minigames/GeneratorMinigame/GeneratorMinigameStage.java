package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class GeneratorMinigameStage extends MyStage {
    public GeneratorMinigameStage(MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);

    }

    @Override
    public void init() {

    }
}
