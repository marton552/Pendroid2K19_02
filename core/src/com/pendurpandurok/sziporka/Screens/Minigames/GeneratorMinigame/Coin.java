package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Coin {
        public OneSpriteStaticActor coin;
        public float x;
    public Coin(GeneratorMinigameStage gs,Float y){
        x = gs.getViewport().getWorldWidth();
        coin = new OneSpriteStaticActor(Assets.manager.get(Assets.PENZ));
        coin.setSize(gs.getViewport().getWorldWidth()/5f,gs.getViewport().getWorldWidth()/5f);
        coin.setPosition(x,y);
        gs.addActor(coin);
        }
    }