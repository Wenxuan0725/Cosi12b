/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA6 RaceTrack class
 * COSI 12B
 */
package main;

/**
 * This is a class organize those cars when they palying.
 * @author Wenxuan Jin
 *
 */
public class RaceTrack {
	/**
	 * There are 6 fields in the class
	 * raceCar is a RaceCar array containing all raceCars joining this race
	 * formulaOne is a FormulaOne array containing all formulaOnes joining this race
	 * count is an integer to record how many ticks cars take before the last car entering finish line
	 * pitStop is a PitStop object which uses to fix damaged cars
	 * finishLine is a FinishLine object which uses to judge whether a car enter the finish line and whether all cars are finished
	 * logger is a TrackLoggerB object which works to print information 
	 */
	private RaceCar[] raceCar;
	private FormulaOne[] formulaOne;
	private int count=1;
	private PitStop pitStop;
	private FinishLine finishLine;

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerB logger;
	
	/**
	 * This is the constructor of the class
	 */
	public RaceTrack() {
		logger = new TrackLoggerB(); // DO NOT REMOVE THIS LINE
		this.raceCar=new RaceCar[10];
		this.formulaOne=new FormulaOne[10];
		this.pitStop=new PitStop();
		this.finishLine=new FinishLine();
		
	}
	
	/**
	 * This is a set method to gain all raceCars (only raceCars) which join this race
	 * @param racecars is an array contains all raceCars joining this race
	 */
	public void setCars(RaceCar[] racecars) {
		this.raceCar=racecars;
		this.formulaOne=new FormulaOne[0];
	}
	
	/**
	 * This is another version of set method to gain all raceCars and formulaOnes which join this race 
	 * @param racecars is an array contains all raceCars joining this race
	 * @param formulaOnes is an array contains all formulaOnes joining this race
	 */
	public void setCars(RaceCar[] racecars, FormulaOne[] formulaOnes) {
		this.raceCar=racecars;
		this.formulaOne=formulaOnes;
	}
	
	/**
	 * This is a method to tick, make all cars run once, and check condition of all cars.
	 */
	public void tick() {
		logger.logNewTick();//print a new tick
		for(int i=0;i<raceCar.length;i++) {//push raceCars to move
			if(raceCar[i]!=null&&raceCar[i].getDamagedSpeed()==0) {//if raceCar does not damage, move distance of speed
				raceCar[i].setLocation(raceCar[i].getSpeed());
			}else if(raceCar[i]!=null) {//if raceCar has damaged, move distance of damage speed
				raceCar[i].setLocation(raceCar[i].getDamagedSpeed());
			}
		}
		for(int i=0;i<formulaOne.length;i++) {//push formulaOnes to move
			if(formulaOne[i]!=null&&formulaOne[i].getDamagedSpeed()==0) {//if formulaOne does not damage, move distance of speed
				formulaOne[i].setLocation(formulaOne[i].getSpeed());
			}else if(formulaOne[i]!=null){//if formulaOne has damaged, move distance of damage speed
				formulaOne[i].setLocation(formulaOne[i].getDamagedSpeed());
			}
		}
		
		for(int i=0;i<raceCar.length;i++) {//check whether there is a raceCar needs to enter pitStop
			//if the raceCar is damaged and it pass the 75 unit of a lap, it will enter the pitStop
			if(raceCar[i]!=null&&raceCar[i].getDamagedSpeed()!=0&&((raceCar[i].getLocation()-raceCar[i].getDamagedSpeed())%100+raceCar[i].getDamagedSpeed())>=75) {
				pitStop.enterPitStop(raceCar[i],count,i,logger);
				raceCar[i]=null;//the car need be removed from raceCar array until 2 ticks after
			}
		}
		
		for(int i=0;i<formulaOne.length;i++) {//check whether there is a formulaOne needs to enter pitStop
			//if the formulaOne is damaged and it pass the 75 unit of a lap, it will enter the pitStop
			if(formulaOne[i]!=null&&formulaOne[i].getDamagedSpeed()!=0&&((formulaOne[i].getLocation()-formulaOne[i].getDamagedSpeed())%100+formulaOne[i].getDamagedSpeed())>=75) {
				pitStop.enterPitStop(formulaOne[i],count,i,logger);
				formulaOne[i]=null;//the car need be removed from formulaOne array until 2 ticks after
			}
		}
		
		for(int i=0;i<pitStop.getRaceCar().length;i++) {//check whether the raceCar in pitStop can return to the race
			if(pitStop.getRaceCar()[i]!=null) {//if there is a car in the raceCar array in pitStop
				if(pitStop.checkRace(count,i)) {//if the raceCar has already waited two ticks
					raceCar[i]=pitStop.pushBackRace(i,logger);//the car will return to the raceCar array of the RaceTrack
					raceCar[i].setLocation(raceCar[i].getSpeed());//after returning, it will move immediately the distance of its speed
				}
			}
		}
		
		for(int i=0;i<pitStop.getFormulaOne().length;i++) {//check whether the formulaOne in pitStop can return to the race
			if(pitStop.getFormulaOne()[i]!=null) {//if there is a car in the formulaOne array in pitStop
				if(pitStop.checkFormula(count,i)) {//if the formulaOne has already waited two ticks
					formulaOne[i]=pitStop.pushBackFormula(i,logger);//the car will return to the formulaOne array of the RaceTrack
					formulaOne[i].setLocation(formulaOne[i].getSpeed());//after returning, it will move immediately the distance of its speed
				}
			}
		}
		
		for(int i=0;i<raceCar.length;i++) {//check whether the raceCar enter the finish line
			if (raceCar[i]!=null&&raceCar[i].getLocation()>=1000) {//if the raceCar has already 10 laps, the raceCar will enter the finish line
				finishLine.enterFinishLine(i,raceCar[i],logger);
				raceCar[i]=null;//after entering the finish line, the car will be removed from the raceCar array
			}
		}
		for(int i=0;i<formulaOne.length;i++) {//check whether the formulaOne enter the finish line
			if (formulaOne[i]!=null&&formulaOne[i].getLocation()>=1000) {//if the formulaOne has already 10 laps, the formulaOne will enter the finish line
				finishLine.enterFinishLine(i,formulaOne[i],logger);
				formulaOne[i]=null;//after entering the finish line, the car will be removed from the formulaOne array
			}
		}
		
		checkCollision();//check if there are cars colliding
		count++;
	}
	
