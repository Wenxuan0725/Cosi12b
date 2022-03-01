/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA1 Problem1
 * COSI 12B
 */

import java.util.*;
public class Problem1 {
	/**
	 * Calculate a given number until the number is 1 and print each step
	 */

	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.println("Please type a positive integer");
		int initial=console.nextInt();//get a positive integer through Scanner
		if(initial<1) {//if the input number is less than 1, stop and print Error
			System.out.println("Error");
			return;
		}
		int count=0;
		System.out.println("Initial value is: "+initial);
		while (initial!=1) {
			if(initial%2==0) {
				initial=initial/2;
				count++;
				if(initial==1) {//if the initial is 2 and changes to 1, "Final value" needs to print and stop the program 
					System.out.println("Final value is: "+initial+", number of operations performed "+count);
					return;
				}else {
					System.out.println("Next value is: "+initial);
				}
			}else {
				initial=initial*3+1;
				count++;
				System.out.println("Next value is: "+initial);
			}
		}
		

	}

}
