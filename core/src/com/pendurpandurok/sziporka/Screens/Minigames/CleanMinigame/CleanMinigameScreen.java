package com.pendurpandurok.sziporka.Screens.Minigames.CleanMinigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.pendurpandurok.sziporka.MusicPlayer;
import com.pendurpandurok.sziporka.MyGdxGame;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class CleanMinigameScreen extends MyScreen {

    CleanMinigameStage cleanMinigameStage;
    public CleanMinigameScreen(MyGdxGame game) {
        super(game);

        cleanMinigameStage = new CleanMinigameStage(game);
        Gdx.input.setInputProcessor(cleanMinigameStage);

        MusicPlayer.playMinigameMusic(0);
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
