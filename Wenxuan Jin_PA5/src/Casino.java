/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA5 Casino (main) class
 * COSI 12B
 */
import java.util.*;
/**
 * This is a class play a war game
 * @author Wenxuan Jin
 *
 */
public class Casino {
	
	/**
	 * This is the main method which runs the program
	 * @param args is the command line parameter required for the signature of the method
	 */
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.println("How much money do you have? (Please enter an integer)");
		int money=console.nextInt();
		while(money<=0) {//prevent user input invalid value representing money
			System.out.println("Your money needs to be positive. Please enter a positve integer");
			money=console.nextInt();
		}
		Deck data=new Deck();
		money=play(money,console,data);//update money after play the game once
		while(money>0) {//this is a while loop which would stop if the player do not have money
			System.out.println("Do you want to continue playing? (please enter yes or no)");
			String answer=console.next();
			while(!answer.equals("yes")&&!answer.equals("no")) {//make sure the input gained from user readable
				System.out.println("Please enter yes or no to represent whether you want to continue");
				answer=console.next();
			}
			if(answer.equals("yes")) {
				money=play(money,console,data);
			}else {
				System.out.println("You choose to stop playing and your money is "+money+" now!");
				return;
			}
		}
		System.out.println("You are bankrupt!");
	}
	
	/**
	 * This is a method to play once the war game
	 * @param money is an integer represent the money user have now
	 * @param console is a scanner gain user input
	 * @param data is the Card Array used to play the game
	 * @return the updated money of the user (win or lose)
	 */
	public static int play (int money,Scanner console,Deck data) {
		System.out.println("How much is your bet? (Please enter an integer)");
		int bet=console.nextInt();
		while(bet<=0) {//make sure the bet user input is a positive value
			System.out.println("Your bet needs to be positive. Please enter a positve integer");
			bet=console.nextInt();
		}
		while(money-bet<0) {//make sure the player has enough money to pay the bet
			System.out.println("Your bet is largaer than the money you have. Please enter a smaller bet");
			bet=console.nextInt();
		}
		if(game(data)==true) {//run in to this "if" if the player wins the game
			System.out.println("You win! The moneny you have now is: "+(money+bet));
			return money+bet;
		}else {
			System.out.println("You lose. The moneny you have now is: "+(money-bet));
			return money-bet;
		}
	}
	
	/**
	 * This is the method compare the value gained by the user and the computer
	 * @param data the card array using to play the game
	 * @return boolean, if the user win, return true; otherwise return false
	 */
	public static boolean game(Deck data) {
		Card computer=data.drawNextCard();
		System.out.println("the value computer gain is "+computer.getValue());
		Card user=data.drawNextCard();
		System.out.println("the value user gain is "+user.getValue());
		if(user.getValue()>computer.getValue()) {//player wins
			return true;
		}else {
			return false;
		}
	}

}
