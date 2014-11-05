package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.helpers.LanguagesManager;




public abstract class GameWorld {
		
	private LanguagesManager languagesManager;	
	private GameRenderer renderer;	
	private MyGemas game;
	
	public GameWorld(MyGemas game, LanguagesManager languagesManager){
		this.languagesManager = languagesManager;	
		this.game = game;
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

	public MyGemas getGame() {
		return game;
	}	

		
}
