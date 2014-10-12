package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.helpers.LanguagesManager;




public abstract class GameWorld {
		
	protected LanguagesManager _lang;
	
	public GameWorld(){
		_lang = LanguagesManager.getInstance();
	}
	
	public abstract void update(float delta);
	

}
