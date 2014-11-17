package com.parazathy.mygemas.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.parazathy.mygemas.MyGemas;

public class DesktopLauncher {
	public static void main (String[] arg) {
						
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "My Gemas";		
		config.width = 1280;
		config.height = 720;
		
		new LwjglApplication(MyGemas.getInstance(), config);
	}
}
