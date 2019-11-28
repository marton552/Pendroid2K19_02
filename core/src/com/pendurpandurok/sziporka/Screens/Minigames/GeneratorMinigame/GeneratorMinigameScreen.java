package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GeneratorMinigameScreen extends MyScreen {

    GeneratorMinigameStage generatorMinigameStage;

    public GeneratorMinigameScreen(MyGdxGame game) {
        super(game);

        generatorMinigameStage = new GeneratorMinigameStage(spriteBatch, game);
        Gdx.input.setInputProcessor(generatorMinigameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        generatorMinigameStage.act(delta);
        generatorMinigameStage.draw();
    }

    @Override
    public void init() {

    }
}
