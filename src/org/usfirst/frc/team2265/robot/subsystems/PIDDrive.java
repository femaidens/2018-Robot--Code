package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDDrive extends PIDSubsystem {//You're doing great Zarrin! Keep it up! I like the PID drive class =)
	public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftPort);
	public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightPort);
	public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftPort);
	public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightPort);
	
	public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

	public PIDDrive(String name, double p, double i, double d) {
		super("PIDDrive", 0.1, 0, 0.1);		// TODO Auto-generated constructor stub
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
