package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Rectangle;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererMenu extends GameRenderer{
		
	private GameWorldMenu myWorld;
	
	
	public GameRendererMenu(GameWorldMenu world, int gameHeight, int gameWidth){		
		super(gameHeight, gameWidth);
		this.myWorld = world;
		
	}
	
	@Override
	public void render(float runTime, Rectangle _viewport) {
		this.renderCommon(_viewport);
		
		// Start rendering
        _batch.begin();
		
		// STATE LOADING - Just render loading
		if (myWorld.get_state() == GameWorldMenu.StateMenu.Loading) {
			String loading = _lang.getString("Loading...");
			TextBounds bounds = AssetLoader._fontLoadingMenu.getBounds(loading);
			AssetLoader._fontLoadingMenu.draw(_batch,
						     loading,
						     (this.myGameWidth - bounds.width) / 2,
						     (this.myGameHeight - bounds.height) / 2);
			
			return;
		}
		
	    _batch.draw(AssetLoader._imgBackgroundMenu, 0, 0);
	    
	    _batch.setColor(1.0f, 1.0f, 1.0f, (float)(myWorld.get_animTime() / myWorld.get_animLogoTime()));
	    _batch.draw(AssetLoader._imgLogoMenu, 0, 0);
	    _batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		
	    int numOptions = myWorld.get_options().size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader._fontMenu.getBounds(myWorld.get_options().get(i).getFirst());
			
			AssetLoader._fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
			AssetLoader._fontMenu.draw(_batch, (myWorld.get_options().get(i).getFirst(), (Freegemas.VIRTUAL_WIDTH - bounds.width) / 2, _menuStart.y + i * _menuGap + 4);
			AssetLoader._fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			AssetLoader._fontMenu.draw(_batch, (myWorld.get_options().get(i).getFirst(), (Freegemas.VIRTUAL_WIDTH - bounds.width) / 2, _menuStart.y + i * _menuGap);
		}

	    _gems.draw(Gdx.graphics.getDeltaTime());
		
		if (myWorld.is_readyToChange()) {
			_batch.draw(AssetLoader._imgHighlightMenu,
		    		   (this.myGameWidth - AssetLoader._imgHighlightMenu.getRegionWidth()) / 2,
		    		   _menuStart.y + 5 + _selectedOption * _menuGap);
		}
		
		
        _batch.end();
	}

}
