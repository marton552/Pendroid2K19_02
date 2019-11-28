package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class MenuStage extends MyStage {

    private OneSpriteStaticActor background;
    private OneSpriteStaticActor gat;

    public MenuStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);

        background = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND));
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        background.setX(-75);
        addActor(background);

        gat = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT1));
        gat.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        gat.setX(-75);
        addActor(gat);
    }

    @Override
    public void init() {

    }
}
