package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameobjects.Board;
import com.parazathy.mygemas.gameobjects.Coord;
import com.parazathy.mygemas.helpers.AssetLoader;
import com.parazathy.mygemas.inputhandler.InputHandlerGame;
import com.parazathy.mygemas.screens.GameMenu;
import com.parazathy.mygemas.ui.GameButton;

public class GameWorldGame extends GameWorld{
	
	public enum StateGame {
		Loading,
		InitialGems,
		Wait,
		SelectedGem,
		ChangingGems,
		DisappearingGems,
		FallingGems,
		DisappearingBoard,
		TimeFinished,
		ShowingScoreTable
	};
	
	private InputHandlerGame inputHandler;
	private StateGame state;	
	
	private GameButton exitButton;
	private GameButton musicButton;
	private GameButton resetButton;
	private GameButton hintButton;
	
	private boolean isFirstExceution;
	
	private int points;
	private double remainingTime;
	private String txtTime;
	
	// Selected squares
	private Coord selectedSquareFirst;
	private Coord selectedSquareSecond;
	private Board board;
	private ParticleEffectPool effectPool;
	private Array<PooledEffect> effects;
	
	// Animations
	private double animTime;
	private double animTotalTime;
	private double animTotalInitTime;
	
	public GameWorldGame(Stage stage){
		super(stage);		
		this.state = StateGame.Loading;
		this.inputHandler = new InputHandlerGame();
		this.isFirstExceution = true;	
		
		this.board = new Board();
		
		AssetLoader.loadParticleEffect();
		
		init();
		
	}
	
	private void startGame(){
		
		// Play music if it wasn't playing
		if (!AssetLoader.songGame.isPlaying()) {
			AssetLoader.songGame.setLooping(true);
			AssetLoader.songGame.play();
		}
		
		createMenu();
		
		//Añadimos el cursor
		this.getStage().addActor(this.getCursor());

		//Empezamos a escuchar los eventos
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(this.getStage());
		inputMultiplexer.addProcessor(inputHandler);
		Gdx.input.setInputProcessor(inputMultiplexer);		
				
	}
	
	private void init() {
		this.txtTime = new String("");
		this.selectedSquareFirst = new Coord(-1, -1);
		this.selectedSquareSecond = new Coord(-1, -1);
		
		effectPool = new ParticleEffectPool(AssetLoader.effect, 20, 100);
		
		effects = new Array<PooledEffect>();
		
		// Initial animation state
	    animTime = 0;

	    // Steps for short animations
	    animTotalTime = 0.3;

	    // Steps for long animations
	    animTotalInitTime = 1.0;
		
		resetGame();
	}
	
	private void resetGame() {
		// Reset score
		this.points = 0;
		
		this.remainingTime = 120; 
		
		// Generate board
		this.board.generate();
				
	}
	
	private void createMenu(){		
		this.exitButton = new GameButton(180, 600, MyGemas.getLanguagesManager().getString("Exit"), GameButton.OPTION.EXIT);
		this.exitButton.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				exitButton.setClicked(true);
				return true;
	        }
	 
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				exitButton.setClicked(false);
            	MyGemas.getInstance().changeScreen(new GameMenu());
	        }
			           
        });
		this.getStage().addActor(this.exitButton);
		this.musicButton = new GameButton(180, 515, MyGemas.getLanguagesManager().getString("Turn off music"), GameButton.OPTION.MUSIC);
		this.musicButton.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				musicButton.setClicked(true);
				return true;
	        }
	 
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				musicButton.setClicked(false);
				if (AssetLoader.songGame.isPlaying()) {
					musicButton.setText(MyGemas.getLanguagesManager().getString("Turn on music"));
					AssetLoader.songGame.stop();
	            }
	            else {
	            	musicButton.setText(MyGemas.getLanguagesManager().getString("Turn off music"));
	            	AssetLoader.songGame.setLooping(true);
	            	AssetLoader.songGame.play();
	            }	 
	        }
			           
        });
		this.getStage().addActor(this.musicButton);
		this.resetButton = new GameButton(180, 430, MyGemas.getLanguagesManager().getString("Reset"), GameButton.OPTION.RESET);
		this.resetButton.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				resetButton.setClicked(true);
				return true;
	        }
	 
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				resetButton.setClicked(false);	
				resetGame();
	        }
			           
        });
		this.getStage().addActor(this.resetButton);
		this.hintButton = new GameButton(180, 345, MyGemas.getLanguagesManager().getString("Hint"), GameButton.OPTION.HINT);
		this.hintButton.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				hintButton.setClicked(true);
				return true;
	        }
	 
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				hintButton.setClicked(false);				
	        }
			           
        });
		this.getStage().addActor(this.hintButton);
		
	}

	@Override
	public void update(float delta) {
		if(this.isFirstExceution){
			AssetLoader.loadGameAssets();
			this.isFirstExceution = false;
		}
		
		if (state == StateGame.Loading) {
			updateLoadingGame(delta);
		}		
		else{ 
			if (state == StateGame.InitialGems) {		
				updateInitialGame(delta);
			}
			
			updateTime(delta);
		}
		
		
		
	}
	
	private void updateLoadingGame(float delta){
		if (AssetLoader.assetManager.update()) {
			AssetLoader.assignGameResources();
			startGame();
			this.state = StateGame.InitialGems;
		}	
	}
	
	private void updateInitialGame(float delta){		
		
		// If animation ended
		if ((animTime += delta) >= animTotalInitTime) {
			// Switch to next state (waiting for user input)
			state = StateGame.Wait;
			board.endAnimation();
			
			// Reset animation step counter
			animTime = 0;
		}
		
	}
	
	private void updateTime(float delta){
		this.remainingTime -= delta;
		// If we are under the time limit, compute the string for the board
		if (this.remainingTime > 0) {
			int minutes = (int)(this.remainingTime / 60.0);
			int seconds = (int)(this.remainingTime - minutes * 60);
			this.txtTime = "" + minutes;
			if (seconds < 10) {
				this.txtTime += ":0" + seconds;
			}
			else {
				this.txtTime += ":" + seconds;
			}
		}// If we are over the time limit and not in a final score
		else if (this.remainingTime <= 0 && this.state != StateGame.TimeFinished && this.state != StateGame.ShowingScoreTable) {
			// End the game
			this.state = StateGame.TimeFinished;
						
		}
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		AssetLoader.disposeGameAssets();
		
	}

	public StateGame getState() {
		return state;
	}

	public int getPoints() {
		return points;
	}

	public String getTxtTime() {
		return txtTime;
	}

	public Board getBoard() {
		return board;
	}

	public double getAnimTime() {
		return animTime;
	}

	public double getAnimTotalTime() {
		return animTotalTime;
	}

	public double getAnimTotalInitTime() {
		return animTotalInitTime;
	}	
	
	
	
}
