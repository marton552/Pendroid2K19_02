package com.pendurpandurok.sziporka.Screens.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class GameStage extends MyStage {

    public MyGdxGame game;

    public GameStage(MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), game);
        this.game = game;


    }

    @Override
    public void init() {

    }
}
