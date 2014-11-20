package com.parazathy.mygemas.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.helpers.AdsRequestHandler;

public class DesktopLauncher implements AdsRequestHandler{
	
	private static DesktopLauncher application;
	
	public static void main (String[] arg) {
		
		if(application == null){
			application = new DesktopLauncher();
		}
	
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "My Gemas";		
		config.width = 1280;
		config.height = 720;
		
		MyGemas.setHandler(application);
		new LwjglApplication(MyGemas.getInstance(), config);
	}

	@Override
	public void showAds(boolean show) {
		// TODO Auto-generated method stub
		
	}
}
