package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.screens.MyScreen;


public abstract class GameWorld {
				
	private MyScreen screen;
	
	public GameWorld(MyScreen screen){		
		this.screen = screen;
	}
	
	public abstract void update(float delta);
		
	public MyScreen getScreen() {
		return screen;
	}	

	
		
}
