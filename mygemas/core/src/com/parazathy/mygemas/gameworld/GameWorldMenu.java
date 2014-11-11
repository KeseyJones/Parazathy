package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameobjects.Gems;
import com.parazathy.mygemas.gameobjects.Pair;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.InputHandlerMenu;
import com.parazathy.mygemas.screens.MyScreen;


public class GameWorldMenu extends GameWorld{
	
	//Estados del menu
	public static enum StateMenu { Loading,
							TransitionIn,
							Active,
							TransitionOut } ;
	
	private StateMenu state;
	
	// Animation time
	private double animTime;
	private double animLogoTime;
	private double animTotalTime;
	
	private boolean readyToChange;
	
	// Positions
	private Vector2 menuStart;
	private Vector2 menuEnd;
	private int menuGap;	
		
	private Gems gems;
	
	// Options
	private int selectedOption;
	private Array<Pair<String, MyGemas.Screens>> options;
	
	private boolean isFirstExceution;
			
	
	public GameWorldMenu(MyScreen screen){
		super(screen);
		state = StateMenu.Loading;
		
		// Menu options
		selectedOption = 0;
		options = new Array<Pair<String, MyGemas.Screens>>();
		options.add(new Pair(screen.getGame().getLanguagesManager().getString("Timetrial mode"), MyGemas.Screens.Game));
		options.add(new Pair(screen.getGame().getLanguagesManager().getString("How to play"), MyGemas.Screens.HowTo));
		if (Gdx.app.getType() != ApplicationType.WebGL) {
			options.add(new Pair(screen.getGame().getLanguagesManager().getString("Exit"), MyGemas.Screens.Exit));
		}
		
		// Animation times
		animTime = 0.0;
		animTotalTime = 1.0;
		animLogoTime = 1.0;
		
		gems = new Gems(screen.getWidth());
		
		readyToChange = false;
		
		isFirstExceution = true;		
				
	}
	
	private void initialize(){
		// Set positions now that we now about sizes		
		float maxWidth = 0;
		int numOptions = options.size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader._fontMenu.getBounds(options.get(i).getFirst());
			
			if (bounds.width > maxWidth) {
				maxWidth = bounds.width;
			}
		}
		
		menuStart = new Vector2((this.getScreen().getWidth() - maxWidth) / 2, 390);
		menuGap = 100;
		menuEnd = new Vector2(menuStart.x + maxWidth, 350 + options.size * menuGap);
		
		//Iniciamos gemas
		gems.initialize();
		
		//Activamos en este momento el tecaldo
		Gdx.input.setInputProcessor(new InputHandlerMenu(this));
	}
		
	
	@Override
	public void update(float delta) {	
		if(isFirstExceution){
			AssetLoader.loadMenuAssets();
			isFirstExceution = false;
		}
		
		if (state == StateMenu.Loading) {
			if (AssetLoader._assetManager.update()) {
				AssetLoader.AssignMenuResources();
				initialize();
				state = StateMenu.TransitionIn;
			}					
		}
		else if (state  == StateMenu.TransitionIn) {
			gems.update(delta);
	        if ((animTime += delta) >= animTotalTime) {
	        	state = StateMenu.Active;
	        	animTime = animLogoTime;
	        }
	        
	    }
	    
	}
		
	public double getAnimTime() {
		return animTime;
	}


	public double getAnimLogoTime() {
		return animLogoTime;
	}


	public double getAnimTotalTime() {
		return animTotalTime;
	}


	public StateMenu getState() {
		return state;
	}
	

	public void setState(StateMenu state) {
		this.state = state;
	}


	public Array<Pair<String, MyGemas.Screens>> getOptions() {
		return options;
	}
	
	public void setReadyToChange(boolean readyToChange) {
		this.readyToChange = readyToChange;
	}

	public boolean isReadyToChange() {
		return readyToChange;
	}


	public int getSelectedOption() {
		return selectedOption;
	}


	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Vector2 getMenuStart() {
		return menuStart;
	}

	public Vector2 getMenuEnd() {
		return menuEnd;
	}

	public int getMenuGap() {
		return menuGap;
	}

	public Gems getGems() {
		return gems;
	}
	
	
}
