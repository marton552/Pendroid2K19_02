package com.pendurpandurok.sziporka.Screens.Minigames.WorkerMinigame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;
import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class WorkerMinigameStage extends MyStage {

    OneSpriteStaticActor ember;

    int counter = 0;
    float speed = 50f;
    int csiki = 0;

    float oY = 0;

    int theSpotW = 20;
    int theSpotStart = MathUtils.random(theSpotW, 100 - theSpotW);

    int currSpot = 0;
    int spotDecr = 2;

    int sumSpot = 0;

    MyGdxGame game;

    OneSpriteStaticActor currSpotBar;
    OneSpriteStaticActor sumSpotBar;

    int barW = 700;

    public WorkerMinigameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);
        this.game = game;
        getCamera().position.x += 73;

        if(MathUtils.random(0, 1) == 0) ember = new OneSpriteStaticActor(Assets.manager.get(Assets.HAS_F));
        else ember = new OneSpriteStaticActor(Assets.manager.get(Assets.HAS_L));
        ember.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        oY = ember.getY();
        ember.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                if(counter >= csiki) csiki = counter + 40 + MathUtils.random(0, 10);

                currSpot += 10;
                if(currSpot > 100) currSpot = 100;
            }
        });
        addActor(ember);


        OneSpriteStaticActor spotBarBG = new OneSpriteStaticActor(Assets.manager.get(Assets.FULLWHITE));
        spotBarBG.setSize(barW, 30);
        spotBarBG.setPosition(getViewport().getWorldWidth() / 2 - spotBarBG.getWidth() / 2, getViewport().getWorldHeight() - 50);

        OneSpriteStaticActor spotBarOutline = new OneSpriteStaticActor(Assets.manager.get(Assets.GRAY));
        spotBarOutline.setSize(barW + 10, 30 + 10);
        spotBarOutline.setPosition(spotBarBG.getX() - 5, spotBarBG.getY() - 5);

        addActor(spotBarOutline);
        addActor(spotBarBG);

        OneSpriteStaticActor theRedSpot = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        theRedSpot.setSize((barW / 100) * theSpotW, 30 + 10);
        theRedSpot.setPosition(spotBarOutline.getX() + (barW / 100) * theSpotStart, spotBarOutline.getY());

        addActor(theRedSpot);

        currSpotBar = new OneSpriteStaticActor(Assets.manager.get(Assets.LVL_BAR));
        currSpotBar.setSize(0, spotBarBG.getHeight());
        currSpotBar.setPosition(spotBarBG.getX(), spotBarBG.getY());

        addActor(currSpotBar);

        MyLabel currl = new MyLabel("Csiki méter", game.getLabelStyle());
        currl.setFontScale(0.5f);
        currl.setAlignment(Align.center);
        currl.setPosition((spotBarBG.getX() + spotBarBG.getWidth()) / 2 - currl.getWidth() / 2 + 40, spotBarBG.getY() - 20);
        currl.setColor(Color.BLACK);
        addActor(currl);

        OneSpriteStaticActor sumBarBG = new OneSpriteStaticActor(Assets.manager.get(Assets.FULLWHITE));
        sumBarBG.setSize(barW, 30);
        sumBarBG.setPosition(getViewport().getWorldWidth() / 2 - sumBarBG.getWidth() / 2, getViewport().getWorldHeight() - 50 - 30 - 15);

        OneSpriteStaticActor sumBarOutline = new OneSpriteStaticActor(Assets.manager.get(Assets.GRAY));
        sumBarOutline.setSize(barW + 10, 30 + 10);
        sumBarOutline.setPosition(sumBarBG.getX() - 5, sumBarBG.getY() - 5);

        addActor(sumBarOutline);
        addActor(sumBarBG);

        sumSpotBar = new OneSpriteStaticActor(Assets.manager.get(Assets.LVL_BAR));
        sumSpotBar.setSize(0, sumBarBG.getHeight());
        sumSpotBar.setPosition(sumBarBG.getX(), sumBarBG.getY());

        addActor(sumSpotBar);


        MyLabel l = new MyLabel("Haladás", game.getLabelStyle());
        l.setFontScale(0.5f);
        l.setAlignment(Align.center);
        l.setPosition((sumBarBG.getX() + sumBarBG.getWidth()) / 2 - l.getWidth() / 2 + 40, sumBarBG.getY() - 20);
        l.setColor(Color.WHITE);
        addActor(l);


        MyLabel infoout = new MyLabel("Csikizz meg!", game.getLabelStyle());
        infoout.setColor(Color.BLACK);
        infoout.setFontScale(0.72f);
        infoout.setAlignment(Align.center);
        infoout.setPosition(getViewport().getWorldWidth() / 2 - l.getWidth() / 2 - 55 - 1, sumBarBG.getY() - 20 - 60 - 1);
        addActor(infoout);

        MyLabel info = new MyLabel("Csikizz meg!", game.getLabelStyle());
        info.setColor(Color.RED);
        info.setFontScale(0.7f);
        info.setAlignment(Align.center);
        info.setPosition(getViewport().getWorldWidth() / 2 - l.getWidth() / 2 - 55, sumBarBG.getY() - 20 - 60);
        addActor(info);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        counter++;


        if(currSpot >= theSpotStart && currSpot <= (theSpotStart + theSpotW) && counter % 10 == 0) {
            sumSpot++;

            if(sumSpot >= 100) {
                //setScreen
                game.save.putFloat("munkasok_hp", 100.0f);
                game.save.flush();
                game.setScreen(new MenuScreen(game));
            }
        }
        if(currSpot > 0) currSpot--;

        currSpotBar.setWidth((barW / 100) * currSpot);
        sumSpotBar.setWidth((barW / 100) * sumSpot);

        float tSpeed = speed;

        if(counter <= csiki) {
            tSpeed = 2f;
        }

        ember.setY(oY + (float)Math.sin(counter / tSpeed) * 3f);
    }


    @Override
    public void init() {

    }
}
