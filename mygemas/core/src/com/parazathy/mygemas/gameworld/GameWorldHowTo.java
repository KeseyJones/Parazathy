package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.InputHandlerHowTo;


public class GameWorldHowTo extends GameWorld{
	
	public static enum StateHowTo {Loading, Active};	
	
	private StateHowTo state;
	
	private String titleText;
	private String helpText;	
	
	private boolean isFirstExceution;
	
	private InputHandlerHowTo inputHandler;
	
	public GameWorldHowTo(Stage stage){
		super(stage);			
		titleText = MyGemas.getLanguagesManager().getString("How to play");
		helpText = MyGemas.getLanguagesManager().getString("help_text");
		
		state = StateHowTo.Loading;		
		
		isFirstExceution = true;	
		
		inputHandler = new InputHandlerHowTo();
		
	}
			
	
	@Override
	public void update(float delta) {	
		if(isFirstExceution){
			AssetLoader.loadHowToAssets();
			isFirstExceution = false;
		}
		if (state == StateHowTo.Loading) {
			if (AssetLoader.assetManager.update()) {
				AssetLoader.assignHowToResources();
				
				Gdx.input.setInputProcessor(inputHandler);
				state = StateHowTo.Active;
			}
			
			return;
		}
	    
	}

	public StateHowTo getState() {
		return state;
	}


	public String getTitleText() {
		return titleText;
	}


	public String getHelpText() {
		return helpText;
	}
	

	public void setState(StateHowTo state) {
		this.state = state;
	}


	public void setReadyToChange(boolean readyToChange) {
		inputHandler.setReadyToChange(readyToChange);
	}


	@Override
	public void dispose() {

		AssetLoader.unloadHowToAssets();
		Gdx.input.setInputProcessor(null);
		
	}
	
	
	
}
