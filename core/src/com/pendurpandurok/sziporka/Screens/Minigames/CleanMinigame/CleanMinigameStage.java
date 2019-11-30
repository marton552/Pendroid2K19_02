package com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class CleanMinigameStage extends MyStage {

    OneSpriteStaticActor ember;

    int counter = 0;
    float speed = 1;

    public CleanMinigameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);

        ember = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        ember.setSize(500, 500);
        ember.setPosition(getViewport().getWorldWidth() / 2 - ember.getWidth() / 2, getViewport().getWorldHeight() / 2 - ember.getHeight() / 2);
        ember.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                speed = 10f;
            }
        });
        addActor(ember);


    }

    @Override
    public void act(float delta) {
        super.act(delta);
        counter++;
        ember.setY(ember.getY() + (float)Math.sin(counter / 20f) * 0.14f);
    }

    @Override
    public void init() {

    }
}
