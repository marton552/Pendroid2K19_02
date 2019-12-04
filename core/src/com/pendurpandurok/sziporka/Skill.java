package com.pendurpandurok.sziporka;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Screens.Game.GameStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Skill {
    OneSpriteStaticActor kocka;
    public Skill(GameStage gs,Integer howmany){
        kocka = new OneSpriteStaticActor(Assets.manager.get(Assets.PSL));
        kocka.setPosition((gs.getViewport().getWorldWidth()/10)*howmany,gs.getViewport().getWorldWidth()/10);
        kocka.setSize(100, 100);
        gs.addActor(kocka);

        //A stagere rakjuk a listenert mert ha kockára rakod bugool
        gs.addListener(new ClickListener() {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);

                //megnézzük hogy a kockára kattintintunk-e (opcionális)
                if(x >= kocka.getX() && x <= kocka.getX() + kocka.getWidth()) {
                    if(y >= kocka.getY() && y <= kocka.getY() + kocka.getHeight()) {

                        //Itt pedig középre pozícionáljuk a kockát rá az x,y koordinátára
                        kocka.setPosition(x - kocka.getWidth() / 2, y - kocka.getHeight() / 2);
                    }
                }
            }
        });
    }
}
