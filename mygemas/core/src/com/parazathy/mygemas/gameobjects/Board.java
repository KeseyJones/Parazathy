package com.parazathy.mygemas.gameobjects;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Board {
	private Square[][] squares;
	
	// Aux 
	private MultipleMatch matches;
	private Match[][] columns;
	private Match[][] rows;
	private Coord[] matchCoords;
	private Coord[] solCoords;
	private Array<Coord> results;
	
	public Board() {
		squares = new Square[8][8];
		
		columns = new Match[8][6];
		rows = new Match[8][6];
		for (int x = 0; x < 8; ++x) {
			for (int y = 0; y < 6; ++y) {
				columns[x][y] = new Match();
				rows[x][y] = new Match();
			}
		}
		
		matchCoords = new Coord[1000];
		solCoords = new Coord[1000];
		for (int x = 0; x < 1000; ++x) {
			matchCoords[x] = new Coord();
			solCoords[x] = new Coord();
		}
		
		results = new Array<Coord>();
		matches = new MultipleMatch();
	}
	
	public Square getSquare(int x, int y) {
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			return null;
		}
		else {
			return squares[x][y];
		}
	}
	
	public Square[][] getSquares() {
		return squares;
	}
	
	public void swap(int x1, int y1, int x2, int y2) {
//		if (x1 >= 0 && x1 < 8 &&
//			y1 >= 0 && y1 < 8 &&
//			x2 >= 0 && x2 < 8 &&
//			y2 >= 0 && y2 < 8) {
			
			Square temp = squares[x1][y1];
			squares[x1][y1] = squares[x2][y2]; 
			squares[x2][y2] = temp;
//		}
	}
	
	public void del(int x, int y) {
//		if (x >= 0 && x < 8 &&
//			y >= 0 && y < 8) {
			
			squares[x][y].setType(Square.Type.sqEmpty);
//		}
	}
	
	public void generate() {
		boolean repeat = false;
		
		do {
			repeat = false;			
			
			for (int i = 0; i < 8; ++i) {
				for (int j = 0; j < 8; ++j) {
					squares[i][j] = new Square(Square.numToType(MathUtils.random(1, 7)));
	                squares[i][j].mustFall = true;
	                squares[i][j].origY = (int)MathUtils.random(-7, -1);
	                squares[i][j].destY = j - squares[i][j].origY;
	                
				}
			}
			
			if (check().size != 0) {				
				repeat = true;
			}
			
			else if (solutions().size == 0) {				
				repeat = true;
			}
		} while(repeat);
				
	}
	
	public void calcFallMovements() {
		for (int x = 0; x < 8; ++x) {
			// From bottom to top
			for (int y = 7; y >= 0; --y) {
				// origY stores the initial position in the fall
				squares[x][y].origY = y;
				
				// If square is empty, make all the squares above it fall
				if (squares[x][y].equals(Square.Type.sqEmpty)) {
					for (int k = y - 1; k >= 0; --k) {
						squares[x][k].mustFall = true;
						squares[x][k].destY++;
						
						if (squares[x][k].destY > 7)
						{
							System.out.println("WARNING");
						}
					}
				}
			}
		}
	}
	
	public void applyFall() {
		for (int x = 0; x < 8; ++x) {
			// From bottom to top in order not to overwrite squares
			for (int y = 7; y >= 0; --y) {
				if (squares[x][y].mustFall == true &&
					!squares[x][y].equals(Square.Type.sqEmpty)) {
					int y0 = squares[x][y].destY;
					
					if (y + y0 > 7)
					{
						System.out.println("WARNING");
					}
					
					squares[x][y + y0] = squares[x][y];
					squares[x][y] = new Square(Square.Type.sqEmpty);
				}
			}
		}
	}
	
	public void fillSpaces() {
		for(int x = 0; x < 8; ++x){
	        // Count how many jumps do we have to fall
	        int jumps = 0;

	        for(int y = 0; y < 8; ++y){
	            if(!squares[x][y].equals(Square.Type.sqEmpty)) {
	            	break;
	            }
	            ++jumps;
	        }

	        for(int y = 0; y < 8; ++y){
	            if(squares[x][y].equals(Square.Type.sqEmpty)) {
	                squares[x][y].setType(Square.numToType(MathUtils.random(1, 7)));
	                squares[x][y].mustFall = true;  
	                squares[x][y].origY = y - jumps;
	                squares[x][y].destY = jumps;
	            }       
	        }
	    }   
	}
	
	public MultipleMatch check() {
	    int k;
    
	    matches.clear();
	    int currCoord = 0;
	    
	    // First, we check each row (horizontal)
	    for (int y = 0; y < 8; ++y) {

	        for (int x = 0; x < 6; ++x) {

	            Match currentRow = rows[y][x];
	            currentRow.clear();
	            matchCoords[currCoord].x = x;
	            matchCoords[currCoord].y = y;
	            currentRow.add(matchCoords[currCoord]);
	            ++currCoord;

	            for (k = x + 1; k < 8; ++k) {
	                if (squares[x][y].equals(squares[k][y]) &&
	                   !squares[x][y].equals(Square.Type.sqEmpty)) {
	                	matchCoords[currCoord].x = k;
	    	            matchCoords[currCoord].y = y;
	                    currentRow.add(matchCoords[currCoord]);
	                    ++currCoord;
	                }
	                else {
	                    break;
	                }
	            }

	            if (currentRow.size > 2) {
	                matches.add(currentRow);
	            }

	            x = k - 1;
	        }   
	    }

	    for (int x = 0; x < 8; ++x) {
	        for (int y = 0; y < 6; ++y) {

	            Match currentColumn = columns[x][y];
	            currentColumn.clear();
	            matchCoords[currCoord].x = x;
	            matchCoords[currCoord].y = y;
	            currentColumn.add(matchCoords[currCoord]);
	            ++currCoord;

	            for (k = y + 1; k < 8; ++k) {
	                if (squares[x][y].equals(squares[x][k]) &&
	                	!squares[x][y].equals(Square.Type.sqEmpty)) {
	                	matchCoords[currCoord].x = x;
	    	            matchCoords[currCoord].y = k;
	                	currentColumn.add(matchCoords[currCoord]);
	                	++currCoord;
	                }
	                else {
	                    break;
	                }
	            }

	            if (currentColumn.size > 2) {
	                matches.add(currentColumn);
	            }

	            y = k - 1;
	        }
	    }

	    return matches;
	}
	
	public Array<Coord> solutions() {
		results.clear();
		int currCoord = 0;
		
	    if(check().size != 0){
	    	solCoords[currCoord].x = -1;
	    	solCoords[currCoord].y = -1;
	        results.add(solCoords[currCoord]);
	        ++currCoord;
	        return results;
	    }

	    /* 
	       Check all possible boards
	       (49 * 4) + (32 * 2) although there are many duplicates
	    */
	    for(int x = 0; x < 8; ++x){
	        for(int y = 0; y < 8; ++y){
	        
	            // Swap with the one above and check
	            if (y > 0) {
	                swap(x, y, x, y - 1);
	                if (check().size != 0) {
	                	solCoords[currCoord].x = x;
	        	    	solCoords[currCoord].y = y;
	                    results.add(solCoords[currCoord]);
	                    ++currCoord;
	                }
	                
	                swap(x, y, x, y - 1);
	            }

	            // Swap with the one below and check
	            if (y < 7) {
	                swap(x, y, x, y + 1);
	                if (check().size != 0) {
	                	solCoords[currCoord].x = x;
	        	    	solCoords[currCoord].y = y;
	                    results.add(solCoords[currCoord]);
	                    ++currCoord;
	                }
	                
	                swap(x, y, x, y + 1);
	            }

	            // Swap with the one on the left and check
	            if (x > 0) {
	                swap(x, y, x - 1, y);
	                if (check().size != 0) {
	                	solCoords[currCoord].x = x;
	        	    	solCoords[currCoord].y = y;
	                    results.add(solCoords[currCoord]);
	                    ++currCoord;
	                }
	                
	                swap(x, y, x - 1, y);
	            }

	            // Swap with the one on the right and check
	            if (x < 7) {
	                swap(x, y, x + 1, y);
	                if (check().size != 0) {
	                	solCoords[currCoord].x = x;
	        	    	solCoords[currCoord].y = y;
	                    results.add(solCoords[currCoord]);
	                    ++currCoord;
	                }
	                
	                swap(x, y, x + 1, y);
	            }
	        }
	    }

	    return results;
	}
	
	public void endAnimation() {
		for(int x = 0; x < 8; ++x){
	        for(int y = 0; y < 8; ++y){
	            squares[x][y].mustFall = false;
	            squares[x][y].origY = y;
	            squares[x][y].destY = 0;
	        }
	    }
	}
	
	public String toString() {
		String string = "";
		
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				string += "(" + squares[i][j].origY + ", " + squares[i][j].destY + ")  ";
			}
			
			string += "\n";
		}
		
		string += "\n";
		
		return string;
	}
}
