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
	/*public static int rearLeftPort = 1;
	public static int frontLeftPort = 2;

	public static int rearRightPort = 3;
	public static int frontRightPort = 4; */
	
	public static int rearLeftPort = 7; //3
	public static int frontLeftPort = 9; //4
	public static int rearRightPort = 2; //1
	public static int frontRightPort = 1; //2
	
	//U-squish talon ports
	public static int acqLeftPort = 11;
	public static int acqRightPort = 3;
	public static int pivPort = 4;
	


	// Encoder Ports
	/*public static int encPort1 = 5;
	public static int encPort2 = 6;
	public static int encPort3 = 7;
	public static int encPort4 = 8;*/
	/*public static int encPort1 = 4;
	public static int encPort2 = 5;
	public static int encPort3 = 6;
	public static int encPort4 = 7;
	
	public static int encPivPort1 = 5;
	public static int encPivPort2 = 5;
	public static int encPivPort3 = 5;
	public static int encPivPort4 = 5;*/
	
	//Gyro port
	public static int gyroPort = 10;

	//limit switch ports
	//public static int acqlimPort = 1; 
	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}