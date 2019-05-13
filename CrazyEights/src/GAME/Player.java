package GAME;

public class Player {

		  private String name;
		  private CardCollection hand;

		  public Player(String name) {
		    this.name = name;
		    this.hand = new CardCollection(name);
		  }

		  
		  public String getName() {
		    return name;
		  }

		  
		  public CardCollection getHand() {
		    return hand;
		  }


		 
		  public void display() {
		    hand.display();
		  }

}
