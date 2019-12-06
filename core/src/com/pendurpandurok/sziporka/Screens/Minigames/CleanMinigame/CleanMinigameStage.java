package com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.Card;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;
import com.pendurpandurok.sziporka.newCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class CleanMinigameStage extends MyStage {
    newCard first;
    newCard second;
    public int nehezseg;
    List<Card> pakli = new ArrayList<>();
    List<Integer> sorrend = new ArrayList<>();
    public int kartya1=100;
    public int kartya2=100;
    public int life;
    public boolean clickable = true;
    public MyLabel infoout;
    public int kellmeg = 0;

    OneSpriteStaticActor overBg;
    MyLabel overLabel;
    MyButton overBtn;

    OneSpriteStaticActor victoryBg;
    MyLabel victoryLabel;
    MyButton victoryBtn;

    public CleanMinigameStage(final MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);
        nehezseg = Math.round(game.save.getFloat("lapat_hp"));
        if(nehezseg > 75){
            nehezseg = 6;
        }
        else if(nehezseg > 50){
            nehezseg = 8;
        }
        else if(nehezseg > 25){
            nehezseg = 10;
        }
        else nehezseg = 12;

        life = Math.round(nehezseg*1.3f);
        kellmeg = nehezseg;

        for(int i = 0; i < nehezseg/2; i++){
            sorrend.add(i);
            sorrend.add(i);
        }
        Collections.shuffle(sorrend);
        System.out.println(sorrend);

        OneSpriteStaticActor background = new OneSpriteStaticActor(Assets.manager.get(Assets.ASZTAL));
        background.setSize((getViewport()).getWorldWidth(), getViewport().getWorldHeight());
        addActor(background);

        infoout = new MyLabel("Még ennyit ronthatsz: "+life, game.getLabelStyle());
        infoout.setFontScale(0.72f);
        infoout.setColor(Color.WHITE);
        infoout.setPosition(Align.center,getViewport().getWorldHeight()-infoout.getHeight());
        addActor(infoout);

        int sor = 0;
        for(int i = 0; i < nehezseg; i++){
            if(i%2==0)sor++;
            pakli.add(new Card(this,sorrend.get(i),nehezseg,i,sor));
            System.out.println(sor);
        }

        overBg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        overBg.setSize(getViewport().getWorldWidth(), 500);
        overBg.setY(getViewport().getWorldHeight() / 2 - overBg.getHeight() / 2);
        overBg.setAlpha(0.8f);
        overBg.setVisible(false);

        addActor(overBg);

        overLabel = new MyLabel("Vesztettél!", game.getLabelStyle());
        overLabel.setFontScale(0.7f);
        overLabel.setColor(Color.RED);
        overLabel.setPosition(getViewport().getWorldWidth() / 2 - (overLabel.getWidth()*overLabel.getFontScaleX()) / 2, overBg.getY() + 300);
        overLabel.setVisible(false);

        addActor(overLabel);

        overBtn = new MyButton("Újra", game.getButtonStyle());
        overBtn.setWidth(300);
        overBtn.setPosition(getViewport().getWorldWidth() / 2 - overBtn.getWidth() / 2, overBg.getY() + 150);
        overBtn.setVisible(false);
        overBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new CleanMinigameScreen(game));
            }
        });

        addActor(overBtn);

        victoryBg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        victoryBg.setSize(getViewport().getWorldWidth(), 500);
        victoryBg.setY(getViewport().getWorldHeight() / 2 - victoryBg.getHeight() / 2);
        victoryBg.setAlpha(0.8f);
        victoryBg.setVisible(false);

        addActor(victoryBg);

        victoryLabel = new MyLabel("Sikeresen megtaláltad\na párokat!\nJutalmad "+Math.round(25*(game.save.getFloat("skill_3")+1))+" pénz", game.getLabelStyle());
        victoryLabel.setFontScale(0.7f);
        victoryLabel.setAlignment(Align.center);
        victoryLabel.setColor(Color.WHITE);
        victoryLabel.setPosition(getViewport().getWorldWidth() / 2 - (victoryLabel.getWidth()*victoryLabel.getFontScaleX()) / 2 - 80, victoryBg.getY() + 300);
        victoryLabel.setVisible(false);

        addActor(victoryLabel);

        victoryBtn = new MyButton("Vissza", game.getButtonStyle());
        victoryBtn.setWidth(300);
        victoryBtn.setPosition(getViewport().getWorldWidth() / 2 - victoryBtn.getWidth() / 2, victoryBg.getY() + 150);
        victoryBtn.setVisible(false);
        victoryBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.save.putFloat("minigamek",game.save.getFloat("minigamek")+1);
                game.save.putFloat("lapat_hp",100);
                game.save.flush();
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(victoryBtn);

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreen(new MenuScreen(game));
            }
        });
    }


    @Override
    public void init() {

    }

    int saveone = 0;
    int savetwo = 0;

    public void felfordit(int hanyadik,int melyik){
        if(clickable){
        if(kartya1 == 100){
            kartya1 = melyik;
            first = new newCard(this,melyik,pakli.get(hanyadik).card.getX(),pakli.get(hanyadik).card.getY(),pakli.get(hanyadik).card.getWidth(),pakli.get(hanyadik).card.getHeight());
            saveone = hanyadik;
        }
        else if(kartya2 == 100){
            kartya2 = melyik;
            second = new newCard(this,melyik,pakli.get(hanyadik).card.getX(),pakli.get(hanyadik).card.getY(),pakli.get(hanyadik).card.getWidth(),pakli.get(hanyadik).card.getHeight());
            savetwo = hanyadik;
        }

        if(kartya1 == 0){
            wait = 10;
            clickable = false;
            kartya1 = 100;
        }
        if(kartya2 == 0){
            wait = 2;
            clickable = false;
            kartya1 = 100;
            kartya2 = 100;
        }

        if(kartya1 == kartya2 && kartya2!=100){
            wait = 3;
            kartya1 = 100;
            kartya2 = 100;
            clickable = false;
        }
        else if(kartya2!=100){
            wait = 4;
            kartya1 = 100;
            kartya2 = 100;
            clickable = false;
        }}
    }


    int wait = 0;
    double nextPay = System.currentTimeMillis() + 1000;

    public void act(float delta) {
        super.act(delta);

        infoout.setText("Még ennyit ronthatsz: "+life);

        if (nextPay <= System.currentTimeMillis()) {
            nextPay = System.currentTimeMillis() + 1000;




            if(wait==3){
                first.destroy();
                second.destroy();
                pakli.get(saveone).destroy();
                pakli.get(savetwo).destroy();
                wait = 0;
                clickable = true;
                kellmeg-=2;
                if(kellmeg ==2){

                    victoryBg.setVisible(true);
                    victoryBtn.setVisible(true);
                    victoryLabel.setVisible(true);

                }
            }
            if(wait==4){
                first.destroy();
                second.destroy();
                life = life-1;
                wait = 0;
                clickable = true;
                if(life == 0){
                    overLabel.setVisible(true);
                    overBg.setVisible(true);
                    overBtn.setVisible(true);
                }
            }
            if(wait == 11){
                first.destroy();
                life = life-1;
                wait = 0;
                clickable = true;
                if(life == 0){
                    overLabel.setVisible(true);
                    overBg.setVisible(true);
                    overBtn.setVisible(true);
                }
            }

            if(wait==1){
                wait = 3;
            }
            if(wait==2){
                wait = 4;
            }
            if(wait == 10){
                wait = 11;
            }
        }
    }
}