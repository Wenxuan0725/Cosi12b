/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA7 SportsCar class
 * COSI 12B
 */
package main;

/**
 * This is a class define an object SportsCar
 * @author Wenxuan Jin
 *
 */
public class SportsCar extends Car{
	/**
	 * This is a constructor with two parameters
	 * @param speed the speed of the SportsCar
	 * @param strength the strength of the SportsCar
	 */
	public SportsCar(int speed, int strength) {
		super();
		if(speed<=45&&speed>=20) {
			this.speed=speed;
		}else if(speed<20) {//if the speed is less than the minimum speed of SportsCar, then set the speed 30.
			this.speed=20;
		}else {//if the speed is larger than the maximum speed of SportsCar, then set the speed 55.
			this.speed=45;
		}
		if(strength<=3&&strength>=1) {
			this.strength=strength;
		}else if(strength<1) {//if the strength is less than the minimum strength of SportsCar, then set the strength 2.
			this.strength=1;
		}else {//if the strength is larger than the maximum strength of SportsCar, then set the strength 4.
			this.strength=3;
		}
	}
	
	/**
	 * This is a constructor without parameter, which sets the speed as 30 and the strength as 2
	 */
	public SportsCar() {
		super();
		this.speed=30;
		this.strength=2;
	}
	
	/**
	 * This is a method to print the information of SportsCar
	 * @return a string of SportsCar's information
	 */
	public String toString() {
//		throw new UnsupportedOperationException("not implemented yet");
		return "SportsCar"+speed+"/"+strength;
	}
	
	/**
	 * This is a method to get the Score of a SportCar
	 * @return 200, the score will add when there is a SportCar
	 */
	public int getScore() {
		return 200;
	}

}



