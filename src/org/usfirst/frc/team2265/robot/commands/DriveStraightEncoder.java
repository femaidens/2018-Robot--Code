package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.subsystems.PIDDrive;
import org.usfirst.frc.team2265.robot.Robot;

public class DriveStraightEncoder extends Command {
	public DriveStraightEncoder() {
		requires(Robot.drive);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		PIDDrive.encoderLeft.reset();
		PIDDrive.encoderRight.reset();
	}
	
	// Called repeatedly when this Command is scheduled to run
	/*protected void execute() {
		if (PIDDrive.encoderLeft.get() > PIDDrive.encoderRight.get()) {
			Robot.drive.drive(PIDDrive.frontLeft.getMotorOutputPercent() - 0.1, PIDDrive.frontRight.getMotorOutputPercent() + 0.1);
		} else if (PIDDrive.encoderRight.get() > PIDDrive.encoderLeft.get()) {
			Robot.drive.drive(PIDDrive.frontLeft.getMotorOutputPercent() + 0.1,PIDDrive.frontRight.getMotorOutputPercent() - 0.1);
		}
	}*/
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
	//	Robot.drive.drive(0, 0);
		PIDDrive.encoderLeft.reset();
		PIDDrive.encoderRight.reset();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
