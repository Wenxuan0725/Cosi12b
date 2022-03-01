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
public class FormulaOne extends Car {
	/**
	 * This is a constructor with two parameters
	 * @param speed the speed of the formulaOne
	 * @param strength the strength of the formulaOne
	 */
	public FormulaOne(int speed, int strength) {
		super();
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
		super();
		this.speed=50;
		this.strength=4;
	}
	
	/**
	 * This is a method to print the information of formulaOne
	 * @return a string of formulaOne's information
	 */
	public String toString() {
//		throw new UnsupportedOperationException("not implemented yet");
		return "FormulaOne"+speed+"/"+strength;
	}
	
	/**
	 * This is a method to get the Score of a formulaOne
	 * @return 100, the score will add when there is a formulaOne
	 */
	public int getScore() {
		return 100;
	}
}
