package Games;

import java.util.Scanner;

public class TicTacToe {
	private static Scanner pOB;
	static boolean playersTurn = true;
	static boolean keepPlaying = true;
	static int roundsInGame = 0;
	public void ticTacToe() {
		/* the real number of rounds in the game should be 9 unless there's an error.
		 * every time the while loop will run the whole way through the roundsInGame will go up by one.
		 * meaning if every move is legal the game will only run 9 times.
		 * every time there is an illegal move the count will not go up.
		 * making sure there will only be 9 legal moves and limitless illegal ones.
		 */
		int [] board = new int [9];
		for(int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		 printBoard();
		   System.out.println("player 1 start's");
		   try {
				while (keepPlaying && roundsInGame < board.length) {
					pOB = new Scanner(System.in);
					System.out.println("please enter the place you'd like to place your peice");
					int placeOnBoard = pOB.nextInt()-1;
					if(board[placeOnBoard] == 'x' || board[placeOnBoard] == 'o') {
						System.out.println(" Error \n That space is allready occupied :( \n please try again");
						printNewBoard(board);
						System.out.println();
						System.out.println();
					}else {
					if(playersTurn) {
						board[placeOnBoard] = 'x';
					}else {
						board[placeOnBoard] = 'o';
					}
					 printNewBoard(board);
				     keepPlaying = keepPlaying(board);
				     playersTurn = !playersTurn;
				     roundsInGame++;
					}
		    	}
		   }catch(Exception e) {
				   System.out.println("Error!!! \ntry again :("); 
				   System.out.println();
		   }
			finishTheGame(board);
      	}
	static void printNewBoard (int[] board) {
		for (int i = 0; i < board.length; i += 3) {
			System.out.println((char)board[i] + " | " + (char)board[i+1] + " | " + (char)board[i+2]);
		if(i != 2)
				System.out.println("---------");
		}
	}
	static void printBoard () {
		System.out.println("1" + " | " + "2" + " | " + "3" 
			             + "\n---------\n"
				         + "4" + " | " + "5" + " | " + "6"
			             + "\n---------\n"
		   	             + "7" + " | " + "8" + " | " + "9");
	             
	}
	static boolean keepPlaying (int[] board) {
		boolean keepPlaying = true;
		
		for(int i = 0;i < 3;i = i + 3) { 
			 if((char)board[i] == (char)board[i+1] && (char)board[i+1] == (char)board[i+2] &&((char)board[i]) != (' ')) {
		    	keepPlaying = false;
			 }
	    for(int ij = 0;ij < 3;ij++) {
		     if((char)board[ij] == (char)board[ij+3] && (char)board[ij+3] == (char)board[ij+6] && ((char)board[ij]) != (' '))
		        keepPlaying = false;
		     }   
		if((char)board[0] == (char)board[4] && (char)board[4] == (char)board[8] && ((char)board[0]) != (' '))
		   keepPlaying = false;
		if( (char)board[2] == (char)board[4] && (char)board[4] == (char)board[6] && ((char)board[2]) != (' '))
		   keepPlaying = false;
	     }
		return keepPlaying;
	}
	static void finishTheGame(int[]board) {
		System.out.println("game over");
		if(keepPlaying) {
			System.out.println("No winner");
		}else {
			if(!playersTurn) {
				System.out.println("player 1 won");
			}else {
				System.out.println("player 2 won");
			}
    	}
		resetTTT(board);
	} 
	static void resetTTT(int board[]) {
		roundsInGame = 0;
		playersTurn = true;
		keepPlaying = true;
		for(int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
	}
}
