package com.pendurpandurok.sziporka;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;
import com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame.CleanMinigameScreen;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;

public class Show_part {
    OneSpriteStaticActor holy_light;
    OneSpriteStaticActor part;
    OneSpriteStaticActor szalag;
    MyButton back;

    public Show_part(final MenuStage gs, String name, Integer lvl){
        holy_light = new OneSpriteStaticActor(Assets.manager.get(Assets.LIGHT));
        holy_light.setWidth(gs.getViewport().getWorldWidth());
        holy_light.setHeight(holy_light.getWidth());
        holy_light.setPosition(0,gs.getViewport().getWorldHeight()/3);
        gs.addActor(holy_light);

        if(name == "Generátor"){
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR3));
        }
        else if(name == "Lapát"){
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT3));
        }
        else if(name == "Csőrendszer"){
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK3));
        }
        else if(name == "Munkások"){
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK3));
        }
        else{
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.FAL1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.FAL2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.FAL3));
        }


        if(lvl == 0){
            szalag = new OneSpriteStaticActor(Assets.manager.get(Assets.SZALAG1));
        }
        else if(lvl == 1){
            szalag = new OneSpriteStaticActor(Assets.manager.get(Assets.SZALAG2));
        }
        else if(lvl == 2){
            szalag = new OneSpriteStaticActor(Assets.manager.get(Assets.SZALAG3));
        }
        else if(lvl == 3){
            szalag = new OneSpriteStaticActor(Assets.manager.get(Assets.SZALAG4));
        }
        else if(lvl == 4){
            szalag = new OneSpriteStaticActor(Assets.manager.get(Assets.SZALAG5));
        }
        else{
            szalag = new OneSpriteStaticActor(Assets.manager.get(Assets.SZALAG6));
        }


        part.setWidth(gs.getViewport().getWorldWidth()/1.5f);
        part.setHeight(part.getWidth()/1.65f);
        part.setPosition(gs.getViewport().getWorldWidth()/2-(part.getWidth()/2),gs.getViewport().getWorldHeight()/2);
        gs.addActor(part);

        szalag.setWidth(gs.getViewport().getWorldWidth()/1.5f);
        szalag.setHeight(szalag.getWidth()/1.58f);
        szalag.setPosition(gs.getViewport().getWorldWidth()/3,gs.getViewport().getWorldHeight()/2.3f);
        gs.addActor(szalag);


        back = new MyButton("Vissza", gs.game.getButtonStyle());
        back.setPosition(0, back.getHeight());
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                gs.back_to_mainscreens();
            }
        });
        gs.addActor(back);
    }


    public void destroy(){
        holy_light.remove();
        part.remove();
        szalag.remove();
        back.remove();
    }
}
