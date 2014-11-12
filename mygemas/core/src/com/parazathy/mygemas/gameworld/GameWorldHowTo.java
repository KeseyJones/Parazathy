package com.parazathy.mygemas.gameworld;

import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.screens.MyScreen;


public class GameWorldHowTo extends GameWorld{
	
	public static enum StateHowTo {Loading, Active};	
	
	private StateHowTo state;
	
	private String titleText;
	private String helpText;
		
	private boolean readyToChange;
	
	private boolean isFirstExceution;
	
	public GameWorldHowTo(MyScreen screen){
		super(screen);		
		
		titleText = screen.getGame().getLanguagesManager().getString("How to play");
		helpText = screen.getGame().getLanguagesManager().getString("help_text");
		
		state = StateHowTo.Loading;
		readyToChange = false;
		
		isFirstExceution = true;		
		
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


	public boolean isReadyToChange() {
		return readyToChange;
	}


	public void setState(StateHowTo state) {
		this.state = state;
	}


	public void setReadyToChange(boolean readyToChange) {
		this.readyToChange = readyToChange;
	}
	
	
	
}
