package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame.Bomb;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Bomba {
    public OneSpriteStaticActor bomba;
    public float x;
    public Bomba(GeneratorMinigameStage gs,Float y){
        x = gs.getViewport().getWorldWidth();
        bomba = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY));
        bomba.setSize(gs.getViewport().getWorldWidth()/5f,gs.getViewport().getWorldWidth()/5f);
        bomba.setPosition(x,y);
        gs.addActor(bomba);
    }

}
