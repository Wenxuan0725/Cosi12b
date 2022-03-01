/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA7 PitStop class
 * COSI 12B
 */
package main;

/**
 * This is a class define the pitStop object, working to let damaged cars to enter to repair
 * @author Wenxuan Jin
 *
 */
public class PitStop {
	/**
	 * There are 2 fields in the class
	 * cars is a Car array contains all cars which enter the pitStop.
	 * race is a Car array contains information about cars running in the race.
	 */
	private Car[]cars;
	private Car[]race;
	
	/**
	 * This is a constructor of the class
	 */
	public PitStop(Car[] cars) {
		this.race=cars;
		this.cars=new Car[10];
	}
	
	/**
	 * This is a method to make a car enter a pitStop
	 * @param car the car needs to enter the pitStop
	 */
	public void enterPitStop(Car car) {
		for(int i=0;i<race.length;i++) {
			if(race[i]!=null&&race[i].toString().equals(car.toString())) {
				cars[i]=car;//put the car in the cars array at the same location (i) with the race array
			}
		}
	}
	
	/**
	 * This is a method to check whether a car has already waited for two ticks
	 * @param i the location of the car in the cars array in PitStop object
	 * @param tick the tick the race current takes
	 */
	public boolean checkCar(int i,int tick) {
		if(tick-cars[i].getTick()==2) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This is a method to repair damaged cars and push cars which already wait for two ticks back to the race
	 * @param i the location of the car in the cars array in the pitStop object
	 * @return the car which exit the pitStop
	 */
	public Car pushBack(int i) {
		Car res=cars[i];
		int lap=(int) ((res.getLocation()-res.getDamagedSpeed())/100);
		res.resetLocation(lap*100+75);
		res.setDamagedSpeed(0);
		cars[i]=null;
		return res;
	}
	
	/**
	 * This is a method to return the cars array(field) in the pitStop class
	 * @return RaceCar array
	 */
	public Car[] getCar() {
		return cars;
	}
}
