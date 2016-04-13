package com.daghan.robots.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.daghan.robots.error.Messages;
import com.daghan.robots.impl.Robot.RobotActionEnum;

public class RobotTest {
	Robot unitUnderTest;

	@Before
	public void prepareTest() {
		unitUnderTest = new Robot();
	}

	@Test
	public void testWrongPlaceCommandParameterSize0() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] {});
		assertEquals(Messages.ERROR_PLACE_INSUFFICIENT_PARAMETER, result);
	}

	@Test
	public void testWrongPlaceCommandParameterSize1() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] { "0" });
		assertEquals(Messages.ERROR_PLACE_INSUFFICIENT_PARAMETER, result);
	}

	@Test
	public void testWrongPlaceCommandParameterSize2() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] { "0", "1" });
		assertEquals(Messages.ERROR_PLACE_INSUFFICIENT_PARAMETER, result);
	}

	@Test
	public void testWrongPlaceCommandNonIntegerParameter1() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] { "a", "1", "NORTH" });
		assertEquals(Messages.ERROR_PLACE_NON_INTEGER_PARAMETER, result);
	}

	@Test
	public void testWrongPlaceCommandNonIntegerParameter2() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] { "1", "b", "NORTH" });
		assertEquals(Messages.ERROR_PLACE_NON_INTEGER_PARAMETER, result);
	}

	@Test
	public void testWrongPlaceCommandNonIntegerParameter3() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] { "a", "b", "NORTH" });
		assertEquals(Messages.ERROR_PLACE_NON_INTEGER_PARAMETER, result);
	}

	@Test
	public void testWrongPlaceCommandDirection() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] { "1", "2", "A" });
		assertEquals(Messages.ERROR_PLACE_DIRECTION_WRONG, result);
	}

	@Test
	public void testOutsideTable() {
		String result = unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] { "-1", "2", "NORTH" });
		assertEquals(Messages.ERROR_PLACE_OUTSIDE_TABLE, result);
	}

	@Test
	public void testMoveLeftBeforePlacing() {
		String result = unitUnderTest.executeAction(RobotActionEnum.LEFT);
		assertEquals(Messages.ERROR_ROBOT_NOT_PLACED_YET, result);
	}

	@Test
	public void testMoveRightBeforePlacing() {
		String result = unitUnderTest.executeAction(RobotActionEnum.RIGHT);
		assertEquals(Messages.ERROR_ROBOT_NOT_PLACED_YET, result);
	}

	@Test
	public void testMoveForwardBeforePlacing() {
		String result = unitUnderTest.executeAction(RobotActionEnum.MOVE);
		assertEquals(Messages.ERROR_ROBOT_NOT_PLACED_YET, result);
	}
	
	@Test
	public void testMoveSuccess1() {
		unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] {"0","0","NORTH"});
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		String result = unitUnderTest.executeAction(RobotActionEnum.REPORT);
		assertEquals("0,1,NORTH", result);
	}
	
	@Test
	public void testMoveSuccess2() {
		unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] {"0","0","NORTH"});
		unitUnderTest.executeAction(RobotActionEnum.LEFT);
		String result = unitUnderTest.executeAction(RobotActionEnum.REPORT);
		assertEquals("0,0,WEST", result);
	}
	
	@Test
	public void testMoveSuccess3() {
		unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] {"1","2","EAST"});
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		unitUnderTest.executeAction(RobotActionEnum.LEFT);
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		String result = unitUnderTest.executeAction(RobotActionEnum.REPORT);
		assertEquals("3,3,NORTH", result);
	}
	
	@Test
	public void testStopFalling1() {
		unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] {"3","2","EAST"});
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		String result = unitUnderTest.executeAction(RobotActionEnum.MOVE);
		assertEquals(Messages.ERROR_PLACE_MOVING_OFF_TABLE, result);
		result = unitUnderTest.executeAction(RobotActionEnum.REPORT);
		assertEquals("5,2,EAST", result);
	}
	
	@Test
	public void testStopFalling2() {
		unitUnderTest.executeAction(RobotActionEnum.PLACE, new String[] {"3","2","SOUTH"});
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		unitUnderTest.executeAction(RobotActionEnum.MOVE);
		String result = unitUnderTest.executeAction(RobotActionEnum.MOVE);
		assertEquals(Messages.ERROR_PLACE_MOVING_OFF_TABLE, result);
		result = unitUnderTest.executeAction(RobotActionEnum.REPORT);
		assertEquals("3,0,SOUTH", result);
	}

}
