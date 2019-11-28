package com.pendurpandurok.sziporka.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {

    GameStage gameStage;

    public GameScreen(MyGdxGame game) {
        super(game);

        gameStage = new GameStage(spriteBatch, game);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void init() {

    }
}
