package com.pendurpandurok.sziporka.Screens.Detail;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class DetailScreen extends MyScreen {

    DetailStage detailStage;
    public DetailScreen(MyGdxGame game) {
        super(game);

        detailStage = new DetailStage(spriteBatch, game);
        Gdx.input.setInputProcessor(detailStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        detailStage.act(delta);
        detailStage.draw();
    }

    @Override
    public void init() {

    }
}
