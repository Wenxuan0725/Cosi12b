/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA5 Card class
 * COSI 12B
 */

/**
 * This is the Card class define an new object Card
 * @author Wenxuan Jin
 *
 */
public class Card {
	/**
	 * These are two fields in the class, one is the value of cards, and the other is the suit of cards
	 */
	private int value;
	private String suit;
	
	/**
	 * This is the constructor of the class
	 * @param value value of the card from 1-13
	 * @param suit suit of the card such as Hearts, Diamonds, Spades and Clubs
	 */
	public Card(int value,String suit) {
		this.value=value;
		this.suit=suit;
	}
	
	/**
	 * This is the method gain the value of a Card
	 * @return an integer which is the value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * This is method find the color of a card
	 * @return a String which is color of a card
	 */
	public String getColor() {
		if(suit.equals("Hearts")||suit.equals("Diamonds")) {
			return "red";
		}else {
			return "black";
		}
	}
	
	/**
	 * This is the method return the suit of a card
	 * @return a String which is the suit of a card
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * This is a method return the information of a card in a String.
	 * @return a String containing information of the card
	 */
	public String toString() {
		if(value==1) {
			return "Ace of "+suit;
		}else if(value==11) {
			return "Jack of "+suit;
		}else if(value==12) {
			return "Queen of "+suit;
		}else if(value==13) {
			return "King of "+suit;
		}else {
			return value+" of "+suit;
		}
	}

}
