package com.daghan.robots.error;

public class Messages {
	// Error messages
	public static final String ERROR_PLACE_INSUFFICIENT_PARAMETER = "ERROR: PLACE command takes three parameters: X,Y,F x location, y location, and direction respectively.";
	public static final String ERROR_PLACE_NON_INTEGER_PARAMETER = "ERROR: First two paramteres to PLACE should be integer.";
	public static final String ERROR_PLACE_DIRECTION_WRONG = "ERROR: The last parameter to PLACE should be either one of NORTH, SOUTH, EAST, or WEST case sensitive.";
	public static final String ERROR_PLACE_OUTSIDE_TABLE = "ERROR: The robot is located outside the table.";
	public static final String ERROR_PLACE_MOVING_OFF_TABLE = "ERROR: Moving off the table, action ignored position not changed.";
	public static final String ERROR_ROBOT_NOT_PLACED_YET = "ERROR: Robot has not been placed yet ignoring the action.";
	public static final String ERROR_ACTION_NAME = "ERROR: Action can be one of PLACE, MOVE, LEFT, RIGHT, or REPORT case sensitive.";

}
