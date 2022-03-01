/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA7 Car class
 * COSI 12B
 */
package main;

/**
 * This is an abstract class which define the object Car
 * @author Wenxuan Jin
 */
public abstract class Car {
	/**
	 * There are 5 fields in the class
	 * speed is an integer representing the speed of a car
	 * strength is an integer representing the strength of a car
	 * damagedSpeed is an integer representing the speed of a car after damaged
	 * location is a double representing the location of a car
	 * tick is the int which represents the tick the car experiences now
	 */
	protected int speed;
	protected int strength;
	protected int damagedSpeed;
	protected double location;
	protected int tick=1;
	
	/**
	 * This is the constructor of this class
	 */
	public Car() {
		this.speed=0;
		this.strength=0;
		this.damagedSpeed=0;
		this.location=0;
	}
	
	/**
	 * This is a method to get the speed of the car
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * This is a method to get the damage speed of a car
	 * @return damagedSpeed
	 */
	public int getDamagedSpeed() {
		return damagedSpeed;
	}
	
	/**
	 * This is a method to get the strength of the car
	 * @return strength
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * This is a method set the speed when the car is damaged
	 */
	public void setDamagedSpeed() {
		damagedSpeed=speed-(strength*5);
	}
	
	/**
	 * This is a method to set damaged speed to a integer data(usually 0, means repaired)
	 * @param data an integer for car's damaged speed
	 */
	public void setDamagedSpeed(int data) {
		damagedSpeed=data;
	}
	
	/**
	 * This is a method reset the location of a car
	 * @param data is the place a car exit the pitStop
	 */
	public void resetLocation(double data) {
		this.location=data;
	}
	
	/**
	 * This is a method to add distance for each tick
	 * @param speed is the distance a car will move for each tick
	 */
	public void setLocation(double speed) {
		this.location+=speed;
	}
	
	/**
	 * This is a method get location of a car
	 * @return location
	 */
	public double getLocation() {
		return location;
	}
	
	/**
	 * This is a method to print the information of a car
	 * @return a string of a car's information
	 */
	public String toString() {
		return "Car"+speed+"/"+strength;
	}
	
	/**
	 * This is a method to get the Score of a car
	 * @return the score of a car add
	 */
	public abstract int getScore();
	
	/**
	 * This is a method to get the tick of the car
	 * @return tick
	 */
	public int getTick() {
		return tick;
	}
	
	/**
	 * This is a method to set the tick of the car
	 * @param count the tick the race take now
	 */
	public void setTick(int count) {
		tick=count;
	}

}
