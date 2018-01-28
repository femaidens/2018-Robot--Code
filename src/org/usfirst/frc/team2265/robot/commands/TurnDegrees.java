package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

public class TurnDegrees extends Command {
	
	double degrees;
	public static boolean done;
	
	public TurnDegrees(double d) {
		//requires(Robot.driveTrain);
		degrees = d;
		done = false;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		done = false;
	}
	
	protected void execute() {
		System.out.println("Gyro: " + Drivetrain.gyro.getAngle());
		System.out.println("Turning");
		// if the angle the robot is currently in is less than the degree you want, then
		// the robot would turn right.
		Robot.drivetrain.turnDegrees(degrees);
		done = true;
	}
	
	protected boolean isFinished() {
		return done;
	}
	
	// Tells driver that gyro was reset to 0 degrees, as it returns to 0 degrees.
	// Resets everything.
	protected void end() {
		System.out.println("Gyro: " + Drivetrain.gyro.getAngle());
	}
	
	protected void interrupted() {
		done = true;
	}
}
