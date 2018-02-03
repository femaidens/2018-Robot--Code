package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Timer;

public class PIDDrive extends PIDSubsystem {
	// creates speed controller objects

	// public final int WHEELRADIUS = 2;

	// the pid constants
	public static double Kp = 0.1;
	public static double Ki = 0;
	public static double Kd = 0.1;
	double errorR = 0;
	double lastErrorR;
	double derivativeR;
	double errorSumR;
	double output;
	double errorL = 0;
	double lastErrorL;
	double derivativeL;
	double errorSumL;
	double outputL;
	

	@SuppressWarnings("deprecation") // in order to use the deprecated method addActuator()
	public PIDDrive() {
		super("PIDDrive", Kp, Ki, Kd);
		// this is from the PIDSubsystem class these declare the PID values
		// still need to figure out this LiveWindow BS
		LiveWindow.addActuator("Drive", "PIDSubsystemController", getPIDController());

		// reset drive encoders for PID
		resetEncoders();

		// this is a 20% tolerable error
		// not really used
		// getPIDController().setAbsoluteTolerance(20.0);

		// sets value to singular setpoint
		// not really used
		// getPIDController().setContinuous(true);

	}

	public void adjust(double setPoint, double distance) {
		setSetpoint(setPoint);
		distance *= 236 / 12; // convert the desired distance into the desired number of ticks
		resetEncoders();
		// this loop will continue going until the robot goes the desired distance
		while (getLEncDistance() < distance && getREncDistance() < distance) {
			usePIDOutput(returnPIDInput());
			usePIDOutputRight(returnPIDInputRight());
			Timer.delay(0.5);
			// motors go at same speed for at least .5 seconds before another iteration of
			// the loop
		}
		resetEncoders();
	}

	@Override
	// this method will be used over and over again to make sure that the left
	// motors are going the
	protected double returnPIDInput() {
		lastErrorL = errorL;
		errorL = getSetpoint() - getLEncDistance();
		derivativeL = (errorL - lastErrorL);
		errorSumL += errorL;
		outputL = errorL * Kp + derivativeL * Kd + errorSumL * Ki;
		return outputL;
	}

	protected double returnPIDInputRight() {
		lastErrorR = errorR;
		errorR = getSetpoint() - getREncDistance();
		derivativeR = (errorR - lastErrorR);
		errorSumR += errorR;
		output = errorR * Kp + derivativeR * Kd + errorSumR * Ki;
		return output;
	}

	@Override
	protected void usePIDOutput(double output) {
		output *= 0.05;
		Drivetrain.frontLeft.pidWrite(output);
		Drivetrain.rearLeft.pidWrite(output);
	}

	protected void usePIDOutputRight(double output) {
		output *= 0.05;
		Drivetrain.frontRight.pidWrite(-output); //negative because right transmissions are on backwards
		Drivetrain.rearRight.pidWrite(-output);
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
