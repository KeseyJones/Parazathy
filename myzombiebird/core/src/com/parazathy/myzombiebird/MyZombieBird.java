package com.parazathy.myzombiebird;

import com.badlogic.gdx.Game;
import com.parazathy.myzombiebird.myzbhelpers.AdsRequestHandler;
import com.parazathy.myzombiebird.myzbhelpers.AssetLoader;
import com.parazathy.myzombiebird.screens.SplashScreen;

public class MyZombieBird extends Game {
	
	private static AdsRequestHandler handler;
	private static MyZombieBird instance;
	
	public static MyZombieBird getInstance() {
		if(instance == null) {
			instance = new MyZombieBird();
		}
		return instance;
	}	
	
	private MyZombieBird(){
		super();		
	}

    @Override
    public void create() {        
        AssetLoader.load();
        setScreen(new SplashScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

	public static AdsRequestHandler getHandler() {
		return handler;
	}

	public static void setHandler(AdsRequestHandler handler) {
		MyZombieBird.handler = handler;
	}
    
}