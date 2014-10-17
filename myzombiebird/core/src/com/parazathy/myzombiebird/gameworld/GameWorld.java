package com.parazathy.myzombiebird.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.parazathy.myzombiebird.gameobjects.Bird;
import com.parazathy.myzombiebird.gameobjects.ScrollHandler;
import com.parazathy.myzombiebird.myzbhelpers.AssetLoader;

public class GameWorld {
	
	public enum GameState {

	    MENU, READY, RUNNING, GAMEOVER, HIGHSCORE

	}

	private Bird bird;
	private ScrollHandler scroller;
	private Rectangle ground;
	private int score = 0;
	private float runTime = 0;
	private int midPointY;
	private GameRenderer renderer;

	private GameState currentState;
	
	
	public GameWorld(int midPointY) {
		currentState = GameState.MENU;
		this.midPointY = midPointY;
		bird = new Bird(33, midPointY - 5, 17, 12);
		// The grass should start 66 pixels below the midPointY
		scroller = new ScrollHandler(this, midPointY + 66);
		ground = new Rectangle(0, midPointY + 66, 137, 11);
	}
	
	public void update(float delta) {
		runTime += delta;
		
        switch (currentState) {
        case READY:
        case MENU:	
            updateReady(delta);
            break;

        case RUNNING:
            updateRunning(delta);
            break;
        default:
            updateRunning(delta);
            break;
        }

    }
	
	private void updateReady(float delta) {
		bird.updateReady(runTime);
        scroller.updateReady(delta);
    }

	public void updateRunning(float delta) {		
		if (delta > .15f) {
			delta = .15f;
		}

		bird.update(delta);
		scroller.update(delta);

		if (scroller.collides(bird) && bird.isAlive()) {
			scroller.stop();
			bird.die();
			AssetLoader.dead.play();
			renderer.prepareTransition(255, 255, 255, .3f);

			AssetLoader.fall.play();
		}

		if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
			
			if (bird.isAlive()) {
				AssetLoader.dead.play();
				renderer.prepareTransition(255, 255, 255, .3f);

				bird.die();
			}

			scroller.stop();			
			bird.decelerate();
			currentState = GameState.GAMEOVER;
			
			if (score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
		}
	}
	
	public boolean isHighScore() {
	    return currentState == GameState.HIGHSCORE;
	}

	public Bird getBird() {
		return bird;

	}

	public ScrollHandler getScroller() {
		return scroller;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int increment) {
		score += increment;
	}
	
	public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }
    
    public void ready() {
        currentState = GameState.READY;
		renderer.prepareTransition(0, 0, 0, 1f);
    }

    public void restart() {        
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        ready();
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }   

    public boolean isMenu() {
        return currentState == GameState.MENU;
    }
    
    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }
    
    public int getMidPointY() {
        return midPointY;
    }

	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}
}
