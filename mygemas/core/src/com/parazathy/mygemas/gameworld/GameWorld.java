package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.MyGemas;


public abstract class GameWorld {
			
	private GameRenderer renderer;	
	private MyGemas game;
	
	public GameWorld(MyGemas game){		
		this.game = game;
	}
	
	public abstract void update(float delta);
	
	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}
				
	public GameRenderer getRenderer() {
		return renderer;
	}	

	public MyGemas getGame() {
		return game;
	}	

		
}
