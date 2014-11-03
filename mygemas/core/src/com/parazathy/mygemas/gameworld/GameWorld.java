package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.helpers.LanguagesManager;
import com.parazathy.mygemas.helpers.PlatformResolver;




public abstract class GameWorld {
		
	private LanguagesManager _lang;
	
	private GameRenderer renderer;
	private PlatformResolver _resolver;
	
	public GameWorld(){
		_lang = LanguagesManager.getInstance();
	}
	
	public abstract void update(float delta);
	
	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}
		
	public void set_resolver(PlatformResolver _resolver) {
		this._resolver = _resolver;
	}
	
	public PlatformResolver get_resolver() {
		return _resolver;
	}

	public GameRenderer getRenderer() {
		return renderer;
	}

	public LanguagesManager get_lang() {
		return _lang;
	}	

	
	
}
