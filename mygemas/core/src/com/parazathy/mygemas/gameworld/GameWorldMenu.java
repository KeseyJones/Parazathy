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
		MenuButton buttonPlay = new MenuButton(MyGemas.getLanguagesManager().getString("Timetrial mode"), this.getStage().getWidth() ,0);			
		buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) { 
            	
            	AssetLoader.selectSFXMenu.play();
            	MenuButton.setSelectedOption(0);
            }
        });
		this.getStage().addActor(buttonPlay);		
		MenuButton buttonHowTo = new MenuButton(MyGemas.getLanguagesManager().getString("How to play"),this.getStage().getWidth(),  1);			
		buttonHowTo.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {     
            	AssetLoader.selectSFXMenu.play();
            	if(MenuButton.isReadyToChange() && MenuButton.getSelectedOption() == 1){            		
            		MyGemas.getInstance().changeScreen(new GameHowTo());
            	}
            	MenuButton.setReadyToChange(true);
            	MenuButton.setSelectedOption(1);
            }
        });
		this.getStage().addActor(buttonHowTo);
		if (Gdx.app.getType() != ApplicationType.WebGL) {
			MenuButton buttonExit = new MenuButton(MyGemas.getLanguagesManager().getString("Exit"),this.getStage().getWidth(), 2);			
			buttonExit.addListener(new ClickListener(){
	            @Override
	            public void clicked(InputEvent event, float x, float y) {  
	            	AssetLoader.selectSFXMenu.play();
	            	if(MenuButton.isReadyToChange() && MenuButton.getSelectedOption() == 2){
	            		MyGemas.exit();
	            	}
	            	MenuButton.setReadyToChange(true);
	            	MenuButton.setSelectedOption(2);
	            }
	        });			
			this.getStage().addActor(buttonExit);
					
		}
	}
		
	private void initialize(){
		
		//Ya tenemos las fuentes. Iniciamos menu
		createMenu();
		
		//Iniciamos gemas
		gems.initialize();
		
		//Asignamos los actores
		this.getStage().addActor(gems);
		
		
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
