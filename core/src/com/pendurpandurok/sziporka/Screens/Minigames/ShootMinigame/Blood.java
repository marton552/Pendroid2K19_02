package com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class Blood extends OneSpriteAnimatedActor {

    ShootMinigameStage stage;

    public Blood(ShootMinigameStage stage) {
        super(Assets.manager.get(Assets.BLOOD_ATLAS));
        this.stage = stage;

        setSize(getWidth() / 1.5f, getHeight() / 1.5f);
        setLooping(false);
        setFps(15);
    }

    @Override
    public void setFrame(int frame) {
        super.setFrame(frame);

        if(frame == getFrameCount() - 1) stage.getActors().removeValue(this, false);
    }


}
