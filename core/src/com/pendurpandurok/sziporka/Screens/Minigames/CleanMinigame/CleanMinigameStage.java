package com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class CleanMinigameStage extends MyStage {

    public CleanMinigameStage(MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);

    }

    @Override
    public void init() {

    }
}
