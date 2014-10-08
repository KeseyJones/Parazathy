package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
		
	public static AssetManager _assetManager;
	
	//MENU SCREEN
	public static TextureRegion _imgMouse;
	public static TextureRegion _imgBackgroundMenu;
	public static TextureRegion _imgLogoMenu;
	public static TextureRegion _imgHighlightMenu;
	public static Sound _selectSFXMenu;	
	// Font
	public static BitmapFont _fontMenu;
	public static BitmapFont _fontLoadingMenu;
	
	//GEMS ANIMATION
	private static TextureRegion[] _imgGemsAnimation;	
	
	public static void initialize () {
		
		// Create assets manager
		_assetManager = new AssetManager();
		_assetManager.load("data/handCursor.png", Texture.class);
		_assetManager.finishLoading();
		_imgMouse = new TextureRegion(_assetManager.get("data/handCursor.png", Texture.class));
        _imgMouse.flip(false, true);
		
	}
	
	public static void loadLoadingFont(PlatformResolver _resolver){
		_fontLoadingMenu = _resolver.loadFont("data/loadingFont.fnt", "data/normal.ttf", 70);
	}
			
	
	public static void assignGemsAnimationResources(){
		_imgGemsAnimation = new TextureRegion[7];		
		
		_imgGemsAnimation[0] = new TextureRegion(_assetManager.get("data/gemWhite.png", Texture.class));
		_imgGemsAnimation[1] = new TextureRegion(_assetManager.get("data/gemRed.png", Texture.class));
		_imgGemsAnimation[2] = new TextureRegion(_assetManager.get("data/gemPurple.png", Texture.class));
		_imgGemsAnimation[3] = new TextureRegion(_assetManager.get("data/gemOrange.png", Texture.class));
		_imgGemsAnimation[4] = new TextureRegion(_assetManager.get("data/gemGreen.png", Texture.class));
		_imgGemsAnimation[5] = new TextureRegion(_assetManager.get("data/gemYellow.png", Texture.class));
		_imgGemsAnimation[6] = new TextureRegion(_assetManager.get("data/gemBlue.png", Texture.class));
		
		for (int i = 0; i < 7; ++i) {
			_imgGemsAnimation[i].flip(false, true);
		}
	}

	public static void loadMenuAssets(PlatformResolver _resolver) {		
		
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
		_fontMenu =_resolver.loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
				
		// Sound
		_assetManager.load("data/select.ogg", Sound.class);
		
		
		
	}
	
	public static void AssignMenuResources(){
		
		_imgBackgroundMenu = new TextureRegion(_assetManager.get("data/mainMenuBackground.png", Texture.class));
		_imgLogoMenu = new TextureRegion(_assetManager.get("data/mainMenuLogo.png", Texture.class));
		_imgHighlightMenu = new TextureRegion(_assetManager.get("data/menuHighlight.png", Texture.class));
		
		_imgBackgroundMenu.flip(false, true);
		_imgLogoMenu.flip(false, true);
		_imgHighlightMenu.flip(false, true);
		
		_selectSFXMenu = _assetManager.get("data/select.ogg", Sound.class);
		
	}
	
	
	
	public static void unloadMenuAssets() {		
		
		// Set references to null
		_imgBackgroundMenu = null;
		_imgLogoMenu = null;
		_imgHighlightMenu = null;		
		_selectSFXMenu = null;
		
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
	
	public static void dispose(){
		if(_assetManager != null){
			_assetManager.dispose();
		}
		
	}
	
		
}
