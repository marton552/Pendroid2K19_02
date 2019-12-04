package com.pendurpandurok.sziporka.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pendurpandurok.sziporka.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		System.setProperty("user.name", "Public");

		config.width = 480;
		config.height = 950;
		config.resizable = true;

		new LwjglApplication(new MyGdxGame(), config);
	}
}
