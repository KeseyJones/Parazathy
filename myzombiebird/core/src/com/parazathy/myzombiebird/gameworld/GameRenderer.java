package com.parazathy.myzombiebird.gameworld;

import java.util.List;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.parazathy.myzombiebird.gameobjects.Bird;
import com.parazathy.myzombiebird.gameobjects.Grass;
import com.parazathy.myzombiebird.gameobjects.Pipe;
import com.parazathy.myzombiebird.gameobjects.ScrollHandler;
import com.parazathy.myzombiebird.myzbhelpers.AssetLoader;
import com.parazathy.myzombiebird.myzbhelpers.InputHandler;
import com.parazathy.myzombiebird.tweenaccessors.Value;
import com.parazathy.myzombiebird.tweenaccessors.ValueAccessor;
import com.parazathy.myzombiebird.ui.SimpleButton;

public class GameRenderer {

	private GameWorld myWorld;	
	private ShapeRenderer shapeRenderer;	

	private int midPointY;	

	// Game Objects
	private Bird bird;
	private ScrollHandler scroller;
	private Grass frontGrass, backGrass;
	private Pipe pipe1, pipe2, pipe3;

	// Game Assets
	private TextureRegion bg, grass, birdMid, skullUp, skullDown, bar, ready,
			zbLogo, gameOver, highScore, scoreboard, star, noStar, retry;
	private Animation birdAnimation;

	// Tween stuff
    private TweenManager manager;
    private Value alpha = new Value();

    // Buttons
    private List<SimpleButton> menuButtons;
	private Color transitionColor;
	
	private Stage stage;

	public GameRenderer(GameWorld world, Stage stage) {
		this.myWorld = world;
		this.stage = stage;
		this.midPointY = this.myWorld.getMidPointY();
		
		this.menuButtons = ((InputHandler) Gdx.input.getInputProcessor())
	                .getMenuButtons();
		this.stage.getBatch().setProjectionMatrix(stage.getCamera().combined);		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(stage.getCamera().combined);

		// Call helper methods to initialize instance variables
		initGameObjects();
		initAssets();

		transitionColor = new Color();
		prepareTransition(255, 255, 255, .5f);
	}
		
	private void initGameObjects() {
		bird = myWorld.getBird();
		scroller = myWorld.getScroller();
		frontGrass = scroller.getFrontGrass();
		backGrass = scroller.getBackGrass();
		pipe1 = scroller.getPipe1();
		pipe2 = scroller.getPipe2();
		pipe3 = scroller.getPipe3();
	}

	private void initAssets() {
		bg = AssetLoader.bg;
		grass = AssetLoader.grass;
		birdAnimation = AssetLoader.birdAnimation;
		birdMid = AssetLoader.bird;
		skullUp = AssetLoader.skullUp;
		skullDown = AssetLoader.skullDown;
		bar = AssetLoader.bar;
		ready = AssetLoader.ready;
		zbLogo = AssetLoader.zbLogo;
		gameOver = AssetLoader.gameOver;
		highScore = AssetLoader.highScore;
		scoreboard = AssetLoader.scoreboard;
		retry = AssetLoader.retry;
		star = AssetLoader.star;
		noStar = AssetLoader.noStar;
	}

	private void drawGrass() {
		// Draw the grass
		this.stage.getBatch().draw(grass, frontGrass.getX(), frontGrass.getY(),
				frontGrass.getWidth(), frontGrass.getHeight());
		this.stage.getBatch().draw(grass, backGrass.getX(), backGrass.getY(),
				backGrass.getWidth(), backGrass.getHeight());
	}

	private void drawSkulls() {

		this.stage.getBatch().draw(skullUp, pipe1.getX() - 1,
				pipe1.getY() + pipe1.getHeight() - 14, 24, 14);
		this.stage.getBatch().draw(skullDown, pipe1.getX() - 1,
				pipe1.getY() + pipe1.getHeight() + 45, 24, 14);

		this.stage.getBatch().draw(skullUp, pipe2.getX() - 1,
				pipe2.getY() + pipe2.getHeight() - 14, 24, 14);
		this.stage.getBatch().draw(skullDown, pipe2.getX() - 1,
				pipe2.getY() + pipe2.getHeight() + 45, 24, 14);

		this.stage.getBatch().draw(skullUp, pipe3.getX() - 1,
				pipe3.getY() + pipe3.getHeight() - 14, 24, 14);
		this.stage.getBatch().draw(skullDown, pipe3.getX() - 1,
				pipe3.getY() + pipe3.getHeight() + 45, 24, 14);
	}

	private void drawPipes() {
		this.stage.getBatch().draw(bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(),
				pipe1.getHeight());
		this.stage.getBatch().draw(bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + 45,
				pipe1.getWidth(), midPointY + 66 - (pipe1.getHeight() + 45));

		this.stage.getBatch().draw(bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(),
				pipe2.getHeight());
		this.stage.getBatch().draw(bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + 45,
				pipe2.getWidth(), midPointY + 66 - (pipe2.getHeight() + 45));

		this.stage.getBatch().draw(bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(),
				pipe3.getHeight());
		this.stage.getBatch().draw(bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + 45,
				pipe3.getWidth(), midPointY + 66 - (pipe3.getHeight() + 45));
	}

