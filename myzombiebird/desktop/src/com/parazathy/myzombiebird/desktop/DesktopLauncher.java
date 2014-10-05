package com.parazathy.myzombiebird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.parazathy.myzombiebird.MyZombieBird;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title ="MyZombieBird";
		config.useGL30 = false;
		config.width = 272;
		config.height = 408;
		new LwjglApplication(new MyZombieBird(), config);
	}
}
