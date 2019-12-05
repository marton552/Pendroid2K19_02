package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.math.MathUtils;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Bomb extends OneSpriteStaticActor {

    double bombTime;
    boolean exploded = true;

    ShootUpHUD hud;
    public Bomb(ShootUpHUD hud) {
        super(Assets.manager.get(Assets.CSOMBA));
        this.hud = hud;

        setSize(getWidth() * 4, getHeight() * 4);
        setVisible(false);
    }

    public void armTheBomb() {
        bombTime = System.currentTimeMillis() + MathUtils.random(5000, 10000);
        exploded = false;
        setVisible(true);
    }

    public void explodeTheBomb() {
        setVisible(false);
        exploded = true;

        OneSpriteAnimatedActor expl = new OneSpriteAnimatedActor(Assets.manager.get(Assets.EXPLOSION_ATLAS)){
            @Override
            public void init() {
                super.init();
            }

            @Override
            public void setFrame(int frame) {
                super.setFrame(frame);

                if(frame == getFrameCount() - 1) hud.getActors().removeValue(this, false);
            }
        };
        expl.setSize(expl.getWidth() * 2, expl.getHeight() * 2);
        expl.setPosition(getX() + getWidth() / 2 - expl.getWidth() / 2, getY() + getHeight() - expl.getHeight() / 2);
        expl.setLooping(false);

        hud.addActor(expl);
        hud.bombExploded();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(exploded == false) {
            if(System.currentTimeMillis() >= bombTime) {
                explodeTheBomb();
            }
        }


    }
}
