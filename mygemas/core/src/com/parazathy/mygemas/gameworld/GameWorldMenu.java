package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.inputhandler.InputHandlerMenu;
import com.parazathy.mygemas.screens.GameHowTo;
import com.parazathy.mygemas.screens.GameScreen;
import com.parazathy.mygemas.ui.BackGroundMenu;
import com.parazathy.mygemas.ui.Gems;
import com.parazathy.mygemas.ui.MenuButton;


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
		
	private Gems gems;	
	
	private boolean isFirstExceution;	
	
	private InputHandlerMenu inputHandler;
	
	public GameWorldMenu(Stage stage){		
		super(stage);
		state = StateMenu.Loading;
				
		// Animation times
		animTime = 0.0;
		animTotalTime = 1.0;
		animLogoTime = 1.0;
				
		gems = new Gems(Math.round(stage.getWidth()));		
		
		isFirstExceution = true;	
		
		inputHandler = new InputHandlerMenu();
				
	}
	
	private void createMenu(){		
		MenuButton buttonPlay = new MenuButton(MyGemas.getLanguagesManager().getString("Timetrial mode"), this.getStage().getWidth() ,MenuButton.OPTION.GAME);			
		buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { 
            	
            	AssetLoader.selectSFXMenu.play();
            	if(MenuButton.isReadyToChange() && MenuButton.getSelectedOption() == MenuButton.OPTION.GAME){            		
            		MyGemas.getInstance().changeScreen(new GameScreen());
            	}
            	MenuButton.setReadyToChange(true);
            	MenuButton.setSelectedOption(MenuButton.OPTION.GAME);
            }
        });
		this.getStage().addActor(buttonPlay);		
		MenuButton buttonHowTo = new MenuButton(MyGemas.getLanguagesManager().getString("How to play"),this.getStage().getWidth(),  MenuButton.OPTION.HOWTO);			
		buttonHowTo.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {     
            	AssetLoader.selectSFXMenu.play();
            	if(MenuButton.isReadyToChange() && MenuButton.getSelectedOption() == MenuButton.OPTION.HOWTO){            		
            		MyGemas.getInstance().changeScreen(new GameHowTo());
            	}
            	MenuButton.setReadyToChange(true);
            	MenuButton.setSelectedOption(MenuButton.OPTION.HOWTO);
            }
        });
		this.getStage().addActor(buttonHowTo);
		if (Gdx.app.getType() != ApplicationType.WebGL) {					
			MenuButton buttonExit = new MenuButton(MyGemas.getLanguagesManager().getString("Exit"),this.getStage().getWidth(), MenuButton.OPTION.EXIT);			
			buttonExit.addListener(new ClickListener(){
	            @Override
	            public void clicked(InputEvent event, float x, float y) {  
	            	AssetLoader.selectSFXMenu.play();
	            	if(MenuButton.isReadyToChange() && MenuButton.getSelectedOption() == MenuButton.OPTION.EXIT){
	            		MyGemas.exit();
	            	}
	            	MenuButton.setReadyToChange(true);
	            	MenuButton.setSelectedOption(MenuButton.OPTION.EXIT);
	            }
	        });				
			this.getStage().addActor(buttonExit);			
					
		}
	}
		
	private void initialize(){
		
		//Añadimos el background
		this.getStage().addActor (new BackGroundMenu (this));
					
		//Añadimos el menu
		createMenu();
		
		//Iniciamos gemas y añadimos las gemas
		gems.initialize();		
		this.getStage().addActor(gems);
		
		//Añadimos el cursor
		this.getStage().addActor(this.getCursor());
		
		//Empezamos a escuchar los eventos
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(this.getStage());
		inputMultiplexer.addProcessor(inputHandler);
		Gdx.input.setInputProcessor(inputMultiplexer);
				
		
		
				
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
	
	public Gems getGems() {
		return gems;
	}	

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		AssetLoader.disposeMenuAssets();
		
	}
	
	
	
}
