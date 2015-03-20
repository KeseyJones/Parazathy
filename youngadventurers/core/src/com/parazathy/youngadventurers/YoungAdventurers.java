package com.parazathy.youngadventurers;

import com.badlogic.gdx.Game;
import com.parazathy.youngadventurers.screens.GameScreen;

public class YoungAdventurers extends Game {	
	
	private GameScreen screen;

	@Override
	public void create () {

		screen = new GameScreen();
		setScreen(screen);
	}
}