	/**
	 * This is a method to check whether there is a collision occurred
	 */
	public void checkCollision() {
		for(int i=0;i<raceCar.length;i++) {
			for(int j=i+1;j<raceCar.length;j++) {//this is double for loop which will let all raceCars compared with other raceCars in raceCar array
				if(raceCar[i]!=null&&raceCar[j]!=null&&raceCar[i].getLocation()%100==raceCar[j].getLocation()%100) {//if two raceCars stop at the same unit no matter which lap, they will collide
					if(raceCar[i].getDamagedSpeed()==0) {//the speed of raceCar will only change if it did not damage before
						logger.logDamaged(raceCar[i]);
						raceCar[i].setDamagedSpeed();
					}
					if(raceCar[j].getDamagedSpeed()==0) {
						logger.logDamaged(raceCar[j]);
						raceCar[j].setDamagedSpeed();
					}
				}
			}
		}
		for(int i=0;i<formulaOne.length;i++) {//this is double for loop which will let all formulaOnes compared with other formulaOnes in raceCar array
			for(int j=i+1;j<formulaOne.length;j++) {
				if(formulaOne[i]!=null&&formulaOne[j]!=null&&formulaOne[i].getLocation()%100==formulaOne[j].getLocation()%100) {//if two formulaOnes stop at the same unit no matter which lap, they will collide
					if(formulaOne[i].getDamagedSpeed()==0) {//the speed of the formulaOne will only change if it did not damage before
						logger.logDamaged(formulaOne[i]);
						formulaOne[i].setDamagedSpeed();
					}
					if(formulaOne[j].getDamagedSpeed()==0) {
						logger.logDamaged(formulaOne[j]);
						formulaOne[j].setDamagedSpeed();
					}
				}
			}
		}
		for(int i=0;i<raceCar.length;i++) {//this is double for loop which will let all raceCars compared with all formulaOnes
			for(int j=0;j<formulaOne.length;j++) {
				if(raceCar[i]!=null&&formulaOne[j]!=null&&raceCar[i].getLocation()%100==formulaOne[j].getLocation()%100) {//if the raceCars and the formulaOne stop at the same unit no matter which lap, they will collide
					if(raceCar[i].getDamagedSpeed()==0) {//the speed of those cars will only change if it did not damage before
						logger.logDamaged(raceCar[i]);
						raceCar[i].setDamagedSpeed();
					}
					if(formulaOne[j].getDamagedSpeed()==0) {
						logger.logDamaged(formulaOne[i]);
						formulaOne[j].setDamagedSpeed();
					}
				}
			}
		}
	}
	
	/**
	 * This is a method to run the race
	 */
	public void run() {
		finishLine.set(raceCar, formulaOne);//set the finishLine object
		while(!finishLine.finished()) {//this is a while loop which will stop until all cars have finished
			tick();
		}
		calculatorScore(count-1);//Calculate the score of the race at the end of the race
	}
	
	/**
	 * This is a method to calculate the score of cars in the race
	 * @param ticks an integer of the number of tick/round
	 * @return the score
	 */
	public int calculatorScore(int ticks) {
//		throw new UnsupportedOperationException("not implemented yet");
		int res=1000-ticks*20+finishLine.getcountFormula()*100+finishLine.getcountRace()*150;
		logger.logScore(res);
		return res;
	}
	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerB getLogger() {
		return logger;
	}

}
