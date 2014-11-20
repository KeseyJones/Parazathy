package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.mygemas.inputhandler.InputHandlerGame;

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
	
	public GameWorldGame(Stage stage){
		super(stage);		
		
		inputHandler = new InputHandlerGame();
		Gdx.input.setInputProcessor(inputHandler);
		
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
