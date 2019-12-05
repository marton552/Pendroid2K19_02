package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.Screens.Game.GameScreen;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Player {
    public OneSpriteStaticActor play;
    public Player(GeneratorMinigameStage gs,Float tall){
        play = new OneSpriteStaticActor(Assets.manager.get(Assets.PLAYER));
        play.setSize(gs.getViewport().getWorldWidth()/10,gs.getViewport().getWorldHeight()/(tall/10));
        play.setPosition(gs.getViewport().getWorldWidth()/2-play.getWidth()/2,gs.getViewport().getWorldHeight()/3.4f);
        gs.addActor(play);
    }
}
