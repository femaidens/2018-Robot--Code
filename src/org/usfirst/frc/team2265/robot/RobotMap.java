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
	public static int driveJoyPort = 2;
	public static int launchpadPort = 0;

	// Talon Ports
	//drivetrain
	//REAL
	public static int rearLeftPort = 7; //3
	public static int frontLeftPort = 9; //4
	public static int rearRightPort = 2; //10
	public static int frontRightPort = 1;//11
	
	//cascade
	//REAL
	public static int casL1 = 12;//1
	public static int casL2 = 10;//0
	public static int casR1 = 6;//6
	public static int casR2 = 8;//5
	
	//acquirer
	//REAL
	public static int acqLeftPort = 11;//2
	public static int acqRightPort = 3;//8
	public static int pivPort = 4; //9
	
	// Encoder Ports
	//drivetrain REAL
	/*public static int encRL = 7;
	public static int encFL = 9;
	public static int encRR = 2;
	public static int encFR = 1;*/
	
	//cascade REAL
	public static int casEncL1 = 1; //12
	public static int casEncL2 = 0;//10
	public static int casEncR1 = 6;//6
	public static int casEncR2 = 5;//8
	
	//pivot placeholder idk
	//public static int encpivPort = 000;
	
	//Gyro port
	public static int gyroPort = 1;
	
	//solenoid ports
	public static int intakeRPort1 = 0;
	public static int intakeRPort2 = 1; //might conflict with gyro port 
	
	//public static int intakeLPort1 = 0000;
	//public static int intakeLPort2 = 0000;
	
	//public static int climbPort1 = 0000;
	//public static int climbPort2 = 0000;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}