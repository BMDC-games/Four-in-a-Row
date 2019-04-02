package Games;

import java.util.Scanner;

public class FourInARow {

	private static Scanner nB;
	static boolean keepPlaying;
	static boolean playersTurn;
	static int roundsInGame = 0;
	public void FourInArow() 
	{
	    boolean playersTurn = true;
	    int[][] board = new int [7][8];
	   	for(int i = 0;i < board.length;i++) 
	        for(int j = 0;j < board[0].length;j++)
	        	board[i][j] = ' ';
	   	printNewBoard(board);
      	while(keepPlaying(board) && roundsInGame < (board.length)*(board[0].length)) 
		{
			try {
				nB = new Scanner(System.in);
				System.out.println("please enter the column you'd like to place you piece");
				if(playersTurn) 
					System.out.println("it is player 1 turn");
				else
					System.out.println("it is player 2 turn");
				int rowNumber = 6;
				int columnNumber = nB.nextInt()-1;
				for(int i = 6;i > -1;i--) 
				{
			       if(board[i][columnNumber] != ' ') 
			       {
			    	   rowNumber--;
			       }
				}
				 if(playersTurn) 
					{
					board[rowNumber][columnNumber] = 'o';
					}
					else
					{
				    board[rowNumber][columnNumber] = 'x';	
					}
				    playersTurn = !playersTurn;
				    roundsInGame++;	
				printNewBoard(board);
			}
			catch(Exception e) {
			    System.out.println("Error!!! \ntry again :("); 
			    System.out.println();
			}
		}
		finishTheGame(board);
	}
	public static void printNewBoard(int[][]board)
	{
		for(int i = 1;i < 9;i++)
		System.out.print(" " + i + " ");
		System.out.println();
        for (int i = 0;i < board.length;i++) 
        {
        	System.out.print("|_");
        	for (int j = 0; j < board[0].length; j++)
        	{
        	 if(j == (board[0].length -1))	
        		 System.out.print((char)board[i][j] + "|" );
        	 else {
        		 System.out.print((char)board[i][j] + "|_" );	 
        	 }
			}
			System.out.println();
       /* if you want it to look different
        *  for(int i2 = 0;i2 < 33;i2++)
        	if(i2 == 0)
            	System.out.print(" -");
            else {
        	System.out.print("-");
        }
        System.out.println();*/
        }
	 }
	public static boolean keepPlaying(int[][]board)
	{
		//this check's if someone won
		boolean keepPlaying = true;
		//up and down 
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] != ' ' && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j])
					keepPlaying = false;
			}
		}
		//right to left 
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < 5; j++) {
				if(board[i][j] != ' ' && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3])
					keepPlaying = false;
			}
		}
		 //diagonal left to right
		for (int i = 6; i > 2; i--) {
			for (int j = 0; j < 5; j++) {
				if(board[i][j] != ' ' && board[i][j] == board[i-1][j+1] && board[i][j] == board[i-2][j+2] && board[i][j] == board[i-3][j+3])
					keepPlaying = false;
			}
		}
		//diagonal right to left
		for (int i = 6; i > 2; i--) {
			for (int j = 7; j > 2; j--) {
				if(board[i][j] != ' ' && board[i][j] == board[i-1][j-1] && board[i][j] == board[i-2][j-2] && board[i][j] == board[i-3][j-3])
					keepPlaying = false;		
			}
		}
		return keepPlaying;
	}
	public static void finishTheGame(int[][]board) 
	{
		System.out.println("game over");
		if (!keepPlaying) {
			if(playersTurn)
			{
		    System.out.println("Player 2 won");
			}
			else
			{
			System.out.println("Player 1 won");	
			}
		}
		else
		{
			System.out.println("No winner");
		}
		for(int i = 0;i < board.length;i++) 
	        for(int j = 0;j < board[0].length;j++)
	        	board[i][j] = ' ';	
		 resetFIAR(board);
	}
    public static void resetFIAR(int board[][]) {
    playersTurn = true;
    roundsInGame = 0;
    
    	for(int i = 0;i < board.length;i++) 
	        for(int j = 0;j < board[0].length;j++)
	        	board[i][j] = ' ';
    }
}
