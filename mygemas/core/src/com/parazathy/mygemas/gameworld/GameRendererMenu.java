package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.screens.MyScreen;


public class GameRendererMenu extends GameRenderer{
					
	private static final int MENU_START_HEIGHT = 390;
	private static final int MENU_GAP_HEIGHT = 100;
			
	public GameRendererMenu(GameWorldMenu world){		
		super(world);	
		this.getStage().addActor(this.getCursor());
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
			world.getMenu().get(i).setPosition(( this.getStage().getWidth() - bounds.width) / 2, MENU_START_HEIGHT + i *  MENU_GAP_HEIGHT + 4);
			this.getStage().addActor(world.getMenu().get(i));
			//world.getMenu().get(i).draw(batch, 1);	
			world.getMenu().get(i).setStyle(world.getWhiteStyleButtonMenu());			
			world.getMenu().get(i).setPosition(( this.getStage().getWidth() - bounds.width) / 2, MENU_START_HEIGHT + i * MENU_GAP_HEIGHT);
			//world.getMenu().get(i).draw(batch, 1);
			this.getStage().addActor(world.getMenu().get(i));
		}
				
		//Pintamos el que esta seleccionado
		if (world.isReadyToChange()) {
			batch.draw(AssetLoader.imgHighlightMenu,
		    		   ( this.getStage().getWidth() - AssetLoader.imgHighlightMenu.getRegionWidth()) / 2,
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
		
		this.getStage().getBatch().end();

		this.getStage().draw();
		//Pintamos la ui
		
	}

}
