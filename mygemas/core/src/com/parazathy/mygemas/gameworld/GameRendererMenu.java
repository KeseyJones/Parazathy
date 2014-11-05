package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Rectangle;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererMenu extends GameRenderer{
				
	
	public GameRendererMenu(GameWorldMenu world, int height, int width){		
		super(world, height, width);		
		
	}
	
	private void renderLoading(){
		String loading = this.getWorld().getLanguagesManager().getString("Loading...");
		
		TextBounds bounds = AssetLoader._fontLoadingMenu.getBounds(loading);
		AssetLoader._fontLoadingMenu.draw(this.getBatch(),
					     loading,
					     (this.getWidth() - bounds.width) / 2,
					     (this.getHeight() - bounds.height) / 2);
	}
	
	private void renderMenu(GameWorldMenu world){
					
		this.getBatch().draw(AssetLoader._imgBackgroundMenu, 0, 0);		    
		this.getBatch().setColor(1.0f, 1.0f, 1.0f, (float)(world.get_animTime() / world.get_animLogoTime()));
		this.getBatch().draw(AssetLoader._imgLogoMenu, 0, 0);
		this.getBatch().setColor(1.0f, 1.0f, 1.0f, 1.0f);
			
			
	    int numOptions = world.get_options().size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader._fontMenu.getBounds(world.get_options().get(i).getFirst());
			
			AssetLoader._fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
			AssetLoader._fontMenu.draw(this.getBatch(), world.get_options().get(i).getFirst(), (this.getWidth() - bounds.width) / 2, world.get_menuStart().y + i *  world.get_menuGap() + 4);
			AssetLoader._fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			AssetLoader._fontMenu.draw(this.getBatch(), world.get_options().get(i).getFirst(), (this.getWidth() - bounds.width) / 2, world.get_menuStart().y + i *  world.get_menuGap());
		}
			/*
		    //_gems.draw(Gdx.graphics.getDeltaTime());
			*/
		if (world.is_readyToChange()) {
			this.getBatch().draw(AssetLoader._imgHighlightMenu,
		    		   (this.getWidth() - AssetLoader._imgHighlightMenu.getRegionWidth()) / 2,
		    		   world.get_menuStart().y + 5 + world.get_selectedOption() * world.get_menuGap());
		    		   
		}
			
		
	}
	
	@Override
	public void render(float runTime, Rectangle viewport) {
		GameWorldMenu world = (GameWorldMenu)this.getWorld();
				
		this.initRender(viewport);
			
		this.getBatch().begin();
		if (world.getState() == GameWorldMenu.StateMenu.Loading) {
			renderLoading();
			
		}else{
			renderMenu(world);
		}
				
		this.getBatch().end();
		
		this.renderCursor();
		
	}

}
