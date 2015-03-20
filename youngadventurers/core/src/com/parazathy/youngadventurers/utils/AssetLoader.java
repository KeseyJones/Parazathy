package com.parazathy.youngadventurers.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static AssetManager assetManager = new AssetManager();
	
	
	//GAME SCREEN
	public static TextureRegion imgBackgroundGame;
	
	private AssetLoader(){
		
	}
		
	
	public static void loadGameAssets() {
		
		AssetLoader.assetManager.load("data/game/gameBackground.png", Texture.class);
       
    }

}
