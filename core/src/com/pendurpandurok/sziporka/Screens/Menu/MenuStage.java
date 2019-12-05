package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.GUI;
import com.pendurpandurok.sziporka.Matek_osztaly;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.STATUS_BAR;
import com.pendurpandurok.sziporka.Screens.Game.GameScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame.CleanMinigameScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame.ShootMinigameScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame.ShootUpMinigameScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.WorkerMinigame.WorkerMinigameScreen;
import com.pendurpandurok.sziporka.Show_part;
import com.pendurpandurok.sziporka.Skill;
import com.pendurpandurok.sziporka.Upgrade;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class MenuStage extends MyStage {


    private OneSpriteStaticActor background;
    private OneSpriteStaticActor gat;
    public OneSpriteStaticActor sikerorlose;
    public OneSpriteStaticActor smile;
    public OneSpriteStaticActor skill;
    public MyGdxGame game;
    GUI generator;
    GUI lapat;
    GUI csovek;
    GUI munkasok;
    GUI fal;
    GUI skillpoints;

    STATUS_BAR money;
    STATUS_BAR aram;
    STATUS_BAR veszt;
    STATUS_BAR penz_mennyiseg;

    public String part = "";
    public int levelup = 0;
    public boolean siker = false;
    public boolean vis = false;

    Show_part sh_generator;

    List<Upgrade> gen = new ArrayList<Upgrade>();

    boolean kepernyo = true;

    public MenuStage( final MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);
        this.game = game;
        //getCamera().position.y += 150;

        //if(Gdx.app.getType() == Application.ApplicationType.Desktop) getCamera().position.x += 73;

        background = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND));
        background.setSize(((FitViewport)getViewport()).getWorldWidth(), getViewport().getWorldHeight());
        addActor(background);

        if(game.save.getFloat("gatfal_lvl")== 0)gat = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT1));
        else if(game.save.getFloat("gatfal_lvl")== 1)gat = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT2));
        else gat = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT3));
        gat.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(gat);


        draw_screen();

        MyButton minigameTestBtn = new MyButton("Kártya", game.getButtonStyle());
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

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                if (kepernyo){
                    game.setScreenBackByStackPop();
                }
                else{
                    back_to_mainscreens();
                }
            }
        });

    }

    public void draw_screen(){
        money = new STATUS_BAR(this,"money",1);
        aram = new STATUS_BAR(this,"aram",2);
        veszt = new STATUS_BAR(this,"veszt",3);
        penz_mennyiseg = new STATUS_BAR(this,"penz",4);


        if(kepernyo) {
            float generator_level = game.save.getFloat("aram_termeles") + game.save.getFloat("aram_to_penz") + game.save.getFloat("attetelek") + Math.round(game.save.getFloat("turokepesseg_generator"));
            float lapat_level = game.save.getFloat("forgasi_sebesseg") + game.save.getFloat("fogaskerekek") + game.save.getFloat("lapatok_merete") + game.save.getFloat("kerek_merete") + Math.round(game.save.getFloat("turokepesseg_lapat"));
            float csovek_level = game.save.getFloat("csovek_szelessege") + game.save.getFloat("csohalozat_elrendezese") + Math.round(game.save.getFloat("turokepesseg_csovek"));
            float munaksok_level = game.save.getFloat("munkaero") + game.save.getFloat("szorgalom") + game.save.getFloat("odafigyeles") + game.save.getFloat("adocsalas") + Math.round(game.save.getFloat("turokepesseg_munkasok"));
            float gatfal_level = game.save.getFloat("magassag") + game.save.getFloat("vastagsag") + Math.round(game.save.getFloat("turokepesseg_gatfal"));


            generator = new GUI(this, "Generátor", generator_level, game.save.getFloat("generator_hp"), 1f);
            lapat = new GUI(this, "Lapát", lapat_level, game.save.getFloat("lapat_hp"), 1.5f);
            csovek = new GUI(this, "Csőrendszer", csovek_level, game.save.getFloat("csovek_hp"), 2f);
            munkasok = new GUI(this, "Munkások", munaksok_level, game.save.getFloat("munkasok_hp"), 2.5f);
            fal = new GUI(this, "Gátfal", gatfal_level, game.save.getFloat("gatfal_hp"), 3f);

            skill = new OneSpriteStaticActor(Assets.manager.get(Assets.SKILL));
            skill.setSize(getViewport().getWorldWidth()/2f,getViewport().getWorldHeight()/15f);
            skill.setPosition(getViewport().getWorldWidth()/2-skill.getWidth()/2,getViewport().getWorldHeight()-(3.5f*(getViewport().getWorldHeight()/4f))+skill.getHeight()/2);
            skill.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    game.save.flush();
                    game.setScreen(new GameScreen(game));
                }
            });
            addActor(skill);
        }
    }

    public void destroy_screen(){
        if (kepernyo) {
            generator.destroy();
            lapat.destroy();
            csovek.destroy();
            munkasok.destroy();
            fal.destroy();
            skill.remove();
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
            sh_generator = new Show_part(this,"Generátor",game.save.getFloat("generator_lvl"));

            for (int i = 0; i < 5; i++){
            gen.add(new Upgrade(this,"Generátor",i));}
        }
        else if(name == "Lapát"){
            sh_generator = new Show_part(this,"Lapát",game.save.getFloat("lapat_lvl"));
            for (int i = 0; i < 6; i++){
                gen.add(new Upgrade(this,"Lapát",i));}
        }
        else if(name == "Csőrendszer"){
            sh_generator = new Show_part(this,"Csőrendszer",game.save.getFloat("csovek_lvl"));
            for (int i = 0; i < 4; i++){
                gen.add(new Upgrade(this,"Csőrendszer",i));}
        }
        else if(name == "Munkások"){
            sh_generator = new Show_part(this,"Munkások",game.save.getFloat("munkasok_lvl"));
            for (int i = 0; i < 6; i++){
                gen.add(new Upgrade(this,"Munkások",i));}
        }
        else if(name == "Gátfal"){
            sh_generator = new Show_part(this,"Gátfal",game.save.getFloat("gatfal_lvl"));
            for (int i = 0; i < 4; i++){
                gen.add(new Upgrade(this,"Gátfal",i));}
        }

        sh_generator.back.setHeight(gen.get(gen.size()-1).front.getY()+gen.get(gen.size()-1).front.getHeight());
        sh_generator.play.setHeight(gen.get(gen.size()-1).front.getY()+gen.get(gen.size()-1).front.getHeight());
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
            System.out.println("asd");
            if(game.save.getFloat("penz_mennyiseg") > (gen.get(hanyadik).lvl+1)*25){
                game.save.putFloat("penz_mennyiseg",game.save.getFloat("penz_mennyiseg")-(gen.get(hanyadik).lvl+1)*25);
                game.save.putFloat(gen.get(hanyadik).level,game.save.getFloat(gen.get(hanyadik).level)+1);
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
                game.save.putFloat(gen.get(hanyadik).level,game.save.getFloat(gen.get(hanyadik).level)+1);
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

            System.out.println(gen.get(hanyadik).level);
            System.out.println(gen.get(hanyadik).levelup);
            System.out.println(hanyadik);
        }


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

            if(siker == true && vis == false){
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
