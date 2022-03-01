/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA5 TEST class
 * COSI 12B
 */
import java.util.*;
/**
 * This is a class testing those written classes
 * @author Wenxuan Jin
 *
 */
public class Test {
	
	/**
	 * This is the main method run this program
	 * @param args is the command line parameter required for the signature of the method
	 */
	public static void main(String[] args) {
		Deck card=new Deck();
		for(int i=0;i<card.deck.length;i++) {
			System.out.println(card.deck[i]);
		}
		System.out.println();
		for(int i=0;i<56;i++) {
			System.out.print(i+" ");
			System.out.println(card.drawNextCard());
		}
		
	}

}
