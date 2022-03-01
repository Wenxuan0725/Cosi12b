/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA4 Problem2
 * COSI 12B
 */
import java.util.*;
import java.io.*;
/**
 * This is the main class that run the program
 * @author Wenxuan Jin
 *
 */
public class Problem2 {

	/**
	 * This is the main method to run this program
	 * @param args is the command line parameter required for the signature of the method
	 * @throws FileNotFoundException throw an exception if the document cannot be found on computer
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("This program allows you to search through the\n"
				+ "data from the Social Security Administration\n"
				+ "to see how popular a particular name has been");
		Scanner info=check();
		while(info==null) {//this is a while loop which will stop when the info gained is not null
			System.out.println("the name is invaild, please enter another one");
			info=check();
		}
		print(info);

	}
	
	/**
	 * This is a static method to make sure the name user inputed can be found
	 * @return return a Scanner which contains popularity about the name user input
	 * @throws FileNotFoundException throw Exception when the file cannot be found
	 */
	public static Scanner check () throws FileNotFoundException {
		Scanner input=new Scanner(new File("names.txt"));
		Scanner console=new Scanner(System.in);
		System.out.print("Name? ");
		String name=console.next();
		String first=name.substring(0,1);
		first=first.toUpperCase();
		String other=name.substring(1);
		other=other.toLowerCase();
		name=first+other;//deal with the format of name user input
		while(input.hasNextLine()) {//this is a while loop which will stop when there is no new lines in the Scanner
			String data=input.nextLine();
			Scanner info=new Scanner(data);
			if(name.equals(info.next())) {
				System.out.println("Statistic on name \""+name+"\"");
				return info;
			}
		}
		return null;
	}
	
	/**
	 * This is a static method which will print the popularity of a name from 1900 to 2000
	 * @param info a Scanner which containing those popularity information
	 */
	public static void print(Scanner info) {
		int count=1900;
		while(info.hasNextInt()) {//this is a while loop which will stop when there is no integer in the Scanner
			int a=info.nextInt();
			System.out.println(count+": "+a);
			count+=10;
		}
		
		
	}

}
