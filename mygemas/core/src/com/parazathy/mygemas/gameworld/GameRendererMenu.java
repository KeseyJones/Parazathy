package com.parazathy.mygemas.gameworld;



public class GameRendererMenu extends GameRenderer{
						
			
	public GameRendererMenu(GameWorldMenu world){		
		super(world);			
	}	
		
	
	@Override
	public void render(float runTime) {
		GameWorldMenu world = (GameWorldMenu)this.getWorld();		
					
		if (world.getState() == GameWorldMenu.StateMenu.Loading) {
			this.initRender();			
			this.getStage().getBatch().begin();
			this.renderLoading();
			world.getCursor().draw(this.getStage().getBatch(), 1);
			this.getStage().getBatch().end();
			
		}else{
			//Pintamos la ui
			this.getStage().draw();
		}		
				
	}

}
