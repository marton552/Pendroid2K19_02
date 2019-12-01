package com.pendurpandurok.sziporka;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Screens.Game.GameStage;
import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GUI {

    MyLabel qwe;
    OneSpriteStaticActor icon;
    OneSpriteStaticActor hpbar;
    OneSpriteStaticActor iface_back;
    OneSpriteStaticActor iface;
    OneSpriteStaticActor lvlbar;

    public GUI(final MenuStage gs, final String name, Integer lvl, Integer life, Float hanyadik){

        iface_back = new OneSpriteStaticActor(Assets.manager.get(Assets.IF_BACK));
        iface_back.setSize(gs.getViewport().getWorldWidth()/1.5f,gs.getViewport().getWorldHeight()/10f);
        iface_back.setPosition(gs.getViewport().getWorldWidth()/5.5f,gs.getViewport().getWorldHeight()-(hanyadik*(gs.getViewport().getWorldHeight()/4f)));
        gs.addActor(iface_back);
        iface = new OneSpriteStaticActor(Assets.manager.get(Assets.IF));
        iface.setSize(gs.getViewport().getWorldWidth()/1.5f,gs.getViewport().getWorldHeight()/10f);
        iface.setPosition(gs.getViewport().getWorldWidth()/5.5f,gs.getViewport().getWorldHeight()-(hanyadik*(gs.getViewport().getWorldHeight()/4f)));
        iface.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gs.another_screen(name);
            }
        });
        gs.addActor(iface);


        hpbar= new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        hpbar.setPosition(iface.getX()+iface.getX()/5.2f,iface.getY()+iface.getHeight()/20);
        hpbar.setSize((iface.getWidth()/1.7f)*life/100f,iface.getHeight()/5);

        lvlbar = new OneSpriteStaticActor(Assets.manager.get(Assets.LVL_BAR));
        lvlbar.setPosition(iface.getX()+iface.getX()/5.2f,iface.getY()+iface.getHeight()/5);

        if(name == "Generátor"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(12*(gs.game.save.getInteger("generator_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Lapát"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(15*(gs.game.save.getInteger("lapat_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Csőrendszer"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(9*(gs.game.save.getInteger("csovek_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Munkások"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(15*(gs.game.save.getInteger("munkasok_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Gátfal"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(9*(gs.game.save.getInteger("gatfal_lvl")+1)),iface.getHeight()/5);
        }

        gs.addActor(lvlbar);
        gs.addActor(hpbar);
        gs.addActor(iface);



        if(name == "Generátor"){
            if(gs.game.save.getInteger("generator_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR1));}
            else if (gs.game.save.getInteger("generator_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR2));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR3));}
            gs.addActor(icon);

            qwe = new MyLabel("Generátor",gs.game.getLabelStyle());
        }
        else if(name == "Lapát"){
            if(gs.game.save.getInteger("lapat_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT1));}
            else if (gs.game.save.getInteger("lapat_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT2));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.LAPAT3));}
            gs.addActor(icon);

            qwe = new MyLabel("Lapát",gs.game.getLabelStyle());
        }
        else if(name == "Csőrendszer"){
            if(gs.game.save.getInteger("csovek_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK1));}
            else if (gs.game.save.getInteger("csovek_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK2));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.CSOVEK3));}
            gs.addActor(icon);

            qwe = new MyLabel("Csörendszer",gs.game.getLabelStyle());
        }
        else if(name == "Munkások"){
            if(gs.game.save.getInteger("munkasok_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK1));}
            else if (gs.game.save.getInteger("munkasok_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK2));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.MUNKASOK3));}
            gs.addActor(icon);

            qwe = new MyLabel("Munkások",gs.game.getLabelStyle());
        }
        else {
            if(gs.game.save.getInteger("gatfal_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.FAL1));}
            else if (gs.game.save.getInteger("gatfal_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.FAL2));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.FAL3));}
            gs.addActor(icon);

            qwe = new MyLabel("Gátfal",gs.game.getLabelStyle());
        }

        icon.setSize(iface.getWidth()/4.2f,iface.getHeight()/1.45f);
        icon.setPosition(iface.getX()+(iface.getWidth()-icon.getWidth()*1.3f),iface.getY()+iface.getHeight()/8);
        icon.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gs.another_screen(name);
            }
        });

        qwe.setPosition(iface.getX()+iface.getWidth()/15,iface.getY()+iface.getHeight()/2);
        qwe.setFontScale(0.7f);
        gs.addActor(qwe);


    }

    public void destroy(){
        qwe.remove();
        icon.remove();
        hpbar.remove();
        iface_back.remove();
        iface.remove();
        lvlbar.remove();
    }
}
