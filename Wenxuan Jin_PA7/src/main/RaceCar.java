/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA7 RaceCar class
 * COSI 12B
 */
package main;

/**
 * This is a class define an object RaceCar
 * @author Wenxuan Jin
 *
 */
public class RaceCar extends Car {
	
	/**
	 * This is a constructor with two parameters
	 * @param speed the speed of the raceCar
	 * @param strength the strength of the raceCar
	 */
	public RaceCar(int speed, int strength) {
		super();
		if(speed<=55&&speed>=30) {
			this.speed=speed;
		}else if(speed<30) {//if the speed is less than the minimum speed of raceCar, then set the speed 30.
			this.speed=30;
		}else {//if the speed is larger than the maximum speed of raceCar, then set the speed 55.
			this.speed=55;
		}
		if(strength<=4&&strength>=2) {
			this.strength=strength;
		}else if(strength<2) {//if the strength is less than the minimum strength of raceCar, then set the strength 2.
			this.strength=2;
		}else {//if the strength is larger than the maximum strength of raceCar, then set the strength 4.
			this.strength=4;
		}
	}
	
	/**
	 * This is a constructor without parameter, which sets the speed as 40 and the strength as 3
	 */
	public RaceCar() {
		super();
		this.speed=40;
		this.strength=3;
	}
	
	/**
	 * This is a method to print the information of raceCar
	 * @return a string of raceCar's information
	 */
	public String toString() {
//		throw new UnsupportedOperationException("not implemented yet");
		return "RaceCar"+speed+"/"+strength;
	}
	
	/**
	 * This is a method to get the Score of raceCar
	 * @return 150, the score will add when there is a raceCar
	 */
	public int getScore() {
		return 150;
	}
}
