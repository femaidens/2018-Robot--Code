package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDDrive extends PIDSubsystem { //You're doing great Zarrin! Keep it up! I like the PID drive class =)
	//creates talon objects
	public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftPort);
	public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightPort);
	public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftPort);
	public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightPort);
	//public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	
	//initializs the encoder objects
	public static Encoder encoderLeft = new Encoder(RobotMap.encPort1, RobotMap.encPort2, true, Encoder.EncodingType.k1X);
    public static Encoder encoderRight = new Encoder(RobotMap.encPort3, RobotMap.encPort4, false, Encoder.EncodingType.k1X);
	
    public PIDDrive(String name, double p, double i, double d) {
		super("PIDDrive", 0.1, 0, 0.1); //from super class constructor, sets the PID values
		getPIDController().setContinuous(true);
		setName("PIDDrive", "PIDSubsytemController");
		getPIDController().setPercentTolerance(20.0); //the tolerable percent error 
		//gyro.reset();
		
		encoderLeft.reset();
		encoderRight.reset();
		
		sensormode = SensorMode.ENCODER; //use encoder as main sensor for PID control
		drivemode = DriveMode.TURN; //this is the velocity main
	}
	//these are enumerators that hold constant values
	public enum SensorMode {
		GYRO, ENCODER;
	}
	
	public enum DriveMode {
		TURN, DRIVE;
	}
	
	public SensorMode sensormode;
	public DriveMode drivemode;
	
	public final int WHEELRADIUS = 2;
	
	public void startAdjust(double current, double setPoint) {
		if (sensormode ==  SensorMode.ENCODER) {
			setPoint %= 360;
			setSetpoint((int)(current-setPoint));
			
		}
		
	}
	
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
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
