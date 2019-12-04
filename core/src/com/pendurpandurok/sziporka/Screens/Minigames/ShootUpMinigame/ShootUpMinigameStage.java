package com.pendurpandurok.sziporka.Screens.Minigames.ShootUpMinigame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pendurpandurok.sziporka.Assets;
import com.pendurpandurok.sziporka.MyGdxGame;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;
import com.pendurpandurok.sziporka.Screens.Minigames.ShootMinigame.Blood;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.pendurpandurok.sziporka.MyGdxGame.keparanySzelesvaszonra;

public class ShootUpMinigameStage extends MyStage {

    OneSpriteStaticActor urhajo;
    boolean isTouching = false; //Ez nézi hogy az ujjad rajta van-e a stagen

    float SCROLL_SPEED = 10;

    ArrayList<OneSpriteStaticActor> tubes = new ArrayList<>();
    float lastY = -getViewport().getWorldHeight() / 2;

    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Takony> takonys = new ArrayList<>();


    boolean isPlaying = true;

    int maxKill = MathUtils.random(15, 30);
    int currKill = 0;

    OneSpriteAnimatedActor explosion;

    ShootUpMinigameScreen screen;

    public ShootUpMinigameStage(final MyGdxGame game, ShootUpMinigameScreen screen) {
        super(new FitViewport(720f, keparanySzelesvaszonra()), game);
        this.screen = screen;

        getCamera().position.y = 0;


        for (int i = 0; i < 3; i++) {
            OneSpriteStaticActor tube = new OneSpriteStaticActor(Assets.manager.get(Assets.CSO));
            tube.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
            tube.setZIndex(10);
            if(i > 0){
                tube.setY(lastY + tube.getHeight());

                int randAmount = MathUtils.random(1, 3);
                for (int j = 0; j < randAmount; j++) spawnTakony(lastY + tube.getHeight());
            }
            else tube.setY(lastY);
            addActor(tube);

            if(tube.getY() > lastY) lastY = tube.getY();

            tubes.add(tube);
        }


        urhajo = new OneSpriteStaticActor(Assets.manager.get(Assets.URHAJO));
        urhajo.setSize(urhajo.getWidth() / 10, urhajo.getHeight() / 10);
        urhajo.setPosition(getViewport().getWorldWidth() / 2 - urhajo.getWidth() / 2, 20);
        urhajo.addBaseCollisionRectangleShape();
        addActor(urhajo);


        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //urhajo.setPosition(x, y);
                isTouching = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if(isPlaying) {
                    if (x - urhajo.getWidth() / 2 >= 50 && x + urhajo.getWidth() / 2 <= getViewport().getWorldWidth() - 50)
                        urhajo.setX(x - urhajo.getWidth() / 2);
                    urhajo.setY(y - urhajo.getHeight() / 2);
                    isTouching = true;
                }else isTouching = false;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouching = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });


        explosion = new OneSpriteAnimatedActor(Assets.manager.get(Assets.EXPLOSION_ATLAS));

    }

    public void fireWeapon() {
        Bullet b = new Bullet();
        b.setPosition(urhajo.getX() + urhajo.getWidth() / 2 - b.getWidth() / 2, urhajo.getY() + urhajo.getHeight() + 5);
        bullets.add(b);
        addActor(b);
    }

    public void spawnTakony(float startY) {
        Takony t = new Takony();
        t.setPosition(MathUtils.random(50, getViewport().getWorldWidth() - 50 - t.getWidth()), MathUtils.random(startY, startY + getViewport().getWorldHeight()));
        t.setZIndex(15);
        addActor(t);
        takonys.add(t);

    }

    public void killTakony(Takony t, Bullet b) {
        if(isPlaying){
            currKill++;

            Blood blood = new Blood(this);
            blood.setPosition(t.getX() + t.getWidth() / 2 - blood.getWidth(), t.getY() + t.getHeight() / 2 - blood.getHeight());

            getActors().removeValue(t, false);
            getActors().removeValue(b, false);

            takonys.remove(t);
            bullets.remove(b);

            if(currKill >= maxKill) {
                gameVictory();
            }
        }
    }

    public void gameOver() {
        isPlaying = false;

        explosion.setSize(explosion.getWidth() / 2, explosion.getHeight() / 2);
        explosion.setPosition(urhajo.getX() + urhajo.getWidth() / 2 - explosion.getWidth() / 2, urhajo.getY() + urhajo.getHeight() / 2 - explosion.getHeight() / 2);
        explosion.setLooping(false);
        addActor(explosion);

        urhajo.setVisible(false);

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            getActors().removeValue(b, false);
        }

        bullets.clear();

        screen.hud.togOverPanel(true);
    }

    public void gameVictory() {
        isPlaying = false;

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            getActors().removeValue(b, false);
        }

        bullets.clear();

        screen.hud.togVictoryPanel(true);

    }

    public void restartGame() {
        isPlaying = true;

        screen.hud.togOverPanel(false);

        urhajo.setVisible(true);
        currKill = 0;

    }

    int counter = 0;

    @Override
    public void act(float delta) {
        super.act(delta);

        if(isPlaying) {
            counter++;

            urhajo.setY(urhajo.getY() + SCROLL_SPEED);

            getCamera().position.y += SCROLL_SPEED;
            for (int i = 0; i < tubes.size(); i++) {
                if (tubes.get(i).getY() + tubes.get(i).getHeight() < getCamera().position.y - getViewport().getWorldHeight() / 2) {
                    tubes.get(i).setY(lastY + tubes.get(i).getHeight());
                    if (tubes.get(i).getY() > lastY) lastY = tubes.get(i).getY();

                    int randAmount = MathUtils.random(1, 3);
                    for (int j = 0; j < randAmount; j++) spawnTakony(lastY);
                }
            }

            for (int i = 0; i < bullets.size(); i++) {
                Bullet b = bullets.get(i);

                if (b.getY() > getCamera().position.y + getViewport().getWorldHeight() * 2) {
                    getActors().removeValue(b, false);
                    bullets.remove(b);
                    i--;
                    if (i < 0) i = 0;
                }

                for(int j = 0; j < takonys.size(); j++) {
                    Takony t = takonys.get(j);

                    if(b.overlaps(t)) {
                        killTakony(t, b);
                    }
                }
            }


            if (counter % 50 == 0 && isTouching) {
                fireWeapon();
            }
        }else {
            if(explosion.getActualFrame() >= explosion.getFrameCount()-1) {
                getActors().removeValue(explosion, false);
            }
        }
    }

    @Override
    public void init() {

    }
}
