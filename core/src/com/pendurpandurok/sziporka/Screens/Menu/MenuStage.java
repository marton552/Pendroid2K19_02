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
import com.pendurpandurok.sziporka.Show_part;
import com.pendurpandurok.sziporka.Upgrade;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends MyStage {

    private OneSpriteStaticActor background;
    private OneSpriteStaticActor gat;
    public OneSpriteStaticActor sikerorlose;
    public OneSpriteStaticActor smile;
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

    public String part = "";
    public int levelup = 0;
    public boolean siker = false;
    boolean vis = false;

    Show_part sh_generator;

    List<Upgrade> gen = new ArrayList<Upgrade>();

    boolean kepernyo = true;

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
        minigameTestBtn.setPosition(0, minigameTestBtn.getHeight()*2);
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


        if(kepernyo) {
            int generator_level = game.save.getInteger("aram_termeles") + game.save.getInteger("aram_to_penz") + game.save.getInteger("attetelek") + Math.round(game.save.getFloat("turokepesseg_generator"));
            int lapat_level = game.save.getInteger("forgasi_sebesseg") + game.save.getInteger("fogaskerekek") + game.save.getInteger("lapatok_merete") + game.save.getInteger("kerek_merete") + Math.round(game.save.getFloat("turokepesseg_lapat"));
            int csovek_level = game.save.getInteger("csovek_szelessege") + game.save.getInteger("csohalozat_elrendezese") + Math.round(game.save.getFloat("turokepesseg_csovek"));
            int munaksok_level = game.save.getInteger("munkaero") + game.save.getInteger("szorgalom") + game.save.getInteger("odafigyeles") + game.save.getInteger("adocsalas") + Math.round(game.save.getFloat("turokepesseg_munkasok"));
            int gatfal_level = game.save.getInteger("magassag") + game.save.getInteger("vastagsag") + Math.round(game.save.getFloat("turokepesseg_gatfal"));


            generator = new GUI(this, "Generátor", generator_level, game.save.getFloat("generator_hp"), 1f);
            lapat = new GUI(this, "Lapát", lapat_level, game.save.getFloat("lapat_hp"), 1.5f);
            csovek = new GUI(this, "Csőrendszer", csovek_level, game.save.getFloat("csovek_hp"), 2f);
            munkasok = new GUI(this, "Munkások", munaksok_level, game.save.getFloat("munkasok_hp"), 2.5f);
            fal = new GUI(this, "Gátfal", gatfal_level, game.save.getFloat("gatfal_hp"), 3f);
        }
    }

    public void destroy_screen(){
        if (kepernyo) {
            generator.destroy();
            lapat.destroy();
            csovek.destroy();
            munkasok.destroy();
            fal.destroy();
        }
        money.destroy();
        aram.destroy();
        veszt.destroy();
        penz_mennyiseg.destroy();
    }

    public void another_screen(String name){
        kepernyo = false;
        generator.destroy();
        lapat.destroy();
        csovek.destroy();
        munkasok.destroy();
        fal.destroy();
        part = name;

        if(name == "Generátor"){
            sh_generator = new Show_part(this,"Generátor",game.save.getInteger("generator_lvl"));

            for (int i = 0; i < 5; i++){
            gen.add(new Upgrade(this,"Generátor",i));}
        }
        else if(name == "Lapát"){
            sh_generator = new Show_part(this,"Lapát",game.save.getInteger("lapat_lvl"));
            for (int i = 0; i < 6; i++){
                gen.add(new Upgrade(this,"Lapát",i));}
        }
        else if(name == "Csőrendszer"){
            sh_generator = new Show_part(this,"Csőrendszer",game.save.getInteger("csovek_lvl"));
            for (int i = 0; i < 4; i++){
                gen.add(new Upgrade(this,"Csőrendszer",i));}
        }
        else if(name == "Munkások"){
            sh_generator = new Show_part(this,"Munkások",game.save.getInteger("munkasok_lvl"));
            for (int i = 0; i < 6; i++){
                gen.add(new Upgrade(this,"Munkások",i));}
        }
        else if(name == "Gátfal"){
            sh_generator = new Show_part(this,"Gátfal",game.save.getInteger("gatfal_lvl"));
            for (int i = 0; i < 4; i++){
                gen.add(new Upgrade(this,"Gátfal",i));}
        }
    }

    public void back_to_mainscreens(){
        kepernyo = true;
        sh_generator.destroy();
        destroy_screen();
        draw_screen();
        for(int i = 0; i < gen.size();i++){
            gen.get(i).destroy();
        }
        gen.clear();
    }

    public void vasarlas(int hanyadik){
        siker = false;
        if(vis == false){

        if(gen.get(hanyadik).levelup == 0){
            if(game.save.getFloat("penz_mennyiseg") > (gen.get(hanyadik).lvl+1)*25){
                game.save.putFloat("penz_mennyiseg",game.save.getFloat("penz_mennyiseg")-(gen.get(hanyadik).lvl+1)*25);
                game.save.putInteger(gen.get(hanyadik).level,game.save.getInteger(gen.get(hanyadik).level)+1);
                siker = true;
            }
        }
        else if (gen.get(hanyadik).levelup == 1){
            if(game.save.getFloat("penz_mennyiseg") > (gen.get(hanyadik).lvl+1)*25f){
                game.save.putFloat("penz_mennyiseg",game.save.getFloat("penz_mennyiseg")-(gen.get(hanyadik).lvl+1)*25f);
                game.save.putFloat(gen.get(hanyadik).level,(gen.get(hanyadik).lvl+1));
                System.out.println((gen.get(hanyadik).lvl+1));
                siker = true;
            }
        }
        else if(gen.get(hanyadik).levelup == 2){
            if(game.save.getFloat("penz_mennyiseg") > 500 && gen.get(hanyadik).mennyikene-gen.get(hanyadik).lvl>=gen.get(hanyadik).mennyikene){
                game.save.putFloat("penz_mennyiseg",game.save.getFloat("penz_mennyiseg")-500);
                game.save.putInteger(gen.get(hanyadik).level,game.save.getInteger(gen.get(hanyadik).level)+1);
                siker = true;
            }
        }

        if(siker){
            if(gen.get(hanyadik).melyik == 0){
                game.save.putFloat("penz%",game.save.getFloat("penz%")+0.1f);
            }
            else if(gen.get(hanyadik).melyik == 1){
                game.save.putFloat("aram%",game.save.getFloat("aram%")+0.1f);
            }
            else if(gen.get(hanyadik).melyik == 2){
                game.save.putFloat("aramveszteseg%",game.save.getFloat("aramveszteseg%")*1.01f);
            }
            else if(gen.get(hanyadik).melyik == 4){
                game.save.putFloat("penz%",game.save.getFloat("penz%")+0.5f);
                game.save.putFloat("aram%",game.save.getFloat("aram%")+0.5f);
                game.save.putFloat("aramveszteseg%",game.save.getFloat("aramveszteseg%")*1.03f);
            }
            smile = new OneSpriteStaticActor(Assets.manager.get(Assets.HAPPY));
            smile.setHeight(getViewport().getWorldHeight()/2);
            smile.setWidth(smile.getHeight()*1.12f);
            smile.setPosition(getViewport().getWorldWidth()/2-smile.getWidth()/2,getViewport().getWorldHeight()/2);
        }
        else{
            smile = new OneSpriteStaticActor(Assets.manager.get(Assets.SAD));
            smile.setHeight(getViewport().getWorldHeight()/2);
            smile.setWidth(smile.getHeight()*1.12f);
            smile.setPosition(getViewport().getWorldWidth()/2-smile.getWidth()/2,getViewport().getWorldHeight()/2);
            siker = true;
        }

        sh_generator.destroy();
        destroy_screen();
        for(int i = 0; i < gen.size();i++){
            gen.get(i).destroy();
        }
        gen.clear();
        another_screen(part);
        draw_screen();
        game.save.flush();}
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
            Matek_osztaly osszeg = new Matek_osztaly(this,game.save.getFloat("penz%"),game.save.getFloat("aram%"),game.save.getFloat("aramveszteseg%"),game.save.getFloat("generator_hp"),game.save.getFloat("lapat_hp"),game.save.getFloat("csovek_hp"),game.save.getFloat("munkasok_hp"),game.save.getFloat("gatfal_hp"));
            game.save.putFloat("penz_mennyiseg",game.save.getFloat("penz_mennyiseg")+osszeg.osszeg * 1.0f);



            if(kepernyo == false){
                sh_generator.destroy();
                destroy_screen();
                for(int i = 0; i < gen.size();i++){
                    gen.get(i).destroy();
                }
                gen.clear();
                another_screen(part);
                draw_screen();
            }

            if(vis){
                smile.remove();
                vis = false;
                siker = false;
            }

            if(siker && vis != true){
                addActor(smile);
                vis = true;
            }

            game.save.flush();
        }
    }

    @Override
    public void init() {

    }
}
