package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class ShootUpMinigameStage extends MyStage {

    OneSpriteStaticActor dolog;
    boolean isTouching = false; //Ez nézi hogy az ujjad rajta van-e a stagen

    public ShootUpMinigameStage(MyGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);

        dolog = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        dolog.setSize(200, 200);
        dolog.setPositionCenterOfActorToCenterOfViewport();
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //dolog.setPosition(x, y);
                isTouching = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                dolog.setX(x - dolog.getWidth() / 2);
                dolog.setY(y - dolog.getHeight() / 2);
                isTouching = true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouching = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });
        addActor(dolog);
    }

    @Override
    public void init() {

    }
}
