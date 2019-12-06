package com.pendurpandurok.sziporka.Screens.Menu;

import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Gyik extends OneSpriteStaticActor {

    int animStage = 0;
    float speed = 100;

    float sX, sY, eX, eY = 0;
    float stepSizeX, stepSizeY;

    MenuStage stage;

    public Gyik(float sX, float sY, float eX, float eY, MenuStage stage) {
        super(Assets.manager.get(Assets.GYIK));
        this.stage = stage;
        this.sX = sX; this.eX = eX;
        this.sY = sY; this.eY = eY;


        stepSizeX = (eX - sX) / speed;
        stepSizeY = (eY - sY) / speed;

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
                stage.getActors().removeValue(this, false);
            }
        }

    }
}
