package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Align;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;

import java.security.AlgorithmConstraints;

import javax.management.OperationsException;
import javax.swing.GroupLayout;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MultiSpriteActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OffsetSprite;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class AchievementPanel extends MyGroup {

    float oY;
    float upY;
    float showSpeed = 100;
    float showStep;

    MyStage stage;

    int animState = 0;

    public AchievementPanel(String text, float y, float w, float h, MyGdxGame game, MyStage stage) {
        super();
        oY = y;
        this.stage = stage;
        //setZIndex(100000);
        setSize(w, h);
        setPosition(0, y + h);
        upY = getY();

        showStep = (getY() - oY) / showSpeed;

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        bg.setAlpha(0.8f);
        bg.setSize(w, h);
        addActor(bg);

        MyLabel l = new MyLabel(text, game.getLabelStyle());
        l.setScale(0.8f);
        l.setScale(0.8f);
        l.setAlignment(Align.center);
        l.setPosition(w / 2 - (l.getWidth() * l.getScaleX()) / 2 - 65, h / 2 - (l.getHeight() * l.getScaleY()) / 2);
        l.setColor(Color.WHITE);
        l.setFontScale(0.6f);
        addActor(l);
    }

    double waitTime;

    @Override
    public void act(float delta) {
        super.act(delta);

        if (animState == 0) {
            if (getY() > oY) {
                setY(getY() - showStep);
            } else {
                animState++;
                waitTime = System.currentTimeMillis() + 2000;
            }
        }

        if (animState == 1) {
            if(waitTime <= System.currentTimeMillis()) animState++;
        }
/*
        if(animState == 2) {
            if(getY() <= upY)
                setY(getY() + showStep);
            else stage.getActors().removeValue(this, false);
        }*/
    }
}
