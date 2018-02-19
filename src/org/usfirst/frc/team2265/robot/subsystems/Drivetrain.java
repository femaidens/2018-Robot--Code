package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;
import org.usfirst.frc.team2265.robot.commands.DriveTeleop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */

public class Drivetrain extends Subsystem {
	public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	// Put methods for controlling this subsystem
	// here. Call these from Commands
	// Initialize CANTalons
	  public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftPort);
	  public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftPort);
	  public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightPort);
	  public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightPort);

	  public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	//public static PowerDistributionPanel PDP = new PowerDistributionPanel();
	

	// Initializing encoder

	/*public static Encoder encoderLeft = new Encoder(RobotMap.encRL, RobotMap.encFL, true,
			Encoder.EncodingType.k1X);
	public static Encoder encoderRight = new Encoder(RobotMap.encRR, RobotMap.encFR, false,
			Encoder.EncodingType.k1X);*/

	public static double constant = 8.6;

	public Drivetrain() {
		//encoderLeft.setMaxPeriod(2);
		//encoderRight.setMaxPeriod(2);
		frontRight.enableCurrentLimit(true);
		rearRight.enableCurrentLimit(true);
		frontLeft.enableCurrentLimit(true);
		rearLeft.enableCurrentLimit(true);
		
		frontRight.configContinuousCurrentLimit(35,0); //90 is a placeholder for time in milliseconds
		rearRight.configContinuousCurrentLimit(35,0); 
		frontLeft.configContinuousCurrentLimit(35,0);
		rearLeft.configContinuousCurrentLimit(35,0);
	}

	// Teleop
	public void drive() {
		double leftVal = OI.driveJoystick.getRawAxis(5);
		double rightVal = OI.driveJoystick.getRawAxis(1);
		 //System.out.println("leftVal: " + encoderLeft.get() + " rightVal: " + encoderRight.get());
		System.out.println("Gyro: "+ gyro.getAngle());
		frontRight.set(ControlMode.PercentOutput,-rightVal);
		rearRight.set(ControlMode.PercentOutput,-rightVal);
		frontLeft.set(ControlMode.PercentOutput,leftVal);
		rearLeft.set(ControlMode.PercentOutput,leftVal);	
	}
	
	public void driveSlow() {
		double leftVal = OI.driveJoystick.getRawAxis(5);
		double rightVal = OI.driveJoystick.getRawAxis(1);
		 //System.out.println("leftVal: " + encoderLeft.get() + " rightVal: " + encoderRight.get());
		//System.out.println("Gyro: "+ gyro.getAngle());
		frontRight.set(ControlMode.PercentOutput,-rightVal*0.75);
		rearRight.set(ControlMode.PercentOutput,-rightVal*0.75);
		frontLeft.set(ControlMode.PercentOutput,leftVal*0.75);
		rearLeft.set(ControlMode.PercentOutput,leftVal*0.75);
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
	

	/*public void autoAlign() { 
		while ((!AutoAlign.done) &&(Robot.midX < 285 || Robot.midX > 315)) { 
			if (Robot.midX < 285) { 
				frontRight.set(ControlMode.PercentOutput,-0.125);
				rearRight.set(ControlMode.PercentOutput,-0.125); 
				frontLeft.set(ControlMode.PercentOutput,-0.125); 
				rearLeft.set(ControlMode.PercentOutput,-0.125);
				System.out.println("<285"); //turns left 
			} else if (Robot.midX > 315) {
				frontRight.set(ControlMode.PercentOutput,0.125); 
				rearRight.set(ControlMode.PercentOutput,0.125); 
				frontLeft.set(ControlMode.PercentOutput,0.125);
				rearLeft.set(ControlMode.PercentOutput,0.125);
				//turns right 
				System.out.println(">315"); } 
			else { 
				break; 
			}
			 System.out.println("autoaligning, mid X = " + Robot.midX); //this will keep running if the midX is not in within 305 and 335 }
		}
	 
	  
	  frontRight.set(ControlMode.PercentOutput,0); rearRight.set(ControlMode.PercentOutput,0); frontLeft.set(ControlMode.PercentOutput,0); rearLeft.set(ControlMode.PercentOutput,0);
	  return; 
	  
	}*/

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveTeleop());

	}
}
