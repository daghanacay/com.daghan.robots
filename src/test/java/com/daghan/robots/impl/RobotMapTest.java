package com.daghan.robots.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.daghan.robots.impl.RobotMap.Location;

public class RobotMapTest {
	RobotMap unitUnderTest;

	@Before
	public void prepareTest() {
		unitUnderTest = new RobotMap();
	}

	@Test
	public void testIsInsideViaLocation() {
		// prepare test
		Location myLocation = new Location(1, 1);
		// run test
		boolean result = unitUnderTest.isInsideMap(myLocation);
		// verify
		assertTrue(result);
	}

	@Test
	public void testIsInsideViaCoordiante() {
		// prepare test
		int x = 1;
		int y = 1;
		// run test
		boolean result = unitUnderTest.isInsideMap(x, y);
		// verify
		assertTrue(result);
	}

	@Test
	public void testIsInsideViaLocationExtreams1() {
		// prepare test
		Location myLocation = new Location(0, 5);
		// run test
		boolean result = unitUnderTest.isInsideMap(myLocation);
		// verify
		assertTrue(result);
	}

	@Test
	public void testIsInsideViaLocationExtreams2() {
		// prepare test
		Location myLocation = new Location(5, 0);
		// run test
		boolean result = unitUnderTest.isInsideMap(myLocation);
		// verify
		assertTrue(result);
	}

	@Test
	public void testIsOutsideViaLocation() {
		// prepare test
		Location myLocation = new Location(6, -1);
		// run test
		boolean result = unitUnderTest.isInsideMap(myLocation);
		// verify
		assertFalse(result);
	}
}
