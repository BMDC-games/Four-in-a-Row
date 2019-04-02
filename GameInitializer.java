package Games;

import java.util.Scanner;

public class GameInitializer {
	public static Scanner s;
	public static void main(String[] args) {
		int a = 1;
		int input;
    	s = new Scanner(System.in);
    	System.out.println("Hello and welcome \nTo pick a game you must enter a number");
    	while(a == 1) {
    	System.out.println("for tic tac toe enter 1 \nfor four in a row enter 2 ");
    	input = s.nextInt();
    	switch(input) {
    	case 1:
    		TicTacToe ttt = new TicTacToe();
        	ttt.ticTacToe();
        	break;
    	case 2:
	    	FourInARow fiar = new FourInARow();
	    	fiar.FourInArow();
	    	break;
    	}
    	System.out.println("To play again enter 1 \n"
    			         + "To exit enter 0");
         a = s.nextInt();
    	}
  }

}
