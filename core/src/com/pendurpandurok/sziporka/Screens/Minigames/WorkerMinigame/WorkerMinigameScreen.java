package com.pendurpandurok.sziporka.Screens.Minigames.WorkerMinigame;

import com.badlogic.gdx.Gdx;
import com.pendurpandurok.sziporka.MusicPlayer;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class WorkerMinigameScreen extends MyScreen {


    WorkerMinigameStage workerMinigameStage;
    public WorkerMinigameScreen(MyGdxGame game) {
        super(game);

        workerMinigameStage = new WorkerMinigameStage(game);
        Gdx.input.setInputProcessor(workerMinigameStage);

        MusicPlayer.playMinigameMusic(4);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        workerMinigameStage.act(delta);
        workerMinigameStage.draw();
    }

    @Override
    public void init() {

    }
}
