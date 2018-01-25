package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDDrive extends PIDSubsystem {  //You're doing great Zarrin! Keep it up! I like the PID drive class =)
	public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftPort);
	public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightPort);
	public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftPort);
	public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightPort);
	
	public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

	public enum SensorMode {
		GYRO, ENCODER;
	}

	public enum DriveMode {
		TURN, DRIVE;
	}
	
	public PIDDrive(String name, double kp, double ki, double kd) {
		super("PIDDrive", 0.1, 0, 0.1);	//this is from the PIDSubsystem class these declare the PID values
		// still need to figure out this LiveWindow BS
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
		setpoint %= 200; //assumes that the ticks per revolution is 200
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
