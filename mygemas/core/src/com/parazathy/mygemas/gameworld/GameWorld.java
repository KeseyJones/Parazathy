package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.helpers.LanguagesManager;




public abstract class GameWorld {
		
	private LanguagesManager languagesManager;	
	private GameRenderer renderer;	
	
	public GameWorld(LanguagesManager languagesManager){
		this.languagesManager = languagesManager;		
	}
	
	public abstract void update(float delta);
	
	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}
				
	public GameRenderer getRenderer() {
		return renderer;
	}

	public LanguagesManager getLanguagesManager() {
		return languagesManager;
	}	

	
	
}
