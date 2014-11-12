package com.parazathy.myzombiebird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.parazathy.myzombiebird.MyZombieBird;
import com.parazathy.myzombiebird.myzbhelpers.AdsRequestHandler;

public class DesktopLauncher implements AdsRequestHandler{
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title ="MyZombieBird";
		config.useGL30 = false;
		config.width = 272;
		config.height = 408;
		new LwjglApplication(new MyZombieBird(this), config);
	}

	@Override
	public void showAds(boolean show) {
		// TODO Auto-generated method stub
		
	}
}
