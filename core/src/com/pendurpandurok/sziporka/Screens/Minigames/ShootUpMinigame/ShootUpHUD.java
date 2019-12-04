package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;

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


    public ShootUpHUD(final MyGdxGame game, final ShootUpMinigameScreen screen) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);

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
                screen.shootUpMinigameStage.restartGame();
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

        victoryLabel = new MyLabel("Sikeresen kiírtottad\naz összes taknyot!", game.getLabelStyle());
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

    }


    public void togVictoryPanel(boolean state) {
        victoryBg.setVisible(state);
        victoryLabel.setVisible(state);
        victoryBtn.setVisible(state);
    }

    public void togOverPanel(boolean state) {
        overBg.setVisible(state);
        overLabel.setVisible(state);
        overBtn.setVisible(state);
    }

    @Override
    public void init() {

    }
}
