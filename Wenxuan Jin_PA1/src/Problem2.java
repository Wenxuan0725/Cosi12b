/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA1 Problem2
 * COSI 12B
 */

import java.util.*;
public class Problem2 {
	/**
	 * change a number no bigger than 4999 to Roman numerals
	 */
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.println("Please type an integer no bigger than 4999");
		int number=console.nextInt();
		if(number>4999) {//judge if the input is larger than 4999
			System.out.println("Error");
			return;
		}
		String res="";
		if(number>=1000&&number<=4999) {
			int count=number/1000;
			for(int i=0;i<count;i++) {
				res+="M";
			}
			number=number%1000;//delete the thousand digit of the number
		}
		if(number>=100&&number<1000) {
			int count=number/100;
			if(count<4) {
				for(int i=0;i<count;i++) {
					res+="C";
				}
			}else if(count==4) {
				res+="CD";
			}else if(count==5) {
				res+="D";
			}else if(count==9){
				res+="CM";
			}else {
				res+="D";
				for(int i=6;i<=count;i++) {
					res+="C";
				}
			}
			number=number%100;//delete the hundred digit of the number
		}
		if(number>=10&&number<100) {
			int count=number/10;
			if(count<4) {
				for(int i=0;i<count;i++) {
					res+="X";
				}
			}else if(count==4) {
				res+="XL";
			}else if(count==5) {
				res+="L";
			}else if(count==9){
				res+="XC";
			}else {
				res+="L";
				for(int i=6;i<=count;i++) {
					res+="X";
				}
			}
			number=number%10;//delete the tenth digit of the number
		}
		if(number>=0&&number<10) {
			if(number<4) {
				for(int i=0;i<number;i++) {
					res+="I";
				}
			}else if(number==4) {
				res+="IV";
			}else if(number==5) {
				res+="V";
			}else if(number==9){
				res+="IX";
			}else {
				res+="V";
				for(int i=6;i<=number;i++) {
					res+="I";
				}
			}
		}
		System.out.println(res);
	}

}
