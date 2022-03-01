/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA6 FormulaOne class
 * COSI 12B
 */
package main;

/**
 * This is a class define an object FormulaOne
 * @author Wenxuan Jin
 *
 */
public class FormulaOne {
	/**
	 * There are 4 fields in the class
	 * speed is an integer representing the speed of FormulaOne
	 * strength is an integer representing the strength of FormulaOne
	 * damagedSpeed is an integer representing the speed of FormulaOne after damaged
	 * location is a double representing the location of the FormulaOne
	 */
	private int speed;
	private int strength;
	private int damagedSpeed;
	private double location;
	
	/**
	 * This is a constructor with two parameters
	 * @param speed the speed of the formulaOne
	 * @param strength the strength of the formulaOne
	 */
	public FormulaOne(int speed, int strength) {
		if(speed<=70&&speed>=30) {
			this.speed=speed;
		}else if(speed<30) {//if the speed is less than the minimum speed of formulaOne, then set the speed 30.
			this.speed=30;
		}else {//if the speed is larger than the maximum speed of formulaOne, then set the speed 70.
			this.speed=70;
		}
		if(strength<=5&&strength>=3) {
			this.strength=strength;
		}else if(strength<3) {//if the strength is less than the minimum strength of formulaOne, then set the strength 3.
			this.strength=3;
		}else {//if the strength is larger than the maximum strength of formulaOne, then set the strength 5.
			this.strength=5;
		}
	}
	
	/**
	 * This is a constructor without parameter, which set speed as 50 and strength as 4
	 */
	public FormulaOne() {
		this.speed=50;
		this.strength=4;
	}
	
	/**
	 * This is a method to add distance for each tick
	 * @param location is the distance a formulaOne will move for each tick
	 */
	public void setLocation(double location) {
		this.location+=location;
	}
	
	/**
	 * This is a method reset the location of formulaOne
	 * @param location is the place a formulaOne exit the pitStop
	 */
	public void resetLocation(double location) {
		this.location=location;
	}
	
	/**
	 * This is a method get location of the formulaOne
	 * @return location
	 */
	public double getLocation() {
//		throw new UnsupportedOperationException("not implemented yet");
		return location;
	}
	
	/**
	 * This is a method set the speed when the formulaOne is damaged
	 */
	public void setDamagedSpeed() {
		damagedSpeed=speed-(strength*5);
	}
	
	/**
	 * This is a method to get the speed of the formulaOne
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * This is a method to get the strength of the formulaOne
	 * @return strength
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * This is a method to set damaged speed to a integer data(usually 0, means repaired)
	 * @param data an integer for formulaOne's damaged speed
	 */
	public void setDamagedSpeed(int data) {
		damagedSpeed=data;//usually 0
	}
	
	/**
	 * This is a method to get the damage speed of formulaOne
	 * @return damagedSpeed
	 */
	public int getDamagedSpeed() {
		return damagedSpeed;
	}
	
	/**
	 * This is a method to print the information of formulaOne
	 * @return a string of formulaOne's information
	 */
	public String toString() {
//		throw new UnsupportedOperationException("not implemented yet");
		return "FormulaOne"+speed+"/"+strength;
	}
}
