package com.parazathy.mygemas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.Logger;
import com.parazathy.mygemashelpers.LanguagesManager;
import com.parazathy.mygemashelpers.PlatformResolver;

public class MyGemas extends Game {
	
	private Logger _logger = null;
	
	// Language manager
	private LanguagesManager _languagesManager = null;
	
	private PlatformResolver _resolver = null;
	
	@Override
    public void create() {
		// Logger
		_logger = new Logger("MyGemas");
		
		_languagesManager = _languagesManager.getInstance(_resolver != null ? _resolver.getDefaultLanguage() : null);
		
        _logger.info("MyGemas created!!!");    
    }

    @Override
    public void dispose() {
        super.dispose();        
    }

	public PlatformResolver get_resolver() {
		return _resolver;
	}

	public void set_resolver(PlatformResolver _resolver) {
		this._resolver = _resolver;
	}
    
        

}
