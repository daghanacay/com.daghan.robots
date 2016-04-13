package com.daghan.robots.impl;

import com.daghan.robots.impl.RobotMap.Location;

/**
 * Holds the state of the robot and it is thread safe.
 * 
 * @author daghan
 *
 */
public class RobotState {

	private RobotDirectionEnum direction;
	private Location location;

	public RobotState(RobotDirectionEnum direction, Location myLocation) {
		this.direction = direction;
		this.location = myLocation;
	}

	/**
	 * Returns the direction of the robot
	 * 
	 * @return
	 */
	public RobotDirectionEnum getDirection() {
		return direction;
	}

	/**
	 * Gets the location of the robot
	 * 
	 * @return
	 */
	public Location getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return String.format("%d,%d,%s", location.getXcoordinate(), location.getYcoordinate(), direction.name());
	}

	/**
	 * Enumeration that defines all the directions the robot can take
	 * 
	 * @author daghan
	 *
	 */
	public enum RobotDirectionEnum {
		NORTH, SOUTH, EAST, WEST;
		String toLeft, toRight;

		/**
		 * Returns the direction to the left of this direction
		 * 
		 * @return
		 */
		public RobotDirectionEnum toLeft() {
			switch (this) {
			case NORTH:
				return WEST;
			case SOUTH:
				return EAST;
			case WEST:
				return SOUTH;
			case EAST:
				return NORTH;
			}
			return null;
		}

		/**
		 * Returns the direction to the right of this direction
		 * 
		 * @return
		 */
		public RobotDirectionEnum toRight() {
			switch (this) {
			case NORTH:
				return EAST;
			case SOUTH:
				return WEST;
			case WEST:
				return NORTH;
			case EAST:
				return SOUTH;
			}
			return null;
		}

	};
}
