package com.pendurpandurok.sziporka.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pendurpandurok.sziporka.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 720;
		config.height = 1280;

		new LwjglApplication(new MyGdxGame(), config);
	}
}
