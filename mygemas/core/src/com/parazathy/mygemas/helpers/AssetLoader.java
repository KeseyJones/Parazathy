package com.parazathy.mygemas.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.parazathy.mygemas.MyGemas;

public class AssetLoader {
		
	//GENERAL
	public static AssetManager assetManager;
	public static TextureRegion imgMouse;
	public static TextureRegion logo;
	public static BitmapFont fontLoadingMenu;
	
	//MENU SCREEN	
	public static TextureRegion imgBackgroundMenu;
	public static TextureRegion imgLogoMenu;
	public static TextureRegion imgHighlightMenu;
	public static Sound selectSFXMenu;	
	public static BitmapFont fontMenu;	
	public static TextureRegion[] imgGemsAnimation;	
	
	//HOWTO SCREEN
	public static BitmapFont fontTitleHowTo;
	public static BitmapFont fontTextHowTo;
	public static TextureRegion imgBackgroundHowTo;
	public static Sound selectSFXHowTo;		
	
	//HOWTO GAME
	public static BitmapFont fontTimeGame;
	public static BitmapFont fontTextGame;
	public static BitmapFont fontScoreGame;
	public static TextureRegion imgScoreBackgroundGame;
	public static TextureRegion imgTimeBackgroundGame; 
	public static TextureRegion imgBoardGame;
	public static TextureRegion imgWhiteGame;
	public static TextureRegion imgRedGame;
	public static TextureRegion imgPurpleGame;
	public static TextureRegion imgOrangeGame;
	public static TextureRegion imgGreenGame;
	public static TextureRegion imgYellowGame;
	public static TextureRegion imgBlueGame;
	public static TextureRegion imgSelectorGame;
	public static TextureRegion buttonBackgroundGame;
	public static TextureRegion buttonBackgroundClickedGame;
	public static TextureRegion iconHintGame;
	public static TextureRegion iconRestartGame;
	public static TextureRegion iconExitGame;
	public static TextureRegion iconMusicGame; 
	public static Sound match1SFXGame;
	public static Sound match2SFXGame;
	public static Sound match3SFXGame;
	public static Sound selectSFXGame;
	public static Sound fallSFXGame;
	public static Music songGame;
	public static ParticleEffect effect;
	
	
	public static void initialize () {
				
		// Create assets manager
		AssetLoader.assetManager = new AssetManager();
		AssetLoader.assetManager.load("data/logo.png", Texture.class);				
		AssetLoader.assetManager.load("data/handCursor.png", Texture.class);
		AssetLoader.assetManager.finishLoading();
		AssetLoader.logo = new TextureRegion(AssetLoader.assetManager.get("data/logo.png", Texture.class));		
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
	
	public static void loadParticleEffect(){
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal("data/particleStars"), Gdx.files.internal("data"));
		
	}
	
	public static void disposeParticleEffect(){
		if(effect != null){
			effect.dispose();
		}
		effect = null;
		
	}
	
	public static void loadHowToAssets() {		
		
		// Load textures
		AssetLoader.assetManager.load("data/howtoScreen.png", Texture.class);			
		assetManager.load("data/select.ogg", Sound.class);
		
		
	}
	
	public static void assignHowToResources(){
		
		// Load fonts
		AssetLoader.fontTitleHowTo = MyGemas.getResolver().loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
		AssetLoader.fontTextHowTo =  MyGemas.getResolver().loadFont("data/helpFont.fnt", "data/normal.ttf", 37);
				
		// Retrieve resources		
		AssetLoader.imgBackgroundHowTo = new TextureRegion(AssetLoader.assetManager.get("data/howtoScreen.png", Texture.class));
		AssetLoader.selectSFXHowTo = AssetLoader.assetManager.get("data/select.ogg", Sound.class);
		
		AssetLoader.imgBackgroundHowTo.flip(false, true);		
		
	}
	
