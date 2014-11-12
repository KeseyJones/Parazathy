package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.parazathy.mygemas.gameobjects.Gems;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.screens.GameHowTo;
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
		
	private Gems gems;
	
	// Options
	private int selectedOption;	
	
	private boolean isFirstExceution;
	
	private Array<TextButton> menu;
	
	public GameWorldMenu(MyScreen screen){
		super(screen);
		state = StateMenu.Loading;
				
		// Animation times
		animTime = 0.0;
		animTotalTime = 1.0;
		animLogoTime = 1.0;
		
		gems = new Gems(screen.getWidth());
		
		readyToChange = false;
		
		isFirstExceution = true;		
				
	}
	
	private void createMenu(){
		this.menu = new Array<TextButton>();
		this.selectedOption = 0;		
		TextButton buttonPlay = new TextButton(this.getScreen().getGame().getLanguagesManager().getString("Timetrial mode"), getBlackStyleButtonMenu());			
		buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { 
            	
            	AssetLoader.selectSFXMenu.play();
            	selectedOption = 0;
            }
        });
		menu.add(buttonPlay);		
		TextButton buttonHowTo = new TextButton(this.getScreen().getGame().getLanguagesManager().getString("How to play"), getBlackStyleButtonMenu());			
		buttonHowTo.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {     
            	AssetLoader.selectSFXMenu.play();
            	if(isReadyToChange() && selectedOption == 1){
            		getScreen().getGame().changeScreen(new GameHowTo(getScreen().getGame()));
            	}
            	setReadyToChange(true);
            	selectedOption = 1;
            }
        });
		menu.add(buttonHowTo);
		if (Gdx.app.getType() != ApplicationType.WebGL) {
			TextButton buttonExit = new TextButton(this.getScreen().getGame().getLanguagesManager().getString("Exit"), getBlackStyleButtonMenu());			
			buttonExit.addListener(new ClickListener(){
	            @Override
	            public void clicked(InputEvent event, float x, float y) {  
	            	AssetLoader.selectSFXMenu.play();
	            	if(isReadyToChange() && selectedOption == 2){
	            		getScreen().getGame().exit();
	            	}
	            	setReadyToChange(true);
	            	selectedOption = 2;
	            }
	        });
			buttonExit.setTouchable(Touchable.enabled);
			menu.add(buttonExit);
					
		}
	}
	
	public TextButtonStyle getBlackStyleButtonMenu(){
		TextButtonStyle style = new TextButtonStyle();
		style.font= AssetLoader.fontMenu;	
		style.fontColor = new Color(0.0f, 0.0f, 0.0f, 0.5f);
		
		return style;
	}
	
	public TextButtonStyle getWhiteStyleButtonMenu(){
		TextButtonStyle style = new TextButtonStyle();
		style.font= AssetLoader.fontMenu;	
		style.fontColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
		
		return style;
	}
	
	private void initialize(){
		
		createMenu();
		
		//Iniciamos gemas
		gems.initialize();
				
	}
		
	
	@Override
	public void update(float delta) {	
		if(isFirstExceution){
			AssetLoader.loadMenuAssets();
			isFirstExceution = false;
		}
		
		if (state == StateMenu.Loading) {
			if (AssetLoader.assetManager.update()) {
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
	
	public void setReadyToChange(boolean readyToChange) {
		this.readyToChange = readyToChange;
	}

	public boolean isReadyToChange() {
		return readyToChange;
	}


	public int getSelectedOption() {
		return selectedOption;
	}
	
	public Gems getGems() {
		return gems;
	}

	public Array<TextButton> getMenu() {
		return menu;
	}
	
	
	
}
