package com.daghan.robots.impl;

/**
 * Map of the room that defines the edges of a map
 * 
 * @author daghan
 *
 */
public class RobotMap {
	private static final int MIN_X_COORD = 0;
	private static final int MAX_X_COORD = 5;
	private static final int MIN_Y_COORD = 0;
	private static final int MAX_Y_COORD = 5;

	/**
	 * true if x,y location is inside the map
	 * 
	 * @param x
	 *            coordinate as integer
	 * @param y
	 *            coordinate as integer
	 * @return
	 */
	public boolean isInsideMap(int x, int y) {
		return MIN_X_COORD <= x && x <= MAX_X_COORD && MIN_Y_COORD <= y && y <= MAX_Y_COORD;
	}

	/**
	 * True if a given location is inside the map
	 * 
	 * @param loc
	 * @return
	 */
	public boolean isInsideMap(Location loc) {
		return isInsideMap(loc.x_coordinate, loc.y_coordinate);
	}

	/**
	 * Location on a map
	 * 
	 * @author daghan
	 *
	 */
	public static class Location {
		private int x_coordinate;
		private int y_coordinate;

		public Location(int x, int y) {
			x_coordinate = x;
			y_coordinate = y;
		}

		public int getXcoordinate() {
			return x_coordinate;
		}

		public int getYcoordinate() {
			return y_coordinate;
		}
	}
}
