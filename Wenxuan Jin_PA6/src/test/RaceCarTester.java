/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA6 RaceCarTester class
 * COSI 12B
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.RaceCar;

public class RaceCarTester {
	/**
	 * This is a tester to test the raceCar constructor without parameter
	 */
	@Test
	public void testCase1() {
		RaceCar car1=new RaceCar();
		RaceCar car2=new RaceCar(40,3);
		assertEquals(car1.getSpeed(),car2.getSpeed());
		assertEquals(car1.getStrength(),car2.getStrength());
		
	}
	
	/**
	 * This is a tester to test raceCar constructor when the speed and strength are larger than the maximum of raceCar's speed and strength.
	 */
	@Test
	public void testCase2(){
		RaceCar car1=new RaceCar(80,9);
		assertEquals(car1.getSpeed(),55);
		assertEquals(car1.getStrength(),4);
	}
	
	/**
	 * This is a tester to test raceCar constructor when the speed and strength are less than the minimum of raceCar's speed and strength.
	 */
	@Test
	public void testCase3(){
		RaceCar car1=new RaceCar(20,1);
		assertEquals(car1.getSpeed(),30);
		assertEquals(car1.getStrength(),2);
	}
	
	/**
	 * This is a tester to test raceCar constructor when the speed and strength are in the range of raceCar's speed and strength.
	 */
	@Test
	public void testCase4(){
		RaceCar car1=new RaceCar(46,4);
		assertEquals(car1.getSpeed(),46);
		assertEquals(car1.getStrength(),4);
	}
}
