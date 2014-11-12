package com.parazathy.mygemas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.DefaultResolver;
import com.parazathy.mygemas.helpers.LanguagesManager;
import com.parazathy.mygemas.helpers.PlatformResolver;
import com.parazathy.mygemas.screens.GameMenu;
import com.parazathy.mygemas.screens.MyScreen;

public class MyGemas extends Game {
	
	public enum Platform {Desktop, Android, Web, IOS};
	public enum Screens {Menu, HowTo, Game, Exit};
		
	private Logger logger;
	private LanguagesManager languagesManager;	
	private PlatformResolver resolver;
	private Platform platform;
	
	private MyScreen currentScreen;
	
	
	public MyGemas(Platform plat){
		super();
		this.platform = plat;
	}
	
	@Override
    public void create() {
		
		// Logger
		logger = new Logger("MyGemas");
		
		//Activamos el boton back para android
		if(platform == Platform.Android){
			Gdx.input.setCatchBackKey(true);
		}
							
		resolver = new DefaultResolver();		
		languagesManager = new LanguagesManager();		
		languagesManager.setLanguage(resolver.getDefaultLanguage());
		
		//Iniciamos la carga de recursos
		AssetLoader.initialize(resolver);
		
		//Cargamos la fuente de loading que el unico que necesito
		AssetLoader.loadLoadingFont();
		
		currentScreen = new GameMenu(this);
		setScreen(currentScreen);
		
        logger.info("MyGemas created!!!");    
    }
	
	public void changeScreen(MyScreen newScreen) {		
		
		//Eliminamos la Screen
		currentScreen.dispose();
		
		currentScreen = newScreen;
		
		//POnemos la nueva
		setScreen (newScreen);
		
	}
	
	public void exit() {		
				
		Gdx.app.exit();
		
	}
		
    public Logger getLogger() {
		return logger;
	}

	public LanguagesManager getLanguagesManager() {
		return languagesManager;
	}

	public PlatformResolver getResolver() {
		return resolver;
	}

	@Override
    public void dispose() {
    	
        super.dispose();  
        currentScreen.dispose();
        AssetLoader.dispose();
    }
        

}
