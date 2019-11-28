package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class ShootUpMinigameScreen extends MyScreen {

    ShootUpMinigameStage shootUpMinigameStage;
    public ShootUpMinigameScreen(MyGdxGame game) {
        super(game);

        shootUpMinigameStage = new ShootUpMinigameStage(spriteBatch, game);
        Gdx.input.setInputProcessor(shootUpMinigameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        shootUpMinigameStage.act(delta);
        shootUpMinigameStage.draw();
    }

    @Override
    public void init() {

    }
}
