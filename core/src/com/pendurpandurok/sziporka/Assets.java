//https://github.com/tuskeb/mester
package com.pendurpandurok.sziporka;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;



public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "Adventure ReQuest.otf";
		fontParameter.fontParameters.size = 50;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}
	public static final AssetDescriptor<BitmapFont> ALEGREYAREGULAR_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


	public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE
			= new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);

	public static final AssetDescriptor<Texture> FULLWHITE = new AssetDescriptor<Texture>("ui_textures/thisiswhite.png", Texture.class);
	public static final AssetDescriptor<Texture> GRAY = new AssetDescriptor<Texture>("ui_textures/gray.png", Texture.class);
	public static final AssetDescriptor<Texture> BLACK = new AssetDescriptor<Texture>("ui_textures/black.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_BACK = new AssetDescriptor<Texture>("ui_textures/btn_back.png", Texture.class);
	public static final AssetDescriptor<Texture> BTN_HOVER = new AssetDescriptor<Texture>("ui_textures/btn_hover.png", Texture.class);
	public static final AssetDescriptor<Texture> BACKGROUND = new AssetDescriptor<Texture>("hatter.png", Texture.class);
	public static final AssetDescriptor<Texture> GAT1 = new AssetDescriptor<Texture>("gat1.png", Texture.class);
	public static final AssetDescriptor<Texture> GAT2 = new AssetDescriptor<Texture>("gat2.png", Texture.class);
	public static final AssetDescriptor<Texture> GAT3 = new AssetDescriptor<Texture>("gat3.png", Texture.class);
	public static final AssetDescriptor<Texture> FAL1 = new AssetDescriptor<Texture>("fal1.png", Texture.class);
	public static final AssetDescriptor<Texture> FAL2 = new AssetDescriptor<Texture>("fal2.png", Texture.class);
	public static final AssetDescriptor<Texture> FAL3 = new AssetDescriptor<Texture>("fal3.png", Texture.class);
	public static final AssetDescriptor<Texture> IF = new AssetDescriptor<Texture>("guihoz.png", Texture.class);
    public static final AssetDescriptor<Texture> IF_BACK = new AssetDescriptor<Texture>("guibackground.png", Texture.class);
	public static final AssetDescriptor<Texture> HP_BAR = new AssetDescriptor<Texture>("hp_bar.png", Texture.class);
	public static final AssetDescriptor<Texture> LVL_BAR = new AssetDescriptor<Texture>("lvl_bar.png", Texture.class);
	public static final AssetDescriptor<Texture> GENERATOR1 = new AssetDescriptor<Texture>("generator1.png", Texture.class);
    public static final AssetDescriptor<Texture> GENERATOR2 = new AssetDescriptor<Texture>("generator2.png", Texture.class);
    public static final AssetDescriptor<Texture> GENERATOR3 = new AssetDescriptor<Texture>("generator3.png", Texture.class);
	public static final AssetDescriptor<Texture> LAPAT1 = new AssetDescriptor<Texture>("lapat1.png", Texture.class);
	public static final AssetDescriptor<Texture> LAPAT2 = new AssetDescriptor<Texture>("lapat2.png", Texture.class);
	public static final AssetDescriptor<Texture> LAPAT3 = new AssetDescriptor<Texture>("lapat3.png", Texture.class);
	public static final AssetDescriptor<Texture> MUNKASOK1 = new AssetDescriptor<Texture>("hod1.png", Texture.class);
	public static final AssetDescriptor<Texture> MUNKASOK2 = new AssetDescriptor<Texture>("hod2.png", Texture.class);
	public static final AssetDescriptor<Texture> MUNKASOK3 = new AssetDescriptor<Texture>("hod3.png", Texture.class);
	public static final AssetDescriptor<Texture> CSOVEK1 = new AssetDescriptor<Texture>("csovek1.png", Texture.class);
	public static final AssetDescriptor<Texture> CSOVEK2 = new AssetDescriptor<Texture>("csovek2.png", Texture.class);
	public static final AssetDescriptor<Texture> CSOVEK3 = new AssetDescriptor<Texture>("csovek3.png", Texture.class);

	public static final AssetDescriptor<Texture> PENZ = new AssetDescriptor<Texture>("coin.png", Texture.class);
	public static final AssetDescriptor<Texture> PENZ_PER = new AssetDescriptor<Texture>("coinper.png", Texture.class);
	public static final AssetDescriptor<Texture> ARAM = new AssetDescriptor<Texture>("villam.png", Texture.class);
	public static final AssetDescriptor<Texture> VESZT = new AssetDescriptor<Texture>("villam_nincs.png", Texture.class);
	public static final AssetDescriptor<Texture> SHIELD = new AssetDescriptor<Texture>("shield.png", Texture.class);
	public static final AssetDescriptor<Texture> NEW = new AssetDescriptor<Texture>("new.png", Texture.class);

	public static final AssetDescriptor<Texture> LIGHT = new AssetDescriptor<Texture>("light.png", Texture.class);
	public static final AssetDescriptor<Texture> SZALAG1 = new AssetDescriptor<Texture>("szalag1.png", Texture.class);
	public static final AssetDescriptor<Texture> SZALAG2 = new AssetDescriptor<Texture>("szalag2.png", Texture.class);
	public static final AssetDescriptor<Texture> SZALAG3 = new AssetDescriptor<Texture>("szalag3.png", Texture.class);
	public static final AssetDescriptor<Texture> SZALAG4 = new AssetDescriptor<Texture>("szalag4.png", Texture.class);
	public static final AssetDescriptor<Texture> SZALAG5 = new AssetDescriptor<Texture>("szalag5.png", Texture.class);
	public static final AssetDescriptor<Texture> SZALAG6 = new AssetDescriptor<Texture>("szalag6.png", Texture.class);

	public static final AssetDescriptor<Texture> UPGRD = new AssetDescriptor<Texture>("upgrade.png", Texture.class);
	public static final AssetDescriptor<Texture> CLICKABLE = new AssetDescriptor<Texture>("upgrade_front.png", Texture.class);

	public static final AssetDescriptor<Texture> HAPPY = new AssetDescriptor<Texture>("happy.png", Texture.class);
	public static final AssetDescriptor<Texture> SAD = new AssetDescriptor<Texture>("sad.png", Texture.class);
	public static final AssetDescriptor<Texture> SKILL = new AssetDescriptor<Texture>("skill_points.png", Texture.class);
	public static final AssetDescriptor<Texture> PSL = new AssetDescriptor<Texture>("skill.png", Texture.class);
	public static final AssetDescriptor<Texture> SKILL_TREE = new AssetDescriptor<Texture>("skilltree.png", Texture.class);

	public static final AssetDescriptor<Texture> BAR_B = new AssetDescriptor<Texture>("bar_back.png", Texture.class);
	public static final AssetDescriptor<Texture> BAR_F = new AssetDescriptor<Texture>("bar_front.png", Texture.class);

	public static final AssetDescriptor<Texture> HAS_F = new AssetDescriptor<Texture>("hodhasf.png", Texture.class);
	public static final AssetDescriptor<Texture> HAS_L = new AssetDescriptor<Texture>("hodhasl.png", Texture.class);
	public static final AssetDescriptor<Sound> LAUGH_1 = new AssetDescriptor<Sound>("sfx/laugh/1.wav", Sound.class);
	public static final AssetDescriptor<Sound> LAUGH_2 = new AssetDescriptor<Sound>("sfx/laugh/2.wav", Sound.class);
	public static final AssetDescriptor<Sound> LAUGH_3 = new AssetDescriptor<Sound>("sfx/laugh/3.wav", Sound.class);

	public static final AssetDescriptor<Texture> GOBLIN_1 = new AssetDescriptor<Texture>("goblin.png", Texture.class);
	public static final AssetDescriptor<Texture> GOBLIN_2 = new AssetDescriptor<Texture>("goblin2.png", Texture.class);
	public static final AssetDescriptor<Texture> GOBLIN_3 = new AssetDescriptor<Texture>("goblin3.png", Texture.class);
	public static final AssetDescriptor<TextureAtlas> BLOOD_ATLAS = new AssetDescriptor<TextureAtlas>("atlas/blood.atlas", TextureAtlas.class);


	public static final AssetDescriptor<Texture> CSO = new AssetDescriptor<Texture>("cso.png", Texture.class);
	public static final AssetDescriptor<Texture> AMMO = new AssetDescriptor<Texture>("lovedek.png", Texture.class);
	public static final AssetDescriptor<Texture> URHAJO = new AssetDescriptor<Texture>("urhajo.png", Texture.class);
	public static final AssetDescriptor<Texture> TAKONY = new AssetDescriptor<Texture>("takony.png", Texture.class);
    public static final AssetDescriptor<Texture> CSOMBA = new AssetDescriptor<Texture>("csomba.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> EXPLOSION_ATLAS = new AssetDescriptor<TextureAtlas>("atlas/explosion.atlas", TextureAtlas.class);

	public static final AssetDescriptor<Texture> HATLAP = new AssetDescriptor<Texture>("kartyalap.png", Texture.class);
	public static final AssetDescriptor<Texture> KARTYA1 = new AssetDescriptor<Texture>("kartya_1.png", Texture.class);
	public static final AssetDescriptor<Texture> ROSSZKARTYA = new AssetDescriptor<Texture>("kartya_2.png", Texture.class);
	public static final AssetDescriptor<Texture> KARTYA2 = new AssetDescriptor<Texture>("kartya_3.png", Texture.class);
	public static final AssetDescriptor<Texture> KARTYA3 = new AssetDescriptor<Texture>("kartya_4.png", Texture.class);
	public static final AssetDescriptor<Texture> KARTYA4 = new AssetDescriptor<Texture>("kartya_5.png", Texture.class);
	public static final AssetDescriptor<Texture> KARTYA5 = new AssetDescriptor<Texture>("kartya_6.png", Texture.class);

	public static final AssetDescriptor<Texture> ALVANY = new AssetDescriptor<Texture>("ragaszto.png", Texture.class);
	public static final AssetDescriptor<Texture> PLAYER = new AssetDescriptor<Texture>("player.png", Texture.class);
	public static final AssetDescriptor<Texture> ENEMY = new AssetDescriptor<Texture>("enemy.png", Texture.class);
	public static final AssetDescriptor<Texture> CSUSZKA_BG = new AssetDescriptor<Texture>("tall.png", Texture.class);
	public static final AssetDescriptor<Texture> CSUSZKA = new AssetDescriptor<Texture>("csuszka.png", Texture.class);

	public static final AssetDescriptor<Texture> ERDO = new AssetDescriptor<Texture>("csunyaerdo.png", Texture.class);
	public static final AssetDescriptor<Texture> ASZTAL = new AssetDescriptor<Texture>("asztal.png", Texture.class);

    public static final AssetDescriptor<Texture> GYIK = new AssetDescriptor<Texture>("gyik.png", Texture.class);
	public static final AssetDescriptor<Texture> HAL = new AssetDescriptor<Texture>("halacska.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> MADAR_ATLAS = new AssetDescriptor<TextureAtlas>("atlas/madar_atlas.atlas", TextureAtlas.class);

	public static final AssetDescriptor<Music> MENU_MUSIC = new AssetDescriptor<Music>("sfx/music/1.ogg", Music.class);

	public static final AssetDescriptor<Music> MUSIC_1 = new AssetDescriptor<Music>("sfx/music/2.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_2 = new AssetDescriptor<Music>("sfx/music/3.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_3 = new AssetDescriptor<Music>("sfx/music/4.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_4 = new AssetDescriptor<Music>("sfx/music/5.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_5 = new AssetDescriptor<Music>("sfx/music/6.ogg", Music.class);

	public static final AssetDescriptor<Sound> GOBLIN_SOUND1 = new AssetDescriptor<Sound>("sfx/goblin/goblin_groan1.ogg", Sound.class);
	public static final AssetDescriptor<Sound> GOBLIN_SOUND2 = new AssetDescriptor<Sound>("sfx/goblin/goblin_groan2.ogg", Sound.class);
	public static final AssetDescriptor<Sound> GOBLIN_SOUND3 = new AssetDescriptor<Sound>("sfx/goblin/goblin_groan3.ogg", Sound.class);
	public static final AssetDescriptor<Sound> GOBLIN_DEATH_SOUND = new AssetDescriptor<Sound>("sfx/goblin/goblin_splash.ogg", Sound.class);

	public static final AssetDescriptor<Sound> VICTORY_SOUND = new AssetDescriptor<Sound>("sfx/victory.ogg", Sound.class);
	public static final AssetDescriptor<Sound> LOSE_SOUND = new AssetDescriptor<Sound>("sfx/lose.ogg", Sound.class);


	public static final AssetDescriptor<Sound> TAKONY_SOUND = new AssetDescriptor<Sound>("sfx/slime_jump.ogg", Sound.class);
	public static final AssetDescriptor<Sound> EXPLOSION_SOUND = new AssetDescriptor<Sound>("sfx/explosion.ogg", Sound.class);

	public static final AssetDescriptor<Texture> KEP1 = new AssetDescriptor<Texture>("kep1.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP2 = new AssetDescriptor<Texture>("kep2.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP3 = new AssetDescriptor<Texture>("kep3.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP4 = new AssetDescriptor<Texture>("kep4.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP5 = new AssetDescriptor<Texture>("kep5.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP6 = new AssetDescriptor<Texture>("kep6.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP7 = new AssetDescriptor<Texture>("kep7.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP8 = new AssetDescriptor<Texture>("kep8.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP9 = new AssetDescriptor<Texture>("kep9.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP10 = new AssetDescriptor<Texture>("kep10.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP11 = new AssetDescriptor<Texture>("kep11.png", Texture.class);
	public static final AssetDescriptor<Texture> KEP12 = new AssetDescriptor<Texture>("kep12.png", Texture.class);



	public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(GRAY);
		manager.load(FULLWHITE);
		manager.load(BLACK);
		manager.load(BADLOGIC_TEXTURE);
		manager.load(BTN_BACK);
		manager.load(BTN_HOVER);
		manager.load(BACKGROUND);
		manager.load(GAT1);
		manager.load(GAT2);
		manager.load(GAT3);
		manager.load(FAL1);
		manager.load(FAL2);
		manager.load(FAL3);
		manager.load(IF);
        manager.load(IF_BACK);
		manager.load(HP_BAR);
		manager.load(LVL_BAR);
		manager.load(GENERATOR1);
		manager.load(GENERATOR2);
		manager.load(GENERATOR3);
		manager.load(LAPAT1);
		manager.load(LAPAT2);
		manager.load(LAPAT3);
		manager.load(MUNKASOK1);
		manager.load(MUNKASOK2);
		manager.load(MUNKASOK3);
		manager.load(CSOVEK1);
		manager.load(CSOVEK2);
		manager.load(CSOVEK3);

		manager.load(PENZ_PER);
		manager.load(PENZ);
		manager.load(ARAM);
		manager.load(VESZT);
		manager.load(SHIELD);
		manager.load(NEW);

		manager.load(LIGHT);
		manager.load(SZALAG1);
		manager.load(SZALAG2);
		manager.load(SZALAG3);
		manager.load(SZALAG4);
		manager.load(SZALAG5);
		manager.load(SZALAG6);

		manager.load(UPGRD);
		manager.load(CLICKABLE);

		manager.load(SAD);
		manager.load(HAPPY);
		manager.load(SKILL);
		manager.load(PSL);
		manager.load(SKILL_TREE);

		manager.load(BAR_F);
		manager.load(BAR_B);

		manager.load(HAS_F);
		manager.load(HAS_L);
		manager.load(LAUGH_1);
		manager.load(LAUGH_2);
		manager.load(LAUGH_3);

		manager.load(GOBLIN_1);
		manager.load(GOBLIN_2);
		manager.load(GOBLIN_3);
		manager.load(BLOOD_ATLAS);

		manager.load(CSO);
		manager.load(AMMO);
		manager.load(URHAJO);
		manager.load(TAKONY);
		manager.load(CSOMBA);
		manager.load(EXPLOSION_ATLAS);

		manager.load(HATLAP);
		manager.load(KARTYA1);
		manager.load(KARTYA2);
		manager.load(KARTYA3);
		manager.load(KARTYA4);
		manager.load(KARTYA5);
		manager.load(ROSSZKARTYA);

        manager.load(ALVANY);

		manager.load(PLAYER);
		manager.load(ENEMY);
		manager.load(CSUSZKA_BG);
		manager.load(CSUSZKA);

		manager.load(ERDO);
		manager.load(ASZTAL);

		manager.load(GYIK);
		manager.load(HAL);
		manager.load(MADAR_ATLAS);


		manager.load(MENU_MUSIC);
		manager.load(MUSIC_1);
		manager.load(MUSIC_2);
		manager.load(MUSIC_3);
		manager.load(MUSIC_4);
		manager.load(MUSIC_5);

		manager.load(GOBLIN_SOUND1);
		manager.load(GOBLIN_SOUND2);
		manager.load(GOBLIN_SOUND3);
		manager.load(GOBLIN_DEATH_SOUND);

		manager.load(VICTORY_SOUND);
		manager.load(LOSE_SOUND);

		manager.load(TAKONY_SOUND);
		manager.load(EXPLOSION_SOUND);

		manager.load(KEP1);
		manager.load(KEP2);
		manager.load(KEP3);
		manager.load(KEP4);
		manager.load(KEP5);
		manager.load(KEP6);
		manager.load(KEP7);
		manager.load(KEP8);
		manager.load(KEP9);
		manager.load(KEP10);
		manager.load(KEP11);
		manager.load(KEP12);

		manager.load(ALEGREYAREGULAR_FONT);
	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
