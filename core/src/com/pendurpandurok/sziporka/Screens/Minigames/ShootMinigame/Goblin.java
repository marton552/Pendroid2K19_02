package com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Assets;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Goblin extends OneSpriteStaticActor {

    int goblinType;

    float finalW = 0;
    float finalH = 0;
    float zoomSpeed = 20;
    final ShootMinigameStage stage;
    float angry = 1f;

    public Goblin(int type, final ShootMinigameStage stage) {
        super(getGoblinTexture(type));
        this.goblinType = type;
        this.stage = stage;

        finalW = getWidth() / (2 * (goblinType+1));
        finalH = getHeight() / (2 * (goblinType+1));


        setSize(0, 0);

        setOrigin(getX() + getWidth() / 2, getY() +getHeight() / 2);
        setRotation(-20f);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                goblinDeath();

            }
        });

        int randSound = MathUtils.random(0, 2);

        if(randSound == 0) Assets.manager.get(Assets.GOBLIN_SOUND1).play(1);
        else if(randSound == 1) Assets.manager.get(Assets.GOBLIN_SOUND2).play(1);
        else Assets.manager.get(Assets.GOBLIN_SOUND3).play(1);
    }

    public void goblinDeath() {
        stage.onGoblinKill(this);
        counter = 0;
    }


    private static Texture getGoblinTexture(int type) {
        if(type == 0) return Assets.manager.get(Assets.GOBLIN_1);
        if(type == 1) return Assets.manager.get(Assets.GOBLIN_2);
        else return Assets.manager.get(Assets.GOBLIN_3);
    }

    public static int getRandomGoblinType() {
        return MathUtils.random(0, 2);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        setOrigin(getWidth() / 2, getHeight() / 2);

    }

    int counter = 0;

    @Override
    public void act(float delta) {
        super.act(delta);

        counter++;

        if(finalW > getWidth())
            setWidth(getWidth() + (finalW / zoomSpeed));


        if(finalH > getHeight())
            setHeight(getHeight() + (finalH / zoomSpeed));


        setOrigin(getWidth() / 2, getHeight() / 2);
        setRotation(getRotation() + ((float)Math.sin(counter / 4f) * angry));


        if(counter % stage.difficulty == 0) {

            if(angry >= 5f)  {
                //if(counter % 100 == 0) {
                    stage.hitPlayer();
                    counter = 0;
                //}
            }else angry++;
        }

    }
}
