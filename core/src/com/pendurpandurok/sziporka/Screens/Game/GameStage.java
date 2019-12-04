package com.pendurpandurok.sziporka.Screens.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GameStage extends MyStage {

    public MyGdxGame game;


    OneSpriteStaticActor kocka;

    public GameStage(MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), game);
        this.game = game;

        kocka = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        kocka.setSize(100, 100);
        addActor(kocka);

        //A stagere rakjuk a listenert mert ha kockára rakod bugool
        addListener(new ClickListener() {
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

    @Override
    public void init() {

    }
}
