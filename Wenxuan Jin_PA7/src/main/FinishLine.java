/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA7 FinishLine class
 * COSI 12B
 */
package main;

/**
 * This is the FinishLine class check whether a car is entering the finish line and whether all cars entered
 * @author Wenxuan Jin
 *
 */
public class FinishLine{
	/**
	 * There are 3 fields in this class.
	 * countCar is an integer to count how many cars have entered the race.
	 * resCar is an integer to record how many cars take part in the race.
	 * cars is a Car array to store cars which have already pass the finishLine.
	 */
	private int countCar;
	private int resCar;
	private Car[] cars;
	
	/**
	 * This is a method set some fields of FinishLine.
	 * @param cars is the Car array which contains all cars take part in the race.
	 */
	public void set(Car[] cars) {
		//Gain the number of cars join this race
		this.resCar=cars.length;
		//initialize cars array.
		this.cars=new Car[10];
	}
	
	/**
	 * This is a method to make a car enter the finish line.
	 * @param car the car which enters the finish line.
	 */
	public void enterFinishLine(Car car) {
		cars[countCar]=car;
		countCar++;
	}
	
	/**
	 * This is a method to judge whether all cars have already entered the finish line
	 * @return true if all cars have entered the finish line, false otherwise
	 */
	public boolean finished() {
		if(countCar==resCar) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is a method to get the integer countCar.
	 * @return integer countRace
	 */
	public int getcountCar() {
		return countCar;
	}
	
	/**
	 * This is a method to get the cars array
	 * @return cars array
	 */
	public Car[] getCars() {
		return cars;
	}
}

