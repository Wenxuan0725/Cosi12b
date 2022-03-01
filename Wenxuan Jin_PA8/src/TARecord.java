/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA8 TARecord class
 * COSI 12B
 */
import java.io.*;
import java.util.*;

/**
 * This a class extract a specific TA' information from a file
 * @author Wenxuan Jin
 *
 */
public class TARecord {
	/**
	 * There are three fields in this class
	 * string name is the name of the TA need to find his/her information
	 * file data is the target file to find information about a TA
	 * TAInfo is an ArrayList which save a TA's records
	 */
	String name;
	File data;
	ArrayList<String>TAInfo=new ArrayList<String>();
	
	// and any other feilds you need
	
	/**
	 * This is the constructor of the class which gains the name of the TA
	 * @param name the target TA which needs record
	 */
	public TARecord (String name) {
		this.name=name;
	}
	
	/**
	 * This is a method gain the target file for searching needed TA information
	 * @param data target file the program needs to check
	 */
	public void setFile(File data) {
		this.data=data;	
	}
	
	/**
	 * This is a method to set a TA's record to an ArrayList
	 * @throws FileNotFoundException throws an exception if the document cannot be found on computer
	 */
	public void setTA() throws FileNotFoundException {
		int count=0;
		if(data!=null) {//check if the data object is null
			Scanner console=new Scanner(data);
			while(console.hasNextLine()) {//this is a while loop which will stop until no lines in this file
				String current=console.nextLine();
				count++;
				String currentName="";
				if(current.length()>=name.length()) {//if the the length gain from the file is larger the length of the name, then substring that name to check, otherwise currentName is an empty string
					currentName=current.substring(0,name.length());
				}
				if(currentName.equals(name)) {
					TAInfo.add(count+";"+current);
						
				}
			}
		}
	}
	
}
	
	


	


