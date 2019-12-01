package com.pendurpandurok.sziporka;

import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class STATUS_BAR {
    OneSpriteStaticActor icon_bar;
    MyLabel title;
    public STATUS_BAR(final MenuStage gs, final String name, Integer hanyadik){
        if(hanyadik == 1){
            icon_bar = new OneSpriteStaticActor(Assets.manager.get(Assets.PENZ_PER));
            title = new MyLabel(gs.game.save.getFloat("penz%")+"",gs.game.getLabelStyle());
        }else if(hanyadik == 2){
            icon_bar = new OneSpriteStaticActor(Assets.manager.get(Assets.ARAM));
            title = new MyLabel(gs.game.save.getFloat("aram%")+"",gs.game.getLabelStyle());
        }else if(hanyadik == 4){
            icon_bar = new OneSpriteStaticActor(Assets.manager.get(Assets.PENZ));
            title = new MyLabel(Math.round(gs.game.save.getFloat("penz_mennyiseg"))+"",gs.game.getLabelStyle());
        }
        else{ icon_bar = new OneSpriteStaticActor(Assets.manager.get(Assets.VESZT));
        title = new MyLabel((gs.game.save.getFloat("aramveszteseg%"))+"",gs.game.getLabelStyle());}

        icon_bar.setWidth(gs.getViewport().getWorldWidth()/15f);
        icon_bar.setHeight(icon_bar.getWidth());
        if(hanyadik == 4){
            icon_bar.setPosition(gs.getViewport().getWorldWidth()-icon_bar.getWidth(),gs.getViewport().getWorldHeight()-(icon_bar.getWidth()));
        }else icon_bar.setPosition(1,gs.getViewport().getWorldHeight()-(hanyadik*icon_bar.getWidth()));
        gs.addActor(icon_bar);

        if(hanyadik == 4){
            title.setPosition(gs.getViewport().getWorldWidth()*0.75f,gs.getViewport().getWorldHeight()-((icon_bar.getHeight())));
        }else title.setPosition(icon_bar.getWidth()*1.2f,gs.getViewport().getWorldHeight()-(hanyadik*(icon_bar.getHeight())));
        title.setFontScale(1f);
        gs.addActor(title);

        gs.game.save.flush();
    }

    public void destroy(){
        icon_bar.remove();
        title.remove();
    }

}
