/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA8 TAChecker class
 * COSI 12B
 */
import java.io.*;
import java.util.*;

/**
 * This is a class to check whether TAs have problem on their work. 
 * @author Wenxuan Jin
 *
 */
public class TAChecker {	
	/**
	 * This is the main method to run the project.
	 * @param args is the command line parameter required for the signature of the method
	 * @throws FileNotFoundException throws an exception if the document cannot be found on computer
	 */
	public static void main(String [] args) throws FileNotFoundException {
		Map<String, ArrayList>TAInformation=new HashMap<String, ArrayList>();
		Scanner console=new Scanner(System.in);
		System.out.println("Enter a work log: ");
		File data=new File(console.nextLine());//get the file need to do operation
	
		Scanner info=new Scanner(data);
		while(info.hasNextLine()) {//this is a while loop which will stop until there is no next line in the file
			String current=info.nextLine();
			int location=findLocation(current,";");
			String name=current.substring(0,location);//using ";" as a sign to get the name of current information
			if(!TAInformation.containsKey(name)) {//check whether this TA information has added into the map or not
				TARecord ta=new TARecord(name);//create a new TARecord object and use methods in that class to deal with information
				ta.setFile(data);
				ta.setTA();
				ArrayList<String>currentTA=ta.TAInfo;
				TAInformation.put(ta.name,currentTA);
			}
		}
		Map<String,ArrayList>startData=start(TAInformation);//get the map only contains start data
		Map<String,ArrayList>IDData=idData(TAInformation);//get the map only contains idData
		
		Set<String> TAName1=startData.keySet();
		Iterator<String>itr1=TAName1.iterator();
		while(itr1.hasNext()) {//this is a while loop which will not stop until trace all keys in startData
			String currentTA=itr1.next();
			ArrayList<String>startInfo=startData.get(currentTA);
			ArrayList<Integer>idInfo=IDData.get(currentTA);
			if(startInfo.isEmpty()&&(!idInfo.isEmpty())||startInfo.size()!=idInfo.size()) {//if there is no start information but ID information or number of start informations less than ID informations, then there is unstarted job
				String place="";
				ArrayList<String>currentTAData=TAInformation.get(currentTA);
				for(int i=0;i<currentTAData.size();i++) {
					if(findLocation(currentTAData.get(i),"START")==-1){
						int temp=findLocation(currentTAData.get(i),";");
						place=currentTAData.get(i).substring(0,temp);//get the line number of the ID information line
					}
				}
				System.out.println(place+";"+currentTA+";"+"UNSTARTED_JOB");
			}
		}
		
		Set<String> TAName2=startData.keySet();
		Iterator<String>itr2=TAName2.iterator();
		while(itr2.hasNext()) {//this is a while loop which will not stop until trace all keys in startData
			String currentTA=itr2.next();
			ArrayList<String>startInfo=startData.get(currentTA);
			ArrayList<Integer>idInfo=IDData.get(currentTA);
			for(int i=0;i<startInfo.size();i++) {
				String startLine=startInfo.get(i);
				int IDInfo=idInfo.get(i);
				Iterator<String>itr3=TAName2.iterator();
				while(itr3.hasNext()) {//this is a while loop which will not stop until trace all keys in startData
					String currentCheck=itr3.next();
					if(!currentCheck.equals(currentTA)) {
						ArrayList<String>startCheck=startData.get(currentCheck);
						ArrayList<Integer>idInfoCheck=IDData.get(currentCheck);
						if(startCheck.size()==1) {//go into if the TA who is checked only have one start statement
							String startLineCheck=startCheck.get(0);
							int IDInforCheck=idInfoCheck.get(0);
							if(transfer(startLine)<transfer(startLineCheck)&&IDInforCheck<IDInfo) {//if the current checking TA have a larger start line but a small ID number, then this TA is shortened_job
								System.out.println(startLineCheck+";"+currentCheck+";"+"SHORTENED_JOB");
							}
						}else if(startCheck.size()>1){//go into if the TA has more than one start statement 
							int sh=0;
							int su=0;
							ArrayList<String>checkStartLine=new ArrayList<String>();
							for(int j=0;j<startCheck.size();j++) {//this is a for loop which will not stop until reach all data in startcheck
								String startLineCheck=startCheck.get(j);//get the startLine number and IDInfor number to check 
								int IDInforCheck=idInfoCheck.get(j);
								for(int d=j+1;d<idInfoCheck.size();d++) {
									String startLineCheckNext=startCheck.get(d);//get the information of the next data
									int IDInforCheckNext=idInfoCheck.get(d);
									if(transfer(startLine)<transfer(startLineCheck)&&IDInforCheck<IDInfo&&transfer(startLine)<transfer(startLineCheckNext)&&IDInforCheckNext<IDInfo) {
									//if both checks fulfill the shorten_job condition compared with start check, then integer sh (shorten) add 1
										sh++;
										if(!checkStartLine.contains(startLineCheck)) {//add those line into an ArrayList to prepare for further use
											checkStartLine.add(startLineCheck);
										}
										if(!checkStartLine.contains(startLineCheckNext)) {
											checkStartLine.add(startLineCheckNext);
										}
									}else if(transfer(startLine)<transfer(startLineCheck)&&IDInforCheck<IDInfo||transfer(startLine)<transfer(startLineCheckNext)&&IDInforCheckNext<IDInfo){
									//if only one check have the shorten_job condition and do not know the related start statement, then su (suspicious) add one
										su++;
									}
								}
							}
							if(sh!=0&&su==0) {//if only sh has value and su equals 0, then the condition is shorten_job 
								for(int h=0;h<checkStartLine.size();h++) {
									System.out.println(checkStartLine.get(h)+";"+currentCheck+";"+"SHORTENED_JOB");
								}
							}else if(su!=0) {//if su does not equals 0, then the condition is suspicious_batch
								String place="";
								ArrayList<String>currentCheckData=TAInformation.get(currentCheck);
								for(int k=0;k<currentCheckData.size();k++) {
									if(findLocation(currentCheckData.get(k),",")!=-1){
										int temp=findLocation(currentCheckData.get(k),";");
										place=currentCheckData.get(k).substring(0,temp);
									}
								}
								System.out.println(place+";"+currentCheck+";"+"SUSPICOUS_BATCH");
							}
						}
					}
					
				}
			}	
		}
	}
	
