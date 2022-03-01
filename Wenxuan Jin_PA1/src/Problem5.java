/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA1 Problem5
 * COSI 12B
 */

import java.util.*;
public class Problem5 {
	/**
	 * display all digits of a number
	 */
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.println("Please type a positive integer:");
		int number=console.nextInt();
		int count=0;
		int temp=number;
		while(temp!=0) {//get the number of digits of the number
			temp=temp/10;
			count++;
		}
		for(int i=0;i<count-1;i++) {//runs 1 time less than the number of digits
			int divide=10;
			for(int j=i;j<count-2;j++) {
				divide=divide*10;
			}
			int res=number/divide;
			number=number%divide;//delete the biggest digit of the number
			System.out.println(res);
		}
		System.out.println(number);//print the unit digit of the number

	}

}
