/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA7 RaceTrack class
 * COSI 12B
 */
package main;

/**
 * This is a class organize those cars when they play.
 * @author Wenxuan Jin
 *
 */
public class RaceTrack {
	/**
	 * There are 5 fields in the class
	 * cars is a Car array containing all cars joining this race
	 * count is an integer to record how many ticks cars take until the last car entering finish line
	 * pitStop is a PitStop object which uses to fix damaged cars
	 * finishLine is a FinishLine object which uses to judge whether a car enter the finish line and whether all cars are finished
	 * logger is a TrackLoggerC object which works to print information 
	 */
	private Car []cars;
	private int count=1;
	private PitStop pitStop;
	private FinishLine finishLine;

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerC logger;
	
	/**
	 * This is the constructor of the class
	 */
	public RaceTrack() {
		logger = new TrackLoggerC(); // DO NOT REMOVE THIS LINE
		this.cars=new Car[10];
		this.finishLine=new FinishLine();
		
	}
	
	/**
	 * This is a set method to gain all cars which join this race
	 * @param cars is an array contains all cars joining this race
	 */
	public void setCars(Car[] cars) {
		this.cars=cars;
		this.pitStop=new PitStop(cars);
	}
	
	/**
	 * This is a method to tick, make all cars run once, and check condition of all cars.
	 */
	public void tick() {
		logger.logNewTick();//print a new tick
		
		for(int i=0;i<cars.length;i++) {//this is a for loop which will end until reviewing all cars once
			if(cars[i]!=null) {
				cars[i].setTick(count);//update the tick cars experience now
			}
		}
		
		for(int i=0;i<cars.length;i++) {//push cars to move
			if(cars[i]!=null&&cars[i].getDamagedSpeed()==0) {//if cars does not damage, move distance of speed
				cars[i].setLocation(cars[i].getSpeed());
			}else if(cars[i]!=null) {//if cars has damaged, move distance of damaged speed
				cars[i].setLocation(cars[i].getDamagedSpeed());
			}
		}
		
		for(int i=0;i<cars.length;i++) {//check whether there is a car needs to enter pitStop
			//if the car is damaged and it pass the 75 unit of a lap, it will enter the pitStop
			if(cars[i]!=null&&cars[i].getDamagedSpeed()!=0&&(cars[i].getLocation()-cars[i].getDamagedSpeed())%100<=75&&((cars[i].getLocation()-cars[i].getDamagedSpeed())%100+cars[i].getDamagedSpeed())>=75) {
				pitStop.enterPitStop(cars[i]);
				logger.logEnterPit(cars[i]);
				cars[i]=null;//the car needs be removed from cars array if it enter pitStop
			}
		}
		
		for(int i=0;i<pitStop.getCar().length;i++) {//check whether the car in pitStop can return to the race
			if(pitStop.getCar()[i]!=null) {//if there is a car in the cars array in pitStop
				if(pitStop.checkCar(i, count)) {//if the car has already waited two ticks
					cars[i]=pitStop.pushBack(i);//the car will return to the cars array of the RaceTrack
					logger.logExitPit(cars[i]);
					cars[i].setLocation(cars[i].getSpeed());//after returning, it will move immediately the distance of its speed
				}
			}
		}
		
		for(int i=0;i<cars.length;i++) {//check whether the car enter the finish line
			if (cars[i]!=null&&cars[i].getLocation()>=1000) {//if the car has already run 10 laps, the car will enter the finish line
				finishLine.enterFinishLine(cars[i]);
				logger.logFinish(cars[i], finishLine.getcountCar());
				cars[i]=null;//after entering the finish line, the car will be removed from the raceCar array
			}
		}
		
		checkCollision();//check if there are cars colliding
		count++;
	}
	
	/**
	 * This is a method to check whether there is a collision occurred
	 */
	public void checkCollision() {
		for(int i=0;i<cars.length;i++) {
			for(int j=i+1;j<cars.length;j++) {//this is double for loop which will let all cars compared with other cars in cars array
				if(cars[i]!=null&&cars[j]!=null&&cars[i].getLocation()%100==cars[j].getLocation()%100) {//if two cars stop at the same unit no matter which lap, they will collide
					if(cars[i].getDamagedSpeed()==0) {//the speed of the car will only change if it did not damage before
						logger.logDamaged(cars[i]);
						cars[i].setDamagedSpeed();
					}
					if(cars[j].getDamagedSpeed()==0) {
						logger.logDamaged(cars[j]);
						cars[j].setDamagedSpeed();
					}
				}
			}
		}
	}

	/**
	 * This is a method to run the race
	 */
	public void run() {
		finishLine.set(cars);//set the finishLine object
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
		int res=1000-20*(count-1);
		for(int i=0;i<finishLine.getCars().length;i++) {
			if(finishLine.getCars()[i]!=null) {
				res+=finishLine.getCars()[i].getScore();
			}
		}
		logger.logScore(res);
		return res;
	}
	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerC getLogger() {
		return logger;
	}

}
