/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA4 Problem1
 * COSI 12B
 */
import java.io.*;
import java.util.*;
/**
 * This is the main class that run the program
 * @author Wenxuan Jin
 *
 */
public class Problem1 {

	/**
	 * This is the main method to run this program
	 * @param args is the command line parameter required for the signature of the method
	 * @throws FileNotFoundException throw an exception if the document cannot be found on computer
	 */
	public static void main(String[] args) throws FileNotFoundException{
		int[]count=new int[2];
		Scanner console=new Scanner(System.in);
		System.out.println("Please enter the location of document you want count words:");
		File f=new File(console.nextLine());
		Scanner input=new Scanner(f);//gain the file need to be counted 
		int line=0;
		while(input.hasNextLine()) {//this is a while loop stop until the file does not have lines which do not be read
			String information=input.nextLine();
			if(!information.equals("")) {//if the line is an empty line, then the number of line will not add 1
				line++;
			}
			countWords(information,count);
		}
		System.out.println("tatal words: "+count[0]);
		System.out.println("total lines: "+line);
		System.out.println("tatal characters: "+count[1]);

	}
	
	/**
	 * This is a static method count the number of words and characters
	 * @param information the string containing the information needed to be counted
	 * @param count an array which length is 2, one is to store the number of words and the other is to store the number of characters
	 */
	public static void countWords(String information,int[]count) {
		int words=0;
		Scanner data=new Scanner(information);
		while(data.hasNext()) {//this is a while loop which will stop when there is no word in that string.
			String word=data.next();
			count[1]+=word.length();
			words++;
		}
		count[0]+=words;
	}

}
