package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
		
	public static AssetManager assetManager;
	
	//MENU SCREEN
	public static TextureRegion imgMouse;
	public static TextureRegion imgBackgroundMenu;
	public static TextureRegion imgLogoMenu;
	public static TextureRegion imgHighlightMenu;
	public static Sound selectSFXMenu;	
	public static BitmapFont fontMenu;
	public static BitmapFont fontLoadingMenu;
	public static TextureRegion[] imgGemsAnimation;	
	
	//HOWTO SCREEN
	public static BitmapFont fontTitle;
	public static BitmapFont fontText;
	public static TextureRegion imgBackgroundHowTo;
	public static Sound selectSFXHowTo;	
	
	
	private static PlatformResolver resolver;
	
	public static void initialize (PlatformResolver resolver) {
		
		AssetLoader.resolver = resolver;
		
		// Create assets manager
		AssetLoader.assetManager = new AssetManager();
		AssetLoader.assetManager.load("data/handCursor.png", Texture.class);
		AssetLoader.assetManager.finishLoading();
		AssetLoader.imgMouse = new TextureRegion(AssetLoader.assetManager.get("data/handCursor.png", Texture.class));
		AssetLoader.imgMouse.flip(false, true);
		
	}
	
	public static void loadLoadingFont(){
		AssetLoader.fontLoadingMenu = AssetLoader.resolver.loadFont("data/loadingFont.fnt", "data/normal.ttf", 70);
	}
			
	
	public static void assignGemsAnimationResources(){
		AssetLoader.imgGemsAnimation = new TextureRegion[7];		
		
		AssetLoader.imgGemsAnimation[0] = new TextureRegion(AssetLoader.assetManager.get("data/gemWhite.png", Texture.class));
		AssetLoader.imgGemsAnimation[1] = new TextureRegion(AssetLoader.assetManager.get("data/gemRed.png", Texture.class));
		AssetLoader.imgGemsAnimation[2] = new TextureRegion(AssetLoader.assetManager.get("data/gemPurple.png", Texture.class));
		AssetLoader.imgGemsAnimation[3] = new TextureRegion(AssetLoader.assetManager.get("data/gemOrange.png", Texture.class));
		AssetLoader.imgGemsAnimation[4] = new TextureRegion(AssetLoader.assetManager.get("data/gemGreen.png", Texture.class));
		AssetLoader.imgGemsAnimation[5] = new TextureRegion(AssetLoader.assetManager.get("data/gemYellow.png", Texture.class));
		AssetLoader.imgGemsAnimation[6] = new TextureRegion(AssetLoader.assetManager.get("data/gemBlue.png", Texture.class));
		
		for (int i = 0; i < 7; ++i) {
			AssetLoader.imgGemsAnimation[i].flip(false, true);
		}
	}
	
	public static void loadHowToAssets() {		
		
		// Load textures
		AssetLoader.assetManager.load("data/howtoScreen.png", Texture.class);			
		assetManager.load("data/select.ogg", Sound.class);
	}
	
	public static void assignHowToResources(){
		// Load fonts
		fontTitle = AssetLoader.resolver.loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
		fontText =  AssetLoader.resolver.loadFont("data/helpFont.fnt", "data/normal.ttf", 37);
		
		// Retrieve resources		
		imgBackgroundHowTo = new TextureRegion(AssetLoader.assetManager.get("data/howtoScreen.png", Texture.class));
		selectSFXHowTo = AssetLoader.assetManager.get("data/select.ogg", Sound.class);
		
		imgBackgroundHowTo.flip(false, true);		
		
	}
	
	public static void unloadHowToAssets() {
		// Set references to null
		AssetLoader.imgBackgroundHowTo = null;
		AssetLoader.fontTitle = null;
		AssetLoader.fontText = null;
		AssetLoader.selectSFXHowTo = null;
		
		// Unload resources
		AssetLoader.assetManager.unload("data/howtoScreen.png");
		AssetLoader.assetManager.unload("data/select.ogg");
	}

	public static void loadMenuAssets() {		
		
		// Load textures
		AssetLoader.assetManager.load("data/mainMenuBackground.png", Texture.class);
		AssetLoader.assetManager.load("data/mainMenuLogo.png", Texture.class);
		AssetLoader.assetManager.load("data/menuHighlight.png", Texture.class);
		AssetLoader.assetManager.load("data/gemWhite.png", Texture.class);
		AssetLoader.assetManager.load("data/gemRed.png", Texture.class);
		AssetLoader.assetManager.load("data/gemPurple.png", Texture.class);
		AssetLoader.assetManager.load("data/gemOrange.png", Texture.class);
		AssetLoader.assetManager.load("data/gemGreen.png", Texture.class);
		AssetLoader.assetManager.load("data/gemYellow.png", Texture.class);
		AssetLoader.assetManager.load("data/gemBlue.png", Texture.class);	
		
		// Load fonts
		AssetLoader.fontMenu =AssetLoader.resolver.loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
				
		// Sound
		AssetLoader.assetManager.load("data/select.ogg", Sound.class);
		
		
		
	}
	
	public static void AssignMenuResources(){
		
		AssetLoader.imgBackgroundMenu = new TextureRegion(AssetLoader.assetManager.get("data/mainMenuBackground.png", Texture.class));
		AssetLoader.imgLogoMenu = new TextureRegion(AssetLoader.assetManager.get("data/mainMenuLogo.png", Texture.class));
		AssetLoader.imgHighlightMenu = new TextureRegion(AssetLoader.assetManager.get("data/menuHighlight.png", Texture.class));
		
		AssetLoader.imgBackgroundMenu.flip(false, true);
		AssetLoader.imgLogoMenu.flip(false, true);
		AssetLoader.imgHighlightMenu.flip(false, true);
		
		AssetLoader.selectSFXMenu = AssetLoader.assetManager.get("data/select.ogg", Sound.class);
		
	}
	
	
	
	public static void unloadMenuAssets() {		
		
		// Set references to null
		AssetLoader.imgBackgroundMenu = null;
		AssetLoader.imgLogoMenu = null;
		AssetLoader.imgHighlightMenu = null;		
		AssetLoader.selectSFXMenu = null;
		
		// Unload resources		
		AssetLoader.assetManager.unload("data/mainMenuBackground.png");
		AssetLoader.assetManager.unload("data/mainMenuLogo.png");
		AssetLoader.assetManager.unload("data/menuHighlight.png");
		AssetLoader.assetManager.unload("data/gemWhite.png");
		AssetLoader.assetManager.unload("data/gemRed.png");
		AssetLoader.assetManager.unload("data/gemPurple.png");
		AssetLoader.assetManager.unload("data/gemOrange.png");
		AssetLoader.assetManager.unload("data/gemGreen.png");
		AssetLoader.assetManager.unload("data/gemYellow.png");
		AssetLoader.assetManager.unload("data/gemBlue.png");
		AssetLoader.assetManager.unload("data/select.ogg");
		
	}
	
	public static void dispose(){
		if(AssetLoader.assetManager != null){
			AssetLoader.assetManager.dispose();
		}
		
	}
	
		
}
