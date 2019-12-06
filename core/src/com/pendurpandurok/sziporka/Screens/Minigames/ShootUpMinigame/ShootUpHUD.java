package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;

import java.awt.SystemTray;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class ShootUpHUD extends MyStage {
    OneSpriteStaticActor overBg;
    MyLabel overLabel;
    MyButton overBtn;

    OneSpriteStaticActor victoryBg;
    MyLabel victoryLabel;
    MyButton victoryBtn;

    MyLabel info;

    Bomb bomb;
    OneSpriteStaticActor bombLine;

    ShootUpMinigameScreen screen;

    public ShootUpHUD(final MyGdxGame game, final ShootUpMinigameScreen screen) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);
        this.screen = screen;

        bombLine = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        bombLine.setSize(screen.shootUpMinigameStage.urhajo.getWidth(), getViewport().getWorldHeight());
        bombLine.setVisible(false);
        bombLine.addBaseCollisionRectangleShape();
        bombLine.setAlpha(0.4f);
        addActor(bombLine);

        bomb = new Bomb(this);
        bomb.setSize(bomb.getWidth() / 10, bomb.getHeight() / 10);
        addActor(bomb);


        overBg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        overBg.setSize(getViewport().getWorldWidth(), 500);
        overBg.setY(getViewport().getWorldHeight() / 2 - overBg.getHeight() / 2);
        overBg.setAlpha(0.8f);
        overBg.setVisible(false);

        addActor(overBg);

        overLabel = new MyLabel("Meghaltál!", game.getLabelStyle());
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
                screen.shootUpMinigameStage.restartGame();
            }
        });

        addActor(overBtn);

        victoryBg = new OneSpriteStaticActor(Assets.manager.get(Assets.BLACK));
        victoryBg.setSize(getViewport().getWorldWidth(), 500);
        victoryBg.setY(getViewport().getWorldHeight() / 2 - victoryBg.getHeight() / 2);
        victoryBg.setAlpha(0.8f);
        victoryBg.setVisible(false);

        addActor(victoryBg);

        victoryLabel = new MyLabel("Sikeresen kiírtottad\naz összes taknyot!"+"\nJutalmad "+Math.round(25*(game.save.getFloat("skill_3")+1))+" pénz", game.getLabelStyle());
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
                game.save.flush();
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(victoryBtn);

        info = new MyLabel(screen.shootUpMinigameStage.maxKill+"/"+screen.shootUpMinigameStage.currKill, game.getLabelStyle());
        info.setAlignment(Align.center);
        info.setFontScale(0.9f);
        info.setPosition(getViewport().getWorldWidth() / 2 - (info.getWidth()*info.getFontScaleX()) / 2 - 10, getViewport().getWorldHeight() - info.getHeight() - 10);

        addActor(info);
    }

    boolean exploded = true;
    double nextBomb = 0;


    public void generateBomb() {
        bombLine.setX(MathUtils.random(0, getViewport().getWorldWidth() - bombLine.getWidth()));
        bombLine.setVisible(true);

        bomb.setPosition(bombLine.getX() + bombLine.getWidth() / 2 - bomb.getWidth() / 2, getViewport().getWorldHeight() - bomb.getHeight() - 10);
        bomb.armTheBomb();
        bomb.setVisible(true);

        exploded = false;
    }

    public void reArmBomb() {
        exploded = true;
        nextBomb = System.currentTimeMillis() + MathUtils.random(5000, 8000);
    }

    public void bombExploded() {
        OneSpriteStaticActor temp = new OneSpriteStaticActor(Assets.manager.get(Assets.HP_BAR));
        temp.addBaseCollisionRectangleShape();
        temp.setSize(bombLine.getWidth(), bombLine.getHeight());
        temp.setX(bombLine.getX());

        boolean death = screen.shootUpMinigameStage.bombExploded(temp);
        bombLine.setVisible(false);
        if(death == false) {
            exploded = true;
            nextBomb = System.currentTimeMillis() + MathUtils.random(5000, 8000);
        }
    }

    public void updateKillText(int max, int curr) {
        info.setText(max+"/"+curr);
    }


    public void togVictoryPanel(boolean state) {
        victoryBg.setVisible(state);
        victoryLabel.setVisible(state);
        victoryBtn.setVisible(state);

        if(state) Assets.manager.get(Assets.VICTORY_SOUND).play(1);
    }

    public void togOverPanel(boolean state) {
        overBg.setVisible(state);
        overLabel.setVisible(state);
        overBtn.setVisible(state);

        if(state) Assets.manager.get(Assets.LOSE_SOUND).play(1);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(exploded) {
            if(nextBomb <= System.currentTimeMillis()) {
                generateBomb();
            }
        }
    }

    @Override
    public void init() {

    }
}
