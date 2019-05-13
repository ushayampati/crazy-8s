package GAME;

public class Card {
	
	 public static final String[] RANKS = {
		      null, "Ace", "2", "3", "4", "5", "6", "7",
		      "8", "9", "10", "Jack", "Queen", "King"};
		  public static final String[] SUITS = {
		      "Clubs", "Diamonds", "Hearts", "Spades"};

		  private final int rank;
		  private final int suit;

		  public Card(int rank, int suit) {
		    this.rank = rank;
		    this.suit = suit;
		  }

		  public int getRank() {
		    return rank;
		  }

		  public int getSuit() {
		    return suit;
		  }  

		  public String toString() {
		    return RANKS[rank] + " of " + SUITS[suit]; 
		  }

		  public boolean equals(Card that) {
		    return rank == that.rank
		        && suit == that.suit;
		  }

		  public static void printDeck(Card[] cards) {
		    for (int i = 0; i < cards.length; i++) {
		      System.out.println(cards[i]);
		    }
		  }
		}

