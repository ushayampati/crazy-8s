package GAME;
import java.util.ArrayList;
import java.util.Scanner;

public class Eights {

  private CardCollection drawPile;
  private CardCollection discardPile;
  private Scanner in;
  private ArrayList<EightsPlayer> players;

  public Eights() {
    Deck deck = new Deck("Deck");
    deck.shuffle();
    this.players = new ArrayList<EightsPlayer>();
    discardPile = new CardCollection("Discards");
    deck.deal(discardPile, 1);
    drawPile = new CardCollection("Draw pile");
    deck.dealAll(drawPile);
    in = new Scanner(System.in);
  }


  
   // adds the player to array list<Eights player>
   
  public void createPlayer(EightsPlayer player) {
    players.add(player);
  }


   // waits for users input
  
  public String playerName() {
    System.out.println("Enter player name: ");
    String name = in.next();
    while (name == "") {
      name = in.nextLine();
    }
    return name;
  }

   // The player gets 5 cards to his hand.
  
  public void equipPlayer(int players) {
	  if(players == 2)
	  {
		  EightsPlayer player = new EightsPlayer(playerName());
		  createPlayer(player);
		  drawPile.deal(player.getHand(), 7);
   
	  }
	  else
	  {
		  EightsPlayer player = new EightsPlayer(playerName());
		  createPlayer(player);
		  drawPile.deal(player.getHand(), 5);
		  
	  }
  }

  
   //Returns a player from the array at a given index. 
  
  public EightsPlayer getPlayer(int i) {
    return players.get(i);
  }

  
   // Returns index of the player.
  public int getPlayerIndex(EightsPlayer player) {
    return players.indexOf(player);
  }


  // Returns true if hand is empty.
  public boolean isDone() {
    for (int x = 0; x < players.size(); x++) {
      if (getPlayer(x).getHand().empty()) {
        return true;
      }
    }
    return false;
  }

 
  //Moves cards from the discard pile to the draw pile and shuffles.
  
  public void reshuffle() {

    Card convert = discardPile.popCard();
    EightsCard prev = new EightsCard(0, 0);
    prev = prev.convert(convert);
    discardPile.dealAll(drawPile);
    discardPile.addCard(prev);
    drawPile.shuffle();
  }

  
   // Returns a card from the draw pile.
  public EightsCard draw() {
    if (drawPile.empty()) {
      reshuffle();
    }
    Card convert = drawPile.popCard();
    EightsCard prev = new EightsCard(0, 0);
    return prev.convert(convert);
  }

  // Switches players turn.
   
  public EightsPlayer nextPlayer(EightsPlayer current) {
    if (getPlayerIndex(current) < players.size() - 1) {
      return getPlayer(getPlayerIndex(current) + 1);
    }
    if (getPlayerIndex(current) == players.size() - 1) {
      return getPlayer(getPlayerIndex(current) + 1 - players.size());
    }
    return null;
  }

  //Displays discarded pile cards, draw pile card picked by the player and states cards left in draw pile
  public void displayState() {
    for (int x = 0; x < players.size(); x++) {
      getPlayer(x).display();
    }
    discardPile.display();
    System.out.print("Draw pile: ");
    System.out.println(drawPile.size() + " cards");
  }

   // Waits for the user to press enter.
  public void waitForUser() {
    in.nextLine();
  }

  //operations when a player takes his turn
  public void takeTurn(EightsPlayer player) {
    Card convert = discardPile.last();
    EightsCard prev = new EightsCard(0, 0);
    prev = prev.convert(convert);    
    EightsCard next = player.play(this, prev);
    if(next != null)
    {
    discardPile.addCard(next);
    }

    System.out.println(player.getName() + " plays " + next);
    System.out.println();
  }



  
}