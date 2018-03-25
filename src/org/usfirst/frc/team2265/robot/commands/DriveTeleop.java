package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;

/**
 *
 */

public class DriveTeleop extends Command {

	public DriveTeleop() {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.exampleSubsystem);
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.drive();
		System.out.println("Gyro Value: " + Robot.drivetrain.gyro.getAngle());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.drive(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}