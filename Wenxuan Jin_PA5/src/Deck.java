/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA5 deck class
 * COSI 12B
 */

import java.util.*;
/**
 * This a class define an object Deck
 * @author Wenxuan Jin
 *
 */

public class Deck {
	/**
	 * there are 5 fields in the class
	 * deck is an Array contain those 52 card. 
	 * disCardPile is an Array using to contain cards draw from deck array 
	 * tempDeck is an Array use temporarily when shuffle cards
	 * current is an int used to count the current card draw from the card
	 * count is an int used to count the location of discard pile when add new cards
	 */
	public Card[] deck;
	public Card[] disCardPile;
	public Card[] tempDeck;
	private int current;
	private int count;
	
	/**
	 * This is a constructor of the class
	 */
	public Deck() {
		deck=new Card[52];
		for(int i=1;i<=13;i++) {//four for loop create an card with all those cards
			deck[i-1]=new Card(i,"Heart");
		}
		for(int i=1;i<=13;i++) {
			deck[i+12]=new Card(i,"Diamonds");
		}
		for(int i=1;i<=13;i++) {
			deck[i+25]=new Card(i,"Spades");
		}
		for(int i=1;i<=13;i++) {
			deck[i+38]=new Card(i,"Clubs");
		}
		tempDeck=new Card[52];
		shuffle();
		disCardPile=new Card[52];
	}
	
	/**
	 * This is a void method shuffle the cards in deck array
	 */
	public void shuffle() {
		Random random=new Random();
		for(int i=0;i<tempDeck.length;i++) {
			int temp=random.nextInt(52);
			if(deck[temp]!=null) {//make sure there is no null card shuffle
				tempDeck[i]=deck[temp];
				deck[temp]=null;
			}else {
				i--;
			}
		}
		deck=tempDeck;
		tempDeck=new Card[52];
	}
	
	/**
	 * This is a method gain one card from the deck in sequence
	 * @return the card gained
	 */
	public Card drawNextCard() {
		current++;
		if(current<=52) {
			discard(deck[current-1]);
			return deck[current-1];
		}else {
			current=1;
			deck=disCardPile.clone();
			shuffle();//if there is no card in deck array, move all the card from discard pile into deck array and shuffle it
			disCardPile=new Card[52];
			return deck[current-1];
		}
	}
	/**
	 * This is a method add one card into the discard pile
	 * @param c is the card needed to add
	 */
	public void discard(Card c) {
		disCardPile[count]=c;
		count++;
		if(count>51) {
			count=0;
		}
	}

}
