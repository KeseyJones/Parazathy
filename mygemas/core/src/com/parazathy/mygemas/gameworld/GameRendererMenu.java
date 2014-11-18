package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererMenu extends GameRenderer{
						
			
	public GameRendererMenu(GameWorldMenu world){		
		super(world);	
		this.getStage().addActor(this.getCursor());
	}	
	
	private void renderBackGround(Batch batch, GameWorldMenu world){
								
		batch.draw(AssetLoader.imgBackgroundMenu, 0, 0);		    
		batch.setColor(1.0f, 1.0f, 1.0f, (float)(world.getAnimTime() / world.getAnimLogoTime()));
		batch.draw(AssetLoader.imgLogoMenu, 0, 0);
		batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);	    
		
	}
	
	@Override
	public void render(float runTime) {
		GameWorldMenu world = (GameWorldMenu)this.getWorld();
				
		this.initRender();
				
		this.getStage().getBatch().begin();
					
		if (world.getState() == GameWorldMenu.StateMenu.Loading) {
			this.renderLoading();
			
		}else{
			renderBackGround(this.getStage().getBatch(), world);
		}		
		
		this.getStage().getBatch().end();

		this.getStage().draw();
		//Pintamos la ui
		
	}

}
