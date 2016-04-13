package com.daghan.robots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.daghan.robots.error.Messages;
import com.daghan.robots.impl.Robot;
import com.daghan.robots.impl.Robot.RobotActionEnum;
import com.daghan.robots.impl.RobotState.RobotDirectionEnum;

/**
 * Main Class for running the program
 * 
 * @author daghan
 *
 */
public class MainClass {
	private static final String END_PROGRAM = "quit";

	public static void main(String[] args) {
		Robot myRobot = new Robot();

		System.out
				.println(String.format("Reading from command line. Please write %s to end the program.", END_PROGRAM));
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input;
			String result = "";
			while ((input = br.readLine()) != null) {
				if (input.equalsIgnoreCase(END_PROGRAM)) {
					System.out.println("Good bye");
					System.exit(0);
				}

				String[] commands = input.split(" ");
				if (commands.length < 1 || commands.length > 4) {
					printUsage();
					continue;
				}
				try {
					result = myRobot.executeAction(RobotActionEnum.valueOf(commands[0]),
							Arrays.copyOfRange(commands, 1, commands.length));
				} catch (IllegalArgumentException e) {
					System.out.println(Messages.ERROR_ACTION_NAME);
					continue;
				}

				System.out.println(result == null ? "" : result);
			}

		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	/**
	 * Prints the usage to the command line
	 */
	private static void printUsage() {
		System.out.println("Usage");
		System.out.println(
				"Place robot on table:\t\t\tPLACE X (int), Y (int), F (one of NORTH, SOUTH, EAST, WEST case sensitive)");
		System.out.println("Move robot (after placing) :\t\tMOVE ");
		System.out.println("Turn robot (after placing) :\t\tLEFT ");
		System.out.println("Turn robot (after placing) :\t\tRIGHT ");
		System.out.println("Report robot position (after placing) :\tLEFT ");
	}

}
