/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA7 CarTester class
 * COSI 12B
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.Car;
import main.FormulaOne;
import main.RaceCar;
import main.SportsCar;

public class CarTester {
	@Test
	public void testCase1() {
		Car car=new RaceCar();
		assertEquals(car.getSpeed(),40);
		assertEquals(car.getStrength(),3);
	}
	
	@Test
	public void testCase2() {
		Car car=new RaceCar(70,6);
		assertEquals(car.getSpeed(),55);
		assertEquals(car.getStrength(),4);
	}
	
	@Test
	public void testCase3() {
		Car car=new FormulaOne();
		assertEquals(car.getSpeed(),50);
		assertEquals(car.getStrength(),4);
	}
	
	@Test
	public void testCase4() {
		Car car=new FormulaOne(89,8);
		assertEquals(car.getSpeed(),70);
		assertEquals(car.getStrength(),5);
	}
	
	@Test
	public void testCase5() {
		Car car=new SportsCar();
		assertEquals(car.getSpeed(),30);
		assertEquals(car.getStrength(),2);
	}
	
	@Test
	public void testCase6() {
		Car car=new SportsCar(55,4);
		assertEquals(car.getSpeed(),45);
		assertEquals(car.getStrength(),3);
	}
	
}
