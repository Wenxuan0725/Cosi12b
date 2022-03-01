/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA2 Problem1
 * COSI 12B
 */
import java.util.*;
public class Problem1 {
	/*
	 * Play a guess number game and data like total guess would include at the end of the game.
	 */
	public static int guess(int constant) {//function to guess
		System.out.println("Think of a number...");
		Random rand=new Random();
		int res=rand.nextInt(constant)+1;//provide a random number between 1 and constant(which is 100 here)
		Scanner console=new Scanner(System.in);
		System.out.println("My guess: "+res);
		String answer=console.next();
		int count=0;
		int min=0;
		int max=constant+1;
		while(!answer.equals("correct")) {//the loop would not stop until having a correct guess
			if(answer.equals("higher")) {
				min=res;//if the user input higher, my guess<correct number. So the minimum of the guess game is updated
				res=min+rand.nextInt(max-min-1)+1;//get a random number between min+1 and max-1
				System.out.println("My guess: "+res);
				answer=console.next();
			}else {
				max=res;//similarly, if the user input lower, the maximum of the guess game is updated
				res=min+rand.nextInt(max-min-1)+1;
				System.out.println("My guess: "+res);
				answer=console.next();
			}
			count++;
		}
		count++;
		System.out.println("I got it right in "+count+" guesses");
		System.out.println();
		return count;//return the number of guess computer takes
	}

	public static void main(String[] args) {
		int constant=100;
		System.out.println("This program allows you to play a guessing game.");
		System.out.println("Think of a number between 1 and "+constant);
		System.out.println("and I will guess until I get it.");
		System.out.println("for each guess, tell me if the");
		System.out.println("right answer is higher or lower than your guess, or if it is correct.");
		System.out.println();
		
		int maxGuess=guess(constant);//when play the game 1st time, assume that time gain the maximum guess
		int totalGuess=maxGuess;
		int totalGames=1;
		Scanner console=new Scanner(System.in);
		System.out.print("Do you want to play again?");
		String result=console.next();
		result.toLowerCase();
		System.out.println();
		while(result.charAt(0)!='n') {//the while loop would end until the user type in no/n (the input No/N has been change to no/n)
			int a=guess(constant);
			if(maxGuess<a) {//if the new game played has a larger guess, then maxGuess would equal to that one
				maxGuess=a;
			}
			totalGames++;
			totalGuess+=a;
			System.out.print("Do you want to play again?");
			result=console.next();
			result.toLowerCase();
			System.out.println();
		}
		double average=(double)totalGuess/totalGames;
		System.out.println();
		System.out.println("Overall results: ");
		System.out.printf("    "+"%-14s"+"="+" "+totalGames+"\n","total games");
		System.out.printf("    "+"%-14s"+"="+" "+totalGuess+"\n","total guesses");
		System.out.printf("    "+"%-14s"+"="+" "+"%.1f"+"\n","guesses/game",average);
		System.out.printf("    "+"%-14s"+"="+" "+maxGuess+"\n","max Guesses");
		
	}

}
