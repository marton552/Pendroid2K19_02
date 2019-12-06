package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class Madar extends OneSpriteAnimatedActor {

    MenuStage stage;
    float stepSize;
    float speed = 20;

    float sX, eX, y;

    public Madar(float sX, float y, float eX, MenuStage stage) {
        super(Assets.manager.get(Assets.MADAR_ATLAS));
        this.stage = stage;
        this.sX = sX; this.y = y; this.eX = eX;

        setLooping(true);

        setSize(getWidth() / 20, getHeight() / 20);
        setPosition(sX, y);
        stage.isAllatOut = true;
        setAlpha(0f);

        stepSize = (eX - sX) / speed;

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                madarClicked();
            }
        });
    }

    public void madarClicked() {
        stage.game.save.putFloat("penz_mennyiseg", stage.game.save.getFloat("penz_mennyiseg") + 15);
        stage.game.save.flush();
        stage.getActors().removeValue(this, false);
        stage.isAllatOut = false;
    }
}
