/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA3 Problem1
 * COSI 12B
 */
import java.util.*;
/**
 * This is the main class that run the program
 * @author Wenxuan Jin
 *
 */
public class problem1 {
	/**
	 * This is a static method to check whether there is repeated number is a array
	 * @param data the array import to check
	 * @return return true if all elements are unique in the array, otherwise return false
	 */
	public static boolean isUnique(int[]data) {
		int length=data.length;
		for(int i=0;i<length;i++) {
			for(int j=i+1;j<length;j++) {
				if(data[i]==data[j]) {
					return false;
				}
			}
		}
		return true;
		
	}
	/**
	 * This is the main method to run the program
	 * @param args 
	 */
	public static void main(String[] args) {
		//explain the program
		System.out.println("This is a program which check whether each value in an array is unique.");
		System.out.println("Result true means values in the array is unique.");
		System.out.println("Result false means values in the array is not unique.");
		//get the user input
		Scanner console=new Scanner(System.in);
		System.out.println("How many value in your array (please enter integer only)?");
		int length =console.nextInt();
		while(length<1) {//avoid the user to input a negative number of array size
			System.out.println("please enter a positive integer");
			length=console.nextInt();
		}
		int[]data=new int[length];
		System.out.println("please enter values (integer only)");
		for(int i=1;i<=length;i++) {
			System.out.print(i+": ");
			data[i-1]=console.nextInt();
		}
		//call the method isUnique and print the result
		System.out.println(isUnique(data));
		
	}

}
