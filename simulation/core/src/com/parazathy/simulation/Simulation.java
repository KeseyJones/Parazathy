package com.parazathy.simulation;


import com.badlogic.gdx.Game;
import com.parazathy.simulation.screen.GameScreen;

public class Simulation extends Game {	
			
	private GameScreen screen;
	
	@Override
	public void create () {
		
		screen = new GameScreen();
		setScreen(screen);
	}
	
}
