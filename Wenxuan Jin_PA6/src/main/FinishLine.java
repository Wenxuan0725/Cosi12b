/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA6 FinishLine class
 * COSI 12B
 */
package main;

/**
 * This is the FinishLine class check whether a car is entering the finish line and whether all cars entered
 * @author Wenxuan Jin
 *
 */
public class FinishLine {
	/**
	 * There are 6 fields in this class.
	 * countRace is an integer to count how many RaceCar have entered the finishLine.
	 * countFormula is an integer to count how many FormulaOne have entered the finishLine.
	 * resRace is an integer to record how many RaceCar take part in the race.
	 * resFormula is an integer to record how many FormulaOne take part in the race.
	 * finishedRace is an RaceCar array to store RaceCars which have already pass the finishLine.
	 * finishedFormula is an FormulaOne array to store FormulaOnes which have already pass the finishLine.
	 */
	private int countRace;
	private int countFormula;
	private int resRace;
	private int resFormula;
	private RaceCar[] finishedRace;
	private FormulaOne[] finishedFormula;
	
	/**
	 * This is a method set some fields of FinishLine.
	 * @param raceCar is the RaceCar array which contains all RaceCars take part in the race.
	 * @param formulaOne is the FormulaOne array which contains all FormulaOnes take part in the race.
	 */
	public void set(RaceCar[] raceCar,FormulaOne[] formulaOne) {
		//Gain the number of RaceCars and FormulaOnes join this race
		this.resRace=raceCar.length;
		this.resFormula=formulaOne.length;
		//initialize finishedRace and finishedFormula arrays.
		this.finishedRace=new RaceCar[resRace];
		this.finishedFormula=new FormulaOne[resFormula];
	}
	
	/**
	 * This is a method whether the raceCar is enter the finish line.
	 * @param i the location of the raceCar in the RaceCar Array
	 * @param raceCar the RaceCar needs to be judged whether enter the finish line or not.
	 * @param logger 
	 */
	public void enterFinishLine(int i,RaceCar raceCar,TrackLoggerB logger) {
		countRace++;
		logger.logFinish(raceCar, (countFormula+countRace));
		finishedRace[i]=raceCar;
	}
	
	/**
	 * This is a method whether the formulaOne is enter the finish line.
	 * @param i the location of the formulaOne in the FormulaOne Array
	 * @param formulaOne the formulaOne needs to be judged whether enter the finish line or not.
	 * @param logger
	 */
	public void enterFinishLine(int i,FormulaOne formulaOne,TrackLoggerB logger) {
		countFormula++;
		logger.logFinish(formulaOne, (countFormula+countRace));
		finishedFormula[i]=formulaOne;
	}
	
	/**
	 * This is a method to judge whether all cars have already entered the finish line
	 * @return true if all cars have entered the finish line, false otherwise
	 */
	public boolean finished() {
		if(countRace==resRace&&countFormula==resFormula) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is a method to gain the integer countRace.
	 * @return integer countRace
	 */
	public int getcountRace() {
		return countRace;
	}
	
	/**
	 * This is a method to gain the integer countFormula
	 * @return integer countFormula
	 */
	public int getcountFormula() {
		return countFormula;
	}
}

