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

import java.util.ArrayList;
import java.util.List;

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
			save.putFloat("penz_mennyiseg",50.0f);
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
			save.putFloat("allatok",0);
			save.putFloat("eltelt_ido",0);
			save.putFloat("minigamek",0);
			save.putFloat("goblinok",0);
			save.putFloat("szerzett_penz",0);
			save.putFloat("fejlesztesek_szama",0);

			//skillek
			save.putFloat("skill_1",0);
			save.putFloat("skill_2",0);
			save.putFloat("skill_3",0);
			save.putFloat("skill_4",0);
			save.putFloat("skill_5",0);
			save.putFloat("skill_6",0);
			save.putFloat("skillpontok",3);
			save.putString("kordinata","");

			//acihvmentek
			save.putFloat("inditas_0",0);
			save.putFloat("allatok_0",0);
			save.putFloat("eltelt_ido_0",0);
			save.putFloat("minigamek_0",0);
			save.putFloat("goblinok_0",0);
			save.putFloat("szerzett_penz_0",0);
			save.putFloat("fejlesztesek_szama_0",0);

			//mentett aram stb
			save.putFloat("aram_volt",0);
			save.putFloat("penz_volt",0);
			save.putFloat("veszt_volt",0);

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
		save.flush();
		super.pause();
	}

	@Override
	public void dispose () {
		save.flush();
		super.dispose();
		Assets.unload();
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


	public static float keparanySzelesvaszonra()
	{
		float keparany = (Gdx.graphics.getHeight()/1.0f) / Gdx.graphics.getWidth();//a portré mód miatt csak megkellett cserélnem a kettőt
		int egyArany = 80;//egy arányra eső szélesség 720-as magasságnál ((720/9)*x)
		int x = 1;//szélességi arány
		while (keparany > (x/9.0f)) x++;

		if((int)keparany*(x*egyArany) != Gdx.graphics.getWidth()) return (720.0f/Gdx.graphics.getWidth() * Gdx.graphics.getHeight());
		//Ha nem pontos a képarány számítása, akkor a világ magassága legyen a telefon kijelzőjének magassága 720 pixelhez viszonyítva

		return x * egyArany;
	}
}
