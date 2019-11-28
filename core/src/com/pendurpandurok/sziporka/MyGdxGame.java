package com.pendurpandurok.sziporka;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {

	public Preferences save;

	@Override
	public void create () {
		Assets.prepare();
		setScreen(new LoadingScreen(this));


		save = Gdx.app.getPreferences("gameSave");

		//save.contins("key") <- létre van-e hozva?
		//save.putString("key", "value") <- string érték mentése
		//save.getString("key") <- string érték lekérése
		//save.remove("key") <- adat mentésekből törlése

		/*
		if(save.contains("teszt")) {
			System.out.println(save.getString("teszt"));
		}else {
			System.out.println("Üres, berak");
			save.putString("teszt", "Szeretem az őszt");
		}*/

	}

	@Override
	public void resume() {
		super.resume();
		Assets.manager.update();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void dispose () {
		super.dispose();
		Assets.unload();
		save.flush();
	}

	public TextButton.TextButtonStyle getButtonStyle(){
		TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
		buttonStyle.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);
		buttonStyle.fontColor = new Color(1, 1, 1, 1);
		buttonStyle.overFontColor = new Color(0, 0, 0, 1);
		buttonStyle.downFontColor = new Color(0, 0, 0, 1);

		buttonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_BACK)));
		buttonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_HOVER)));
		buttonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_HOVER)));

		return buttonStyle;
	}

	public Label.LabelStyle getLabelStyle() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);
		style.fontColor = Color.WHITE;
		return style;
	}
}
