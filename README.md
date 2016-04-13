# Robot Example

Description
-----------

- A toy robot moving on a square table top of dimensions 5 units x 5 units.
- The robot is free to roam around the surface within the boundaries. Robot will ignore any commands that will make it fall off the table but will continue to receive commands.

- Robot can understand the following commands:
    PLACE X,Y,F
    MOVE
    LEFT
    RIGHT
    REPORT

- PLACE will put the toy robot on the table in position X,Y and facing NORTH,
  SOUTH, EAST or WEST.
- The origin (0,0) is considered to be the SOUTH WEST most corner.
- The first valid command to the robot is a PLACE command, after that, any
  sequence of commands may be issued, in any order, including another PLACE
  command. The application should discard all commands in the sequence until
  a valid PLACE command has been executed.
- MOVE will move the toy robot one unit forward in the direction it is
  currently facing.
- LEFT and RIGHT will rotate the robot 90 degrees in the specified direction
  without changing the position of the robot.
- REPORT will announce the X,Y and F of the robot. This can be in any form,
  but standard output is sufficient.

- Any MOVE, LEFT, RIGHT, and REPORT will be ignored if a valid PLACE command has not been issued.
- Input is from command line

## Installation 

Install Apache Maven https://maven.apache.org/install.html
 
In the folder where this read.me exists run he following command

mvn clean package

## Running the program

In the folder where this Readme file is, get help by writing:

java -cp target/com.daghan.robots-0.0.1-SNAPSHOT.jar com.daghan.robots.MainClass

## Example

Automated test can be found in "RobotTest.java"

or you can try from the command line  
    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Expected output
    3,3,NORTH
