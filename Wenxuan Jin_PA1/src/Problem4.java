/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA1 Problem4
 * COSI 12B
 */

import java.util.*;
public class Problem4 {
	/**
	 * transfer people's name from English to pig latin
	 */
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.println("Please type your first name: ");
		String first=console.next();
		System.out.println("Please type your last name: ");
		String last=console.next();
		String res="";
		first=first.toLowerCase();
		last=last.toLowerCase();
		String first1=first.substring(0,1);
		String first2=first.substring(1,2);
		first2=first2.toUpperCase();
		res=res+first2+first.substring(2)+first1+"ay";
		String last1=last.substring(0,1);
		String last2=last.substring(1,2);
		last2=last2.toUpperCase();
		res=res+" "+last2+last.substring(2)+last1+"ay";
		System.out.println(res);

	}

}
