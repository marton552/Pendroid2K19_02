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
    OneSpriteStaticActor back_bar;
    OneSpriteStaticActor bar;
    OneSpriteStaticActor red;
    MyButton back;
    MyButton play;

    public Show_part(final MenuStage gs, String name, Float lvl){
        float level = 0;

        holy_light = new OneSpriteStaticActor(Assets.manager.get(Assets.LIGHT));
        holy_light.setWidth(gs.getViewport().getWorldWidth());
        holy_light.setHeight(holy_light.getWidth());
        holy_light.setPosition(0,gs.getViewport().getWorldHeight()/2f);
        gs.addActor(holy_light);

        if(name == "Generátor"){
            level = gs.game.save.getFloat("generator_hp");
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR3));
        }
        else if(name == "Lapát"){
            level = gs.game.save.getFloat("lapat_hp");
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT3));
        }
        else if(name == "Csőrendszer"){
            level = gs.game.save.getFloat("csovek_hp");
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK3));
        }
        else if(name == "Munkások"){
            level = gs.game.save.getFloat("munkasok_hp");
            if (lvl == 0) part = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK1));
            else if (lvl == 1) part = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK2));
            else part = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK3));
        }
        else{
            level = gs.game.save.getFloat("gatfal_hp");
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
        part.setPosition(gs.getViewport().getWorldWidth()/2-(part.getWidth()/2),gs.getViewport().getWorldHeight()/1.5f);
        gs.addActor(part);

        szalag.setWidth(gs.getViewport().getWorldWidth()/1.5f);
        szalag.setHeight(szalag.getWidth()/1.58f);
        szalag.setPosition(gs.getViewport().getWorldWidth()/3,gs.getViewport().getWorldHeight()/1.7f);
        gs.addActor(szalag);


        back = new MyButton("Vissza", gs.game.getButtonStyle());
        back.setWidth(gs.getViewport().getWorldWidth()/8);
        back.setPosition(0, 0);
        back.getLabel().setFontScale(0.4f);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                gs.back_to_mainscreens();
            }
        });
        gs.addActor(back);

        back_bar = new OneSpriteStaticActor(Assets.manager.get(Assets.BAR_B));
        back_bar.setWidth(gs.getViewport().getWorldWidth()/1.33f);
        back_bar.setHeight(back.getHeight());
        back_bar.setPosition(back.getWidth(),0);
        gs.addActor(back_bar);

        red = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        red.setWidth(gs.getViewport().getWorldWidth()/1.33f*(level/100));
        red.setHeight(back.getHeight());
        red.setPosition(back.getWidth(),0);
        gs.addActor(red);

        bar = new OneSpriteStaticActor(Assets.manager.get(Assets.BAR_F));
        bar.setWidth(gs.getViewport().getWorldWidth()/1.33f);
        bar.setHeight(back.getHeight());
        bar.setPosition(back.getWidth(),0);
        gs.addActor(bar);

        play = new MyButton("Play", gs.game.getButtonStyle());
        play.setWidth(gs.getViewport().getWorldWidth()/8);
        play.setPosition(gs.getViewport().getWorldWidth()-play.getWidth(), 0);
        play.getLabel().setFontScale(0.4f);
        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);


            }
        });
        gs.addActor(play);
    }


    public void destroy(){
        holy_light.remove();
        part.remove();
        szalag.remove();
        back.remove();
        back_bar.remove();
        red.remove();
        bar.remove();
    }
}
