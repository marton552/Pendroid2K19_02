package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.GUI;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends MyStage {

    private OneSpriteStaticActor background;
    private OneSpriteStaticActor gat;

    public MenuStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);

        background = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND));
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        background.setX(-75);
        background.setZIndex(-10);
        addActor(background);

        gat = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT1));
        gat.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        gat.setX(-75);
        background.setZIndex(-9);
        addActor(gat);

        int generator_level = MyGdxGame.save.getInteger("aram_termeles")+MyGdxGame.save.getInteger("aram_to_penz")+MyGdxGame.save.getInteger("attetelek")+MyGdxGame.save.getInteger("turokepesseg_generator");
        int lapat_level = MyGdxGame.save.getInteger("forgasi_sebesseg")+MyGdxGame.save.getInteger("fogaskerekek")+MyGdxGame.save.getInteger("lapatok_merete")+MyGdxGame.save.getInteger("kerek_merete")+MyGdxGame.save.getInteger("turokepesseg_lapat");
        int csovek_level = MyGdxGame.save.getInteger("csovek_szelessege")+MyGdxGame.save.getInteger("csohalozat_elrendezese")+MyGdxGame.save.getInteger("turokepesseg_csovek");
        int munaksok_level = MyGdxGame.save.getInteger("munkaero")+MyGdxGame.save.getInteger("szorgalom")+MyGdxGame.save.getInteger("odafigyeles")+MyGdxGame.save.getInteger("adocsalas")+MyGdxGame.save.getInteger("turokepesseg_munkasok");
        int gatfal_level = MyGdxGame.save.getInteger("magassag")+MyGdxGame.save.getInteger("vastagsag")+MyGdxGame.save.getInteger("turokepesseg_gatfal");

        GUI generator = new GUI(this,"Generátor",generator_level,MyGdxGame.save.getInteger("generator_hp"),1f);
        GUI lapat = new GUI(this,"Lapát",lapat_level,MyGdxGame.save.getInteger("lapat_hp"),1.5f);
        GUI csovek = new GUI(this,"Csőrendszer",csovek_level,MyGdxGame.save.getInteger("csovek_hp"),2f);
        GUI munkasok = new GUI(this,"Munkások",munaksok_level,MyGdxGame.save.getInteger("munkasok_hp"),2.5f);
        GUI fal = new GUI(this,"Gátfal",gatfal_level,MyGdxGame.save.getInteger("gatfal_hp"),3f);


    }

    @Override
    public void init() {

    }
}
