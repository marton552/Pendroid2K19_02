package com.pendurpandurok.sziporka.Screens.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Skill;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class GameStage extends MyStage {

    public MyGdxGame game;


    OneSpriteStaticActor kocka;

    public GameStage(MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);
        this.game = game;

        OneSpriteStaticActor background = new OneSpriteStaticActor(Assets.manager.get(Assets.SKILL_TREE));
        background.setSize(((FitViewport)getViewport()).getWorldWidth(), getViewport().getWorldHeight());
        addActor(background);

        Skill cube = new Skill(this,1);
        Skill cube2 = new Skill(this,2);

    }

    @Override
    public void init() {

    }
}
