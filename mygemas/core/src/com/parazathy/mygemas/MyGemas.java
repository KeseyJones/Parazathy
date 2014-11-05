package com.parazathy.mygemas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Logger;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.DefaultResolver;
import com.parazathy.mygemas.helpers.LanguagesManager;
import com.parazathy.mygemas.helpers.PlatformResolver;
import com.parazathy.mygemas.screens.GameMenu;

public class MyGemas extends Game {
	
	public enum Platform {Desktop, Android, Web};
	public static final int VIRTUAL_WIDTH = 1280;
	public static final int VIRTUAL_HEIGHT = 720;
	
	private Logger logger;
	private LanguagesManager languagesManager;	
	private PlatformResolver resolver;
	private Platform platform;
	
	
	public MyGemas(Platform plat){
		super();
		this.platform = plat;
	}
	
	@Override
    public void create() {
		
		// Logger
		logger = new Logger("MyGemas");
							
		resolver = new DefaultResolver();		
		languagesManager = new LanguagesManager();		
		languagesManager.setLanguage(resolver.getDefaultLanguage());
		
		//Iniciamos la carga de recursos
		AssetLoader.initialize(resolver);
		
		setScreen(new GameMenu(languagesManager, VIRTUAL_HEIGHT, VIRTUAL_WIDTH));
		
        logger.info("MyGemas created!!!");    
    }
	
	public void changeScreen(Screen oldScreen, Screen newScreen) {
		
	}
	

    @Override
    public void dispose() {
    	
        super.dispose();   
        AssetLoader.dispose();
    }
        

}
