package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2265.robot.Robot;

public class DriveStraightEncoder extends Command {
	public DriveStraightEncoder() {
		requires(Robot.drivetrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Drivetrain.encoderLeft.reset();
		Drivetrain.encoderRight.reset();
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Drivetrain.encoderLeft.get() > Drivetrain.encoderRight.get()) {
			Robot.drivetrain.drive(Drivetrain.frontLeft.getMotorOutputPercent() - 0.1, Drivetrain.frontRight.getMotorOutputPercent() + 0.1);
		} else if (Drivetrain.encoderRight.get() > Drivetrain.encoderLeft.get()) {
			Robot.drivetrain.drive(Drivetrain.frontLeft.getMotorOutputPercent() + 0.1,Drivetrain.frontRight.getMotorOutputPercent() - 0.1);
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.drive(0, 0);
		Drivetrain.encoderLeft.reset();
		Drivetrain.encoderRight.reset();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