	public static void disposeHowToAssets() {
		
		AssetLoader.imgBackgroundHowTo = null;
		if(AssetLoader.fontTitleHowTo != null){
			AssetLoader.fontTitleHowTo.dispose();
			AssetLoader.fontTitleHowTo = null;
		}
		if(AssetLoader.fontTextHowTo != null){
			AssetLoader.fontTextHowTo.dispose();
			AssetLoader.fontTextHowTo = null;
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
	
	public static void assignMenuResources(){
		
		
		AssetLoader.fontMenu =MyGemas.getResolver().loadFont("data/menuFont.fnt", "data/menu.ttf", 60);
		AssetLoader.fontMenu.setScale(0.8f);
		
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
		
	public static void assignGameResources() {	
		
		// Load fonts
		AssetLoader.fontTimeGame = MyGemas.getResolver().loadFont("data/timeFont.fnt", "data/lcd.ttf", 100);
		AssetLoader.fontScoreGame = MyGemas.getResolver().loadFont("data/scoreFont.fnt", "data/lcd.ttf", 70);
		AssetLoader.fontTextGame = MyGemas.getResolver().loadFont("data/normalFont.fnt", "data/normal.ttf", 45);
		
		// Load textures
		imgScoreBackgroundGame = new TextureRegion(assetManager.get("data/scoreBackground.png", Texture.class));
		imgBoardGame = new TextureRegion(assetManager.get("data/board.png", Texture.class));
		imgSelectorGame = new TextureRegion(assetManager.get("data/selector.png", Texture.class));
		imgTimeBackgroundGame = new TextureRegion(assetManager.get("data/timeBackground.png", Texture.class));
		imgWhiteGame = new TextureRegion(assetManager.get("data/gemWhite.png", Texture.class));
		imgRedGame = new TextureRegion(assetManager.get("data/gemRed.png", Texture.class));
		imgPurpleGame = new TextureRegion(assetManager.get("data/gemPurple.png", Texture.class));
		imgOrangeGame = new TextureRegion(assetManager.get("data/gemOrange.png", Texture.class));
		imgGreenGame = new TextureRegion(assetManager.get("data/gemGreen.png", Texture.class));
		imgYellowGame = new TextureRegion(assetManager.get("data/gemYellow.png", Texture.class));
		imgBlueGame = new TextureRegion(assetManager.get("data/gemBlue.png", Texture.class));
		AssetLoader.buttonBackgroundGame = new TextureRegion(assetManager.get("data/buttonBackground.png", Texture.class));
		AssetLoader.buttonBackgroundClickedGame = new TextureRegion(assetManager.get("data/buttonBackgroundPressed.png", Texture.class));
		AssetLoader.iconHintGame = new TextureRegion(assetManager.get("data/iconHint.png", Texture.class));
		AssetLoader.iconRestartGame = new TextureRegion(assetManager.get("data/iconRestart.png", Texture.class));
		AssetLoader.iconExitGame = new TextureRegion(assetManager.get("data/iconExit.png", Texture.class));
		AssetLoader.iconMusicGame = new TextureRegion(assetManager.get("data/iconMusic.png", Texture.class));
		
		imgScoreBackgroundGame.flip(false, true);
		imgBoardGame.flip(false, true);
		imgSelectorGame.flip(false, true);
		imgTimeBackgroundGame.flip(false, true);
		imgWhiteGame.flip(false, true);
		imgRedGame.flip(false, true);
		imgPurpleGame.flip(false, true);
		imgOrangeGame.flip(false, true);
		imgGreenGame.flip(false, true);
		imgYellowGame.flip(false, true);
		imgBlueGame.flip(false, true);
		AssetLoader.buttonBackgroundGame.flip(false, true);
		AssetLoader.buttonBackgroundClickedGame.flip(false, true);
		AssetLoader.iconHintGame.flip(false, true);
		AssetLoader.iconRestartGame.flip(false, true);
		AssetLoader.iconExitGame.flip(false, true);
		AssetLoader.iconMusicGame.flip(false, true);
		
		// Load SFX and music
		AssetLoader.match1SFXGame = AssetLoader.assetManager.get("data/match1.ogg", Sound.class);
		AssetLoader.match2SFXGame = AssetLoader.assetManager.get("data/match2.ogg", Sound.class);
		AssetLoader.match3SFXGame = AssetLoader.assetManager.get("data/match3.ogg", Sound.class);
		AssetLoader.selectSFXGame = AssetLoader.assetManager.get("data/select.ogg", Sound.class);
		AssetLoader.fallSFXGame = AssetLoader.assetManager.get("data/fall.ogg", Sound.class);
		AssetLoader.songGame = AssetLoader.assetManager.get("data/music1.ogg", Music.class);
		
		
			
	}
	
		
	public static void loadGameAssets() {				
		
		// Load textures
		AssetLoader.assetManager.load("data/scoreBackground.png", Texture.class);
		AssetLoader.assetManager.load("data/buttonBackground.png", Texture.class);
		AssetLoader.assetManager.load("data/buttonBackgroundPressed.png", Texture.class);
		AssetLoader.assetManager.load("data/board.png", Texture.class);
		AssetLoader.assetManager.load("data/selector.png", Texture.class);
		AssetLoader.assetManager.load("data/timeBackground.png", Texture.class);
		AssetLoader.assetManager.load("data/gemWhite.png", Texture.class);
		AssetLoader.assetManager.load("data/gemRed.png", Texture.class);
		AssetLoader.assetManager.load("data/gemPurple.png", Texture.class);
		AssetLoader.assetManager.load("data/gemOrange.png", Texture.class);
		AssetLoader.assetManager.load("data/gemGreen.png", Texture.class);
		AssetLoader.assetManager.load("data/gemYellow.png", Texture.class);
		AssetLoader.assetManager.load("data/gemBlue.png", Texture.class);
		AssetLoader.assetManager.load("data/iconHint.png", Texture.class);
		AssetLoader.assetManager.load("data/iconRestart.png", Texture.class);
		AssetLoader.assetManager.load("data/iconExit.png", Texture.class);
		AssetLoader.assetManager.load("data/iconMusic.png", Texture.class);		
		
		// Load SFX and music
		AssetLoader.assetManager.load("data/match1.ogg", Sound.class);
		AssetLoader.assetManager.load("data/match2.ogg", Sound.class);
		AssetLoader.assetManager.load("data/match3.ogg", Sound.class);
		AssetLoader.assetManager.load("data/select.ogg", Sound.class);
		AssetLoader.assetManager.load("data/fall.ogg", Sound.class);
		AssetLoader.assetManager.load("data/music1.ogg", Music.class);
				
	}
		
	public static void disposeGameAssets() {
		// Set assets references to null
		AssetLoader.imgBoardGame = null;
		AssetLoader.imgWhiteGame = null;
		AssetLoader.imgRedGame = null;
		AssetLoader.imgPurpleGame = null;
		AssetLoader.imgOrangeGame = null;
		AssetLoader.imgGreenGame = null;
		AssetLoader.imgYellowGame = null;
		AssetLoader.imgBlueGame = null;
		AssetLoader.imgSelectorGame = null;
		AssetLoader.imgScoreBackgroundGame = null;
		AssetLoader.imgTimeBackgroundGame = null;
		AssetLoader.buttonBackgroundGame = null;
		AssetLoader.buttonBackgroundClickedGame = null;
		AssetLoader.iconHintGame = null;
		AssetLoader.iconRestartGame = null;
		AssetLoader.iconExitGame = null;
		AssetLoader.iconMusicGame = null;
		if(AssetLoader.fontTimeGame != null){
			AssetLoader.fontTimeGame.dispose();
			AssetLoader.fontTimeGame = null;
		}
		if(AssetLoader.fontScoreGame != null){
			AssetLoader.fontScoreGame.dispose();
			AssetLoader.fontScoreGame = null;
		}
		if(AssetLoader.fontTextGame != null){
			AssetLoader.fontTextGame.dispose();
			AssetLoader.fontTextGame = null;
		}
		if(AssetLoader.match1SFXGame != null){
			AssetLoader.match1SFXGame.dispose();
			AssetLoader.match1SFXGame = null;
		}
		if(AssetLoader.match2SFXGame != null){
			AssetLoader.match2SFXGame.dispose();
			AssetLoader.match2SFXGame = null;
		}
		if(AssetLoader.match3SFXGame != null){
			AssetLoader.match3SFXGame.dispose();
			AssetLoader.match3SFXGame = null;
		}
		if(AssetLoader.selectSFXGame != null){
			AssetLoader.selectSFXGame.dispose();
			AssetLoader.selectSFXGame = null;
		}
		if(AssetLoader.fallSFXGame != null){
			AssetLoader.fallSFXGame.dispose();
			AssetLoader.fallSFXGame = null;
		}
		if(AssetLoader.songGame != null){
			AssetLoader.songGame.dispose();
			AssetLoader.songGame = null;
		}		
		
		disposeParticleEffect();
		
		// Unload assets		
		AssetLoader.assetManager.unload("data/scoreBackground.png");
		AssetLoader.assetManager.unload("data/buttonBackground.png");
		AssetLoader.assetManager.unload("data/buttonBackgroundPressed.png");
		AssetLoader.assetManager.unload("data/board.png");
		AssetLoader.assetManager.unload("data/selector.png");
		AssetLoader.assetManager.unload("data/timeBackground.png");
		AssetLoader.assetManager.unload("data/gemWhite.png");
		AssetLoader.assetManager.unload("data/gemRed.png");
		AssetLoader.assetManager.unload("data/gemPurple.png");
		AssetLoader.assetManager.unload("data/gemOrange.png");
		AssetLoader.assetManager.unload("data/gemGreen.png");
		AssetLoader.assetManager.unload("data/gemYellow.png");
		AssetLoader.assetManager.unload("data/gemBlue.png");
		AssetLoader.assetManager.unload("data/iconHint.png");
		AssetLoader.assetManager.unload("data/iconRestart.png");
		AssetLoader.assetManager.unload("data/iconExit.png");
		AssetLoader.assetManager.unload("data/iconMusic.png");
		AssetLoader.assetManager.unload("data/match1.ogg");
		AssetLoader.assetManager.unload("data/match2.ogg");
		AssetLoader.assetManager.unload("data/match3.ogg");
		AssetLoader.assetManager.unload("data/select.ogg");
		AssetLoader.assetManager.unload("data/fall.ogg");
		AssetLoader.assetManager.unload("data/music1.ogg");
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
