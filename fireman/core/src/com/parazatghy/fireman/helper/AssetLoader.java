package com.parazatghy.fireman.helper;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
		
	//GENERAL
	public static AssetManager assetManager;	
	
	//MENU SCREEN	
	public static TextureRegion imgLogoMenuAnimation[];	
	
	
	public static void initialize () {
				
		// Create assets manager
		AssetLoader.assetManager = new AssetManager();		
		
	}		
	
	private void loadData(){
		AssetLoader.assetManager.load("data/logo.jpg", Texture.class);	
	}
	
	public static void assignMenuResources(){
		AssetLoader.imgLogoMenuAnimation = new TextureRegion[14];		
		
		AssetLoader.imgLogoMenuAnimation[0] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 0, 0 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[1] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 43, 0, 43, 82);
		AssetLoader.imgLogoMenuAnimation[2] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 86, 0 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[3] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 129, 0 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[4] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 172, 0 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[5] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 215, 0 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[6] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 258, 0 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[7] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 0, 82 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[8] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 43, 82, 43, 82);
		AssetLoader.imgLogoMenuAnimation[9] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 86, 82 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[10] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 129, 82 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[11] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 172, 82 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[12] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 215, 82 , 43, 82);
		AssetLoader.imgLogoMenuAnimation[13] = new TextureRegion(AssetLoader.assetManager.get("data/logo.jpg", Texture.class), 258, 82 , 43, 82);
		
		for (int i = 0; i < 14; ++i) {
			AssetLoader.imgLogoMenuAnimation[i].flip(false, true);
		}
	}
			
	
	public static void dispose(){		
		
		if(AssetLoader.assetManager != null){
			AssetLoader.assetManager.dispose();
		}
		
	}
	
		
}
