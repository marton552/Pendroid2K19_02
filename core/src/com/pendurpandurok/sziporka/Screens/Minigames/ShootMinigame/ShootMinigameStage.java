package com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame.ShootUpMinigameScreen;

import java.util.ArrayList;
import java.util.EventListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class ShootMinigameStage extends MyStage {

    ArrayList<Goblin> goblins = new ArrayList<>();
    int barW = 700;
    int killedGoblins = 0;
    int maxGoblinKill = MathUtils.random(10, 30);
    int playerHP = 100;

    boolean isGamePlaying = true;

    OneSpriteStaticActor hpBar;

    OneSpriteStaticActor overBg;
    MyLabel overLabel;
    MyButton overBtn;

    OneSpriteStaticActor victoryBg;
    MyLabel victoryLabel;
    MyButton victoryBtn;

    public int difficulty;

    MyGdxGame game;

    MyLabel info;

    public ShootMinigameStage(final MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);
        this.game = game;
        difficulty = Math.round(game.save.getFloat("gatfal_hp"));
        if(difficulty <= 10) difficulty = 20;

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        OneSpriteStaticActor fal;

        if(game.save.getFloat("gatfal_lvl") == 2.0f) fal = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT3));
        else if(game.save.getFloat("gatfal_lvl") == 1.0f) fal = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT2));
        else fal = new OneSpriteStaticActor(Assets.manager.get(Assets.GAT1));

        fal.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(fal);

        OneSpriteStaticActor hpBarBG = new OneSpriteStaticActor(Assets.manager.get(Assets.FULLWHITE));
        hpBarBG.setSize(barW, 30);
        hpBarBG.setPosition(getViewport().getWorldWidth() / 2 - hpBarBG.getWidth() / 2, getViewport().getWorldHeight() - 50);

        OneSpriteStaticActor hpBarOut = new OneSpriteStaticActor(Assets.manager.get(Assets.GRAY));
        hpBarOut.setSize(barW + 10, 30 + 10);
        hpBarOut.setPosition(hpBarBG.getX() - 5, hpBarBG.getY() - 5);

        addActor(hpBarOut);
        addActor(hpBarBG);

        hpBar = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        hpBar.setSize((barW/100)*playerHP, hpBarBG.getHeight());
        hpBar.setPosition(hpBarBG.getX(), hpBarBG.getY());

        addActor(hpBar);

        MyLabel hpLabel = new MyLabel("HP", game.getLabelStyle());
        hpLabel.setFontScale(0.6f);
        hpLabel.setPosition(getViewport().getWorldWidth() / 2 - (hpLabel.getWidth()*hpLabel.getFontScaleX()) / 2 + 3, hpBarBG.getY() - 20);

        addActor(hpLabel);

        overBg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        overBg.setSize(getViewport().getWorldWidth(), 500);
        overBg.setY(getViewport().getWorldHeight() / 2 - overBg.getHeight() / 2);
        overBg.setAlpha(0.8f);
        overBg.setVisible(false);
        overBg.setZIndex(1000);

        addActor(overBg);

        overLabel = new MyLabel("Meghaltál!", game.getLabelStyle());
        overLabel.setFontScale(0.7f);
        overLabel.setColor(Color.RED);
        overLabel.setPosition(getViewport().getWorldWidth() / 2 - (overLabel.getWidth()*overLabel.getFontScaleX()) / 2, overBg.getY() + 300);
        overLabel.setVisible(false);
        overLabel.setZIndex(1000);

        addActor(overLabel);

        overBtn = new MyButton("Újra", game.getButtonStyle());
        overBtn.setWidth(300);
        overBtn.setPosition(getViewport().getWorldWidth() / 2 - overBtn.getWidth() / 2, overBg.getY() + 150);
        overBtn.setVisible(false);
        overBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                restartGame();
            }
        });
        overBg.setZIndex(1000);

        addActor(overBtn);

        victoryBg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        victoryBg.setSize(getViewport().getWorldWidth(), 500);
        victoryBg.setY(getViewport().getWorldHeight() / 2 - victoryBg.getHeight() / 2);
        victoryBg.setAlpha(0.8f);
        victoryBg.setVisible(false);

        addActor(victoryBg);

        victoryLabel = new MyLabel("Sikeresen kiírtottad\naz összes goblint!", game.getLabelStyle());
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
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(victoryBtn);


        info = new MyLabel(maxGoblinKill+"/"+killedGoblins, game.getLabelStyle());
        info.setAlignment(Align.center);
        info.setFontScale(0.9f);
        info.setPosition(getViewport().getWorldWidth() / 2 - (info.getWidth()*info.getFontScaleX()) / 2 - 10, getViewport().getWorldHeight() - 130);

        addActor(info);

    }

    public void onGoblinKill(Goblin g) {

        Blood blood = new Blood(this);
        blood.setPosition(g.getX() + g.getWidth() / 2 - blood.getWidth() / 2, g.getY() + g.getHeight() / 2 - blood.getHeight() / 2);
        addActor(blood);

        getActors().removeValue(g, false);
        goblins.remove(g);

        killedGoblins++;

        if(killedGoblins >= maxGoblinKill) {
            gameVictory();
        }

        info.setText(maxGoblinKill+"/"+killedGoblins);
    }

    public void createRandomGoblin() {
        Goblin g = new Goblin(Goblin.getRandomGoblinType(), this);
        g.setPosition(MathUtils.random(10, getViewport().getWorldWidth() - 100), MathUtils.random(10, getViewport().getWorldHeight() - 180));
        goblins.add(g);
        addActor(g);
    }

    public void hitPlayer() {
        if(isGamePlaying == false) return;

        playerHP -= MathUtils.random(1, 3);
        if(playerHP <= 0) {
            playerHP = 0;

            gameOver();

        } else hpBar.setWidth((barW/100)*playerHP);


    }

    public void gameOver() {
        isGamePlaying = false;

        overBg.setVisible(true);
        overLabel.setVisible(true);
        overBtn.setVisible(true);

        hpBar.setWidth((barW/100)*playerHP);

        for (int i = 0; i < goblins.size(); i++) {
            Goblin g = goblins.get(i);
            getActors().removeValue(g, false);
        }

        for (int i = 0; i < goblins.size(); i++) {
            goblins.remove(i);
        }

        goblins.clear();
    }

    public void gameVictory() {
        isGamePlaying = false;

        victoryBg.setVisible(true);
        victoryLabel.setVisible(true);
        victoryBtn.setVisible(true);

        game.save.putFloat("gatfal_hp", 100.0f);
        game.save.flush();
    }

    public void restartGame() {
        playerHP = 100;
        killedGoblins = 0;

        overBg.setVisible(false);
        overLabel.setVisible(false);
        overBtn.setVisible(false);

        //difficulty += 5; // Ez elrontja az egészet, tehát nem fog könnyebb lenni a dolog
        info.setText(maxGoblinKill+"/"+killedGoblins);
        hpBar.setWidth((barW/100)*playerHP);

        isGamePlaying = true;

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreen(new MenuScreen(game));
            }
        });
    }

    int counter = 0;

    @Override
    public void act(float delta) {
        super.act(delta);

        if(isGamePlaying) {
            counter++;

            if(counter % difficulty == 0) {
                if(killedGoblins+goblins.size()+1 <= maxGoblinKill) createRandomGoblin();
            }
        }
    }

    @Override
    public void init() {

    }
}
