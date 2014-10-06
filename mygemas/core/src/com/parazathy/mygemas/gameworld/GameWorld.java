package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameWorld {
	
	private AssetLoader _assetLoader = null;
	private TextureRegion _imgMouse = null;
	
	public GameWorld() {
						
		_assetLoader = AssetLoader.getInstance();
		_assetLoader.loadCommonAssets();
		_imgMouse = new TextureRegion(_assetLoader.get_assetManager().get("data/handCursor.png", Texture.class));
        _imgMouse.flip(false, true);
		
	}

	public TextureRegion get_imgMouse() {
		return _imgMouse;
	}
	

}
