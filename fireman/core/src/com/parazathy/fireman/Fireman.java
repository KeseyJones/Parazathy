package com.parazathy.fireman;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.I18NBundle;
import com.parazatghy.fireman.helper.AssetLoader;
import com.parazathy.fireman.screen.CommonScreen;
import com.parazathy.fireman.screen.MenuScreen;

public class Fireman extends Game {
	private static Fireman instance;
	private static CommonScreen currentScreen;
	private static I18NBundle language;
	
	private Fireman(){
		super();
	}
	
	public static Fireman getInstance() {
		if(instance == null) {
			instance = new Fireman();
		}
		return instance;
	}	
		
	
	@Override
	public void create () {
		
		//Cargamos los idiomas
		FileHandle baseFileHandle = Gdx.files.internal("i18n/Fireman");
		this.language = I18NBundle.createBundle(baseFileHandle);
		
		//Activamos botones en caso de que sea Android
		if(Gdx.app.getType() == ApplicationType.Android){
			Gdx.input.setCatchBackKey(true);
			Gdx.input.setCatchMenuKey(true);
		}
		
		//Arrancamos el AssetLoader
		AssetLoader.initialize();
		
		//Ponemos la pantall
		changeScreen(new MenuScreen());
		
	}

	@Override
	public void render () {
		
	}
	
	@Override
    public void dispose() {
        super.dispose();     
        AssetLoader.dispose();
        currentScreen.dispose();
        
    }
	
	public void changeScreen(CommonScreen newScreen) {		
		
		//Eliminamos la Screen
		if(currentScreen != null){
			currentScreen.dispose();
		}
		
		currentScreen = newScreen;
		
		//Ponemos la nueva
		setScreen (newScreen);
		
	}
	
	public static void exit() {		
		
		Gdx.app.exit();
		
	}

	public static I18NBundle getLanguage() {
		return language;
	}
	
	
}
