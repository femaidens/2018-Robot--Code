package org.usfirst.frc.team2265.robot;

//RobotMap.java
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// Joystick Ports
	public static int driveJoyPort = 1;
	// public static int atkJoyPort = 1;

	// Talon Ports
	
	public static int rearLeftPort = 7;
	public static int frontLeftPort = 9; 
	public static int rearRightPort = 2; 
	public static int frontRightPort = 1;
	
	public static int casL1 = 12;
	public static int casL2 = 10;
	public static int casR1 = 6;
	public static int casR2 = 8;

	// Encoder Ports
	public static int encRL = 7;
	public static int encFL = 9;
	public static int encRR = 2;
	public static int encFR = 1;
	
	public static int casEncL1 = 12;
	public static int casEncL2 = 10;
	public static int casEncR1 = 6;
	public static int casEncR2 = 8;
	
	//Gyro port
	public static int gyroPort = 1;


	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}