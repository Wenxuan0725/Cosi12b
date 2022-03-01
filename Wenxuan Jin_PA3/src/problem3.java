/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA3 Problem3
 * COSI 12B
 */
import java.util.*;
/**
 * This is the main class run the program 
 * @author Wenxuan Jin
 *
 */
public class problem3 {
	/**
	 * This is a static method to gain the closest price lower than the correct price 
	 * @param bids an array contained those guessing value
	 * @param correct the correct price
	 * @return return the closest value lowering than the correct price, return -1 if all value in bids larger than the correct one 
	 */
	public static int priceIsRight(int[]bids,int correct) {
		int minDifference=-1;
		for(int i=0;i<bids.length;i++) {
			if(bids[i]<=correct) {
				if(bids[i]>minDifference) {
					minDifference=bids[i];
				}
			}
		}
		return minDifference;
	}

	/**
	 * This is the main method run this program
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("This is a program print out the most close guess price");
		Scanner console=new Scanner(System.in);
		System.out.println("How many guess you made in your array (please enter integer only)?");
		int length =console.nextInt();
		while(length<1) {//make sure the size of the array is positive
			System.out.println("please enter a positive integer");
			length=console.nextInt();
		}
		int[]bids=new int[length];
		System.out.println("please enter guess (integer only)");
		for(int i=1;i<=length;i++) {
			System.out.print(i+": ");
			int temp=console.nextInt();
			while(temp<0) {//make sure those guessing prices are non-negative
				System.out.println("please enter a non-negative value (integer only)");
				temp=console.nextInt();
			}
			bids[i-1]=temp;
		}
		System.out.println("What is the correct price?");
		int correct=console.nextInt();
		System.out.println("The closest guess is: "+priceIsRight(bids,correct));

	}

}
