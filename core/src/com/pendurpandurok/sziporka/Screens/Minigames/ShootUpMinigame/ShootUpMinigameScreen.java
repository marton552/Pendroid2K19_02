package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.pendurpandurok.sziporka.MusicPlayer;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class ShootUpMinigameScreen extends MyScreen {

    public ShootUpMinigameStage shootUpMinigameStage;
    public ShootUpHUD hud;

    public ShootUpMinigameScreen(MyGdxGame game) {
        super(game);

        shootUpMinigameStage = new ShootUpMinigameStage(game, this);
        hud = new ShootUpHUD(game,this);

        InputMultiplexer im = new InputMultiplexer();
        im.addProcessor(hud);
        im.addProcessor(shootUpMinigameStage);

        Gdx.input.setInputProcessor(im);

        MusicPlayer.playMinigameMusic(3);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        shootUpMinigameStage.act(delta);
        shootUpMinigameStage.draw();

        hud.act(delta);
        hud.draw();
    }

    @Override
    public void init() {

    }
}
