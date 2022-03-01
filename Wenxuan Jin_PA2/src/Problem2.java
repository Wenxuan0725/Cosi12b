/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA2 Problem2
 * COSI 12B
 */
import java.util.*;
public class Problem2 {
/*
 * Playing the reverse Hangman game
 */
	public static void drawing(int numberOfGuess) {//function to print the gallows, the numberOfGuess is the number of time have a wrong guess
		String first="+--+";
		String second="|  |";
		String third="|";
		String fourth="|";
		String fifth="|";
		String sixth="|";
		String seventh="+-----";
		System.out.println(first);
		System.out.println(second);
		if(numberOfGuess>0) {
			third+="  O";
			if(numberOfGuess>1) {
				fourth+="  |";
				if(numberOfGuess>2) {
					fifth+="   \\";
					if(numberOfGuess>3) {
						fifth=fifth.substring(0,2)+"/"+fifth.substring(3);
						if(numberOfGuess>4) {
							fourth+="\\";
							if(numberOfGuess>5) {
								fourth=fourth.substring(0,2)+"/"+fourth.substring(3);
							}
						}
					}
							
				}
			}
		}
		System.out.println(third);
		System.out.println(fourth);
		System.out.println(fifth);
		System.out.println(sixth);
		System.out.println(seventh);
		
	}
	
	public static String changeSpace(String letterUpper,char temp,String space,int number) {//function to create the record of letters have been guessed 
		for(int i=0;i<number;i++) {
			boolean a=true;
			int b=0;
			while(b<letterUpper.length()&&a) {
				if(letterUpper.charAt(b)==temp) {
					a=false;
				}else {
					b++;
				}
			}
			space=space.substring(0,b*2)+letterUpper.toLowerCase().charAt(b)+space.substring(b*2+1);
			letterUpper=letterUpper.substring(0,b)+" "+letterUpper.substring(b+1);
		}
		
		return space;
	}

	public static void main(String[] args) {
		System.out.println("This program plays a game of reverse hangman.");
		System.out.println("You think up a word (by typing it on the computer) and I'll try to guess the letters");
		System.out.println();
		Scanner console= new Scanner(System.in);
		System.out.print("How many letters are in your word?");
		int numOfLetter=console.nextInt();
		while(numOfLetter<1) {//make sure the numOfLetter is a positive integer
			System.out.print("Please enter a positive value");
			numOfLetter=console.nextInt();
		}
		System.out.print("Please enter the word for me to guess (letter only): ");
		String letter=console.next();
		String letterUpper=letter.toUpperCase();
		String space="";
		for (int i=0;i<numOfLetter;i++) {//create the initial record which no letters were guessed
			space+="_ ";
		}
		System.out.println(space);
		System.out.println();
		drawing(0);//drawing the initial gallow
		int count=0;
		Random random=new Random();
		char temp;
		String guessData="";
		int numOfGuess=0;
		while(numOfGuess<7&&count<numOfLetter) {//the while loop would stop when numOfGuess is 6 (fail to the game) or the count=numOfLetter (win the game)
			boolean judge=false;
			temp=(char)(random.nextInt(26)+65);//gain a random letter
			for(int j=0;j<guessData.length();j++) {//make sure the letter used in each guess does not repeat
				if(temp==guessData.charAt(j)) {
					judge=true;
				}
			}
			if(judge==false) {
				guessData+=temp;
				System.out.println("I've got "+count+" of the "+numOfLetter+" letters so far");
				System.out.println("I guess: "+temp);
				System.out.print("Is that letter in the word? Please enter n or y to represent no and yes");
				String answer=console.next();
				if(answer.equals("n")) {//if I guess wrong, the numOfGuess would add one, and the space/record would not change.
					numOfGuess++; 
					System.out.println(space);
					System.out.println();
				}else if(answer.equals("y")){//if I guess correct, the numOfGuess would not add one(there would be no change to the hanging person), and the space/record would update 
					System.out.print("How many letter are in the word?");
					int number=console.nextInt();
					count+=number;
					space=changeSpace(letterUpper,temp,space,number);
					System.out.println(space);
					System.out.println();
					
				}else {//if the user enter a letter neither n nor y, computer would not understand that and the game would stop
					System.out.println("Error");
					return;
				}
				drawing(numOfGuess);
				System.out.println();
			}
			
			
		}
		if(count==numOfLetter) {//when the while loop finish, if the count of correct times equals the length of user input--win!
			System.out.println("Congratulations");
		}else {//if the count does not equal to the length of user input--lose...
			System.out.println("You beat me this time");
		}
		
		

	}

}
