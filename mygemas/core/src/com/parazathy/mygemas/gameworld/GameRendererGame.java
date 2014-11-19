package com.parazathy.mygemas.gameworld;


public class GameRendererGame extends GameRenderer{
	
	public GameRendererGame(GameWorldGame world){		
		super(world);		
		
	}

	@Override
	public void render(float runTime) {
		GameWorldGame world = (GameWorldGame)this.getWorld();
		
		this.initRender();
			
		this.getStage().getBatch().begin();
				
		world.getCursor().draw(this.getStage().getBatch(), 1);
				
		this.getStage().getBatch().end();
		
	}

}
