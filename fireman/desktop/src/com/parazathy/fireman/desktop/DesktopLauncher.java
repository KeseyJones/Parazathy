package com.parazathy.fireman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.parazathy.fireman.Fireman;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Fireman";		
		config.width = 272;
		config.height = 408;
		
		new LwjglApplication(Fireman.getInstance(), config);
	}
}
