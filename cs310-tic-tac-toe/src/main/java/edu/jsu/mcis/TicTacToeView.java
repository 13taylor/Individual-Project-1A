package edu.jsu.mcis;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeView extends JPanel{

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
	
	public void TicTacToeController {

		private TicTacToeModel model;
		private Scanner keyboard;
		
		/* CONSTRUCTOR */

		public TicTacToeController(TicTacToeModel model) {
			/* Initialize scanner (for console keyboard) */
			keyboard = new Scanner(System.in);
		}
		public void controlModel() {
			/* Prompt player for next move using view's showNextMovePrompt() */
			showNextMovePrompt();
			
			/* Receive and validate input, which should be read at the keyboard as
			   two integers, the row and the column (for example, "1 1" for the
			   center square of a 3 x 3 grid).  Make mark if input is valid, or show
			   error message using view's showInputError() if input is invalid. */
			
			/* INSERT YOUR CODE HERE */
			int row = keyboard.nextInt();
			int col = keyboard.nextInt();
			
			if(!model.isGameover()){
				if(model.makeMark(row, col)){
					model.makeMark(row, col);
					model.getResult();
				}
				else{
					view.showInputError();
				}
			}
		}
	
}