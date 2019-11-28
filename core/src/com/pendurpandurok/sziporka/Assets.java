//https://github.com/tuskeb/mester
package com.pendurpandurok.sziporka;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

import hu.csanyzeg.master.Demos.DemoGame.AssetsGroupDemoGame;


public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "alegreyaregular.otf";
		fontParameter.fontParameters.size = 50;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}
	public static final AssetDescriptor<BitmapFont> ALEGREYAREGULAR_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


	public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE
			= new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);

	public static final AssetDescriptor<Texture> BTN_BACK = new AssetDescriptor<Texture>("ui_textures/btn_back.png", Texture.class);
	public static final AssetDescriptor<Texture> BTN_HOVER = new AssetDescriptor<Texture>("ui_textures/btn_hover.png", Texture.class);
	public static final AssetDescriptor<Texture> BACKGROUND = new AssetDescriptor<Texture>("hatter.png", Texture.class);
	public static final AssetDescriptor<Texture> GAT1 = new AssetDescriptor<Texture>("gat1.png", Texture.class);
	public static final AssetDescriptor<Texture> GAT2 = new AssetDescriptor<Texture>("gat2.png", Texture.class);
	public static final AssetDescriptor<Texture> GAT3 = new AssetDescriptor<Texture>("gat3.png", Texture.class);
	public static final AssetDescriptor<Texture> IF = new AssetDescriptor<Texture>("guihoz.png", Texture.class);
	public static final AssetDescriptor<Texture> HP_BAR = new AssetDescriptor<Texture>("hp_bar.png", Texture.class);
	public static final AssetDescriptor<Texture> LVL_BAR = new AssetDescriptor<Texture>("lvl_bar.png", Texture.class);

    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(BADLOGIC_TEXTURE);
		manager.load(BTN_BACK);
		manager.load(BTN_HOVER);
		manager.load(BACKGROUND);
		manager.load(GAT1);
		manager.load(GAT2);
		manager.load(GAT3);
		manager.load(IF);
		manager.load(HP_BAR);
		manager.load(LVL_BAR);

		manager.load(ALEGREYAREGULAR_FONT);
	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
