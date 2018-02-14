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
		// Robot.drivetrain.drive();
		Robot.drivetrain.drive();
		/*System.out.println("front left: " + Drivetrain.PDP.getCurrent(14));
		System.out.println("rear left: " + Drivetrain.PDP.getCurrent(15));
		System.out.println("front right: " + Drivetrain.PDP.getCurrent(1));
		System.out.println("rear right: " + Drivetrain.PDP.getCurrent(0));*/
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}