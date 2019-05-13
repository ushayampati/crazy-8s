package GAME;

import java.util.Scanner;

public class EightsPlayer extends Player {

	  private CardCollection eightsHand;
	  

	  public EightsPlayer(String name) {
	    super(name);
	    eightsHand = new CardCollection(name);
	  }

	  public CardCollection getHand() {
	    return eightsHand;
	  }


	  // removes and returns a card from the player's hand
	  public EightsCard play(Eights eights, EightsCard prev) {
	    EightsCard ecard = new EightsCard(0, 0);
	    Scanner in = new Scanner(System.in);
	    ecard = ecard.convert(searchForMatch(prev));

	    if (ecard == null) {

	      ecard = drawForMatch(eights, prev);
	      return ecard;
	    }
	    return ecard;
	  }

	  //searches for the player's hand for a matching card
	  public Card searchForMatch(EightsCard prev) {
		 
		  Card card =  null;
		  System.out.println("Turn for player : " + getName() + " Tell the Index of the card to be discarded");
		  System.out.println("PRESS 10 To pic a card from Draw Pile");
		  int i = 0;
		  while(card == null)
		  {
		  Scanner in = new Scanner(System.in);  
		  i = in.nextInt();
		  if(i == 10)
		  { 
			  return null;
		  }
		  else 
		  {
			  i = i-1;
			  card = eightsHand.getCard(i);
		  } 
		  } 
	      EightsCard duplicate = new EightsCard(0,0);
	      duplicate = duplicate.convert(card);
	      if (duplicate.cardMatches(prev)) 
	      {
	        return eightsHand.popCard(i);
	      }
		
	   
	    return null;
	  }
	 

	  // Draws a single card from draw pile
	  public EightsCard drawForMatch(Eights eights, EightsCard prev) {
	    while (true) {
	      EightsCard card = eights.draw();
	      System.out.println(getName() + " draws " + card);
	      if (card.cardMatches(prev)) {
	        return card;
	      }
	      else
	      {	  
	      eightsHand.addCard(card);
	      return null;
	    }
	   }
	  }
	  
	  public int score() {
		    int sum = 0;
		    for (int i = 0; i < eightsHand.size(); i++) {
		      Card card = eightsHand.getCard(i);
		      int rank = card.getRank();
		      if (rank == 8) {
		        sum += 0;
		      } else if (rank > 10) {
		        sum += 10;
		      } else {
		        sum += rank;
		      }
		    }
		    return sum;
		  }

		  
		  public void displayScore() {
		    System.out.println(getName() + " has " + score() + " points");
		  }
	  
	  
	  
	  public void display() {
	    getHand().display();
	  }

	}