package GAME;

import java.util.Scanner;


public class main {

	  public static void main(String[] args) {

	    Eights game = new Eights();
	    Scanner in = new Scanner(System.in);
	        System.out.println(" CRAZY 8'S");
	        System.out.println();
	        System.out.println("Enter number of players: ");

	        int no_ofplayers = in.nextInt();
	        while (no_ofplayers > 7 || no_ofplayers < 2) {
	          System.err.println("Number of players must be between 3 and 7!");
	          System.out.println();
	          System.out.println("Re-enter number of players: ");
	          no_ofplayers = in.nextInt();
	       
	       }

	        for (int i = 0; i < no_ofplayers; i++) {
	        	game.equipPlayer(no_ofplayers);
	        }
	        EightsPlayer player = game.getPlayer(0);
	        while (!game.isDone()) 
	        {
	        	game.displayState();
	        	game.waitForUser();
	        	game.takeTurn(player);
	            player = game.nextPlayer(player);
	        }

	  }

}
