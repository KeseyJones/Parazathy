package com.parazathy.fireman.screen.renderer;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.screen.world.CommonWorld;
import com.parazathy.screen.world.MenuWorld;

public class MenuRenderer extends CommonRenderer{
	
	public MenuRenderer(CommonWorld world, Stage stage){	
		super(world, stage);
		
		
	}

	@Override
	public void render(float runTime) {
		MenuWorld world = (MenuWorld)this.getWorld();	
		
		this.getStage().draw();
		
	}

}
