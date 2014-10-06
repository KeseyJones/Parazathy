package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
	
	private static AssetLoader _instance = null;
	private AssetManager _assetManager = null;
	
	public AssetLoader () {
		
		// Create assets manager
		_assetManager = new AssetManager();
		
	}
	
	public static AssetLoader getInstance() {
		if (_instance == null) {
			_instance = new AssetLoader();
		}
		
		return _instance;
	}
	
	public void loadCommonAssets(){
		_assetManager.load("data/handCursor.png", Texture.class);
		_assetManager.finishLoading();
	}
	
	public void loadMenuAssets() {		
		
		// Load textures
		_assetManager.load("data/mainMenuBackground.png", Texture.class);
		_assetManager.load("data/mainMenuLogo.png", Texture.class);
		_assetManager.load("data/menuHighlight.png", Texture.class);
		_assetManager.load("data/gemWhite.png", Texture.class);
		_assetManager.load("data/gemRed.png", Texture.class);
		_assetManager.load("data/gemPurple.png", Texture.class);
		_assetManager.load("data/gemOrange.png", Texture.class);
		_assetManager.load("data/gemGreen.png", Texture.class);
		_assetManager.load("data/gemYellow.png", Texture.class);
		_assetManager.load("data/gemBlue.png", Texture.class);		
		
		// Sound
		_assetManager.load("data/select.ogg", Sound.class);
		_assetManager.finishLoading();
	}
	
	
	
	
	public void unloadMenuAssets() {		
		
		// Unload resources		
		_assetManager.unload("data/mainMenuBackground.png");
		_assetManager.unload("data/mainMenuLogo.png");
		_assetManager.unload("data/menuHighlight.png");
		_assetManager.unload("data/gemWhite.png");
		_assetManager.unload("data/gemRed.png");
		_assetManager.unload("data/gemPurple.png");
		_assetManager.unload("data/gemOrange.png");
		_assetManager.unload("data/gemGreen.png");
		_assetManager.unload("data/gemYellow.png");
		_assetManager.unload("data/gemBlue.png");
		_assetManager.unload("data/select.ogg");
		
	}

	public AssetManager get_assetManager() {
		return _assetManager;
	}
	
	
}