	/**
	 * This is a method to transfer the general TA record to record only contains start information
	 * @param TAInformation the general TA record
	 * @return Map contains only start information
	 */
	public static Map start(Map TAInformation) {
		Set<String> keys=TAInformation.keySet();
		Iterator<String>itr=keys.iterator();
		Map<String,ArrayList>startData=new HashMap<String,ArrayList>();
		while(itr.hasNext()) {//this is a while loop which will stop until iterator does not have the next.
			String currentKey=itr.next();
			ArrayList<String>currentValue=(ArrayList<String>) TAInformation.get(currentKey);
			ArrayList<String>location=new ArrayList<String>();
			for(int i=0;i<currentValue.size();i++) {//this is a for loop which will reach all records of a TA
				String temp=currentValue.get(i);
				if(findLocation(temp,"START")!=-1) {//check whether the current info is a start sentence
					int semicolon=findLocation(temp,";");
					location.add(temp.substring(0,semicolon));//when I create TARecord, I add line number before each TA information, hence the thing add to the arrayList is line number of start statement
				}
			}
			startData.put(currentKey,location);//add the current TA name and arrayList contains line numbers into a map
		}
		return startData;
	}
	
	/**
	 * This is a method to transfer the general TA record to record only contains ID information
	 * @param TAInformation the general TA record
	 * @return Map contains only ID information
	 */
	public static Map idData(Map TAInformation) {
		Set<String> keys=TAInformation.keySet();
		Iterator<String>itr=keys.iterator();
		Map<String,ArrayList>IDData=new HashMap<String,ArrayList>();
		while(itr.hasNext()) {//using iterator to trace the Map
			String currentKey=itr.next();
			ArrayList<String>currentValue=(ArrayList<String>) TAInformation.get(currentKey);
			ArrayList<String>IDInfo=new ArrayList<String>();//ArrayList contains ID information in type string
			ArrayList<Integer>IDInfor=new ArrayList<Integer>();//ArrayList contains ID information in type integer
			for(int i=0;i<currentValue.size();i++) {//this is a for loop which will reach all records of a TA
				String temp=currentValue.get(i);
				if(findLocation(temp,"START")==-1) {//check whether the current info is a start sentence
					int semiColon=temp.length();
					while(!temp.substring(semiColon-1,semiColon).equals(";")) {
						semiColon--;
					}
					if(findLocation(temp,",")!=-1) {//through check whether contain "," to check whether the TA return 2 IDs at the same time
						int commaPrevious=semiColon;
						while(findLocation(temp,",")!=-1) {
							int comma=findLocation(temp,",");
							IDInfo.add(temp.substring(commaPrevious,comma));//add ID in type of integer
							temp=temp.substring(0,comma)+temp.substring(comma+1);//delete that ","
							commaPrevious=comma;
						}
						IDInfo.add(temp.substring(commaPrevious));//add the last ID
					}else {
						IDInfo.add(temp.substring(semiColon));
					}
				}
				
				for(int j=0;j<IDInfo.size();j++) {
					IDInfor.add(transfer(IDInfo.get(j)));//transfer ID from String to integer
				}
				Collections.sort(IDInfor);//make ID in a increasing order
			}
			IDData.put(currentKey, IDInfor);//add the currentTA's name with her/his IDs into the map
		}
		return IDData;
	}
	
	/**
	 * This is a method transfer a string number to an Integer number
	 * @param a string need to transfer
	 * @return an integer has already transfered
	 */
	public static int transfer(String a) {
		int lengthA=a.length();
		int valueA=0;
		for(int i=0;i<lengthA;i++) {//this is a for loop run the length of A times
			int base=1;
			for(int j=0;j<i;j++) {//calculate the power of 10 needs to multiply
				base=base*10;
			}
			int temp=a.charAt(lengthA-i-1);//get each charter of the string in a reverse order
			valueA+=temp*base;//using ASCII code to give the string an integer value
		}
		return valueA;
	}
	
	/**
	 * This is a method to find the location of a string contains in another string (similar to indexOf)
	 * @param data the string may contain target
	 * @param target the string we want to find location in data
	 * @return an int represents the location of the target, return -1 if do not find
	 */
	public static int findLocation(String data, String target) {
		int location=-1;
		for(int i=0;i<data.length()-target.length()+1;i++) {//this is a for loop get all possible string with length of target
			if(data.substring(i,i+target.length()).equals(target)) {//check whether the string get equals the target
				location=i;
				return location;
			}
		}
		return location;
	}
}
