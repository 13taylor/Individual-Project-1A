package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
		Mark[][] grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid.length; c++){
				grid[r][c] = Mark.EMPTY;
			}
			System.out.println();
		}
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
		if(isValidSquare(row, col) == true){
			if(xTurn == true){
				grid[row][col] = Mark.X;
				xTurn = false;  				
			}
			else{
				grid[row][col] = Mark.O;
				xTurn = true;
			}
                        return true;
		}
		else{
			System.out.println("Invalid Move, Try Again.");
                        return false;
		}

        //return false; /* remove this line! */
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		if(row < width || col < width){
			return true;
		}
		else{
			return false; /* remove this line! */
        }
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
		if(grid[row][col] == Mark.EMPTY){
			return false;
		}
		else{
			return true;
		}

        //return false; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        Mark myMark = grid[row][col];
		return myMark;
		

       // return null; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
        if(isMarkWin(Mark.X) == true){
            return Result.X;
        }
        else if(isMarkWin(Mark.O) == true){
            return Result.O;
        }
        else if(isTie()){
            return Result.TIE;
        }
        else{
            return Result.NONE;
        }
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
        //Horzontal
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid.length; c++){
                if(grid[r][c] != mark){
                    return false;
                }
            }
        }
        //Diagnol 
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c != r; c++){
                if(r == c){
                    if(grid[r][c] != mark){
                        return false;
                    }
                }
            }
        }
        for(int r = grid.length; r < 0; r--){
            for(int c = 0; c < grid.length; c++){
                if(grid[r][c] != mark){
                    return false;
                }
            }
        }
        //Vertical
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid.length; c++){
                if(grid[c][r] != mark){
                    return false;
                }
            }
        }
        return true;

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++)
                if(grid[r][c] == Mark.EMPTY){
                    return false;
                }
        }

        return true; /* remove this line! */
        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}