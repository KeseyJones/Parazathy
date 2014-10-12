package com.parazathy.mygemas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Logger;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.LanguagesManager;
import com.parazathy.mygemas.helpers.PlatformResolver;
import com.parazathy.mygemas.screens.GameMenu;

public class MyGemas extends Game {
	
	private Logger _logger = null;
	
	// Language manager
	private LanguagesManager _languagesManager = null;
	
	private PlatformResolver _resolver = null;
	
	public static final int VIRTUAL_WIDTH = 1280;
	public static final int VIRTUAL_HEIGHT = 720;
	
	
	@Override
    public void create() {
		// Logger
		_logger = new Logger("MyGemas");
		
		//Ponemos el lenguaje por defecto
		_languagesManager = _languagesManager.getInstance();
		
		if(_resolver != null) 
			_languagesManager.setLanguage(_resolver.getDefaultLanguage());
		
		//Iniciamos la carga de recursos
		AssetLoader.initialize();
		
		setScreen(new GameMenu(_resolver, VIRTUAL_HEIGHT, VIRTUAL_WIDTH));
		
        _logger.info("MyGemas created!!!");    
    }
	
	public void changeScreen(Screen oldScreen, Screen newScreen) {
		
	}
	

    @Override
    public void dispose() {
        super.dispose();   
        AssetLoader.dispose();
    }
	

	public void set_resolver(PlatformResolver _resolver) {
		this._resolver = _resolver;
	}
    
        

}
