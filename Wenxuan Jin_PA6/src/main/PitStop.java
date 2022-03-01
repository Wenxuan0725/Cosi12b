/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA6 PitStop class
 * COSI 12B
 */
package main;

/**
 * This is a class define the pitStop object, working to let damaged cars to enter to repaire
 * @author Wenxuan Jin
 *
 */
public class PitStop {
	/**
	 * There are 3 fields in the class
	 * RaceCar is an array contains all raceCars which enter the pitStop
	 * FormulaOne is an array contains all formulaOnes which enter the pitStop
	 * count is an int array contains the tick of all cars enter the pitStop
	 */
	private RaceCar[] RaceCar;
	private FormulaOne[] FormulaOne;
	private int[] count;
	
	/**
	 * This is a constructor of the class
	 */
	public PitStop() {
		this.RaceCar=new RaceCar[10];
		this.FormulaOne=new FormulaOne[10];
		this.count=new int[20];
	}
	
	/**
	 * This is a method to make a raceCar enter a pitStop
	 * @param raceCar the car needs to enter the pitStop
	 * @param tick the tick the car experience currently 
	 * @param i the location of raceCar in the raceCar array of RaceTrack
	 * @param logger to print information
	 */
	public void enterPitStop(RaceCar raceCar,int tick,int i,TrackLoggerB logger) {
		RaceCar[i]=raceCar;//gain the information of the raceCar enter the pitStop
		count[i]=tick;//gain the tick of that raceCar
		logger.logEnterPit(raceCar);
	}
	
	/**
	 * This is a method to make a formulaOne enter a pitStop
	 * @param formulaOne the car needs to enter the pitStop
	 * @param tick the tick the car experience currently 
	 * @param i the location of formulaOne in the formulaOne array of RaceTrack
	 * @param logger to print information
	 */
	public void enterPitStop(FormulaOne formulaOne,int tick,int i,TrackLoggerB logger) {
		FormulaOne[i]=formulaOne;//gain the information of the formulaOne enter the pitStop
		count[10+i]=tick;//gain the tick of that formulaOne
		logger.logEnterPit(formulaOne);
	}
	
	/**
	 * This is a method to check whether a raceCar has already waited for two ticks
	 * @param tick the tick the race current takes
	 * @param i the location of the raceCar in the raceCar array in RaceTrack
	 * @return true if the raceCar has already wait for 2 ticks, otherwise false
	 */
	public boolean checkRace(int tick,int i) {
		if(tick-count[i]==2) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This is a method to check whether a formulaOne has already waited for two ticks
	 * @param tick the tick the race current takes
	 * @param i the location of the formulaOne in the formulaOne array in RaceTrack
	 * @return true if the formulaOne has already wait for 2 ticks, otherwise false
	 */
	public boolean checkFormula(int tick,int i) {
		if(tick-count[i+10]==2) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This is a method to repair damaged raceCars and push raceCars which already wait for two ticks back to the race
	 * @param i the location of the raceCar in the RaceCar array in the pitStop object
	 * @param logger print information that the raceCar exit the pitStop
	 * @return the raceCar which exit the pitStop
	 */
	public RaceCar pushBackRace(int i,TrackLoggerB logger) {
		RaceCar res=RaceCar[i];
		int lap=(int) ((res.getLocation()-res.getDamagedSpeed())/100);
		res.resetLocation(lap*100+75);
		res.setDamagedSpeed(0);
		logger.logExitPit(res);
		RaceCar[i]=null;
		return res;
	}
	
	/**
	 * This is a method to repair damaged formulaOnes and push formulaOnes which already wait for two ticks back to the race
	 * @param i the location of the formulaOne in the FormulaOne array in the pitStop object
	 * @param logger print information that the formulaOne exit the pitStop
	 * @return the formulaOne which exit the pitStop
	 */
	public FormulaOne pushBackFormula(int i,TrackLoggerB logger) {
		FormulaOne res=FormulaOne[i];
		int lap=(int) ((res.getLocation()-res.getDamagedSpeed())/100);
		res.resetLocation(lap*100+75);
		res.setDamagedSpeed(0);
		logger.logExitPit(res);
		FormulaOne[i]=null;
		return res;
	}
	
	/**
	 * This is a method to return the RaceCar(field) in the pitStop class
	 * @return RaceCar array
	 */
	public RaceCar[] getRaceCar() {
		return RaceCar;
	}
	
	/**
	 * This is a method to return the FormulaOne(field) in the pitStop class
	 * @return FormulaOne array
	 */
	public FormulaOne[] getFormulaOne() {
		return FormulaOne;
	}
}
