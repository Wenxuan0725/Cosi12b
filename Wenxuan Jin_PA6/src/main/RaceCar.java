/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA6 RaceCar class
 * COSI 12B
 */
package main;

/**
 * This is a class define an object FormulaOne
 * @author Wenxuan Jin
 *
 */
public class RaceCar {
	/**
	 * There are 4 fields in the class
	 * speed is an integer representing the speed of RaceCar
	 * strength is an integer representing the strength of RaceCar
	 * damagedSpeed is an integer representing the speed of RaceCar after damaged
	 * location is a double representing the location of the RaceCar
	 */
	private int speed;
	private int strength;
	private int damagedSpeed;
	private double location;
	
	/**
	 * This is a constructor with two parameters
	 * @param speed the speed of the raceCar
	 * @param strength the strength of the raceCar
	 */
	public RaceCar(int speed, int strength) {
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
		this.speed=40;
		this.strength=3;
	}
	
	/**
	 * This is a method to add distance for each tick
	 * @param location is the distance a raceCar will move for each tick
	 */
	public void setLocation(double location) {
		this.location+=location;
	}
	
	/**
	 * This is a method reset the location of raceCar
	 * @param location is the place a raceCar exit the pitStop
	 */
	public void resetLocation(double location) {
		this.location=location;
	}
	
	/**
	 * This is a method get location of the raceCar
	 * @return location
	 */
	public double getLocation() {
//		throw new UnsupportedOperationException("not implemented yet");
		return location;
	}
	
	/**
	 * This is a method set the speed when the raceCar is damaged
	 */
	public void setDamagedSpeed() {
		damagedSpeed=speed-(strength*5);
	}
	
	/**
	 * This is a method to get the speed of the raceCar
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * This is a method to get the strength of the raceCar
	 * @return strength
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * This is a method to set damaged speed to a integer data(usually 0, means repaired)
	 * @param data an integer for raceCar's damaged speed
	 */
	public void setDamagedSpeed(int data) {
		damagedSpeed=data;//usually 0
	}
	
	/**
	 * This is a method to get the damage speed of raceCar
	 * @return damagedSpeed
	 */
	public int getDamagedSpeed() {
		return damagedSpeed;
	}
	
	/**
	 * This is a method to print the information of raceCar
	 * @return a string of raceCar's information
	 */
	public String toString() {
//		throw new UnsupportedOperationException("not implemented yet");
		return "RaceCar"+speed+"/"+strength;
	}
}
