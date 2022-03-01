/**
 * Wenxuan Jin 
 * wenxuanjin@brandeis.edu
 * PA6 EnterPitStopTester class
 * COSI 12B
 */
package test;

import main.RaceCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.FormulaOne;
import main.PitStop;

import main.TrackLoggerB;

public class EnterPitStopTester {
	/**
	 * This is a tester to test whether a raceCar will enterPitStop
	 */
	@Test
	public void testCase1() {
		TrackLoggerB logger = new TrackLoggerB();
		logger.logNewTick();
		RaceCar car1=new RaceCar();
		PitStop pitStop=new PitStop();
		pitStop.enterPitStop(car1, 4, 6, logger);
		assertEquals(pitStop.getRaceCar()[6].getSpeed(),40);//whether the raceCar enter the raceCar array in the pitStop
		assertEquals(pitStop.getRaceCar()[6].getStrength(),3);
	}
	
	/**
	 * This is a tester to test whether a formulaOne will enterPitStop
	 */
	@Test
	public void testCase2() {
		TrackLoggerB logger = new TrackLoggerB();
		logger.logNewTick();
		FormulaOne car1=new FormulaOne();
		PitStop pitStop=new PitStop();
		pitStop.enterPitStop(car1, 4, 6, logger);
		assertEquals(pitStop.getFormulaOne()[6].getSpeed(),50);//whether the formulaOne enter the raceCar array in the pitStop
		assertEquals(pitStop.getFormulaOne()[6].getStrength(),4);
	}
	
}
