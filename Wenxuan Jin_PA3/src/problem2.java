/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA3 Problem2
 * COSI 12B
 */
import java.util.*;
/**
 * This is the main class that run the program
 * @author Wenxuan Jin
 *
 */
public class problem2 {
	/**
	 * This is a static method to find out the longest sorted (nondecreasing) sequence of integers in the array
	 * @param data the array imported to check the length of the longest sorted nondecreasing sequence
	 * @return return the length of the longest sequence, if the array is empty, return 0
	 */
	public static int longestSortedSequence(int[]data) {
		if(data==null) {
			return 0;
		}
		int max=0;
		int count=1;
		for(int i=0;i<data.length-1;i++) {
			if(data[i]<=data[i+1]) {
				count++;
			}else {
				count=1;
			}
			if(max<count) {
				max=count;
			}
		}
		return max;
	}
	
	/**
	 * This is the main method run this program
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println("This is a program print out the length of longest sorted (nondecreasing) sequence of integers in an array.");
		Scanner console=new Scanner(System.in);
		System.out.println("How many value in your array (please enter integer only)?");
		int length =console.nextInt();
		while(length<0) {//make sure the size of the array is non-negative
			System.out.println("please enter a non-negative integer");
			length=console.nextInt();
		}
		int[]data=new int[length];
		if(length==0) {
			data=null;
		}else {
			System.out.println("please enter values (integer only)");
			for(int i=1;i<=length;i++) {
				System.out.print(i+": ");
				data[i-1]=console.nextInt();
			}
		}
		System.out.println("The length of longest sorted sequence: "+longestSortedSequence(data));

	}

}

