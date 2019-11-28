package com.pendurpandurok.sziporka.Screens.CleanMinigame;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class CleanMinigameScreen extends MyScreen {

    CleanMinigameStage cleanMinigameStage;
    public CleanMinigameScreen(MyGdxGame game) {
        super(game);

        cleanMinigameStage = new CleanMinigameStage(spriteBatch, game);
        Gdx.input.setInputProcessor(cleanMinigameStage);
    }


    @Override
    public void render(float delta) {
        super.render(delta);

        cleanMinigameStage.act(delta);
        cleanMinigameStage.draw();
    }

    @Override
    public void init() {

    }
}
