package GAME;

public class EightsCard extends Card {

	  public EightsCard(int rank, int suit) {
	    super(rank, suit);

	  }

	  // Checks whether cards match.
	  public boolean cardMatches(EightsCard that) {
	    if (getSuit() == that.getSuit()) {
	      return true;
	    }
	    if (getRank() == that.getRank()) {
	      return true;
	    }
	    if (getRank() == 8) {
	      return true;
	    }
	    return false;
	  }


	  //creation of a duplicate card for matching.
	  public EightsCard convert(Card card) {
	    if (card != null) {
	    EightsCard result = new EightsCard(card.getRank(), card.getSuit());
	    return result;
	    } 
	    return null;
	  }
	}