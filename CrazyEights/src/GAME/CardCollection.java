package GAME;
import java.util.ArrayList;
import java.util.Random;


public class CardCollection {

  private String label;
  private ArrayList<Card> cards;

 
  public CardCollection(String label) {
    this.label = label;
    this.cards = new ArrayList<Card>();
  }

  public String getLabel() {
    return label;
  }

 
  public Card getCard(int i) {
	  try {
		  return cards.get(i);  
	  }catch(Exception e)
	  {
		  System.out.println("please enter the valid index to drop the card or press 10 to pick the card");
		  return null;
	  }
	  
    
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public Card popCard(int i) {
    return cards.remove(i);
  }


  public Card popCard() {
    int i = size() - 1;
    return popCard(i);
  }

  
  public int size() {
    return cards.size();
  }

  // return true if cards is empty 
  
  public boolean empty() {
    return cards.size() == 0;
  }

  // create duplicate collection
  public void deal(CardCollection c, int n) {
    for (int i = 0; i < n; i++) {
      Card card = popCard();
      c.addCard(card);
    }
  }

  public void dealAll(CardCollection that) {
    int n = size();
    deal(that, n);
  }



  public Card last() {
    int i = size() - 1;
    return cards.get(i);
  }

  public void swapCards(int i, int j) {
    Card temp = cards.get(i);
    cards.set(i, cards.get(j));
    cards.set(j, temp);
  }
   
  public void shuffle() {
    Random random = new Random();
    for (int i = size() - 1; i > 0; i--) {
      int j = random.nextInt(i);
      swapCards(i, j);
    }
  }

  
  public String toString() {
    return label + ": " + cards.toString();
  }
  
  public void display() {
    System.out.println(label + ": ");
    for (Card card: cards) {
      System.out.println(card);
    }
    System.out.println();
  }

}