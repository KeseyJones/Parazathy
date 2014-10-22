package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.helpers.LanguagesManager;




public abstract class GameWorld {
		
	private LanguagesManager _lang;
	
	private GameRenderer renderer;
	
	public GameWorld(){
		_lang = LanguagesManager.getInstance();
	}
	
	public abstract void update(float delta);
	
	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}
	
	public GameRenderer getRenderer() {
		return renderer;
	}

	public LanguagesManager get_lang() {
		return _lang;
	}	

	
	
}
