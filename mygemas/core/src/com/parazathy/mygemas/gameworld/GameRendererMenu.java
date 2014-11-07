package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.parazathy.mygemas.gameobjects.Gems;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.screens.MyScreen;


public class GameRendererMenu extends GameRenderer{
					
	
	public GameRendererMenu(GameWorldMenu world){		
		super(world);		
		
	}
	
	private void renderLoading(MyScreen screen){		
		
		String loading = this.getWorld().getScreen().getGame().getLanguagesManager().getString("Loading...");
		
		TextBounds bounds = AssetLoader._fontLoadingMenu.getBounds(loading);
		AssetLoader._fontLoadingMenu.draw(this.getBatch(),
					     loading,
					     (screen.getWidth() - bounds.width) / 2,
					     (screen.getHeight() - bounds.height) / 2);
		
	}
	
	private void rendererGems(Gems gems, SpriteBatch batch){
		
		for(int i = 0; i < 7; ++i) {
            double composedTime = gems.getAnimTime() - i * gems.getAnimTotalTime() / 7.0f;
            if (composedTime < 0) {
            	continue;
            }
            
            if (composedTime < gems.getAnimTotalTime()) {
                batch.draw(AssetLoader._imgGemsAnimation[i], gems.getPosX()[i], Animation.easeOutCubic((float)composedTime, 600.0f, (float)gems.getPosY() - 600.0f, gems.getAnimTotalTime()));
            }else{
            	batch.draw(AssetLoader._imgGemsAnimation[i], gems.getPosX()[i], gems.getPosY());
            }
            
        }
        
	}
	
	private void renderMenu(SpriteBatch batch, GameWorldMenu world){
								
		batch.draw(AssetLoader._imgBackgroundMenu, 0, 0);		    
		batch.setColor(1.0f, 1.0f, 1.0f, (float)(world.getAnimTime() / world.getAnimLogoTime()));
		batch.draw(AssetLoader._imgLogoMenu, 0, 0);
		batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			
			
	    int numOptions = world.getOptions().size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader._fontMenu.getBounds(world.getOptions().get(i).getFirst());
			
			AssetLoader._fontMenu.setColor(0.0f, 0.0f, 0.0f, 0.5f);
			AssetLoader._fontMenu.draw(batch, world.getOptions().get(i).getFirst(), (world.getScreen().getWidth() - bounds.width) / 2, world.getMenuStart().y + i *  world.getMenuGap() + 4);
			AssetLoader._fontMenu.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			AssetLoader._fontMenu.draw(batch, world.getOptions().get(i).getFirst(), (world.getScreen().getWidth() - bounds.width) / 2, world.getMenuStart().y + i *  world.getMenuGap());
		}
		
		rendererGems(world.getGems(), batch);
		
		
		if (world.isReadyToChange()) {
			batch.draw(AssetLoader._imgHighlightMenu,
		    		   (world.getScreen().getWidth() - AssetLoader._imgHighlightMenu.getRegionWidth()) / 2,
		    		   world.getMenuStart().y + 5 + world.getSelectedOption() * world.getMenuGap());
		    		   
		}
			
		
	}
	
	@Override
	public void render(float runTime, Rectangle viewport) {
		GameWorldMenu world = (GameWorldMenu)this.getWorld();
				
		this.initRender(viewport);
		
		this.getBatch().begin();
					
		if (world.getState() == GameWorldMenu.StateMenu.Loading) {
			renderLoading(world.getScreen());
			
		}else{
			renderMenu(this.getBatch(), world);
		}
						
		this.renderCursor();
		
		this.getBatch().end();
		
	}

}
