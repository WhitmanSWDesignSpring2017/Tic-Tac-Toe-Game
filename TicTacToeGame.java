package tictactoe2;
//NOTE: Source and class files should be in a directory that matches the package name

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * //TODO: What's the purpose of this class?
 * @author tmaule
 * @author pfernandez
 */

public class TicTacToeGame  {
    
    static Scanner reader = new Scanner(System.in);
    public static int difficulty = 0; // 0 = default, 1 = easy, 2 = hard
    private Scanner diff; // difficulty //TODO: Why do you need two different scanners?
    //NOTE: The use of color is a nice touch. You appropriately set them as constants.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
    * Plays the TicTacToe game. play() randomly determines which player (human or computer)
    * goes first, creates a new Board object, and initializes it as empty. It announces
    * which player goes first, and then asks the user to press any key and the enter key
    * to begin the game. Afterwards, the play() function proceeds with the first
    * turn (calling humanturn or computerturn), checks whether there is a win or tie, 
    * and then switches players and begins the next turn. The turns alternate until 
    * there is a win or a tie.
    * @throws TicTacToeBoard.SpaceTakenException
    */
    public void play() throws TicTacToeBoard.SpaceTakenException{
        
        boolean isHumanTurn = (Math.random() < 0.5);
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeAI computer = new TicTacToeAI();
        
        //TODO: This method is long and hard to read. Refactor into several more methods and/or fewer conditionals.
        board.initialize();
        if(isHumanTurn)
        {
            if (difficulty==1){    
                System.out.print("You go first on easy mode. \n"); 
                System.out.print(ANSI_PURPLE + "--------------------------------------------------\n" + ANSI_RESET);

            } else if (difficulty==2){
                System.out.print("You go first on Artificial Intelligence mode. \n"); 
                System.out.print(ANSI_PURPLE + "--------------------------------------------------\n" + ANSI_RESET);
            }
        }
        else
        {
            if (difficulty==1){    
                System.out.print("The computer goes first on easy mode. \n"); 
                System.out.print(ANSI_PURPLE + "--------------------------------------------------\n" + ANSI_RESET);

            } else if (difficulty==2){
                System.out.print("The computer goes first on Artificial Intelligence mode. \n");
                System.out.print(ANSI_PURPLE + "--------------------------------------------------\n" + ANSI_RESET);
            }
        }         
        String response = null;
        while (response == null){
        	System.out.println("Press any key and 'enter' to begin. ");
        	Scanner user_input = new Scanner(System.in);
        	response = user_input.toString();
        	user_input.next();
        }
        
        while(true) {
            if(isHumanTurn) {
                if (board.isTied()){
                    System.out.println(ANSI_RED + "It's a tie!" + ANSI_RESET);
                    break;
                }
                humanTurn(board);
            }
            else {                
                if (board.isTied()){
                    System.out.println(ANSI_RED + "It's a tie!" + ANSI_RESET);
                    break;
                }
                if (difficulty==1){    
                    computer.computerTurnEasy(board);
            	} else if (difficulty==2){
                    computer.computerTurnDifficult(board);
            	}
            }
            board.printBoard();
            if (isHumanTurn){
            	if (board.isWonBy('X')){
            	System.out.println(ANSI_GREEN + "The human has won!" + ANSI_RESET);
            	break;
            	}
            } else if (!isHumanTurn){
            	if (board.isWonBy('0')){
            	System.out.println(ANSI_RED + "The computer has won!" + ANSI_RESET);
            	break;
            	}
            } else if (board.isTied()){
            	System.out.println(ANSI_BLUE + "It's a tie!" + ANSI_RESET);
                break;
            }
            isHumanTurn = !isHumanTurn;
        }    
      System.out.println("=== GAME OVER ===");   
      reader.close();
    }
    
    /**
     * Gets numeric input from the user to determine where
     * to place the marker
     * @param row0rColumn
     * @param size 
     * @return input
     */
    //TODO: Could this method be static?
    public int getInput(String row0rColumn, int size) {
        while(true){
            System.out.print(ANSI_PURPLE + "What " + row0rColumn + "? (1-" + size + "): " + ANSI_RESET);
            try {
            	int input = reader.nextInt(); 
                if((input<1) || (input>3)) {
                    System.out.println(ANSI_RED + "Please enter a number in the range." + ANSI_RESET );
                    reader.nextLine();

                    continue;
                }
                return input;
            }
            catch(IllegalArgumentException | InputMismatchException a) {
                System.out.println(ANSI_RED + "Please enter an integer." + ANSI_RESET );
                reader.nextLine();

            }
        }
    }    
     
    /**
     * Accomplishes and reports the placing of an 'X' mark
     * on the TicTacToe Board in the spot that the human chose.
     * @param board //TODO: Document all parameters. Actually I'd make this one an attribute of TicTacToeGame objects.
     * @throws TicTacToeBoard.SpaceTakenException
     //TODO: Does not throw a SpaceTakenException, as that exception is caught
     */
    public void humanTurn(TicTacToeBoard board) throws TicTacToeBoard.SpaceTakenException {
      System.out.println("It's your turn.");  
      while(true){
          int row = getInput("row", 3);
          int column = getInput("column", 3);
          try {
            board.markSpace(row-1, column-1, 'X');
            System.out.println("\033[0;1m" + "You mark ("+(row)+","+(column)+").");
          	return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println(ANSI_RED + "The space is out of bounds. Please try again." + ANSI_RESET);
            } catch (TicTacToeBoard.SpaceTakenException e) {
                System.out.println(ANSI_RED + "That space is taken. Please choose another space." + ANSI_RESET);
            }
          
        	  
          }  
    }    
    
    /**
     * askLevel takes no parameters and returns nothing; it simply
     * asks for user input on what level of difficulty they want to play,
     * and accordingly modifies the public variable "difficulty"
     */
    public void askLevel(){
    	System.out.print("Which level of difficulty? (1 = Easy, 2 = Impossible): ");
    	while (difficulty != 1 && difficulty != 2){
        	diff = new Scanner(System.in);
        	difficulty = diff.nextInt();
        	if (difficulty == 1 || difficulty == 2){
        		break;
        	}
    	}
    }  
    
    /**
     * Main function that runs when the project is run; calls 'play()' to begin playing the game.
     *
     * @param args the command line arguments
     * @throws TicTacToeBoard.SpaceTakenException 
     */    
    public static void main(String[] args) throws TicTacToeBoard.SpaceTakenException {
        System.out.print(ANSI_PURPLE + "Tic-Tac-Toe Intelligent Game\n" + ANSI_RESET );
        System.out.print(ANSI_PURPLE + "--------------------------------------------------\n" + ANSI_RESET);
        System.out.print(ANSI_PURPLE + "Developers: Pablo & Tyler\n" + ANSI_RESET );
        System.out.print("Rules: You are X and the computer is 0.\n");
        TicTacToeGame Game = new TicTacToeGame();
        Game.askLevel();
    	Game.play();
    }
    
}
