package com.parazathy.myzombiebird;

import com.badlogic.gdx.Game;
import com.parazathy.myzombiebird.myzbhelpers.AdsRequestHandler;
import com.parazathy.myzombiebird.myzbhelpers.AssetLoader;
import com.parazathy.myzombiebird.screens.SplashScreen;

public class MyZombieBird extends Game {
	
	private AdsRequestHandler handler;
	
	public MyZombieBird(AdsRequestHandler handler){
		super();
		this.handler = handler;
	}

    @Override
    public void create() {        
        AssetLoader.load();
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

	public AdsRequestHandler getHandler() {
		return handler;
	}
    
}