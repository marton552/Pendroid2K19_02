package com.pendurpandurok.sziporka;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Screens.Game.GameStage;
import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GUI {
    public GUI(MenuStage gs, String name, Integer lvl, Integer life, Float hanyadik){

        OneSpriteStaticActor iface = new OneSpriteStaticActor(Assets.manager.get(Assets.IF));
        iface.setSize(gs.getViewport().getWorldWidth()/1.5f,gs.getViewport().getWorldHeight()/10f);
        iface.setPosition(gs.getViewport().getWorldWidth()/10,gs.getViewport().getWorldHeight()-(hanyadik*(gs.getViewport().getWorldHeight()/4f)));
        iface.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("asd");
            }
        });
        gs.addActor(iface);

        OneSpriteStaticActor hpbar = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        hpbar.setPosition(iface.getX()+iface.getX()/3,iface.getY()+iface.getHeight()/20);
        hpbar.setSize((iface.getWidth()/1.7f)*life/100f,iface.getHeight()/5);

        OneSpriteStaticActor lvlbar = new OneSpriteStaticActor(Assets.manager.get(Assets.LVL_BAR));
        lvlbar.setPosition(iface.getX()+iface.getX()/3,iface.getY()+iface.getHeight()/5);
        if(name == "Generátor"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/12,iface.getHeight()/5);
        }
        else if(name == "Lapát"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/12,iface.getHeight()/5);
        }
        else if(name == "Csőrendszer"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/12,iface.getHeight()/5);
        }
        else if(name == "Munkások"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/12,iface.getHeight()/5);
        }
        else if(name == "Gátfal"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/12,iface.getHeight()/5);
        }

        gs.addActor(lvlbar);
        gs.addActor(hpbar);
        gs.addActor(iface);
    }
}
