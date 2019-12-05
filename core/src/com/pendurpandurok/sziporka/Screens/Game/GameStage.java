package com.pendurpandurok.sziporka.Screens.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;
import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame.ShootMinigameScreen;
import com.pendurpandurok.sziporka.Skill;
import com.sun.corba.se.spi.activation.POANameHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class GameStage extends MyStage {

    public MyGdxGame game;
    public List<Skill> pontok = new ArrayList<>();

    OneSpriteStaticActor kocka;

    public GameStage(final MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);
        this.game = game;

        OneSpriteStaticActor background = new OneSpriteStaticActor(Assets.manager.get(Assets.SKILL_TREE));
        background.setSize(((FitViewport) getViewport()).getWorldWidth(), getViewport().getWorldHeight());
        addActor(background);

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.save.putString("kordinata",coor);
                game.save.flush();
                game.setScreen(new MenuScreen(game));
            }
        });



        if(game.save.getString("kordinata") == "") for (int i = 0; i < game.save.getFloat("skillpontok"); i++) {
            pontok.add(new Skill(this, i + 1,0.0f,0.0f));
        }

        else{
            String[] tomb = game.save.getString("kordinata").split(",");

            for (int i = 0; i < game.save.getFloat("skillpontok")*2; i+=2) {
            pontok.add(new Skill(this, i+1,Float.parseFloat(tomb[i]),Float.parseFloat(tomb[i+1])));
        }}

        MyButton back = new MyButton("V\nI\nS\nS\nZ\nA", game.getButtonStyle());
        back.setWidth(getViewport().getWorldWidth() / 8);
        back.setHeight(getViewport().getWorldHeight() / 7);
        back.setPosition(0, 0);
        back.getLabel().setFontScale(0.4f);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                game.setScreen(new MenuScreen(game));
            }
        });
        addActor(back);

        MyButton play = new MyButton("R\nE\nS\nE\nT", game.getButtonStyle());
        play.setWidth(getViewport().getWorldWidth() / 8);
        play.setHeight(getViewport().getWorldHeight() / 7);
        play.setPosition(getViewport().getWorldWidth() - play.getWidth(), 0);
        play.getLabel().setFontScale(0.4f);
        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                for (int i = 0; i < game.save.getFloat("skillpontok"); i++) {
                    pontok.get(i).kocka.setPosition((getViewport().getWorldWidth() / 10) * (i + 1) * 1.5f, getViewport().getWorldWidth() / 10);
                }

            }
        });
        addActor(play);
    }

    @Override
    public void init() {

    }

    double nextPay = System.currentTimeMillis() + 1000;
    String coor;

    public void act(float delta) {
        super.act(delta);


        if (nextPay <= System.currentTimeMillis()) {
            nextPay = System.currentTimeMillis() + 1000;
            game.save.putFloat("skill_1",0);
            game.save.putFloat("skill_2",0);
            game.save.putFloat("skill_3",0);
            game.save.putFloat("skill_4",0);
            game.save.putFloat("skill_5",0);
            game.save.putFloat("skill_6",0);
            coor = "";
            for (int i = 0; i < game.save.getFloat("skillpontok"); i++) {
                if(pontok.get(i).kocka.getY() > getViewport().getWorldHeight() / 7){
                if (pontok.get(i).kocka.getX() < getViewport().getWorldWidth() / 2f) {
                    if (pontok.get(i).kocka.getY()-getViewport().getWorldHeight() / 7 < getViewport().getWorldHeight() / 3.66f) {
                        game.save.putFloat("skill_3",game.save.getFloat("skill_3")+1);
                    } else if (pontok.get(i).kocka.getY()-getViewport().getWorldHeight() / 7 < getViewport().getWorldHeight() / 1.83f) {
                        game.save.putFloat("skill_2",game.save.getFloat("skill_2")+1);
                    } else if (pontok.get(i).kocka.getY()-getViewport().getWorldHeight() / 7 < getViewport().getWorldHeight() / 1.22f) {
                        game.save.putFloat("skill_1",game.save.getFloat("skill_1")+1);
                    }
                } else {
                    if (pontok.get(i).kocka.getY()-getViewport().getWorldHeight() / 7 < getViewport().getWorldHeight() / 3.66f) {
                        game.save.putFloat("skill_6",game.save.getFloat("skill_6")+1);
                    } else if (pontok.get(i).kocka.getY()-getViewport().getWorldHeight() / 7 < getViewport().getWorldHeight() / 1.75f) {
                        game.save.putFloat("skill_5",game.save.getFloat("skill_5")+1);
                    } else if (pontok.get(i).kocka.getY()-getViewport().getWorldHeight() / 7 < getViewport().getWorldHeight() / 1.22f) {
                        game.save.putFloat("skill_4",game.save.getFloat("skill_4")+1);
                    }
                }
                }
                coor += pontok.get(i).kocka.getX()+","+pontok.get(i).kocka.getY()+",";
            }
            game.save.putString("kordinata",coor);
            game.save.flush();
        }
    }
}