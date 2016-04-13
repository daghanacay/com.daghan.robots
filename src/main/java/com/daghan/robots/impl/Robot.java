package com.daghan.robots.impl;

import com.daghan.robots.error.Messages;
import com.daghan.robots.impl.RobotMap.Location;
import com.daghan.robots.impl.RobotState.RobotDirectionEnum;

public class Robot {
	public enum RobotActionEnum {
		PLACE, MOVE, LEFT, RIGHT, REPORT
	};

	private RobotState myState;
	private RobotMap robotMap = new RobotMap();

	/**
	 * Executes and action on this robot. Actions should be one of the actions
	 * defines on this robot.
	 * 
	 * @param action
	 * @param parameters
	 * @return error or corresponding success message of the required action.
	 */
	public String executeAction(RobotActionEnum action, String... parameters) {
		String returnVal = null;

		switch (action) {
		case PLACE:
			int x = 0, y = 0;
			RobotDirectionEnum direction;
			if (parameters.length < 3) {
				returnVal = Messages.ERROR_PLACE_INSUFFICIENT_PARAMETER;
				break;
			}

			try {
				x = Integer.parseInt(parameters[0]);
				y = Integer.parseInt(parameters[1]);
			} catch (NumberFormatException e) {
				returnVal = Messages.ERROR_PLACE_NON_INTEGER_PARAMETER;
				break;
			}

			try {
				direction = RobotDirectionEnum.valueOf(parameters[2]);
			} catch (IllegalArgumentException | NullPointerException e) {
				returnVal = Messages.ERROR_PLACE_DIRECTION_WRONG;
				break;
			}
			Location myLocation = new Location(x, y);
			if (!robotMap.isInsideMap(myLocation)) {
				returnVal = Messages.ERROR_PLACE_OUTSIDE_TABLE;
				break;
			}

			// place the robot
			myState = new RobotState(direction, myLocation);
			break;
		case LEFT:
			if (myState == null) {
				returnVal = Messages.ERROR_ROBOT_NOT_PLACED_YET;
				break;
			}
			myState = new RobotState(myState.getDirection().toLeft(), myState.getLocation());
			break;
		case RIGHT:
			if (myState == null) {
				returnVal = Messages.ERROR_ROBOT_NOT_PLACED_YET;
				break;
			}
			myState = new RobotState(myState.getDirection().toRight(), myState.getLocation());
			break;
		case MOVE:
			if (myState == null) {
				returnVal = Messages.ERROR_ROBOT_NOT_PLACED_YET;
				break;
			}
			Location newLoc;
			switch (myState.getDirection()) {
			case NORTH:
				newLoc = new Location(myState.getLocation().getXcoordinate(),
						myState.getLocation().getYcoordinate() + 1);

				if (!robotMap.isInsideMap(newLoc)) {
					returnVal = Messages.ERROR_PLACE_MOVING_OFF_TABLE;
					break;
				}
				myState = new RobotState(myState.getDirection(), newLoc);
				break;
			case SOUTH:
				newLoc = new Location(myState.getLocation().getXcoordinate(),
						myState.getLocation().getYcoordinate() - 1);

				if (!robotMap.isInsideMap(newLoc)) {
					returnVal = Messages.ERROR_PLACE_MOVING_OFF_TABLE;
					break;
				}
				myState = new RobotState(myState.getDirection(), newLoc);
				break;
			case WEST:
				newLoc = new Location(myState.getLocation().getXcoordinate() - 1,
						myState.getLocation().getYcoordinate());

				if (!robotMap.isInsideMap(newLoc)) {
					returnVal = Messages.ERROR_PLACE_MOVING_OFF_TABLE;
					break;
				}
				myState = new RobotState(myState.getDirection(), newLoc);
				break;
			case EAST:
				newLoc = new Location(myState.getLocation().getXcoordinate() + 1,
						myState.getLocation().getYcoordinate());

				if (!robotMap.isInsideMap(newLoc)) {
					returnVal = Messages.ERROR_PLACE_MOVING_OFF_TABLE;
					break;
				}
				myState = new RobotState(myState.getDirection(), newLoc);
				break;
			}
			break;
		case REPORT:
			if (myState == null) {
				returnVal = Messages.ERROR_ROBOT_NOT_PLACED_YET;
				break;
			}

			returnVal = myState.toString();
			break;
		default:
			System.out.println("Unkown action " + action.toString());
			break;
		}

		return returnVal;
	}

}