	private void drawBirdCentered(float runTime) {
		this.stage.getBatch().draw(birdAnimation.getKeyFrame(runTime), 59, bird.getY() - 15,
				bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
				bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
	}

    private void drawBird(float runTime) {

        if (bird.shouldntFlap()) {
        	this.stage.getBatch().draw(birdMid, bird.getX(), bird.getY(),
                    bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
                    bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());

        } else {
        	this.stage.getBatch().draw(birdAnimation.getKeyFrame(runTime), bird.getX(),
                    bird.getY(), bird.getWidth() / 2.0f,
                    bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
                    1, 1, bird.getRotation());
        }

    }

    private void drawMenuUI() {
    	this.stage.getBatch().draw(zbLogo, 136 / 2 - 56, midPointY - 50,
				zbLogo.getRegionWidth() / 1.2f, zbLogo.getRegionHeight() / 1.2f);

		for (SimpleButton button : menuButtons) {
			button.draw(this.stage.getBatch());
		}

    }

    private void drawScoreboard() {
    	this.stage.getBatch().draw(scoreboard, 22, midPointY - 30, 97, 37);

    	this.stage.getBatch().draw(noStar, 25, midPointY - 15, 10, 10);
    	this.stage.getBatch().draw(noStar, 37, midPointY - 15, 10, 10);
    	this.stage.getBatch().draw(noStar, 49, midPointY - 15, 10, 10);
    	this.stage.getBatch().draw(noStar, 61, midPointY - 15, 10, 10);
    	this.stage.getBatch().draw(noStar, 73, midPointY - 15, 10, 10);

		if (myWorld.getScore() > 2) {
			this.stage.getBatch().draw(star, 73, midPointY - 15, 10, 10);
		}

		if (myWorld.getScore() > 17) {
			this.stage.getBatch().draw(star, 61, midPointY - 15, 10, 10);
		}

		if (myWorld.getScore() > 50) {
			this.stage.getBatch().draw(star, 49, midPointY - 15, 10, 10);
		}

		if (myWorld.getScore() > 80) {
			this.stage.getBatch().draw(star, 37, midPointY - 15, 10, 10);
		}

		if (myWorld.getScore() > 120) {
			this.stage.getBatch().draw(star, 25, midPointY - 15, 10, 10);
		}

		int length = ("" + myWorld.getScore()).length();

		AssetLoader.whiteFont.draw(this.stage.getBatch(), "" + myWorld.getScore(),
				104 - (2 * length), midPointY - 20);

		int length2 = ("" + AssetLoader.getHighScore()).length();
		AssetLoader.whiteFont.draw(this.stage.getBatch(), "" + AssetLoader.getHighScore(),
				104 - (2.5f * length2), midPointY - 3);

	}

	private void drawRetry() {
		this.stage.getBatch().draw(retry, 36, midPointY + 10, 66, 14);
	}

	private void drawReady() {
		this.stage.getBatch().draw(ready, 36, midPointY - 50, 68, 14);
	}

	private void drawGameOver() {
		this.stage.getBatch().draw(gameOver, 24, midPointY - 50, 92, 14);
	}

	private void drawScore() {
		int length = ("" + myWorld.getScore()).length();
		AssetLoader.shadow.draw(this.stage.getBatch(), "" + myWorld.getScore(),
				68 - (3 * length), midPointY - 82);
		AssetLoader.font.draw(this.stage.getBatch(), "" + myWorld.getScore(),
				68 - (3 * length), midPointY - 83);
	}

	private void drawHighScore() {
		this.stage.getBatch().draw(highScore, 22, midPointY - 50, 96, 14);
	}

	public void render(float delta, float runTime) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Filled);

		// Draw Background color
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 136, midPointY + 66);

		// Draw Grass
		shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 66, 136, 11);

		// Draw Dirt
		shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 77, 136, 52);

		shapeRenderer.end();

		this.stage.getBatch().begin();
		this.stage.getBatch().disableBlending();

		this.stage.getBatch().draw(bg, 0, midPointY + 23, 136, 43);

		drawPipes();

		this.stage.getBatch().enableBlending();
		drawSkulls();		

		if (myWorld.isRunning()) {
            drawBird(runTime);
            drawScore();
        } else if (myWorld.isReady()) {
            drawBird(runTime);
            drawReady();
        } else if (myWorld.isMenu()) {
            drawBirdCentered(runTime);
            drawMenuUI();
        } else if (myWorld.isGameOver()) {
            drawScoreboard();
			drawBird(runTime);
			drawGameOver();
			drawRetry();
        } else if (myWorld.isHighScore()) {
            drawScoreboard();
			drawBird(runTime);
			drawHighScore();
			drawRetry();
        }

        drawGrass();

        this.stage.getBatch().end();
		drawTransition(delta);
	}

	public void prepareTransition(int r, int g, int b, float duration) {
		transitionColor.set(r / 255.0f, g / 255.0f, b / 255.0f, 1);
		alpha.setValue(1);
		Tween.registerAccessor(Value.class, new ValueAccessor());
		manager = new TweenManager();
		Tween.to(alpha, -1, duration).target(0)
				.ease(TweenEquations.easeOutQuad).start(manager);
	}

	private void drawTransition(float delta) {
		if (alpha.getValue() > 0) {
			manager.update(delta);
			Gdx.gl.glEnable(GL30.GL_BLEND);
			Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(transitionColor.r, transitionColor.g,
					transitionColor.b, alpha.getValue());
			shapeRenderer.rect(0, 0, 136, 300);
			shapeRenderer.end();
			Gdx.gl.glDisable(GL30.GL_BLEND);

		}
	}

}
