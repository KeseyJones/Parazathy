package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Rectangle;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererMenu extends GameRenderer{
				
	
	public GameRendererMenu(GameWorldMenu world, int height, int width){		
		super(world, height, width);		
		
	}
	
	private void renderLoading(){
		this.getBatch().begin();
		
		String loading = this.getWorld().getGame().getLanguagesManager().getString("Loading...");
		
		TextBounds bounds = AssetLoader._fontLoadingMenu.getBounds(loading);
		AssetLoader._fontLoadingMenu.draw(this.getBatch(),
					     loading,
					     (this.getWidth() - bounds.width) / 2,
					     (this.getHeight() - bounds.height) / 2);
		this.getBatch().end();
	}
	
	private void renderMenu(GameWorldMenu world){
				
		this.getBatch().begin();
		
		this.getBatch().draw(AssetLoader._imgBackgroundMenu, 0, 0);		    
		this.getBatch().setColor(1.0f, 1.0f, 1.0f, (float)(world.getAnimTime() / world.getAnimLogoTime()));
		this.getBatch().draw(AssetLoader._imgLogoMenu, 0, 0);
		this.getBatch().setColor(1.0f, 1.0f, 1.0f, 1.0f);
			
			
	    int numOptions = world.getOptions().size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader._fontMenu.getBounds(world.getOptions().get(i).getFirst());
			
			AssetLoader._fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
			AssetLoader._fontMenu.draw(this.getBatch(), world.getOptions().get(i).getFirst(), (this.getWidth() - bounds.width) / 2, world.getMenuStart().y + i *  world.getMenuGap() + 4);
			AssetLoader._fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			AssetLoader._fontMenu.draw(this.getBatch(), world.getOptions().get(i).getFirst(), (this.getWidth() - bounds.width) / 2, world.getMenuStart().y + i *  world.getMenuGap());
		}
			/*
		    //_gems.draw(Gdx.graphics.getDeltaTime());
			*/
		if (world.isReadyToChange()) {
			this.getBatch().draw(AssetLoader._imgHighlightMenu,
		    		   (this.getWidth() - AssetLoader._imgHighlightMenu.getRegionWidth()) / 2,
		    		   world.getMenuStart().y + 5 + world.getSelectedOption() * world.getMenuGap());
		    		   
		}
			
		this.getBatch().end();
	}
	
	@Override
	public void render(float runTime, Rectangle viewport) {
		GameWorldMenu world = (GameWorldMenu)this.getWorld();
				
		this.initRender(viewport);
					
		if (world.getState() == GameWorldMenu.StateMenu.Loading) {
			renderLoading();
			
		}else{
			renderMenu(world);
		}
						
		this.renderCursor();
		
	}

}
