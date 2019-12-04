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
		super.create();
		Assets.prepare();
		setScreen(new LoadingScreen(this));


		save = Gdx.app.getPreferences("gameSave");
		save.clear();

		//save.contins("key") <- létre van-e hozva?
		//save.putString("key", "value") <- string érték mentése
		//save.getString("key") <- string érték lekérése
		//save.remove("key") <- adat mentésekből törlése


		/*if(save.contains("teszt")) {
			System.out.println(save.getString("teszt"));
		}else {
			System.out.println("Üres, berak");
			save.putString("teszt", "Szeretem az őszt");
		}*/
		//save.remove("inditas");

		if(save.contains("inditas")){
			save.putFloat("inditas",(save.getFloat("inditas")+1));
		}else{
			save.putFloat("inditas",1);
			//nagy változók
			save.putFloat("penz_mennyiseg",10500.0f);
			save.putFloat("aram%",1.0f);
			save.putFloat("penz%",1.0f);
			save.putFloat("aramveszteseg%",0.5f);
			//elemek élete
			save.putFloat("generator_hp",100.0f);
			save.putFloat("lapat_hp",100.0f);
			save.putFloat("gatfal_hp",100.0f);
			save.putFloat("munkasok_hp",100.0f);
			save.putFloat("csovek_hp",100.0f);
			//elemek FŐ szintje
			save.putFloat("generator_lvl",0);
			save.putFloat("lapat_lvl",0);
			save.putFloat("gatfal_lvl",0);
			save.putFloat("munkasok_lvl",0);
			save.putFloat("csovek_lvl",0);
			//generátor fejlesztései
			save.putFloat("aram_termeles",0);
			save.putFloat("aram_to_penz",0);
			save.putFloat("attetelek",0);
			save.putFloat("turokepesseg_generator",0.0f);
			//lapát fejlesztések
			save.putFloat("forgasi_sebesseg",0);
			save.putFloat("fogaskerekek",0);
			save.putFloat("lapatok_merete",0);
			save.putFloat("kerek_merete",0);
			save.putFloat("turokepesseg_lapat",0.0f);
			//gátfal fejlesztések
			save.putFloat("magassag",0);
			save.putFloat("vastagsag",0);
			save.putFloat("turokepesseg_gatfal",0.0f);
			//munkások fejlesztések
			save.putFloat("munkaero",0);
			save.putFloat("szorgalom",0);
			save.putFloat("odafigyeles",0);
			save.putFloat("adocsalas",0);
			save.putFloat("turokepesseg_munkasok",0.0f);
			//csövek fejlesztese
			save.putFloat("csovek_szelessege",0);
			save.putFloat("csohalozat_elrendezese",0);
			save.putFloat("turokepesseg_csovek",0.0f);

			//apróságok
			save.putFloat("click_count",0);
			save.putFloat("eltelt_ido",0);
			save.putFloat("minigamek",0);
		}
		save.flush();
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
		style.fontColor = Color.BLACK;
		return style;
	}
}
