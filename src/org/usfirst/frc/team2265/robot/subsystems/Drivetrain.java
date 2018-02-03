package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;
import org.usfirst.frc.team2265.robot.commands.DriveTeleop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands
	// Initialize CANTalons
	  public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeftPort);
	  public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.rearLeftPort);
	  public static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRightPort);
	  public static WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotMap.rearRightPort);
	  
	  public static SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeft, rearLeft);
	  public static SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRight, rearRight);
	  public static DifferentialDrive difdrive = new DifferentialDrive(leftMotors, rightMotors);
	  
	  public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);

	// Initializing encoder

	  public static Encoder encoderLeft = new Encoder(RobotMap.encPort1, RobotMap.encPort2, true,
			Encoder.EncodingType.k1X);
	  public static Encoder encoderRight = new Encoder(RobotMap.encPort3, RobotMap.encPort4, false,
			Encoder.EncodingType.k1X);
	  public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

	  public static double constant = 8.6;

	  public Drivetrain() {
			encoderLeft.setMaxPeriod(2);
			encoderRight.setMaxPeriod(2);
		}

	// Teleop
	 public void drive() {
			double leftVal = OI.driveJoystick.getRawAxis(5);
			double rightVal = OI.driveJoystick.getRawAxis(1);
			 //System.out.println("leftVal: " + encoderLeft.get() + " rightVal: " + encoderRight.get());
			System.out.println("Gyro: "+ gyro.getAngle());
			frontRight.set(ControlMode.PercentOutput,-rightVal); //negative for 2017 robot bc of misplaced transmissions
			rearRight.set(ControlMode.PercentOutput,-rightVal);
			frontLeft.set(ControlMode.PercentOutput,leftVal);
			rearLeft.set(ControlMode.PercentOutput,leftVal);
	 }
	
	public void driveSlow() {
		double leftVal = OI.driveJoystick.getRawAxis(5);
		double rightVal = OI.driveJoystick.getRawAxis(1);
		 //System.out.println("leftVal: " + encoderLeft.get() + " rightVal: " + encoderRight.get());
		//System.out.println("Gyro: "+ gyro.getAngle());
		frontRight.set(ControlMode.PercentOutput,-rightVal*0.85);
		rearRight.set(ControlMode.PercentOutput,-rightVal*0.85);
		frontLeft.set(ControlMode.PercentOutput,leftVal*0.85);
		rearLeft.set(ControlMode.PercentOutput,leftVal*0.85);
	}
	
	// auton
	public void drive(double l, double r) {
		frontRight.set(ControlMode.PercentOutput,-r);
		rearRight.set(ControlMode.PercentOutput,-r);
		frontLeft.set(ControlMode.PercentOutput,l);
		rearLeft.set(ControlMode.PercentOutput,l);
	}

	public void turnDegrees(double degrees) {
		gyro.reset();

		if (degrees > 0) {
			while (gyro.getAngle() < degrees) {
				frontRight.set(ControlMode.PercentOutput,-0.25);
				rearRight.set(ControlMode.PercentOutput,-0.25);
				frontLeft.set(ControlMode.PercentOutput,-0.25);
				rearLeft.set(ControlMode.PercentOutput,-0.25);
				/*rightMotors.set(-0.25);
				leftMotors.set(0.25);*/
			}
		} 
		else {
			while (gyro.getAngle() > degrees) {
				frontRight.set(ControlMode.PercentOutput,0.25);
				rearRight.set(ControlMode.PercentOutput,0.25);
				frontLeft.set(ControlMode.PercentOutput,0.25);
				rearLeft.set(ControlMode.PercentOutput,0.25);
				/*rightMotors.set(0.25);
				leftMotors.set(0.25);*/
			}
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveTeleop());
	}
}
