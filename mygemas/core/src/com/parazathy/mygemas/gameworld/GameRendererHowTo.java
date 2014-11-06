package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.math.Rectangle;


public class GameRendererHowTo extends GameRenderer{
				
	
	public GameRendererHowTo(GameWorldHowTo world, int height, int width){		
		super(world, height, width);		
		
	}
	
	@Override
	public void render(float runTime, Rectangle viewport) {
		GameWorldHowTo world = (GameWorldHowTo)this.getWorld();
				
		this.initRender(viewport);
			
		
		this.renderCursor();
		
	}

}
