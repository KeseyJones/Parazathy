package com.parazathy.mygemas;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.parazathy.mygemas.helpers.AdsRequestHandler;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.DefaultResolver;
import com.parazathy.mygemas.helpers.LanguagesManager;
import com.parazathy.mygemas.helpers.PlatformResolver;
import com.parazathy.mygemas.screens.GameMenu;
import com.parazathy.mygemas.screens.MyScreen;

public class MyGemas extends Game {
		
	public enum Screens {Menu, HowTo, Game, Exit};
	
	private static MyGemas instance;
	private static AdsRequestHandler handler;
			
	private static LanguagesManager languagesManager;	
	private static PlatformResolver resolver;	
	
	private MyScreen currentScreen;
	
	private MyGemas(){
		super();
	}
	
	
	public static MyGemas getInstance() {
		if(instance == null) {
			instance = new MyGemas();
		}
		return instance;
	}	
		

	@Override
    public void create() {
				
		//Activamos el boton back para android
		if(Gdx.app.getType() == ApplicationType.Android){
			Gdx.input.setCatchBackKey(true);
		}
							
		resolver = new DefaultResolver();		
		languagesManager = new LanguagesManager();		
		languagesManager.setLanguage(resolver.getDefaultLanguage());
		
		//Iniciamos la carga de recursos
		AssetLoader.initialize();		
		
		currentScreen = new GameMenu();
		setScreen(currentScreen);
		        
    }
	
	public void changeScreen(MyScreen newScreen) {		
		
		//Eliminamos la Screen
		currentScreen.dispose();
		
		currentScreen = newScreen;
		
		//POnemos la nueva
		setScreen (newScreen);
		
	}
	
	public static void exit() {		
				
		Gdx.app.exit();
		
	}
	
	public static LanguagesManager getLanguagesManager() {
		return languagesManager;
	}   
	
	public static PlatformResolver getResolver() {
		return resolver;
	}
	
	public static AdsRequestHandler getHandler() {
		return handler;
	}
	
	public static void setHandler(AdsRequestHandler handler) {
		MyGemas.handler = handler;
	}

	@Override
    public void dispose() {
        super.dispose();          
        currentScreen.dispose();
        AssetLoader.dispose();
    }
        

}
