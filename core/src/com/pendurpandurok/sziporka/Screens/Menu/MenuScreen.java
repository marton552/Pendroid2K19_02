package com.pendurpandurok.sziporka.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;


public class MenuScreen extends MyScreen {

    MenuStage menuStage;

    public MenuScreen(MyGdxGame game) {
        super(game);

        menuStage = new MenuStage(spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        menuStage.act(delta);
        menuStage.draw();
    }

    @Override
    public void init() {

    }
}
