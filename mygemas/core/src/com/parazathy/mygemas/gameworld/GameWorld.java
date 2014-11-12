package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.screens.MyScreen;


public abstract class GameWorld {
				
	private MyScreen screen;
	private String loading;	
	
	public GameWorld(MyScreen screen){		
		this.screen = screen;
		this.loading = screen.getGame().getLanguagesManager().getString("Loading...");		
	}
	
	public abstract void update(float delta);
		
	public MyScreen getScreen() {
		return screen;
	}

	public String getLoading() {
		return loading;
	}	

	
		
}
