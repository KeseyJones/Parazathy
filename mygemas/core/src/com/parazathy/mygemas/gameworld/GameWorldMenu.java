package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.parazathy.mygemas.gameobjects.Gems;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.helpers.InputHandlerMenu;
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
	
	// Positions
	//private Vector2 menuStart;
	//private Vector2 menuEnd;
	//private int menuGap;	
		
	private Gems gems;
	
	// Options
	private int selectedOption;
	//private Array<Pair<String, MyGemas.Screens>> options;
	
	private boolean isFirstExceution;
	
	private Array<TextButton> menu;
			
	
	public GameWorldMenu(MyScreen screen){
		super(screen);
		state = StateMenu.Loading;
		
		/* Menu options
		selectedOption = 0;
		options = new Array<Pair<String, MyGemas.Screens>>();		
		options.add(new Pair(screen.getGame().getLanguagesManager().getString("Timetrial mode"), MyGemas.Screens.Game));
		options.add(new Pair(screen.getGame().getLanguagesManager().getString("How to play"), MyGemas.Screens.HowTo));
		if (Gdx.app.getType() != ApplicationType.WebGL) {
			options.add(new Pair(screen.getGame().getLanguagesManager().getString("Exit"), MyGemas.Screens.Exit));
		}*/
		
		createMenu();
		
		// Animation times
		animTime = 0.0;
		animTotalTime = 1.0;
		animLogoTime = 1.0;
		
		gems = new Gems(screen.getWidth());
		
		readyToChange = false;
		
		isFirstExceution = true;		
				
	}
	
	public void createMenu(){
		this.menu = new Array<TextButton>();
		this.selectedOption = 0;
		TextButton buttonPlay = new TextButton(this.getScreen().getGame().getLanguagesManager().getString("Timetrial mode"), getStyleButtonMenu());			
		buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { 
            	
            	AssetLoader.selectSFXMenu.play();
            	selectedOption = 0;
            }
        });
		menu.add(buttonPlay);
		TextButton buttonHowTo = new TextButton(this.getScreen().getGame().getLanguagesManager().getString("How to play"), getStyleButtonMenu());			
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
			TextButton buttonExit = new TextButton(this.getScreen().getGame().getLanguagesManager().getString("Exit"), getStyleButtonMenu());			
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
			menu.add(buttonExit);
		}
	}
	
	public TextButtonStyle getStyleButtonMenu(){
		TextButtonStyle style = new TextButtonStyle();
		style.font= AssetLoader.fontMenu;
		
		return style;
	}
	
	private void initialize(){
		/*
		// Set positions now that we now about sizes		
		float maxWidth = 0;
		int numOptions = options.size;
		
		for (int i = 0; i < numOptions; ++i) {
			TextBounds bounds = AssetLoader.fontMenu.getBounds(options.get(i).getFirst());
			
			if (bounds.width > maxWidth) {
				maxWidth = bounds.width;
			}
		}
		
		menuStart = new Vector2((this.getScreen().getWidth() - maxWidth) / 2, 390);
		menuGap = 100;
		menuEnd = new Vector2(menuStart.x + maxWidth, 350 + options.size * menuGap);
		*/
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


	/*
	public Array<Pair<String, MyGemas.Screens>> getOptions() {
		return options;
	}
	*/
	public void setReadyToChange(boolean readyToChange) {
		this.readyToChange = readyToChange;
	}

	public boolean isReadyToChange() {
		return readyToChange;
	}


	public int getSelectedOption() {
		return selectedOption;
	}

	/*
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
*/
	public Gems getGems() {
		return gems;
	}

	public Array<TextButton> getMenu() {
		return menu;
	}
	
	
	
}
