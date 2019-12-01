package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.GUI;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.STATUS_BAR;
import com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame.CleanMinigameScreen;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends MyStage {

    private OneSpriteStaticActor background;
    private OneSpriteStaticActor gat;
    public MyGdxGame game;
    GUI generator;
    GUI lapat;
    GUI csovek;
    GUI munkasok;
    GUI fal;

    public MenuStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);
        this.game = game;

        background = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND));
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        gat = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT1));
        gat.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(gat);

        STATUS_BAR money = new STATUS_BAR(this,"money",1);
        STATUS_BAR aram = new STATUS_BAR(this,"aram",2);
        STATUS_BAR veszt = new STATUS_BAR(this,"veszt",3);
        STATUS_BAR penz_mennyiseg = new STATUS_BAR(this,"penz",4);

        int generator_level = game.save.getInteger("aram_termeles") + game.save.getInteger("aram_to_penz") + game.save.getInteger("attetelek")+game.save.getInteger("turokepesseg_generator");
        int lapat_level = game.save.getInteger("forgasi_sebesseg") + game.save.getInteger("fogaskerekek") + game.save.getInteger("lapatok_merete")+game.save.getInteger("kerek_merete")+game.save.getInteger("turokepesseg_lapat");
        int csovek_level = game.save.getInteger("csovek_szelessege") + game.save.getInteger("csohalozat_elrendezese")+game.save.getInteger("turokepesseg_csovek");
        int munaksok_level = game.save.getInteger("munkaero") + game.save.getInteger("szorgalom") + game.save.getInteger("odafigyeles")+game.save.getInteger("adocsalas")+game.save.getInteger("turokepesseg_munkasok");
        int gatfal_level = game.save.getInteger("magassag") + game.save.getInteger("vastagsag") + game.save.getInteger("turokepesseg_gatfal");

        generator = new GUI(this,"Generátor", generator_level, game.save.getInteger("generator_hp"),1f);
        lapat = new GUI(this,"Lapát", lapat_level, game.save.getInteger("lapat_hp"),1.5f);
        csovek = new GUI(this,"Csőrendszer", csovek_level, game.save.getInteger("csovek_hp"),2f);
        munkasok = new GUI(this,"Munkások", munaksok_level, game.save.getInteger("munkasok_hp"),2.5f);
        fal = new GUI(this,"Gátfal", gatfal_level, game.save.getInteger("gatfal_hp"),3f);


        MyButton minigameTestBtn = new MyButton("CleanMinigameScreen", game.getButtonStyle());
        minigameTestBtn.setPosition(0, minigameTestBtn.getHeight());
        minigameTestBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                game.setScreen(new CleanMinigameScreen(game));
            }
        });
        addActor(minigameTestBtn);



    }


    public void another_screen(String name){
        System.out.println(name);
        generator.destroy();
        lapat.destroy();
        csovek.destroy();
        munkasok.destroy();
        fal.destroy();
    }

    @Override
    public void init() {

    }
}
