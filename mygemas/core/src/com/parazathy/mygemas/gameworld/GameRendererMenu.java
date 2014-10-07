package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.siondream.freegemas.Freegemas;
import com.siondream.freegemas.StateMenu.State;


public class GameRendererMenu extends GameRenderer{
	
	public GameRendererMenu(GameWorld world, int gameHeight, int gameWidth){
		super(world, gameHeight, gameWidth);
	}
	
	@Override
	public void render(float runTime) {
		this.renderCommon(runTime);
		
		// STATE LOADING - Just render loading
		if (_state == State.Loading) {
			String loading = _lang.getString("Loading...");
			TextBounds bounds = _fontLoading.getBounds(loading);
			_fontLoading.draw(batch,
						     loading,
						     (Freegemas.VIRTUAL_WIDTH - bounds.width) / 2,
						     (Freegemas.VIRTUAL_HEIGHT - bounds.height) / 2);
			
			return;
		}
		
	    _batch.draw(AssetLoader._imgBackgroundMenu, 0, 0);
	    
	    batch.setColor(1.0f, 1.0f, 1.0f, (float)(_animTime / _animLogoTime));
	    batch.draw(_imgLogo, 0, 0);
	    batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		
	    int numOptions = _options.size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = _fontMenu.getBounds(_options.get(i).getFirst());
			
			_fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
			_fontMenu.draw(batch, _options.get(i).getFirst(), (Freegemas.VIRTUAL_WIDTH - bounds.width) / 2, _menuStart.y + i * _menuGap + 4);
			_fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
	        _fontMenu.draw(batch, _options.get(i).getFirst(), (Freegemas.VIRTUAL_WIDTH - bounds.width) / 2, _menuStart.y + i * _menuGap);
		}

	    _gems.draw(Gdx.graphics.getDeltaTime());
		
		if (_readyToChange) {
		    batch.draw(_imgHighlight,
		    		   (Freegemas.VIRTUAL_WIDTH - _imgHighlight.getRegionWidth()) / 2,
		    		   _menuStart.y + 5 + _selectedOption * _menuGap);
		}
	}

}
