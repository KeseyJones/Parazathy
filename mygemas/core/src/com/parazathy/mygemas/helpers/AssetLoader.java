package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.parazathy.mygemas.MyGemas;

public class AssetLoader {
		
	//GENERAL
	public static AssetManager assetManager;
	public static TextureRegion imgMouse;
	public static BitmapFont fontLoadingMenu;
	
	//MENU SCREEN	
	public static TextureRegion imgBackgroundMenu;
	public static TextureRegion imgLogoMenu;
	public static TextureRegion imgHighlightMenu;
	public static Sound selectSFXMenu;	
	public static BitmapFont fontMenu;	
	public static TextureRegion[] imgGemsAnimation;	
	
	//HOWTO SCREEN
	public static BitmapFont fontTitle;
	public static BitmapFont fontText;
	public static TextureRegion imgBackgroundHowTo;
	public static Sound selectSFXHowTo;		
	
	public static void initialize () {
				
		// Create assets manager
		AssetLoader.assetManager = new AssetManager();
		AssetLoader.assetManager.load("data/handCursor.png", Texture.class);
		AssetLoader.assetManager.finishLoading();
		AssetLoader.imgMouse = new TextureRegion(AssetLoader.assetManager.get("data/handCursor.png", Texture.class));
		AssetLoader.imgMouse.flip(false, true);
		AssetLoader.fontLoadingMenu = MyGemas.getResolver().loadFont("data/loadingFont.fnt", "data/normal.ttf", 70);
		
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
		fontTitle = MyGemas.getResolver().loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
		fontText =  MyGemas.getResolver().loadFont("data/helpFont.fnt", "data/normal.ttf", 37);
				
		// Retrieve resources		
		imgBackgroundHowTo = new TextureRegion(AssetLoader.assetManager.get("data/howtoScreen.png", Texture.class));
		selectSFXHowTo = AssetLoader.assetManager.get("data/select.ogg", Sound.class);
		
		imgBackgroundHowTo.flip(false, true);		
		
	}
	
	public static void disposeHowToAssets() {
		
		AssetLoader.imgBackgroundHowTo = null;
		if(AssetLoader.fontTitle != null){
			AssetLoader.fontTitle.dispose();
			AssetLoader.fontTitle = null;
		}
		if(AssetLoader.fontText != null){
			AssetLoader.fontText.dispose();
			AssetLoader.fontText = null;
		}
		if(AssetLoader.selectSFXHowTo != null){
			AssetLoader.selectSFXHowTo.dispose();
			AssetLoader.selectSFXHowTo = null;
		}
		
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
				
		// Sound
		AssetLoader.assetManager.load("data/select.ogg", Sound.class);
		
		
		
	}
	
	public static void AssignMenuResources(){
		
		
		AssetLoader.fontMenu =MyGemas.getResolver().loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
		
		AssetLoader.imgBackgroundMenu = new TextureRegion(AssetLoader.assetManager.get("data/mainMenuBackground.png", Texture.class));
		AssetLoader.imgLogoMenu = new TextureRegion(AssetLoader.assetManager.get("data/mainMenuLogo.png", Texture.class));
		AssetLoader.imgHighlightMenu = new TextureRegion(AssetLoader.assetManager.get("data/menuHighlight.png", Texture.class));
		
		AssetLoader.imgBackgroundMenu.flip(false, true);
		AssetLoader.imgLogoMenu.flip(false, true);
		AssetLoader.imgHighlightMenu.flip(false, true);
		
		AssetLoader.selectSFXMenu = AssetLoader.assetManager.get("data/select.ogg", Sound.class);
		
	}
	
	
	
	public static void disposeMenuAssets() {		
				
		AssetLoader.imgBackgroundMenu = null;
		AssetLoader.imgLogoMenu = null;
		AssetLoader.imgHighlightMenu = null;
		AssetLoader.imgGemsAnimation = null;
		if(AssetLoader.selectSFXMenu != null){
			AssetLoader.selectSFXMenu.dispose();
			AssetLoader.selectSFXMenu = null;
		}
		
		if(AssetLoader.fontMenu != null){
			AssetLoader.fontMenu.dispose();
			AssetLoader.fontMenu = null;
		}		
		
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
		AssetLoader.imgMouse = null;
		if(AssetLoader.fontLoadingMenu != null){
			AssetLoader.fontLoadingMenu.dispose();
			AssetLoader.fontLoadingMenu = null;
		}
		
		AssetLoader.assetManager.unload("data/handCursor.png");
		
		if(AssetLoader.assetManager != null){
			AssetLoader.assetManager.dispose();
		}
		
	}
	
		
}
