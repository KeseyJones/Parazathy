package com.parazathy.mygemashelpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.siondream.freegemas.Freegemas;

public class AssetLoader {
	
	private AssetManager _assetManager = null;
	
	public AssetLoader () {
		
		// Create assets manager
		_assetManager = new AssetManager();
		
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
		
		
		// Load fonts
		_fontMenu = Freegemas.getPlatformResolver().loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
		
		// Sound
		_assetManager.load("data/select.ogg", Sound.class);
	}
	
	
	public void unloadMenuAssets() {
		// Set references to null
		_imgBackground = null;
		_imgLogo = null;
		_imgHighlight = null;
		_fontMenu = null;
		_selectSFX = null;
		
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
		
		_gems = nu

}
