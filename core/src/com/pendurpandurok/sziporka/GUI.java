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

        OneSpriteStaticActor iface_back = new OneSpriteStaticActor(Assets.manager.get(Assets.IF_BACK));
        iface_back.setSize(gs.getViewport().getWorldWidth()/1.5f,gs.getViewport().getWorldHeight()/10f);
        iface_back.setPosition(gs.getViewport().getWorldWidth()/10,gs.getViewport().getWorldHeight()-(hanyadik*(gs.getViewport().getWorldHeight()/4f)));
        gs.addActor(iface_back);
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
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(12*(MyGdxGame.save.getInteger("generator_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Lapát"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(15*(MyGdxGame.save.getInteger("lapat_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Csőrendszer"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(9*(MyGdxGame.save.getInteger("csovek_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Munkások"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(15*(MyGdxGame.save.getInteger("munkasok_lvl")+1)),iface.getHeight()/5);
        }
        else if(name == "Gátfal"){
            lvlbar.setSize((iface.getWidth()/1.7f)*lvl/(9*(MyGdxGame.save.getInteger("gatfal_lvl")+1)),iface.getHeight()/5);
        }

        gs.addActor(lvlbar);
        gs.addActor(hpbar);
        gs.addActor(iface);


        if(name == "Generátor"){
            OneSpriteStaticActor icon;
            if(MyGdxGame.save.getInteger("generator_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else if (MyGdxGame.save.getInteger("generator_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            icon.setPosition(iface.getX()+iface.getX()/0.22f,iface.getY()+iface.getHeight()/10);
            icon.setSize(iface.getWidth()/4.2f,iface.getHeight()/1.45f);
            gs.addActor(icon);
        }
        else if(name == "Lapát"){
            OneSpriteStaticActor icon;
            if(MyGdxGame.save.getInteger("lapat_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else if (MyGdxGame.save.getInteger("lapat_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            icon.setPosition(iface.getX()+iface.getX()/0.22f,iface.getY()+iface.getHeight()/10);
            icon.setSize(iface.getWidth()/4.2f,iface.getHeight()/1.45f);
            gs.addActor(icon);
        }
        else if(name == "Csőrendszer"){
            OneSpriteStaticActor icon;
            if(MyGdxGame.save.getInteger("csovek_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else if (MyGdxGame.save.getInteger("csovek_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            icon.setPosition(iface.getX()+iface.getX()/0.22f,iface.getY()+iface.getHeight()/10);
            icon.setSize(iface.getWidth()/4.2f,iface.getHeight()/1.45f);
            gs.addActor(icon);
        }
        else if(name == "Munkások"){
            OneSpriteStaticActor icon;
            if(MyGdxGame.save.getInteger("munkasok_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else if (MyGdxGame.save.getInteger("munkasok_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            icon.setPosition(iface.getX()+iface.getX()/0.22f,iface.getY()+iface.getHeight()/10);
            icon.setSize(iface.getWidth()/4.2f,iface.getHeight()/1.45f);
            gs.addActor(icon);
        }
        else if(name == "Gátfal"){
            OneSpriteStaticActor icon;
            if(MyGdxGame.save.getInteger("gatfal_lvl")==0){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else if (MyGdxGame.save.getInteger("gatfal_lvl")==1){ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            else{ icon = new OneSpriteStaticActor(Assets.manager.get(Assets.GENERATOR_ICON));}
            icon.setPosition(iface.getX()+iface.getX()/0.22f,iface.getY()+iface.getHeight()/10);
            icon.setSize(iface.getWidth()/4.2f,iface.getHeight()/1.45f);
            gs.addActor(icon);
        }



    }
}
