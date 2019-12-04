package com.pendurpandurok.sziporka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.pendurpandurok.sziporka.Screens.Menu.MenuScreen;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;


public class LoadingScreen extends MyScreen {

	MyGdxGame mygame;
    public LoadingScreen(MyGdxGame game) {
		super(game);
		mygame = game;
    }
	BitmapFont bitmapFont = new BitmapFont();

    @Override
	public void show() {
	    Assets.manager.finishLoading();
		Assets.load();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		mygame.getSpriteBatch().begin();
		bitmapFont.draw(mygame.getSpriteBatch(),"Betöltés: " + Assets.manager.getLoadedAssets() + "/" + (Assets.manager.getQueuedAssets()+ Assets.manager.getLoadedAssets()) + " (" + ((int)(Assets.manager.getProgress()*100f)) + "%)", Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
		mygame.getSpriteBatch().end();
		if (Assets.manager.update()) {
			Assets.afterLoaded();
			game.setScreen(new MenuScreen(mygame));
		}
	}

	@Override
	public void hide() {

	}

	@Override
	public void init() {
		setBackGroundColor(0f, 0f, 0f);
	}
}
