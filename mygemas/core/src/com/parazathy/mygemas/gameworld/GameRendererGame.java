package com.parazathy.mygemas.gameworld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.parazathy.mygemas.MyGemas;
import com.parazathy.mygemas.gameobjects.Square.Type;
import com.parazathy.mygemas.helpers.Animation;
import com.parazathy.mygemas.helpers.AssetLoader;


public class GameRendererGame extends GameRenderer{
	
	private static final Vector2 gemsInitial = new Vector2(572, 68);
	private Color imgColor = Color.WHITE.cpy();
	
	
	public GameRendererGame(GameWorldGame world){		
		super(world);		
		
	}

	@Override
	public void render(float runTime) {
		GameWorldGame world = (GameWorldGame)this.getWorld();
		
		this.initRender();
			
		this.getStage().getBatch().begin();
				
		if (world.getState() == GameWorldGame.StateGame.Loading) {			
			this.renderLoading();
			world.getCursor().draw(this.getStage().getBatch(), 1);
		}else{			
			this.getStage().getBatch().draw(AssetLoader.imgBoardGame, 0, 0);
			drawPoints(world);
			drawTime(world);
			drawBoard(world);
		}
						
		this.getStage().getBatch().end();
		
		//Draw Buttons and cursor
		this.getStage().draw();
		
	}
	
	
	private TextureRegion selectImageGem(Type type){
		
		TextureRegion img = null;
		 // Check the type of each square and
        // save the proper image in the img pointer
        switch (type) {
        case sqWhite:
            img = AssetLoader.imgWhiteGame;
            break;

        case sqRed:
            img =  AssetLoader.imgRedGame;
            break;

        case sqPurple:
            img =  AssetLoader.imgPurpleGame;
            break;

        case sqOrange:
            img =  AssetLoader.imgOrangeGame;
            break;

        case sqGreen:
            img =  AssetLoader.imgGreenGame;
            break;

        case sqYellow:
            img =  AssetLoader.imgYellowGame;
            break;

        case sqBlue:
            img =  AssetLoader.imgBlueGame;
            break;
		default:
			break;

        } // switch
        
        return img;
	}
	
	
	private void drawBoard(GameWorldGame world){
		// Draw board
		TextureRegion img = null;
		Color imgColor = Color.WHITE.cpy();
		
		if (world.getState() != GameWorldGame.StateGame.ShowingScoreTable) {
			// Go through all of the squares
	        for (int i = 0; i < 8; ++i) {
	            for (int j = 0; j < 8; ++j) {

	            	img = selectImageGem(world.getBoard().getSquare(i, j).getType());
	                
	             // Now, if img is not NULL (there's something to draw)
	                if (img != null) {
	                    // Default positions
	                    float imgX = gemsInitial.x + i * 76;
	                    float imgY = gemsInitial.y + j * 76;	                   
	                    
	                    // In the initial state, the gems fall vertically
	                    // decreasing its speed
	                    if (world.getState() == GameWorldGame.StateGame.InitialGems) {
	                        imgY = Animation.easeOutQuad(world.getAnimTime(),
							                             gemsInitial.y + world.getBoard().getSquares()[i][j].origY * 76,
							                             world.getBoard().getSquares()[i][j].destY * 76,
							                             world.getAnimTotalInitTime());                            
	                    }
	                    
	                    /*

	                    // In the ending states, gems fall vertically, 
	                    // increasing their speed
	                    else if (world.getState() == GameWorldGame.StateGame.DisappearingBoard || world.getState() == GameWorldGame.StateGame.TimeFinished) {
	                        imgY = Animation.easeInQuad(_animTime,
	                        						     gemsInitial.y + _board.getSquares()[i][j].origY * 76,
							                            _board.getSquares()[i][j].destY * 76,
							                            _animTotalInitTime); 
	                    }

	                    else if ((world.getState() == GameWorldGame.StateGame.Wait ||
	                    		world.getState() == GameWorldGame.StateGame.SelectedGem ||
	                    				world.getState() == GameWorldGame.StateGame.FallingGems)
	                    		  && world.getBoard().getSquare(i, j).mustFall) {
	                        
	                    	imgY = Animation.easeOutQuad(_animTime,
							                             gemsInitial.y + _board.getSquares()[i][j].origY * 76,
							                             _board.getSquares()[i][j].destY * 76,
							                             _animTotalTime); 
	                    }                    

	                    // When two gems are switching
	                    else if (world.getState() == GameWorldGame.StateGame.ChangingGems) {
	                        if(i == _selectedSquareFirst.x &&  j == _selectedSquareFirst.y) {

	                            imgX = Animation.easeOutQuad(_animTime,
	                            							 gemsInitial.x + i * 76,
	                            		                     (_selectedSquareSecond.x - _selectedSquareFirst.x) * 76,
	                            		                     _animTotalTime);

	                            imgY = Animation.easeOutQuad(_animTime,
	                            							 gemsInitial.y + j * 76,
	                            							 (_selectedSquareSecond.y - _selectedSquareFirst.y) * 76,
	                            							 _animTotalTime);

	                        }

	                        else if (i == _selectedSquareSecond.x && j == _selectedSquareSecond.y){

	                            imgX = Animation.easeOutQuad(_animTime,
	                            							 gemsInitial.x + i * 76,
	                            							 (_selectedSquareFirst.x - _selectedSquareSecond.x) * 76,
	                            							 _animTotalTime);

	                            imgY = Animation.easeOutQuad(_animTime,
	                            							 gemsInitial.y + j * 76,
	                            							 (_selectedSquareFirst.y - _selectedSquareSecond.y) * 76,
	                            							 _animTotalTime);
	                        }
	                    }
	                    
	                    else if (world.getState() == GameWorldGame.StateGame.DisappearingGems) {
	                    	// Winning gems disappearing
	                    	if (_groupedSquares.isMatched(new Coord(i, j))) {
	                    		_imgColor.a = 1.0f - (float)(_animTime/_animTotalTime);
	                    	}
	                    }
	                    */
	                    // Finally draw the image
	                    this.getStage().getBatch().setColor(imgColor);
	                    this.getStage().getBatch().draw(img, imgX, imgY);
	                    imgColor.a = 1.0f;
	                    this.getStage().getBatch().setColor(imgColor);

	                } // End if (img != NULL)
	                
	                img = null;
	            }
	            
	            /*
	            
	            // If the mouse is over a gem
	            if (overGem((int)_mousePos.x, (int)_mousePos.y)) {
	                // Draw the selector over that gem
	            	Coord coord = getCoord((int)_mousePos.x, (int)_mousePos.y);
	                batch.draw(_imgSelector,
	                		  (int)gemsInitial.x + coord.x * 76,
	                		  (int)gemsInitial.y + coord.y * 76);
	            }
	            
	            
	            
	            // If a gem was previously clicked
	            if(_state == State.SelectedGem){
	                // Draw the tinted selector over it
	            	batch.setColor(1.0f, 0.0f, 1.0f, 1.0f);
	                batch.draw(_imgSelector,
	                		   (int)gemsInitial.x + _selectedSquareFirst.x * 76,
	                		   (int)gemsInitial.y + _selectedSquareFirst.y * 76);
	                batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);
	            }
	            */
	        }
	        
	        drawHint(world);
		}
	}
	
	
	private void drawHint(GameWorldGame world){
		/*
		if (_showingHint > 0.0) {
            // Get the opacity percentage
            float p = (float)(_showingHint / _animHintTotalTime);

            float x = gemsInitial.x + _coordHint.x * 76;
            float y = gemsInitial.y + _coordHint.y * 76;

            _imgColor.a = 1.0f - p;
            batch.setColor(_imgColor);
            batch.draw(_imgSelector, x, y);
            _imgColor.a = 1.0f;
            batch.setColor(_imgColor);
        }
        */
	}
	
	private void drawTime(GameWorldGame world){
		this.getStage().getBatch().draw(AssetLoader.imgTimeBackgroundGame, 70, 215);
		AssetLoader.fontTextGame.draw(this.getStage().getBatch(), MyGemas.getLanguagesManager().getString("Time left"), 78, 180);
		 
		AssetLoader.fontTimeGame.draw(this.getStage().getBatch(),
				world.getTxtTime(),
				390 - AssetLoader.fontTimeGame.getBounds(world.getTxtTime()).width,
				237);
	}
	
	private void drawPoints(GameWorldGame world){
		this.getStage().getBatch().draw(AssetLoader.imgScoreBackgroundGame, 70, 75);
		AssetLoader.fontTextGame.draw(this.getStage().getBatch(), MyGemas.getLanguagesManager().getString("Points"), 78, 40);
		AssetLoader.fontScoreGame.draw(this.getStage().getBatch(),
						"" + world.getPoints(),
						452 - AssetLoader.fontScoreGame.getBounds("" + world.getPoints()).width,
						93);
	}

}
