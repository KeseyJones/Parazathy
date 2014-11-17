package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.mygemas.MyGemas;


public abstract class GameWorld {
					
	private String loading;	
	private Stage stage;
	
	public GameWorld(Stage stage){				
		this.stage = stage;
		this.loading = MyGemas.getLanguagesManager().getString("Loading...");		
	}
	
	public abstract void update(float delta);
			

	public String getLoading() {
		return loading;
	}

	public Stage getStage() {
		return stage;
	}	
	
	public abstract void dispose();
		
}
