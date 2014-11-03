package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Rectangle;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererMenu extends GameRenderer{
			
	
	
	public GameRendererMenu(GameWorldMenu world, int gameHeight, int gameWidth){		
		super(world, gameHeight, gameWidth);		
		
	}
	
	private void renderWorld(){
		GameWorldMenu myWorld = (GameWorldMenu)this.getMyworld();
		// STATE LOADING - Just render loading
		if (myWorld.get_state() == GameWorldMenu.StateMenu.Loading) {
			String loading = this.get_lang().getString("Loading...");
			
			TextBounds bounds = AssetLoader._fontLoadingMenu.getBounds(loading);
			AssetLoader._fontLoadingMenu.draw(this.get_batch(),
						     loading,
						     (this.getMyGameWidth() - bounds.width) / 2,
						     (this.getMyGameHeight() - bounds.height) / 2);
			
			return;
			
		}
		/*
		
		this.get_batch().draw(AssetLoader._imgBackgroundMenu, 0, 0);
	    
		this.get_batch().setColor(1.0f, 1.0f, 1.0f, (float)(myWorld.get_animTime() / myWorld.get_animLogoTime()));
		this.get_batch().draw(AssetLoader._imgLogoMenu, 0, 0);
		this.get_batch().setColor(1.0f, 1.0f, 1.0f, 1.0f);
		
	    int numOptions = myWorld.get_options().size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader._fontMenu.getBounds(myWorld.get_options().get(i).getFirst());
			
			AssetLoader._fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
			//AssetLoader._fontMenu.draw(this.get_batch(), (myWorld.get_options().get(i).getFirst(), (this.getMyGameHeight() - bounds.width) / 2, myWorld.get_menuStart().y + i *  myWorld.get_menuGap() + 4);
			AssetLoader._fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			//AssetLoader._fontMenu.draw(this.get_batch(), (myWorld.get_options().get(i).getFirst(), (this.getMyGameWidth() - bounds.width) / 2, myWorld.get_menuStart().y + i *  myWorld.get_menuGap());
		}

	    //_gems.draw(Gdx.graphics.getDeltaTime());
		
		if (myWorld.is_readyToChange()) {
			this.get_batch().draw(AssetLoader._imgHighlightMenu,
		    		   (this.getMyGameWidth() - AssetLoader._imgHighlightMenu.getRegionWidth()) / 2,
		    		   myWorld.get_menuStart().y + 5 + myWorld.get_selectedOption() * myWorld.get_menuGap());
		}
		*/
	}
	
	@Override
	public void render(float runTime, Rectangle _viewport) {
				
		this.initRender(_viewport);
		
		
		// Start rendering
        this.get_batch().begin();
        
        this.renderCursor();
		
        renderWorld();
		
		
		this.get_batch().end();
		// Clear the screen, update the camera and make the sprite batch
        // use its matrices.
        
	}

}
