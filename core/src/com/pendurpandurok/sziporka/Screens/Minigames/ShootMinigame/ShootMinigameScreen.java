package com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class ShootMinigameScreen extends MyScreen {

    ShootMinigameStage shootMinigameStage;
    public ShootMinigameScreen(MyGdxGame game) {
        super(game);

        shootMinigameStage = new ShootMinigameStage(spriteBatch, game);
        Gdx.input.setInputProcessor(shootMinigameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        shootMinigameStage.act(delta);
        shootMinigameStage.draw();
    }

    @Override
    public void init() {

    }
}
