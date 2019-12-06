package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Hal extends OneSpriteStaticActor {
    MenuStage stage;


    int animStage = 0;
    float showStep = 1.0f / 100.0f;
    float alpha = 0;

    public Hal(float x, float y, MenuStage stage) {
        super(Assets.manager.get(Assets.HAL));
        this.stage = stage;

        setSize(getWidth() / 20, getHeight() / 20);
        setPosition(x - getWidth() / 2, y);
        stage.isAllatOut = true;
        setAlpha(0f);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                halClicked();
            }
        });
    }

    public void halClicked() {
        stage.game.save.putFloat("penz_mennyiseg", stage.game.save.getFloat("penz_mennyiseg") + 15);
        stage.game.save.flush();
        stage.getActors().removeValue(this, false);
        stage.isAllatOut = false;
    }

    int counter = 0;
    double waitTime;
    @Override
    public void act(float delta) {
        super.act(delta);
        counter++;

        setY(getY() + (float)Math.sin(counter / 10) * 2);

        if(animStage == 0) {
            alpha += showStep;
            if(alpha >= 1) alpha = 1;
            setAlpha(alpha);

            if(alpha >= 1) {
                animStage = 1;
                waitTime = System.currentTimeMillis() + 2000;
            }
        }

        if(animStage == 1) {
            if(System.currentTimeMillis() >= waitTime) animStage = 2;
        }

        if(animStage == 2) {
            alpha -= showStep;
            if(alpha <= 0) alpha = 0;
            setAlpha(alpha);

            if (alpha <= 0) {
                stage.getActors().removeValue(this, false);
                stage.isAllatOut = false;
            }
        }

    }
}
