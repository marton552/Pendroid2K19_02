package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Gyik extends OneSpriteStaticActor {

    int animStage = 0;
    float speed = 30;

    float sX, sY, eX, eY = 0;
    float stepSizeX, stepSizeY;

    MenuStage stage;

    public Gyik(float sX, float sY, float eX, float eY, final MenuStage stage) {
        super(Assets.manager.get(Assets.GYIK));
        this.stage = stage;
        this.sX = sX; this.eX = eX;
        this.sY = sY; this.eY = eY;

        setPosition(sX, sY);
        setSize(getWidth() / 10, getHeight() / 10);

        stepSizeX = (eX - sX) / speed;
        stepSizeY = (eY - sY) / speed;

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gyikClicked();
            }
        });

        stage.isAllatOut = true;


    }

    public void gyikClicked() {
        stage.game.save.putFloat("penz_mennyiseg", stage.game.save.getFloat("penz_mennyiseg") + 15);
        stage.game.save.flush();
        stage.getActors().removeValue(this, false);
        stage.isAllatOut = false;
    }

    double waitTime;

    @Override
    public void act(float delta) {
        super.act(delta);


        if(animStage == 0) {

            setX(getX() + stepSizeX);
            setY(getY() + stepSizeY);

            if(getX() == eX) {
                animStage = 1;
                waitTime = System.currentTimeMillis() + 2000;
            }
        }

        if(animStage == 1) {
            if (waitTime <= System.currentTimeMillis()) {
                animStage = 2;
            }
        }

        if(animStage == 2) {
            setX(getX() - stepSizeX);
            setY(getY() - stepSizeY);

            if(getX() == sX) {
                stage.isAllatOut = false;
                stage.getActors().removeValue(this, false);
            }
        }

    }
}
