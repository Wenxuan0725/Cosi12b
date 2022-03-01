/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA1 Problem3
 * COSI 12B
 */

import java.util.*;
public class Problem3 {
	/**
	 * Produce a Caesar cipher which rotate each letter n times behind
	 */
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.print("Your message? ");
		String message=console.nextLine();
		message=message.toUpperCase();
		System.out.print("Encoding key? ");
		int rotate=console.nextInt();
		String res="";
		String upper="ABCDEFGHIGKLMNOPQRSTUVWXYZ";
		for(int i=0;i<message.length();i++) {
			String temp=message.substring(i,i+1);
			if(upper.indexOf(temp)!=-1) {//check if the i location is a letter
				int location=upper.indexOf(temp)+rotate;
				if(location<26) {
					res+=upper.substring(location,location+1);
				}else {//work for letter X,Y,Z
					location-=26;
					res+=upper.substring(location,location+1);
				}
			}else {//add things like space to the String res without any change
				res+=temp;
			}
		}
		System.out.println("Your message: "+res);

	}


}
