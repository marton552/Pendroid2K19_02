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


		/*if(save.contains("teszt")) {
			System.out.println(save.getString("teszt"));
		}else {
			System.out.println("Üres, berak");
			save.putString("teszt", "Szeretem az őszt");
		}*/
		save.remove("inditas");

		if(save.contains("inditas")){
			save.putInteger("inditas",(save.getInteger("inditas")+1));
		}else{
			save.putInteger("inditas",1);
			//nagy változók
			save.putFloat("penz_mennyiseg",0);
			save.putFloat("aram%",1);
			save.putFloat("penz%",1);
			save.putFloat("aramveszteseg%",0.5f);
			//elemek élete
			save.putInteger("generator_hp",100);
			save.putInteger("lapat_hp",100);
			save.putInteger("gatfal_hp",100);
			save.putInteger("munkasok_hp",100);
			save.putInteger("csovek_hp",100);
			//elemek FŐ szintje
			save.putInteger("generator_lvl",0);
			save.putInteger("lapat_lvl",0);
			save.putInteger("gatfal_lvl",0);
			save.putInteger("munkasok_lvl",0);
			save.putInteger("csovek_lvl",0);
			//generátor fejlesztései
			save.putInteger("aram_termeles",0);
			save.putInteger("aram_to_penz",0);
			save.putInteger("attetelek",0);
			save.putInteger("turokepesseg_generator",0);
			//lapát fejlesztések
			save.putInteger("forgasi_sebesseg",0);
			save.putInteger("fogaskerekek",0);
			save.putInteger("lapatok_merete",0);
			save.putInteger("kerek_merete",0);
			save.putInteger("turokepesseg_lapat",0);
			//gátfal fejlesztések
			save.putInteger("magassag",0);
			save.putInteger("vastagsag",0);
			save.putInteger("turokepesseg_gatfal",0);
			//munkások fejlesztések
			save.putInteger("munkaero",0);
			save.putInteger("szorgalom",0);
			save.putInteger("odafigyeles",0);
			save.putInteger("adocsalas",0);
			save.putInteger("turokepesseg_munkasok",0);
			//csövek fejlesztese
			save.putInteger("csovek_szelessege",0);
			save.putInteger("csohalozat_elrendezese",0);
			save.putInteger("turokepesseg_csovek",0);

			//apróságok
			save.putInteger("click_count",0);
			save.putInteger("eltelt_ido",0);
			save.putInteger("minigamek",0);
		}
		System.out.println(save.getInteger("inditas"));
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
