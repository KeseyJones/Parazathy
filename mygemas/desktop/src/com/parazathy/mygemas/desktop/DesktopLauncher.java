package com.parazathy.mygemas.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.parazathy.mygemas.MyGemas;

public class DesktopLauncher {
	public static void main (String[] arg) {
		MyGemas game = new MyGemas();
		game.set_resolver(new DesktopResolver());
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "My Gemas";
		config.useGL30 = true;
		config.width = 1280;
		config.height = 720;
		
		new LwjglApplication(new MyGemas(), config);
	}
}
