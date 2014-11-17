package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Vector2;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererHowTo extends GameRenderer{
				
	
	public GameRendererHowTo(GameWorldHowTo world){		
		super(world);		
		
	}
	
	@Override
	public void render(float runTime) {
		GameWorldHowTo world = (GameWorldHowTo)this.getWorld();
				
		this.initRender();
			
		this.getStage().getBatch().begin();
		
		// STATE LOADING - Just render loading
		if (world.getState() == GameWorldHowTo.StateHowTo.Loading) {			
			this.renderLoading();
		}else{
		
			// STATE ACTIVE
			this.getStage().getBatch().draw(AssetLoader.imgBackgroundHowTo, 0, 0);
			
			TextBounds bounds = AssetLoader.fontTitle.getBounds(world.getTitleText());
			Vector2 titlePos = new Vector2(315 + (this.getStage().getWidth() - 400 - bounds.width) / 2, 55);
			Vector2 helpPos = new Vector2(375, 175);
			
			AssetLoader.fontTitle.setColor(0.0f, 0.0f, 0.0f, 0.5f);
			AssetLoader.fontTitle.draw(this.getStage().getBatch(), world.getTitleText(), titlePos.x + 4, titlePos.y + 4);
			AssetLoader.fontTitle.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			AssetLoader.fontTitle.draw(this.getStage().getBatch(), world.getTitleText(), titlePos.x, titlePos.y);
			
			AssetLoader.fontText.drawWrapped(this.getStage().getBatch(), world.getHelpText(), helpPos.x, helpPos.y, this.getStage().getWidth() - 450);
		}
		this.getCursor().draw(this.getStage().getBatch(), 1);
		
		this.getStage().getBatch().end();
		
	}

}
