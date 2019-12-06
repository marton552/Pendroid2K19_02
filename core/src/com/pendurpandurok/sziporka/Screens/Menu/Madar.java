package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class Madar extends OneSpriteAnimatedActor {

    MenuStage stage;
    float iX = 20;

    float sX, y, eX;

    public Madar(float sX, float y, float iX, float eX, MenuStage stage) {
        super(Assets.manager.get(Assets.MADAR_ATLAS));
        this.stage = stage;
        this.sX = sX; this.y = y; this.iX = iX; this.eX = eX;

        setLooping(true);
        setFps(15);

        setSize(getWidth() / 20, getHeight() / 20);
        setPosition(sX, y);
        stage.isAllatOut = true;

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

    @Override
    public void act(float delta) {
        super.act(delta);

        setX(getX() + iX);

        if(getX() < eX) {
            stage.getActors().removeValue(this, false);
            stage.isAllatOut = false;
        }
    }
}
