package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Game.GameScreen;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame.CleanMinigameScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame.Bomb;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class GeneratorMinigameStage extends MyStage {

    public OneSpriteStaticActor kocka;
    public OneSpriteStaticActor kocka2;
    public float magassag = 100;
    public boolean isTouching = false;
    public boolean up = false;
    public Player player;
    public int rnd1;
    public int rnd2;
    public List<Bomba> sokbomba = new ArrayList<>();
    public List<Coin> sokpenz = new ArrayList<>();
    public Float y1;
    public boolean eletbenvan = true;
    public int penz;
    public float difficult;

    OneSpriteStaticActor overBg;
    MyLabel overLabel;
    MyButton overBtn;

    OneSpriteStaticActor victoryBg;
    MyLabel victoryLabel;
    MyButton victoryBtn;
    MyLabel infoout;

    public GeneratorMinigameStage(final MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.ALVANY));
        bg.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(bg);

        difficult = game.save.getFloat("generator_hp")+50;
        difficult = difficult/4;

        kocka = new OneSpriteStaticActor(Assets.manager.get(Assets.CSUSZKA_BG));
        kocka.setSize(getViewport().getWorldWidth()/4f,getViewport().getWorldWidth()/4f);
        kocka.setPosition(getViewport().getWorldWidth()/2-kocka.getWidth()/2,getViewport().getWorldHeight()/3-kocka.getHeight()*1.4f);
        kocka.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isTouching = true;
                up = false;
                return super.touchDown(event, x, y, pointer, button);
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouching = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });
        addActor(kocka);

        kocka2 = new OneSpriteStaticActor(Assets.manager.get(Assets.CSUSZKA));
        kocka2.setSize(getViewport().getWorldWidth()/4f,getViewport().getWorldWidth()/4f);
        kocka2.setPosition(getViewport().getWorldWidth()/2-kocka2.getWidth()/2,getViewport().getWorldHeight()/3-kocka2.getHeight()*2.5f);
        kocka2.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isTouching = true;
                up = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouching = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });
        addActor(kocka2);


        player = new Player(this,100f);

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreen(new MenuScreen(game));
            }
        });

        infoout = new MyLabel("20/"+penz, game.getLabelStyle());
        infoout.setFontScale(0.72f);
        infoout.setColor(Color.WHITE);
        infoout.setPosition(Align.center,getViewport().getWorldHeight()-infoout.getHeight());
        addActor(infoout);

        overBg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        overBg.setSize(getViewport().getWorldWidth(), 500);
        overBg.setY(getViewport().getWorldHeight() / 2 - overBg.getHeight() / 2);
        overBg.setAlpha(0.8f);
        overBg.setVisible(false);
        overBg.setZIndex(1000);

        addActor(overBg);

        overLabel = new MyLabel("Vesztettél!", game.getLabelStyle());
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
                game.setScreen(new GeneratorMinigameScreen(game));
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

        victoryLabel = new MyLabel("Gyöztél! "+"\nJutalmad "+25*(game.save.getFloat("skill_3")+1)+" pénz", game.getLabelStyle());
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
                game.save.putFloat("generator_hp",100);
                game.save.flush();
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(victoryBtn);
    }


    int counter = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        if(eletbenvan){
        counter++;
        if(counter%2==0){
            rnd1 = MathUtils.random(1, 50);
            if(isTouching && up){
                if(magassag<150){
                magassag+=3;}
            }
            if(isTouching && up==false){
                if(magassag>50){
                magassag-=3;}
            }
            player.play.setHeight(getViewport().getWorldHeight()/(magassag/10));
            rnd2 = MathUtils.random(1, 25);
            if(rnd1 == rnd2){
                rnd1 =MathUtils.random(1,2);
                y1 = Float.parseFloat(MathUtils.random(220, 270)+"");
                if(rnd1 ==1) sokbomba.add(new Bomba(this,getViewport().getWorldHeight()/(y1/100)));
                else sokpenz.add(new Coin(this,getViewport().getWorldHeight()/(y1/100)));
            }
            for (int i = 0;i<sokbomba.size();i++){
                if(sokbomba.get(i).bomba.getX() > 0-sokbomba.get(i).bomba.getWidth())sokbomba.get(i).bomba.setX(sokbomba.get(i).bomba.getX()-8);
                if(player.play.getX()+player.play.getWidth() >= sokbomba.get(i).bomba.getX() && player.play.getX() <= sokbomba.get(i).bomba.getX()+sokbomba.get(i).bomba.getWidth() && player.play.getY()+player.play.getHeight() >= sokbomba.get(i).bomba.getY()){
                    eletbenvan = false;
                    overLabel.setVisible(true);
                    overBg.setVisible(true);
                    overBtn.setVisible(true);
                }
            }
            for (int i = 0;i<sokpenz.size();i++){
                if(sokpenz.get(i).coin.getX() > 0-sokpenz.get(i).coin.getWidth())sokpenz.get(i).coin.setX(sokpenz.get(i).coin.getX()-8);
                if(player.play.getX()+player.play.getWidth() >= sokpenz.get(i).coin.getX() && player.play.getX() <= sokpenz.get(i).coin.getX()+sokpenz.get(i).coin.getWidth() && player.play.getY()+player.play.getHeight() >= sokpenz.get(i).coin.getY()){
                    sokpenz.get(i).coin.setX(-100);
                    penz++;
                    infoout.setText("20/"+penz);
                    if(penz == 20){
                    eletbenvan = false;
                    victoryBg.setVisible(true);
                    victoryBtn.setVisible(true);
                    victoryLabel.setVisible(true);}
                }
            }
        }}
    }

    @Override
    public void init() {

    }
}
