package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

public class PIDDrive extends PIDSubsystem {
	// creates speed controller objects

	// public final int WHEELRADIUS = 2;

	// the pid constants
	public static double Kp = 0.1;
	public static double Ki = 0;
	public static double Kd = 0;
	
	double errorR; 
	double lastErrorR = 0;
	double derivativeR;
	double errorSumR = 0;
	double outputR;
	double changeInREncGet;
	double lastREncGet = 0;
	
	double errorL;
	double lastErrorL = 0;
	double derivativeL;
	double errorSumL = 0;
	double outputL;
	double changeInLEncGet;
	double lastLEncGet = 0;
	
	double error;
	double lastError = 0;
	double derivative;
	double errorSum;
	double output;
	double dif;
	

	@SuppressWarnings("deprecation") // in order to use the deprecated method addActuator()
	public PIDDrive() {
		super("PIDDrive", Kp, Ki, Kd);
		// this is from the PIDSubsystem class these declare the PID values
		// still need to figure out this LiveWindow BS
		LiveWindow.addActuator("Drive", "PIDSubsystemController", getPIDController());
		// reset drive encoders for PID
		resetEncoders();
		getPIDController().setContinuous(true);
		enable();
		getPIDController().setAbsoluteTolerance(20.0); // this is a 20% tolerable error
	}

	public void adjust(double distance, double velocity) {
		//setSetpoint((velocity*200)/2); 
		//setPoint represents the number of revolutions per second
		//we assume that there are 200 ticks per revolution
		//we divide by 2 because we allow each loop to go for .5 seconds
		
		setSetpoint(0);
		distance *= 236 / 12; // convert the desired distance into the desired number of ticks
		resetEncoders();
		// this loop will continue going until the robot goes the desired distance
		//Robot.drivetrain.drive(velocity, velocity)
		//Timer.delay(5.0);
		System.out.println("Encoder Left" + Drivetrain.encoderLeft.get());
		System.out.println("Encoder Right" + Drivetrain.encoderRight.get());
		System.out.println("Hi");
		while (getLEncDistance() < distance && getREncDistance() < distance) {
			//usePIDOutput(returnPIDInput());//this is using the output for the left side of the drivetrain 
			usePIDOutputTogether(returnPIDInputTogether());
			//Timer.delay(2.0);
			// motors go at same speed for at least .5 seconds before another iteration of
			// the loop
			System.out.println("frontright" + Drivetrain.frontRight.getMotorOutputPercent());
			System.out.println("rearRight" + Drivetrain.rearRight.getMotorOutputPercent());
			System.out.println("frontleft" + Drivetrain.frontLeft.getMotorOutputPercent());
			System.out.println("rearLeft" + Drivetrain.rearLeft.getMotorOutputPercent());
		//resetEncoders();
		//System.out.println("Hi");
		System.out.println("Encoder Left" + Drivetrain.encoderLeft.get());
		System.out.println("Encoder Right" + Drivetrain.encoderRight.get());
		}	
	}

	// this method will be used over and over again to make sure that the left
	// motors are going the right output
	protected double returnPIDInputTogether() {
		/*
		changeInLEncGet = getLEncDistance() - lastLEncGet;
		lastLEncGet = getLEncDistance();
		errorL = getSetpoint() - changeInLEncGet;
		derivativeL = (errorL - lastErrorL);
		errorSumL += errorL;
		outputL = errorL * Kp + derivativeL * Kd + errorSumL * Ki;
		lastErrorL = errorL;
		return outputL;
		*/
		dif = getLEncDistance() - getREncDistance();
		error = getSetpoint() - dif; 
		errorSum += error;
		output = error*Kp + derivative*Kd + errorSum*Ki;
		lastError = error;
		return output;
	}

	//right 
	@Override
	protected double returnPIDInput() {
		changeInREncGet = getREncDistance() - lastREncGet;
		errorR = getSetpoint() - changeInREncGet;
		derivativeR = (errorR - lastErrorR);
		errorSumR += errorR;
		outputR = errorR * Kp + derivativeR * Kd + errorSumR * Ki;
		lastREncGet = getREncDistance();
		lastErrorR = errorR;
		return outputR;
	}
	
	protected void usePIDOutputTogether(double output) {
		output *= 0.05;
		Drivetrain.frontLeft.pidWrite(output);
		Drivetrain.rearLeft.pidWrite(output);
		Drivetrain.frontRight.pidWrite(output); //negative because right transmissions are on backwards
		Drivetrain.rearRight.pidWrite(output);
	}
	
	//right
	@Override
	protected void usePIDOutput(double output) {
		output *= 0.05;
		//Drivetrain.frontLeft.pidWrite(output);
		//Drivetrain.rearLeft.pidWrite(output);
		Drivetrain.frontRight.pidWrite(output); //negative because right transmissions are on backwards
		Drivetrain.rearRight.pidWrite(output); 
	}

	public double getLEncDistance() {
		return Drivetrain.encoderLeft.get();
	}

	public double getREncDistance() {
		return Drivetrain.encoderRight.get();
	}

	public void resetEncoders() {
		Drivetrain.encoderRight.reset();
		Drivetrain.encoderLeft.reset();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}


