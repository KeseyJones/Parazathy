package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.parazathy.mygemas.gameobjects.Animation;
import com.parazathy.mygemas.gameobjects.Gems;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererMenu extends GameRenderer{
					
	private static final int MENU_START_HEIGHT = 390;
	private static final int MENU_GAP_HEIGHT = 100;
	
	public GameRendererMenu(GameWorldMenu world){		
		super(world);		
		
	}
			
	private void rendererGems(Gems gems, Batch batch){
		
		for(int i = 0; i < 7; ++i) {
			
            double composedTime = gems.getAnimTime() - i * gems.getAnimTotalTime() / 7.0f;
            if (composedTime < 0) {
            	continue;
            }
            
            if (composedTime < gems.getAnimTotalTime()) {
                batch.draw(AssetLoader.imgGemsAnimation[i], gems.getPosX()[i], Animation.easeOutCubic((float)composedTime, 600.0f, (float)gems.getPosY() - 600.0f, gems.getAnimTotalTime()));
            }else{
            	batch.draw(AssetLoader.imgGemsAnimation[i], gems.getPosX()[i], gems.getPosY());
            }
                        
        }
        
	}
	
	private void renderMenu(Batch batch, GameWorldMenu world){
								
		batch.draw(AssetLoader.imgBackgroundMenu, 0, 0);		    
		batch.setColor(1.0f, 1.0f, 1.0f, (float)(world.getAnimTime() / world.getAnimLogoTime()));
		batch.draw(AssetLoader.imgLogoMenu, 0, 0);
		batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			
			
	    int numOptions = world.getMenu().size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader.fontMenu.getBounds(world.getMenu().get(i).getText());
						
			world.getMenu().get(i).setStyle(world.getBlackStyleButtonMenu());		
			world.getMenu().get(i).setPosition((world.getScreen().getWidth() - bounds.width) / 2, MENU_START_HEIGHT + i *  MENU_GAP_HEIGHT + 4);
			world.getMenu().get(i).draw(batch, 1);	
			world.getMenu().get(i).setStyle(world.getWhiteStyleButtonMenu());			
			world.getMenu().get(i).setPosition((world.getScreen().getWidth() - bounds.width) / 2, MENU_START_HEIGHT + i * MENU_GAP_HEIGHT);
			world.getMenu().get(i).draw(batch, 1);			
		}
		
		rendererGems(world.getGems(), batch);
		
		//Pintamos el que esta seleccionado
		if (world.isReadyToChange()) {
			batch.draw(AssetLoader.imgHighlightMenu,
		    		   (world.getScreen().getWidth() - AssetLoader.imgHighlightMenu.getRegionWidth()) / 2,
		    		   MENU_START_HEIGHT + 5 + world.getSelectedOption() * MENU_GAP_HEIGHT);
		    		   
		}
			
		
	}
	
	@Override
	public void render(float runTime) {
		GameWorldMenu world = (GameWorldMenu)this.getWorld();
				
		this.initRender();
		
		this.getStage().getBatch().begin();
					
		if (world.getState() == GameWorldMenu.StateMenu.Loading) {
			this.renderLoading();
			
		}else{
			renderMenu(this.getStage().getBatch(), world);
		}
						
		this.renderCursor();
		
		this.getStage().getBatch().end();
		
	}

}
