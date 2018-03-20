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
	public static int launchpadPort = 0;

	// Talon Ports
	//drivetrain
	public static int rearLeftPort = 3; //7
	public static int frontLeftPort = 4; //9
	public static int rearRightPort = 10; //2
	public static int frontRightPort = 11;//1
	//cascade
	public static int casL1 = 1;//12
	public static int casL2 = 0;//10
	public static int casR1 = 6;//6
	public static int casR2 = 5;//8
	//acquirer
	//REAL second
	public static int acqLeftPort = 2;//11
	public static int acqRightPort = 8;//3
	public static int pivPort = 9; //4
	
	
	

	// Encoder Ports
	//drivetrain
	
	/*public static int encRL = 7;
	public static int encFL = 9;
	public static int encRR = 2;
	public static int encFR = 1;*/
	//cascade second
	public static int casEncL1 = 1; //12
	public static int casEncL2 = 0;//10
	public static int casEncR1 = 6;//6
	public static int casEncR2 = 5;//8
	
	//Gyro port
	public static int gyroPort = 1;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}