package com.pendurpandurok.sziporka;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame.CleanMinigameStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Card {
    public OneSpriteStaticActor card;
    public Card(final CleanMinigameStage gs, final Integer melyik, Integer hanyvan, final Integer hanyadik, Integer sor){
        Float valami = hanyvan*0.75f;
        card = new OneSpriteStaticActor(Assets.manager.get(Assets.HATLAP));
        card.setSize((gs.getViewport()).getWorldWidth()/(hanyvan/1.6f), gs.getViewport().getWorldHeight()/(hanyvan/1.6f));
        if(hanyadik%2==0) card.setPosition(gs.getViewport().getWorldWidth()/2+card.getWidth()*0.2f,gs.getViewport().getWorldHeight()-((gs.getViewport().getWorldHeight()-(card.getHeight()*valami))/30)-(sor*card.getHeight()*1.2f)-gs.getViewport().getWorldHeight()/30);
        else card.setPosition(gs.getViewport().getWorldWidth()/2-card.getWidth()*1.2f,gs.getViewport().getWorldHeight()-((gs.getViewport().getWorldHeight()-(card.getHeight()*valami))/30)-(sor*card.getHeight()*1.2f)-gs.getViewport().getWorldHeight()/30);
        card.addListener(new ClickListener() {
            @Override

            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gs.felfordit(hanyadik,melyik);

            }
        });
        gs.addActor(card);

    }

    public void destroy(){
        card.remove();
    }
}
