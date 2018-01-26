package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import edu.wpi.first.wpilibj.PWMTalonSRX;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class PIDDrive extends PIDSubsystem {  //You're doing great Zarrin! Keep it up! I like the PID drive class =)
	//creates speed controller objects
	public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeftPort);
	public static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRightPort);
	public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.rearLeftPort);
	public static WPI_TalonSRX rearRight = new WPI_TalonSRX (RobotMap.rearRightPort);
	//creates speed controller groups
	public static SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeft, rearLeft);
	public static SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRight, rearRight);
	public static DifferentialDrive drive =  new DifferentialDrive(leftMotors, rightMotors);
	
	public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	
	public final int WHEELRADIUS = 2;
	
	
	public enum SensorMode {
		GYRO, ENCODER;
	}

	public enum DriveMode {
		TURN, DRIVE;
	}
	
	@SuppressWarnings("deprecation")
	public PIDDrive(String name, double kp, double ki, double kd) {
		super("PIDDrive", 0.1, 0, 0.1);	//this is from the PIDSubsystem class these declare the PID values
		// still need to figure out this LiveWindow BS
		LiveWindow.addActuator("Drive", "PIDSubsystemController", getPIDController());
		//we are using an encoder based PID control
		sensorMode = SensorMode.ENCODER;
		driveMode = DriveMode.TURN;
		
		//reset drive encoders for PID
		Drivetrain.encoderLeft.reset();
		Drivetrain.encoderRight.reset();
		
		// this is a 20% tolerable error
		getPIDController().setAbsoluteTolerance(20.0);
		//sets value to singular setpoint
		getPIDController().setContinuous(true);			
		
		}
	
	//initializes the two modes; one to drive and one to use the sensors
	public SensorMode sensorMode;
	public DriveMode driveMode;
	
	public void startAdjust(double currentpoint, double setpoint) {
		//enables PIDController with given setpoint 
		if(sensorMode == SensorMode.ENCODER) {
			setpoint %= 200;//assumes that the ticks per revolution is 200, keeps changing the setpoint by using the remainder as it is divided into the number of ticks per revolution
			setSetpoint((int) (((currentpoint - setpoint >= 0 ? 100 : -100) + currentpoint - setpoint) / 200) * 200 + setpoint); //sets the setpoint to 
		}
		else {
			setSetpoint(setpoint);
		}	
		enable();
	}
	
	public void endAdjust() {
		getPIDController().disable();
	}
	
	@Override
	protected double returnPIDInput() {
		//returns the input to be used by the PIDController
		if(sensorMode == SensorMode.ENCODER) {
			return Drivetrain.encoderLeft.getDistance(); 
		}
		else {
			return gyro.getAngle(); // might have to do some math for this --separate method
		}
	}
	
	@Override
	protected void usePIDOutput(double output) {
		output *= 0.5;
		frontLeft.pidWrite(output);
		frontRight.pidWrite(output);
		rearRight.pidWrite(output);	
		rearLeft.pidWrite(output);
	} 
	
	public void setSpeed(double speed) {
		// Sets wheels to given speed.
		frontRight.set((driveMode == DriveMode.TURN) ? speed : -speed);
		/*if (driveMode == DriveMode.TURN) {
			frontRight.set(speed);
		} 
		  else {
			frontRight.set(-speed);
		}*/
		frontLeft.set((driveMode == DriveMode.TURN) ? speed : -speed);
		/*if(driveMode == DriveMode.TURN) 
			frontLeft.set(speed);
		else 
			frontLeft.set(-speed);*/
		rearRight.set(speed);
	    rearLeft.set(speed);
	}

	public double getEncDistance() {
		return Drivetrain.encoderLeft.get();
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
