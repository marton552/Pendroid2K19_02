package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.GUI;
import com.pendurpandurok.sziporka.Matek_osztaly;
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

    STATUS_BAR money;
    STATUS_BAR aram;
    STATUS_BAR veszt;
    STATUS_BAR penz_mennyiseg;

    public MenuStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(720f, 1280f), batch, game);
        this.game = game;

        getCamera().position.x += 73;

        background = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND));
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        gat = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT1));
        gat.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(gat);

        draw_screen();

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

        game.save.flush();

    }

    public void draw_screen(){
        money = new STATUS_BAR(this,"money",1);
        aram = new STATUS_BAR(this,"aram",2);
        veszt = new STATUS_BAR(this,"veszt",3);
        penz_mennyiseg = new STATUS_BAR(this,"penz",4);

        int generator_level = game.save.getInteger("aram_termeles") + game.save.getInteger("aram_to_penz") + game.save.getInteger("attetelek")+Math.round(game.save.getFloat("turokepesseg_generator") * 10f);
        int lapat_level = game.save.getInteger("forgasi_sebesseg") + game.save.getInteger("fogaskerekek") + game.save.getInteger("lapatok_merete")+game.save.getInteger("kerek_merete")+Math.round(game.save.getFloat("turokepesseg_lapat")*10);
        int csovek_level = game.save.getInteger("csovek_szelessege") + game.save.getInteger("csohalozat_elrendezese")+Math.round(game.save.getFloat("turokepesseg_csovek")*10);
        int munaksok_level = game.save.getInteger("munkaero") + game.save.getInteger("szorgalom") + game.save.getInteger("odafigyeles")+game.save.getInteger("adocsalas")+Math.round(game.save.getFloat("turokepesseg_munkasok")*10);
        int gatfal_level = game.save.getInteger("magassag") + game.save.getInteger("vastagsag") +Math.round(game.save.getFloat("turokepesseg_gatfal")*10);


        generator = new GUI(this,"Generátor", generator_level, game.save.getInteger("generator_hp"),1f);
        lapat = new GUI(this,"Lapát", lapat_level, game.save.getInteger("lapat_hp"),1.5f);
        csovek = new GUI(this,"Csőrendszer", csovek_level, game.save.getInteger("csovek_hp"),2f);
        munkasok = new GUI(this,"Munkások", munaksok_level, game.save.getInteger("munkasok_hp"),2.5f);
        fal = new GUI(this,"Gátfal", gatfal_level, game.save.getInteger("gatfal_hp"),3f);

    }

    public void destroy_screen(){
        generator.destroy();
        lapat.destroy();
        csovek.destroy();
        munkasok.destroy();
        fal.destroy();

        money.destroy();
        aram.destroy();
        veszt.destroy();
        penz_mennyiseg.destroy();
    }

    public void another_screen(String name){
        System.out.println(name);
        generator.destroy();
        lapat.destroy();
        csovek.destroy();
        munkasok.destroy();
        fal.destroy();
    }

    int counter = 0;

    double nextPay = System.currentTimeMillis() + 1000;

    public void act(float delta) {
        super.act(delta);
        counter++;
        if (nextPay <= System.currentTimeMillis()){
            nextPay = System.currentTimeMillis() + 1000;
            destroy_screen();
            draw_screen();
            Matek_osztaly osszeg = new Matek_osztaly(this,game.save.getFloat("penz%"),game.save.getFloat("aram%"),game.save.getFloat("aramveszteseg%"),game.save.getInteger("generator_hp"),game.save.getInteger("lapat_hp"),game.save.getInteger("csovek_hp"),game.save.getInteger("munkasok_hp"),game.save.getInteger("gatfal_hp"));
            game.save.putFloat("penz_mennyiseg",game.save.getFloat("penz_mennyiseg")+osszeg.osszeg * 1.0f);
            game.save.flush();
        }
    }

    @Override
    public void init() {

    }
}
