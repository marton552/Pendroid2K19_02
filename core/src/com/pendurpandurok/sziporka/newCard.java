package com.pendurpandurok.sziporka;

import com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame.CleanMinigameStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class newCard {
    OneSpriteStaticActor card;
    public newCard(CleanMinigameStage gs, Integer melyik, Float x, Float y,Float width,Float height){
        if(melyik == 0)card = new OneSpriteStaticActor(Assets.manager.get(Assets.ROSSZKARTYA));
        else if(melyik == 1)card = new OneSpriteStaticActor(Assets.manager.get(Assets.KARTYA1));
        else if(melyik == 2)card = new OneSpriteStaticActor(Assets.manager.get(Assets.KARTYA2));
        else if(melyik == 3)card = new OneSpriteStaticActor(Assets.manager.get(Assets.KARTYA3));
        else if(melyik == 4)card = new OneSpriteStaticActor(Assets.manager.get(Assets.KARTYA4));
        else card = new OneSpriteStaticActor(Assets.manager.get(Assets.KARTYA5));

        card.setSize(width,height);
        card.setPosition(x,y);

        gs.addActor(card);
    }

    public void destroy(){
        card.remove();
    }
}
