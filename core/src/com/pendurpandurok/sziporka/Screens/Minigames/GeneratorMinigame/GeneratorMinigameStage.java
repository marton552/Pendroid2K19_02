package com.pendurpandurok.sziporka.Screens.Minigames.GeneratorMinigame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pendurpandurok.sziporka.MyGdxGame;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class GeneratorMinigameStage extends MyStage {

    ArrayList<FallingTakony> takonys = new ArrayList<>();

    public GeneratorMinigameStage(MyGdxGame game) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);

        addRandomTakony(10);
    }

    public FallingTakony addRandomTakony(float fallingSpeed) {
        FallingTakony ft = new FallingTakony(fallingSpeed);
        int spot = MathUtils.random(0, 2);

        ft.setPosition(55 + (ft.getWidth() + 10) * spot, getViewport().getWorldHeight());
        addActor(ft);
        takonys.add(ft);

        return ft;
    }

    int counter = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        counter++;

        if(counter % 100 == 0) {
            addRandomTakony(10f);
        }

    }

    @Override
    public void init() {

    }
}
