package com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
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
    float speed = 50f;
    int csiki = 0;
    boolean canCsiki = true;

    float oY = 0;

    public CleanMinigameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);

        ember = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        ember.setSize(500, 500);
        ember.setPosition(getViewport().getWorldWidth() / 2 - ember.getWidth() / 2, getViewport().getWorldHeight() / 2 - ember.getHeight() / 2);
        oY = ember.getY();
        ember.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                if(counter >= csiki) csiki = counter + 40 + MathUtils.random(0, 10);
                System.out.println(counter+" : "+csiki);
            }
        });
        addActor(ember);


    }

    @Override
    public void act(float delta) {
        super.act(delta);
        counter++;

        float tSpeed = speed;

        if(counter <= csiki) {
            tSpeed = 2f;
        }

        ember.setY(oY + (float)Math.sin(counter / tSpeed) * 3f);
    }

    @Override
    public void init() {

    }
}
