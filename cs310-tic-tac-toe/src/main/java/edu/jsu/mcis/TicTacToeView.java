package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {

        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
        System.out.print("\n  ");
        for(int h = 0; h < model.getWidth(); h++){
            System.out.print(h);
        }
        System.out.println("\n");
        for(int r = 0; r < model.getWidth(); r++){
			System.out.print(r + " ");
            for(int c = 0; c < model.getWidth(); c++){
                System.out.print(model.getMark(r, c));		
            }
            System.out.print("\n");
        }
		System.out.print("\n\n");
    }


    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
        if(model.isXTurn() == true){
            System.out.println("Player 1 (X) Move:");
            System.out.println("Enter the row and column numbers, separated by a space:");
        }
        else{
            System.out.println("Player 2 (O) Move:");
            System.out.println("Enter the row and column numbers, separated by a space:");
        }
        

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
        System.out.println("ERROR, INVALID MOVE!");
        
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}