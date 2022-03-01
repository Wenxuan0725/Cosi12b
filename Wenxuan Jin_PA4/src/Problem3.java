/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA4 Problem3
 * COSI 12B
 */
import java.util.*;
import java.io.*;
/**
 * This is the main class that run the program
 * @author Wenxuan Jin
 *
 */
public class Problem3 {
	
	/**
	 * This is the main method to run this program
	 * @param args is the command line parameter required for the signature of the method
	 * @throws FileNotFoundException throw an exception if the document cannot be found on computer
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console=new Scanner(System.in);
		System.out.println("Please enter the first file you want to calulate: ");
		File data1=new File(console.nextLine());
		System.out.println("Please enter the second file you want to calulate: ");
		File data2=new File(console.nextLine());
		Scanner input1=new Scanner(data1);
		Scanner input2=new Scanner(data2);
		int[]file1=rowAndLine(input1);//the number of lines and rows gained in the Array
		int[]file2=rowAndLine(input2);
		int[][] matrix1=transfer(input1,file1);//2-D array contains number in matrix 
		int[][] matrix2=transfer(input2,file2);
		PrintStream output=new PrintStream(new File("results.txt"));
		if(file1[0]==file2[0]&&file1[1]==file2[1]) {//the if would pass/two matrixes can be added only when the dimensions of two matrix are same
			int[][]result=new int[file1[0]][file1[1]];
			for(int i=0;i<result.length;i++) {
				for(int j=0;j<result[0].length;j++) {//this is a double for loop giving values to all spaces in the result 2-D array 
					result[i][j]=matrix1[i][j]+matrix2[i][j];
				}
			}
			print(result,output);
			output.println();
		}else {
			System.out.println("The two matrix cannot be added");
		}
		if(file1[1]==file2[0]) {//the if can pass/two matrix can multiply when the number of line for the first matrix equals the number of row for the second matrix
			int[][]result=new int[file1[0]][file2[1]];
			for(int i=0;i<result.length;i++) {
				for(int j=0;j<result[0].length;j++) {//this is a double for loop giving values to all spaces in the result 2-D array
					int value=0;
					for(int h=0;h<file1[1];h++) {//this is a for loop which will run the time of first matrix's line and calculate the value of for multiplication of two matrixes at [i][j] 
						value+=matrix1[i][h]*matrix2[h][j];
					}
					result[i][j]=value;
				}
			}
			print(result,output);
		}else {
			System.out.println("The two matrix cannot multiply");
		}

	}
	
	/**
	 * This is a static method return the number of row and line for a target matrix
	 * @param input an Scanner of a file which containing a matrix
	 * @return an array which [0] is the number of rows in the matrix and[1] is the number of line
	 */
	public static int[] rowAndLine(Scanner input) {
		int[]res=new int[2];
		int row=0;
		String info=input.nextLine();
		Scanner rowAndLine=new Scanner(info);
		res[0]=rowAndLine.nextInt();
		res[1]=rowAndLine.nextInt();
		return res;
	}
	
	/**
	 * This is a static method to transfer the matrix in the file in to a 2-D array
	 * @param input a Scanner of the matrix file 
	 * @param file an array gained which [0] is the number of row and [1] is the number of line for the target matrix
	 * @return a 2-D array (the matrix in the file)
	 */
	public static int[][] transfer(Scanner input,int[]file){
		int[][] res=new int[file[0]][file[1]];
		for(int i=0;i<res.length;i++){//this is a double for loop which will enter those value in the file to a 2-D array
			String information=input.nextLine();
			Scanner temp=new Scanner(information);
			for(int j=0;j<res[0].length;j++) {
					res[i][j]=temp.nextInt();
			}
			
		}
		return res;
	}
	
	/**
	 * This is a static method to print result in to file
	 * @param result a 2-D array which need to be printed
	 * @param output a PrintStream to print the result into a specific file
	 */
	public static void print(int[][]result,PrintStream output) {
		for(int i=0;i<result.length;i++) {//this is a double for loop to print a 2-D array and use space to divide each value
			output.print(result[i][0]);
			for(int j=1;j<result[0].length;j++) {
				output.print(" ");
				output.print(result[i][j]);
			}
			output.println();
		}
	}

}
